public class PeriodicRunner{
    
    Runnable run;
    int dt;
    MyThread th ;

    public PeriodicRunner(int dt, Runnable run){
        this.dt = dt;
        this.run = run;
        th = new MyThread(run, dt);
    }

    public void start(){
        th.start();
        th.run = true;
    }

    public void stop(){
        th.run = false;
    }
}