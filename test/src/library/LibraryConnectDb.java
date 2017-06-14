package library;

import java.sql.Connection;
import java.sql.DriverManager;

public class LibraryConnectDb {
	private Connection conn;
	private String url = "jdbc:mysql://localhost:3306/project1?useUnicode=true&characterEncoding=UTF-8";
	private String user = "root";
	private String password = "";
	
	public Connection getConnectMySql(){
		// nap driver
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//tao chuoi con
			conn = DriverManager.getConnection(url,user,password);
		} catch (Exception e) {
			System.out.println("Can not load driver");
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void main(String[] args) {
		LibraryConnectDb lDb = new LibraryConnectDb();
		System.out.println(lDb.getConnectMySql());
	}
}
