public class LindaSpace{

    ArrayList<int> nums = new ArrayList<int>();
    int readers = 0;

    public synchronized int read(){
        readers++;
        while(nums.isEmpty()){
            this.wait();
        }
        readers--;
        this.notifyAll();
        return nums.get(0);
    }

    public synchronized int get(){
        while(nums.isEmpty() || readers != 0){
            this.wait();
        }
        int n = num.remove(0);
        this.notifyAll();
        return n;
    }

    public synchronized void add(int num){
        nums.add(num);
        this.notifyAll();
    }
}