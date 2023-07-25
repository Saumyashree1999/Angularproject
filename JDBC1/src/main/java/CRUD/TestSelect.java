package CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestSelect {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/6degree";
			Connection c = DriverManager.getConnection(url, "root", "root");
			Statement s = c.createStatement();
			String query = "select * from brand";
			boolean res = s.execute(query);
			System.out.println(res);
			
			ResultSet r = s.getResultSet();
			
			while (r.next()) {
				System.out.println("id of brand : " + r.getLong(1));
				System.out.println("created at brand : " + r.getDate(2));
				System.out.println("deleted at brand : " + r.getInt(3));
				System.out.println("updated at brand : " + r.getDate(4));
				System.out.println("name of brand : " + r.getString(5));
				System.out.println("logo of brand : " + r.getString(6));
				System.out.println("description of brand : " + r.getString(7));
				System.out.println("designer of brand : " + r.getLong(8));
				System.out.println("---------------------------------");
			}
			c.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
