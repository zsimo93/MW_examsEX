interface CounterOperations{

	command void Increment();
	event void counterHundred(uint32_t increments);
	command void start();
	command void stop();
	command void reset();
}