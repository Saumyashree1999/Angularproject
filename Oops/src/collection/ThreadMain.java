package collection;

public class ThreadMain {
	static Z z = new Z();
	public static void main(String[] args) throws InterruptedException {
		// z = new Z();
		//z.start();
		try {
			z.start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Thread.currentThread().setPriority(5);
		for (Integer i = 1; i <= 5; i++) {
			System.out.println("saumya");
			Thread.sleep(1000);
		}

	}

	public void m1() {
		z.start();
		System.out.println("m1 method");
	}
}

class Z extends Thread {
	@Override
	public void run() {

//			for (Integer i = 1; i <= 5; i++) {
//				System.out.println(i);
//				try {
//					//Thread.sleep(1000);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}

	}
}