//3. Write a query to fetch the remaining quantity of the product which are sold?
package CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Q3 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/6degree";
			Connection c = DriverManager.getConnection(url, "root", "root");
			Statement s = c.createStatement();
			String query = "SELECT prod.id AS productid , vari.id AS variantsid , prod.name AS productname , vari.quantity - SUM(odetail.quantity) AS remaining \r\n"
					+ "FROM product prod\r\n"
					+ "JOIN variants vari ON ( vari.isdeleted = 0 AND prod.id = vari.product_id )\r\n"
					+ "JOIN orderdetails odetail ON ( odetail.isdeleted = 0 AND vari.id = odetail.variants_id ) \r\n"
					+ "WHERE prod.isdeleted = 0 \r\n"
					+ "GROUP BY odetail.variants_id ;\r\n"
					+ "" ;
			boolean res = s.execute(query);
			System.out.println(res);
				
			ResultSet r = s.getResultSet();
			
			while (r.next()) {
				System.out.println("product id : " + r.getLong(1));
				System.out.println("variant id : " + r.getLong(2));
				System.out.println("product name : " + r.getString(3));
				System.out.println("remaining : " + r.getInt(4));
							
				System.out.println("---------------------------------");
			}
			c.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
