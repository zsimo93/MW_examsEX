module MaxRead{
    uses interface Read<uint16_t> as ReadIn;
    provides interface Read<uint16_t> as ReadOut;
    uses Timer<TMilli> as Timer0;
}
implementation{

    int counter;
    uint16_t maxRead;

    command error_t ReadOut.read(){
        counter = 10;
        maxRead = 0;
        call Timer0.startPeriodic(20);
        return SUCCESS;
    }

    event void Timer0.fired(){
        call ReadIn.read();
    }

    event void ReadIn.readDone(error_t err, uint16_t val){
        if (counter!=0){
            if(err == FAIL){
                call ReadIn.read();
            } else {
                counter--;
                maxRead = (val>maxRead) ? val : maxRead;
                if(counter == 1){
                    Timer0.stop();
                    signal readDone(SUCCESS, maxRead);
                }
            }
        }
    }
}