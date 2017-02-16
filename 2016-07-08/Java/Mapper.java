/*
 * 8th July 2016
 */

public class Mapper {

    public int numThreads;
    public MyThread[] setThread;
    public int[] data;
    public Processor p;

    public Mapper(int numThreads){
        this.numThreads=numThreads;
        setThread = new MyThread[numThreads];
        
        for(int i=0;i<numThreads; i++){
        	setThread[i] = new MyThread(this);
        	setThread[i].start();
        }
    }

    void map(int[] data, Processor p){
    	this.data = data;
    	this.p=p;
    	int ind = 0;
    	for (int i=0; i<data.length; i++){
            ind = i % numThreads;
            synchronized (setThread[ind]) {
            	setThread[ind].enqueue(new Elem(data[i], i));
            	setThread[ind].notifyAll();
			}
    	}
    }
    
    
    public static void main(String[] args) throws InterruptedException {
    	Mapper m = new Mapper(4);
    	int[] d = {1,2,3,4,5,6,7,8,9,10};
       	Processor p= new ProcImpl();
    	
       	m.map(d, p);
       	
       	for(int i= 0; i<m.data.length; i++){
       		System.out.println(m.data[i]);
       	}
       	
       	for(int i=0;i<m.numThreads; i++){
       		m.setThread[i].stop();
       	}
    }
}