/*
 * 13th of July 2015 
 */
package javaEx2;


public class MsgBatcher {
	
	private Message[] batch;
	private int counter, dim;
	
	public MsgBatcher(int dim) {
		this.dim = dim;
		batch = new Message[dim];
		counter = 0;
	}
	
	public synchronized void enqueue(Message msg) throws InterruptedException{
		while(dim == counter){
			this.wait(1000);
		}
		batch[counter++] = msg;
		this.notifyAll();
	}
	
	public synchronized void sendAll(){
		new MyThread(this).start();
	}

	public Message[] getBatch() {
		return batch;
	}

	public void setBatch(Message[] batch) {
		this.batch = batch;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public int getDim() {
		return dim;
	}

	public void setDim(int dim) {
		this.dim = dim;
	}
}
