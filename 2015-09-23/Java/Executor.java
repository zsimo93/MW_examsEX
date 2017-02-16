/*
 *  23rd of September 2015
 */
package javaEx3;

public class Executor implements Runnable{

    private Runnable run;
    private boolean stop;
    public Executor(Runnable run){
        this.run=run;
        stop = false;
    }
    
    @Override
	public void run() {
    	while(!stop){
    		run.run();
    		try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
    	}
    }
    
    public void stop(){
    	stop = true;
    }


}