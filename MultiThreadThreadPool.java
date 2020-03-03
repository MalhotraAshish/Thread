package testing;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MultiThreadWorkerThread extends Thread {
	private String message;

	public MultiThreadWorkerThread(String message) {
		this.message = message;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " Start message = " + message);
		processmessage();
		
		System.out.println(Thread.currentThread().getName() + " End ");
	}

	private void processmessage() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

public class MultiThreadThreadPool {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(10);

		for (int i = 0; i < 5; i++) {
			MultiThreadWorkerThread t1 = new MultiThreadWorkerThread(" Hey i am printing " + i);
			executor.execute(t1);
		}

		executor.shutdown();
		while(!executor.isTerminated()){}

		System.out.println("Finished printing all threads");
	}

}
