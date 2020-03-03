package testing;

public class MultiThreadingPriority extends Thread {

	@Override
	public void run() {
		System.out.println("I am running... by thread " + Thread.currentThread().getName() + " having priority "
				+ Thread.currentThread().getPriority());
	}
	
	public static void main(String[] args){
		MultiThreadingPriority t1 = new MultiThreadingPriority();
		MultiThreadingPriority t2 = new MultiThreadingPriority();
		MultiThreadingPriority t3 = new MultiThreadingPriority();
		
		t1.setName("New_Name_T1");
		t2.setName("New_Name_T2");
		t3.setName("New_Name_T3");
		
		t1.setPriority(MIN_PRIORITY);
		t2.setPriority(NORM_PRIORITY);
		t3.setPriority(MAX_PRIORITY);
		
		t1.start();
		t2.start();
		t3.start();
	}

}
