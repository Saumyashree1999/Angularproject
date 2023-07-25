package collection;

public class ThreadImplement {
	public static void main(String[] args) {
		W w = new W();
		 //w.start();
		Thread thread = new Thread(w);
		thread.start();
		for (Integer i = 1; i <= 3; i++)
			System.out.println("main");
	}
}

class W implements Runnable {

	@Override
	public void run() {
		for (Integer i = 1; i <= 3; i++)
		System.out.println("child");

	}

}