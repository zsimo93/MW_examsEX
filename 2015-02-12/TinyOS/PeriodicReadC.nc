module PeriodicReadC{
	uses interface Timer<TMilli> as Timer0;
	uses interface Read<uint16_t> as Read0;
	provides interface PeriodicReadOperations;

}

implementation{

event void Read0.readDone(error_t err, val_t val){
	signal PeriodicReadOperations.readValue(val);
}

event void Timer0.fired(){
	call Read0.read();
}

command void start(uint32_t dt){
	call Timer0.startPeriodic(dt);
}

command void stop(){
	call Timer0.stop();
}

}