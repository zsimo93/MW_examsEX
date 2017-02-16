package javaEx5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {

	public static void main(String[] args) throws IOException {

		Delay d = new Delay();
		while(true){
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String a = br.readLine();
			if (a.equals("c")){
			Delay.delay(new MyRun(), 2);}
			
		}
	}

}
