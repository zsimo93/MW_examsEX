module PacketCounter{
	uses interface Receive;
	uses interface Timer<TMilli> as Timer;
	provides interface Read<uint16_t>;
}

implementation{

	uint16_t counter = 0;
	event message_t* receive(message_t* msg, void* payload, uint8_t len){
		atomic {
			counter ++;
		}
		return msg;
	}

	event void fired(){
		atomic {counter = 0;}
	}

	command error_t Read.read(){
		post sendCount()
		return SUCCESS;
	}

	task void sendCount(){
		signal Read.readDone(error_t err, counter);
	}
 
}