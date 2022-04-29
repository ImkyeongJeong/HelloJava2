package co.micol.student.dao;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

//싱글톤 클래스 패턴
public class DataSource {
	//자기자신 인스턴스 생성
	private static DataSource dataSource = new DataSource();
	//생성자는 외부에서 호출하지 못하게 private지정
	private DataSource() {};
	
	private Connection conn;
	private String driver;
	private String url;
	private String user;
	private String password;
	
	//자신을 객체로 만들어서 getInstance통해 보냄
	public static DataSource getInstance() {
		return dataSource;
	}
	
	public Connection getConnection() {
		configuration();
		try {
			//Class.forName으로 driver로 로드(내 어플리케이션에서 driver를 연결한다)
			Class.forName(driver);
			//연결된 driver를 통해서 터널을 만든다.
			conn = DriverManager.getConnection(url, user, password);
//			System.out.println("DB 연결 성공!!!!!!!!");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("DB 연결 실패....");
		}
		return conn;
		
	}
	//리소스 파일 읽어오도록
	private void configuration() {
		Properties properties = new Properties();
		String resource = getClass().getResource("/db.properties").getPath();
		try {
			properties.load(new FileReader(resource));
			driver = properties.getProperty("driver"); //properties안에 들어있는 key값
			url = properties.getProperty("url");
			user = properties.getProperty("user");
			password = properties.getProperty("password");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
