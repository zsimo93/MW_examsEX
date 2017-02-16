public class MyThread extends Thread{
    
    Runnable run;
    int dt;
    boolean stop;

    public MyThread(int dt, Runnable run){
        super();
        this.dt = dt;
        this.run = run;
        run = false;
    }

    @Override
    public void run(){
        while(!stop){
            run.run();
            Thread.sleep(dt);
        }
    }

}