/*
 * 8th July 2016
 */
package javaEx1;

public class MyRunnable implements Runnable {

	private int id;
	private Mapper mapper;
	private int numTh;
	
	public MyRunnable(int id, Mapper mapper, int num){
		this.id=id;
		this.mapper = mapper;
		numTh=num;
	}
	
	@Override
	public void run() {
		int[] data = mapper.data;
		int batch = data.length/numTh;
		int start = id*batch;
		synchronized (mapper.data){
			for(int i=start ; i< start+batch; i++){
				data[i] = mapper.p.process(data[i]);
			}
			mapper.data.notifyAll();
		}
	}
	
}
