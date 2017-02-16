interface PeriodicReadInt{
	command void start(uint32_t dt);
	event uint32_t redValue(uint32_t val);
	command void stop();
}