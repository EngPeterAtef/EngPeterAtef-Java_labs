/*
This code should illustrate that synchronizing 2 methods of the same object
makes the access to them synchronized with each other
Run this program with and without synchronized several times to see the point
What we're expecting is that 2 threads working on 2 different synched methods, 
should execute in parallel, well it's not!
Although the 2 methods are different, they are synchronized with each other, (i.e
the 2 methods are working sequentially not in parallel), why? 
Because "synchronized" locks the object holding these 2 methods, so even if the 
one method is separate from the other, they'll be synchronized, as any method won't 
get the lock until it's released by any other thread holding it
 */

public class example_7 {
	public static void main (String [] args) throws InterruptedException {
		Counter counter = new Counter();

		Thread t1 = new Thread (new CounterSynchronizedRunnable(counter)); 
		t1.setName("1");
		Thread t2 = new Thread (new CounterSynchronizedRunnable(counter));
		t2.setName("2");

		t1.start(); 
		t2.start();

		t1.join(); 
		t2.join();


	}
}

class CounterSynchronizedRunnable implements Runnable {
	private Counter counter;

	public CounterSynchronizedRunnable (Counter counter) {
		this.counter = counter;
	}

	public void run () {
		if (Thread.currentThread().getName().equals("1"))
			counter.increment();
		else
			counter.decrement();

	}
}

class Counter  {
	public synchronized void increment () {
		System.out.println ("Increment, sleeping ... ");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

		}
		System.out.println ("Increment, wakeup ... ");
	}
	public synchronized void decrement () {
		System.out.println ("Decrement, no sleep");

	}	
}