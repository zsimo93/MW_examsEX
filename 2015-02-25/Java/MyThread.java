package javaEx5;

public class MyThread extends Thread {

	Boolean run;
	
	
	public MyThread() {
		super();
		this.run = true;
	}


	@Override
	public void run() {
		while(run){
			synchronized(Delay.flag){
				while(Delay.job == null){
					try {
						Delay.flag.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				Runnable job = Delay.job;
				Delay.job = null;
				job.run();
			}
		}
	}
}
