package co.micol.streamTest.exam;

import java.io.FileInputStream;
import java.io.InputStream;

public class ReadExample {
	public void run() {
		try {
			InputStream is = new FileInputStream("c:\\Temp\\test1.txt");
			byte[] buffer = new byte[100];
			
			while(true) {
				int data = is.read(buffer); //buffer단위로 읽는다.
				if(data == -1) break; //-1: EOF(바이트 읽을 수 없으면)
				for (int i = 0; i < data; i++) {
					System.out.println(buffer[i]);
				}
			}
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
