
public class example_6 {

	class CounterRunnable implements Runnable {
		private MyCounter counter;

		public CounterRunnable (MyCounter counter) {
			this.counter = counter;
		}

                @Override
		public void run () {
			for (int i = 0 ; i < 1000; i++) 
				counter.increment();
		}
	}

	class MyCounter  {
		private int c =0;
		public synchronized void increment () {
			c++;
		}
		public int value () {return c;}	
	}

	public static void main (String [] args) throws InterruptedException {

		example_6 ex = new example_6();
		MyCounter counter = ex.new MyCounter();
		//Runnable r = ex.new CounterRunnable(counter);
		Thread t1 = new Thread (ex.new CounterRunnable(counter));
		Thread t2 = new Thread (ex.new CounterRunnable(counter));
//		Thread t1 = new Thread (r);
//		Thread t2 = new Thread (r); lo 3aiz t5li al synchronized 3la run

		t1.start();
		t2.start();
		t1.join();
		t2.join();

		System.out.println(counter.value());

	}
}


