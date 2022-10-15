package UserInterface;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
	private static Connection cn;
	
	public static Connection getCon() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost/qlbh", "root", "phongcoi12345");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}		
		return cn;
	}
	public static void main(String[] args) {
		getCon();
	}
}
