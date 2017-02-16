/*
 * 13th of July 2015 
 */
package javaEx2;

public class MyThread extends Thread {
	
	private MsgBatcher msgB;
	
	public MyThread(MsgBatcher msgB) {
		super();
		this.msgB = msgB;
	}
	
	public void run() {
		synchronized(msgB){
		Message[] msgs = msgB.getBatch();
			for(int i=0; i<msgB.getCounter(); i++){
				msgs[i].send();
				msgs[i] = null;
			}
			msgB.setCounter(0);
			msgB.notifyAll();
		}
	}

}
