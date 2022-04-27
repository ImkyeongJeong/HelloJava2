package co.micol.fileCopy.exam;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;

public class fileCopy {
	public void run() {
		try {
			Reader reader = new FileReader("c:\\Temp\\source.txt");
			Writer writer = new FileWriter("c:\\Temp\\sourceCopy.txt");
			while(true) {
				int data = reader.read();
				if(data == -1) break;
				writer.append((char)data);
			}
			reader.close();
			writer.flush();
			writer.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
