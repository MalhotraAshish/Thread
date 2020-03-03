package testing;

public class MultiThreadingJoin extends Thread{
	
	@Override
	public void run() {
		for(int i = 0; i<10; i++){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("I am printing@@@@ " + i);
		}
	}
	
	public static void main(String[] args){
		MultiThreadingJoin t1 = new MultiThreadingJoin();
		MultiThreadingJoin t2 = new MultiThreadingJoin();
		MultiThreadingJoin t3 = new MultiThreadingJoin();
		
		t1.start();
		
		
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t2.start();
		try {
			t2.join(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t3.start();
	}

}
