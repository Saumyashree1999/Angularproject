package collection;

public class Thread1 {
	public static void main(String[] args) throws InterruptedException {
		P p = new P();
		p.start();
		System.out.println(Thread.currentThread().getName());
		Thread.currentThread().setName("Child");
		System.out.println(Thread.currentThread().getName());
	}
}

class P extends Thread {
	public void run() {
		System.out.println(Thread.currentThread().getName());
		Thread.currentThread().setName("saumya");
		System.out.println(Thread.currentThread().getName());
	}
}