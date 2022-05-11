package com.yedam.java.com;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataSource {
	private static DataSource datasource = new DataSource();
	private DataSource() {};
	public static DataSource getInstance() {
		return datasource;
	}
	
	private Connection conn;
	private String driver;
	private String url;
	private String user;
	private String password;
	
	public Connection getConnection() {
		dbConfig();
		try {
			Class.forName(driver); //ojdbc를 갖고 있는 드라이버를 로딩
			conn = DriverManager.getConnection(url, user, password); //driverManager를 통해 db에 연결한다.(DB접근 주소, DB권한 가진 계정과 비밀번호 갖고 옴)
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	private void dbConfig() {
		Properties properties = new Properties();
		String resources = getClass().getResource("/db.properties").getPath();
		try {
			properties.load(new FileInputStream(resources));
			driver = properties.getProperty("driver");
			url = properties.getProperty("url");
			user = properties.getProperty("user");
			password = properties.getProperty("password");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
