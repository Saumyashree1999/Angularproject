package collection;

public class Customer {
	public static void main(String[] args) {

		Bank bank1 = new Bank(4000);
		Thread thread1 = new Thread(bank1);
		Thread thread2 = new Thread(bank1);
		thread1.setName("ram");
		thread2.setName("hari");
		thread1.start();
		thread2.start();

		Bank bank2 = new Bank(5000);
		Thread thread3 = new Thread(bank2);
		Thread thread4 = new Thread(bank2);
		thread3.setName("gopal");
		thread4.setName("ravi");
		thread3.start();
		thread4.start();
	}
}

class Bank implements Runnable {
	static int balance = 5000;
	static int withdraw;

	public Bank(int withdraw) {
		super();
		this.withdraw = withdraw;
	}

	//@Override
	public static synchronized void withdraw() {
		String name = Thread.currentThread().getName();
		if (withdraw <= balance) {
			System.out.println(name + " withdraw " + withdraw + " successfully");
			balance = balance - withdraw;
		} else
			System.out.println("sorry " + name + " insufficient balance");
	}

	@Override
	public void run() {
		withdraw();
	}
}