module CounterC{
	uses interface Timer<TMilli> as Timer0;
	provides interface CounterOperations;
}
implementations{
	uint32_t counter = 0;

	command void Increment(){
		counter ++;
		if(counter == 100)
		{signal counterHundred(counter);}
	}
	
	command void start(){
		call Timer0.startPeriodic(10000);
	}
	command void stop(){
		call Timer0.stop();
	}

	command void reset(){
		counter = 0;
	}

	event void Timer0.fired(){
		counter = 0;
	}
}