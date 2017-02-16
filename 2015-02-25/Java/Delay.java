/*
 * 25th of February 2015 
 */
package javaEx5;

public class Delay {

	public static MyThread th;
	public static Runnable job;
	public static Object flag;
	
	public Delay() {
		th = new MyThread();
		flag = new Object();
		job = null;
		th.start();
	}
	public static void delay(Runnable runnable, int delay){
		try {
			Thread.sleep(delay*1000);
			synchronized (flag) {
				job = runnable;
				flag.notifyAll();
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
