import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/*
 * 8th July 2016
 */

public class MyThread extends Thread {

	private Mapper mapper;
	private Queue<Elem> queue;
	
	public MyThread(Mapper mapper){
		this.mapper = mapper;
		queue = new LinkedBlockingQueue<Elem>();
	}
	
	public void enqueue(Elem i){
		queue.add(i);
	}
	
	@Override
	public void run() {
		while(true){
			synchronized (this) {
				while(queue.isEmpty()){
					try {
						this.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				while(!queue.isEmpty()){
					Elem e = queue.poll();
					Processor p = mapper.p;
					mapper.data[e.getPos()]=p.process(e.getNum());
				}
			}
		}
	}
	
}
