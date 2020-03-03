package testing;

class worker {
	
	int amount = 1000;
	
	/*public static void main(String args[]){
		int amount = 5;
		System.out.println(amount);
	}*/
	synchronized void withdraw(int amt){
		System.out.println("Going to withdraw " + amt);
		if(amount<amt){
			System.out.println("Low balance waiting for deposite");
			try {
				System.out.println("I am going out");
				wait();
				System.out.println("I am back");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("About to withdraw from amount = " + amount);
		amount = amount-amt;
		System.out.println("Withdraw complete updated balance = " + amount);
	}
	
	synchronized void deposite(int amt){
		System.out.println("About to deposite amount....." + amt);
		amount = amount + amt;
		System.out.println("Deposite complete new amount = " + amount);
		notifyAll();
	}
}

public class MultiThreadingInterThreadCommunication{
	public static void main(String[] args){
		final worker obj = new worker();
		new Thread(){
			@Override
			public void run() {
				obj.withdraw(5000);
			}
		}.start();
		
		new Thread(){
			@Override
			public void run() {
				obj.deposite(5000);
			}
		}.start();
	}
}
