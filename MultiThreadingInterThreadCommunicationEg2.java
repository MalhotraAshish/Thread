package testing;

public class MultiThreadingInterThreadCommunicationEg2 {
	static int number = 1;

	public static void main(String args[]) {
		final workereg2 obj = new workereg2();
		new Thread() {
			public void run() {
				System.out.println("i am printing upto 100");
				obj.printupto100();
			};
		}.start();
		new Thread() {
			public void run() {
				System.out.println("i am printing greater than 10 but less than 60");
				obj.printupto60();
			};
		}.start();
		new Thread() {
			public void run() {
				System.out.println("i am printing less than 10");
				obj.printupto10();
			};
		}.start();
	}
}

class workereg2 {
	synchronized void printupto10() {
		for (int i = MultiThreadingInterThreadCommunicationEg2.number; i <= 10; i++) {
			System.out.println(" hey from " + i + " and number = " + MultiThreadingInterThreadCommunicationEg2.number);
			MultiThreadingInterThreadCommunicationEg2.number++;
		}

		System.out.println("hello");
		notifyAll();

	}

	synchronized void printupto60() {
		if (MultiThreadingInterThreadCommunicationEg2.number <= 10) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if (MultiThreadingInterThreadCommunicationEg2.number > 60) {
			notifyAll();
		}
		for (int i = MultiThreadingInterThreadCommunicationEg2.number; i <= 60; i++) {
			System.out.println(" hey from " + i);
			MultiThreadingInterThreadCommunicationEg2.number++;
		}
	}

	synchronized void printupto100() {

		if (MultiThreadingInterThreadCommunicationEg2.number < 60) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for (int i = MultiThreadingInterThreadCommunicationEg2.number; i <= 100; i++) {
			System.out.println(" hey from " + i);
			MultiThreadingInterThreadCommunicationEg2.number++;
		}
	}
}