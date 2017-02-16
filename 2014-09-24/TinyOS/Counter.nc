//2014-09-24
interface CounterInt{
    command void start(TMilli val);
    command void stop();
    event void countSignal(error_t err, uint16_t count);
}

module Counter{
    uses Timer<TMilli> as Timer0;
    provides CounterInt;
}
implementation{
    
    uint16_t counter;

    event void fired{
        counter++;
        signal CounterInt.countSignal(SUCCES, counter);
    }

    command void CounterInt.start(TMilli val){
        counter = 0;
        call Timer0.startPeriodic(val);
    }

    command void CounterInt.stop(){
        call Timer0.stop();
    }
}