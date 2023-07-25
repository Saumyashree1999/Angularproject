//1. Write a Query to fetch shipment all data based on store or designer?
package CRUD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Q1 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/6degree";
			Connection c = DriverManager.getConnection(url, "root", "root");
			Statement s = c.createStatement();
			String query = "SELECT ship.* , sts.name AS status , prod.name AS productname\r\n"
					+ "FROM shipment ship\r\n"
					+ "JOIN status sts ON ( sts.isdeleted = 0 AND ship.status_id = sts.id )\r\n"
					+ "JOIN orderdetails odetail ON ( odetail.isdeleted = 0  AND ship.orderdetails_id = odetail.id )\r\n"
					+ "JOIN variants vari ON ( vari.isdeleted = 0 AND odetail.variants_id = vari.id )\r\n"
					+ "JOIN inventory invent ON ( invent.isdeleted = 0 AND vari.id = invent.variants_id )\r\n"
					+ "JOIN product prod ON ( prod.isdeleted = 0 AND vari.product_id = prod.id )\r\n"
					+ "JOIN store stor ON ( stor.isdeleted = 0 AND invent.store_id = stor.id )\r\n"
					+ "JOIN brand brnd ON ( brnd.isdeleted = 0 AND prod.brand_id = brnd.id ) \r\n"
					+ "JOIN designer design ON ( design.isdeleted = 0 AND brnd.designer_id = design.id ) \r\n"
					+ "WHERE ( stor.id = 3 OR design.id = 1 ) AND ship.isdeleted = 0 \r\n"
					+ "ORDER BY id ASC ;" ;
			boolean res = s.execute(query);
			System.out.println(res);
			
			ResultSet r = s.getResultSet();
			
			while (r.next()) {
				System.out.println("shipment id : " + r.getLong(1));
				System.out.println("created at : " + r.getDate(2));
				System.out.println("deleted at : " + r.getInt(3));
				System.out.println("updated at : " + r.getDate(4));
				System.out.println("order details id : " + r.getLong(5));
				System.out.println("status id : " + r.getLong(6));
				System.out.println("logistic partner : " + r.getString(7));
				System.out.println("status : " + r.getString(8));
				System.out.println("product name : " + r.getString(9));
							
				System.out.println("---------------------------------");
			}
			c.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
