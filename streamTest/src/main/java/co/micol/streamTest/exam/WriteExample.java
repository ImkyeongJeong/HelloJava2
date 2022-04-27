package co.micol.streamTest.exam;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class WriteExample {
	//클래스 구성의 기본 
	//멤버변수 정의
	//생성자 정의
	//필요한 메소드(멤버메소드)
	public void run() {
		try {
			//폴더가 없으면 생성 먼저 하고, 경로에 test1.txt생성 값을 저장한다.
			OutputStream os = new FileOutputStream("c:\\Temp\\test1.txt");
			byte[] arr = {'A', 'B', 'C'}; 	//그냥 숫자가 아닌 아스키코드 값
			os.write(arr);
			os.flush();						//버퍼 비우기
			os.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
