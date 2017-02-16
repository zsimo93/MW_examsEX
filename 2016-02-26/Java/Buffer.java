public class Buffer{
    
    private Integer[] data;
    private int[] readers;
    private Object[] items;

    public Buffer(){
        data = new Integer[10];
        readers = new int[10];
        items = new Object[10];

        for (int i=0;i<10;i++){
            data[i] = null;
            readers[i] = 0;
            items[i] = new Object();
        }

    }

    public int read(int pos){
        synchronized(items[pos]){
            readers[pos]++;
            while(data[pos]==null){
                items[pos].wait();
            }
            readers[pos]--;
            items[pos].notifyAll();
            return data[pos];
        }
    }

    public void write(int value, int pos){
        synchronized(items[pos]){
            while(data[pos]!=null){
                items[pos].wait();
            }
            data[pos] = value;
            items[pos].notifyAll();
        }
    }

    public int get(int pos){
        synchronized(items[pos]){
            while(data[pos]==null || readers[pos] != 0){
                items[pos].wait();
            }
            int d = data[pos];
            data[pos] = null;
            items[pos].notifyAll();
            return d;
        }
    }
}