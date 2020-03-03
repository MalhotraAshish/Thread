package testing;

public class MultiThreadingSynchronizationBlock {
	public static void main(String[] args){
		TableDemo obj = new TableDemo();
		Thread1Demo t1 = new Thread1Demo(obj);
		Thread2Demo t2 = new Thread2Demo(obj);
		
		t1.start();
		t2.start();
	}
}

class TableDemo{
	void printTable(int n){
		synchronized(this){
			for(int i = 0; i<10; i++){
				System.out.println(n*i);
				try {
					Thread.sleep(400);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}

class Thread1Demo extends Thread{
	TableDemo t = new TableDemo();
	public Thread1Demo(TableDemo t) {
		this.t = t;
	}
	
	@Override
	public void run() {
		t.printTable(5);
	}
}
class Thread2Demo extends Thread{
	TableDemo t = new TableDemo();
	public Thread2Demo(TableDemo t) {
		this.t = t;
	}
	
	@Override
	public void run() {
		t.printTable(3);
	}
}
