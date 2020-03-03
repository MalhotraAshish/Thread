package testing;

public class MultiThread extends Thread{
	
	@Override
	public void run() {
		System.out.println("I am running from Thread.....");
		super.run();
	}
	
	public static void main(String[] args){
		MultiThread t1 = new MultiThread();
		System.out.println("before starting thread");
		t1.start();
		System.out.println("after starting thread");
	}
}
