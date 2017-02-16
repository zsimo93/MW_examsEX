interface CounterOperations{

	command void Increment();
	event void CounterHundred(uint32_t increments);
	command void start();
	command void stop();
	command void reset();
}