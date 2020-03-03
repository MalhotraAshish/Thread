package testing;

public class MultiThreadingSleep extends Thread {

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(" I am printing " + i);
		}
	}

	public static void main(String[] args) {
		MultiThreadingSleep t1 = new MultiThreadingSleep();
		MultiThreadingSleep t2 = new MultiThreadingSleep();
		
		t1.start();
		t2.start();
	}

}
