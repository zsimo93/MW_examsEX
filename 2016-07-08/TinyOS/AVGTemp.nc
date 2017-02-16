
module AVGTemp{
    uses interface Read<double> as Read;
    provides interface Read<double> as Read1;
    provides interface StdControl;
    uses interface Timer<TMilli> as Timer;
}
implementation{

    double vals[60];
    int index;
    int counter
    double avg;

    command error_t StdControl.start(){
        counter = 0;
        index = 0;
        call Timer.startPeriodic(1000);
        
        return SUCCESS;
    }

    command errot_t StdControl.stop(){
        call Timer.stop();
    }

    event void Timer.fired(){
        call Read.read();
    }

    event void Read.readDone(error_t err, double val){
        if(err == SUCCES){
            atomic {
                counter ++;
                index = (index == 60) ? 0 : index;
                vals[index++] = val;}
        } else {
            call Read.read();
        }
    }

    command error_t Read1.read(){
        if(counter > 60){
            post avgCompute();
            return SUCCESS;
        }
        else
            return FAIL;
    }

    task void avgCompute(){
        double sum=0;
            
        for(int i=0; i<60; i++){
            sum += vals[i];
        }
        atomic {avg = sum/60;}
        call Read1.readDone(SUCCESS, avg);
    }

}