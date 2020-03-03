package testing;

public class MultiThreadingDeadlock {
	
	public static void main(String[] args){
		final String resource1 = "ABC";
		final String resource2 = "DEF";
		
		Thread t1 = new Thread(){
			@Override
			public void run() {
				synchronized(resource1){
					System.out.println("Thread1 acquired resource " + resource1);
					
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					synchronized(resource2){
						System.out.println("Thread1 acquired resource " + resource2);
					}
				}
			}
		};
		
		Thread t2 = new Thread(){
			@Override
			public void run() {
				synchronized(resource2){
					System.out.println("Thread2 acquired resource " + resource2);
					
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					synchronized(resource1){
						System.out.println("Thread2 acquired resource " + resource1);
					}
				}
			}
		};
		
		t1.start();
		t2.start();
	}

}
