package testing;

public class MultiThreadingUsingRunnable implements Runnable{

	public void run() {
		System.out.println(" I am in run method of runnable interface");
	}
	
	public static void main(String[] args){
		MultiThreadingUsingRunnable t1 = new MultiThreadingUsingRunnable();
		Thread thread = new Thread(t1);
		thread.start();
	}

}
