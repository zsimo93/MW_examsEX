module PacketFilter{
    uses interface Receive as RIn;
    provides interface Receive as ROut;
    provides interface Read<uint32_t> as Read;
}
implementation{
    uint32_t dropped = 0;

    event message_t* RIn.receive(message_t* msg, void* payload, uint8_t len){
        byte[] pld = (byte[]) payload;
        if(pld[0] != 255){
            dropped++;
        }
        else{
            signal ROut.receive(msg, payload, len);
        }
        return msg;
    }

    command error_t Read.read(){
        post sendRead();
        return SUCCESS;
    }

    task void sendRead(){
        signal Read.readDone(SUCCESS, dropped);
    }
}