package testing;

public class MultiThreadingDaemon extends Thread{
	@Override
	public void run() {
		if(Thread.currentThread().isDaemon()){
			System.out.println("I am running as a Daemon Thread .... ..." + Thread.currentThread().getName());
		}else{
			System.out.println("I am running as a User Thread .... ..." + Thread.currentThread().getName());
		}
	}
	
	public static void main(String[] args){
		MultiThreadingDaemon t1 = new MultiThreadingDaemon();
		MultiThreadingDaemon t2 = new MultiThreadingDaemon();
		MultiThreadingDaemon t3 = new MultiThreadingDaemon();
		
		t1.setDaemon(true);
		t1.start();
		t2.start();
		t3.setDaemon(true);
		t3.start();
	}

}
