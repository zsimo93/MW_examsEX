interface CounterInt{
    event void periodicTot(uint32_t val);
    command error_t resetCount();
}

module Counter{
    provides CounterInt;
    uses Receive;
}
implementation{

    uint32_t counter = 0;

    command error_t resetCount(){
        counter = 0;
        return SUCCESS;
    }

    event message_t* receive(message_t* msg, void* payload, uint8_t len){
        counter ++;
        if (counter%10 = 0){
            signal CounterInt.periodicTot(counter);
        }
        return msg;
    }

}