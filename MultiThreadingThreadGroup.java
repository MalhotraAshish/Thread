package testing;

public class MultiThreadingThreadGroup extends Thread{
	
	@Override
	public void run() {
		System.out.println("I am " + Thread.currentThread().getName());
	}
	
	public static void main(String[] args){
		ThreadGroup tg = new ThreadGroup("Parent Thread");
		MultiThreadingThreadGroup thread = new MultiThreadingThreadGroup();
		Thread t1 = new Thread(tg, thread, "one");
		t1.start();
		Thread t2 = new Thread(tg, thread, "two");
		t2.start();
		Thread t3 = new Thread(tg, thread, "three");
		t3.start();
				
		System.out.println("Thread Group name = " + tg.getName());
		tg.list();
	}

}
