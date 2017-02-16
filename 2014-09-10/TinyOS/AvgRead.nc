module AvgRead{
    uses{
        interface Timer<TMilli> as T;
        interface Read<uint16_t> as R1;
        interface Read<uint16_t> as R2;
    }
    provides{
        interface Read<uint16_t> as ROut;
    }
}
implementation{
    uint16_t n1;
    uint16_t n2;
    uint16_t avg;

    command Init.init(){
        call T.startPeriodic(1000);
    }

    event void T.fired(){
        call R1.read();
    }

    event void R1.readDone(error_t result, uint16_t val){
        if(result == SUCCESS){
            n1 = val;
            call R2.read();
        } else call R1.read();
    }

    event void R2.readDone(error_t result, uint16_t val){
        if(result == SUCCESS){
            n2 = val;
            avg = (uint16_t) (n1+n2)/2;
        } else call R2.read();
    }

    command error_t ROut.read(){
        post sentAvg();
        return SUCCESS;
    }

    task void sentAvg(){
        signal ROut.readDone(SUCCESS, avg);
    }

}