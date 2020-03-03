package testing;

public class MultiThreadNaming extends Thread {
	@Override
	public void run() {
		System.out.println("I am running.......... by thread name = " + Thread.currentThread().getName()
				+ " with priority = " + Thread.currentThread().getPriority());
	}

	public static void main(String[] args) {
		MultiThreadNaming t1 = new MultiThreadNaming();
		MultiThreadNaming t2 = new MultiThreadNaming();
		MultiThreadNaming t3 = new MultiThreadNaming();

		System.out.println("I am thread 1 by name = " + t1.getName());
		System.out.println("I am thread 2 by name = " + t2.getName());
		System.out.println("I am thread 3 by name = " + t3.getName());

		System.out.println("I am thread 1 by id = " + t1.getId());
		System.out.println("I am thread 2 by id = " + t2.getId());
		System.out.println("I am thread 3 by id = " + t3.getId());

		t1.start();
		t2.start();
		t3.start();

		t1.setName("New_Name_T1");
		t2.setName("New_Name_T2");
		t3.setName("New_Name_T3");

		System.out.println("I am thread 1 after name change to name = " + t1.getName());
		System.out.println("I am thread 2 after name change to name = " + t2.getName());
		System.out.println("I am thread 3 after name change to name = " + t3.getName());
	}

}
