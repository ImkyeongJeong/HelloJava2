package co.micol.notice.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataSource {
	//자기 자신 인스턴스 생성
	private static DataSource datasource = new DataSource();
	//외부에서 생성하지 못하도록 private 기본생성자 생성
	private DataSource () {};
	
	private Connection conn;
	private String driver;		
	private String url;			
	private String user;		
	private String password;	
	
	//내가 만든 인스턴스를 getInstance통해 보냄
	public static DataSource getInstance() {
		return datasource;
	}
	
	//connection객체를 사용할 수 있도록
	public Connection getConnection() {
		dbConfig();
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	//db.properties파일 읽어올 수 있도록 메소드 생성
	private void dbConfig() {
		Properties properties = new Properties();
		//db.properties내용을 resources에 대입
		String resources = getClass().getResource("/db.properties").getPath();
		
		//resources읽기
		try {
			properties.load(new FileInputStream(resources));
			driver = properties.getProperty("driver"); //db.properties의 key값
			url = properties.getProperty("url");
			user = properties.getProperty("user");
			password = properties.getProperty("password");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
