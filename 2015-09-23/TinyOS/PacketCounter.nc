module PacketCounter{
	uses Receive;
	uses Timer<TMilli> as Timer0;
	provides Read<uint16_t>;
}

implementation{

	uint16_t counter = 0;
	event message_t* receive(message_t* msg, void* payload, uint8_t len){
		counter ++;
		return msg;
	}

	event void fired(){
		counter = 0;
	}

	command error_t Read.read(){
		signal Read.readDone(error_t err, counter);
	}
 
}