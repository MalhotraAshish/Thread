package testing;

public class MultiThreadingStaticSynchronization {
	public static void main(String[] args) {

		Thread1Static t1 = new Thread1Static();
		Thread2Static t2 = new Thread2Static();

		t1.start();
		t2.start();
	}
}

class TableStatic {
	synchronized  static void printTable(int n) {

		for (int i = 0; i < 10; i++) {
			System.out.println(n * i);
			try {
				Thread.sleep(400);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}

class Thread1Static extends Thread {

	@Override
	public void run() {
		TableStatic.printTable(5);
	}
}

class Thread2Static extends Thread {

	@Override
	public void run() {
		TableStatic.printTable(3);
	}
}
