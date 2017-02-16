/*
 * 8th July 2016
 */
package javaEx1;

import java.util.ArrayList;

public class Mapper {

    private int numThreads;
    private ArrayList<Thread> setThread;
    public int[] data;
    Processor p;

    public Mapper(int numThreads){
        this.numThreads=numThreads;
        setThread = new ArrayList<Thread>();
        
        for(int i=0;i<numThreads; i++)
        	setThread.add(new Thread());
    }

    void map(int[] data, Processor p){
    	this.data = data;
    	this.p=p;
    	for (int i=0; i<numThreads; i++){
    		setThread.get(i);
    	}

    }
}