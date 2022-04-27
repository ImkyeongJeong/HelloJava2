package co.micol.streamTest.exam;

import java.io.FileReader;
import java.io.Reader;

public class ReaderExample {
	public void run() {
		try {
			Reader reader = new FileReader("c:\\Temp\\test1.txt");
			while(true) {
				int data = reader.read();
				if(data == -1) break;
				System.out.println((char)data); //넘어온 데이터를 char형으로 출력해달라 
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
