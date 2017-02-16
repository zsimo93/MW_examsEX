import java.util.ArrayList;
import java.util.List;

public class Barrier {
	
	private List<Thread> set;
	private int num;
	private int arrived;
	
	public Barrier(int num) {
		super();
		this.set = new ArrayList<Thread>();
		this.num = num;
		arrived=0;
	}

	public synchronized void await() throws InterruptedException{
		set.add(Thread.currentThread());
		arrived ++;
		notifyAll();
		while(arrived!=num){
			this.wait();
		}
	}
	
	public synchronized void interrupt(){
		for(Thread t : set){
			t.interrupt();
		}
	}
}
