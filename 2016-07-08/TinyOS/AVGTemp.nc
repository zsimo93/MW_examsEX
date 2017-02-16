
module AVGTemp{
    uses Read<double> as Read;
    provides Read<double> as Read1;
    provides StdControl;
    uses Timer<TMilli> as TimerRead;
}
implementation{

    double vals[60];
    int index;
    int counter
    double avg;

    command error_t StdControl.start(){
        counter = 0;
        index = 0;
        call TimerRead.startPeriodic(1000);
        
        return SUCCES;
    }

    command errot_t StdControl.stop(){
        call TimerRead.stop();
    }

    event void TimerRead.fired(){
        call Read.read();
    }

    event void TimerOut.fired(){
        double sum=0;
        for(int i=0; i<60; i++){
            sum += vals[i];
        }

        avg = sum/60;
    }

    event void Read.readDone(error_t err, double val){
        if(err == SUCCES){
            counter ++;
            index = (index == 60) ? 0 : index;
            vals[index++] = val;
        } else {
            call Read.read();
        }
    }

    command error_t Read1.read(){
        if(counter > 60){
            
            double sum=0;
            
            for(int i=0; i<60; i++){
                sum += vals[i];
            }

            avg = sum/60;
            
            call Read1.readDone(SUCCES, avg);
            return SUCCES;
        }
        else    return FAIL;
    }

}