package collection;

public class ThreadScheduler {
	public static void main(String[] args) {
		D d1 = new D();
		D d2 = new D();
		D d3 = new D();
		d1.setName("Thread 1");
		d2.setName("Thread 2");
		d3.setName("Thread 3");
		d1.start();
		d2.start();
		d3.start();
		String name = Thread.currentThread().getName();
		for (Integer i = 1; i <= 3; i++)
			System.out.println(name);
	}
}

class D extends Thread {
	public void run() {

		String name = Thread.currentThread().getName();
		Thread.currentThread().setPriority(8);
		for (Integer i = 1; i <= 3; i++)
			System.out.println(name);
	}
}