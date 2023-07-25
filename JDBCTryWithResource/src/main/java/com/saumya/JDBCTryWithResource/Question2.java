package com.saumya.JDBCTryWithResource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Question2 {
	public static void main(String[] args) {
		System.out.println("\n\n\n" + "2. Write a Query to search a product based on name?");
		System.out.println(
				"-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

		System.out.println(String.format(
				"%-15s %-15s %-12s %-20s %-50s %-75s %-20s %-20s %-15s %-15s %-18s %-17s %-15s %-18s %-23s %-21s %-15s",
				"product_id", "created_at", "deleted_at", "updated_at", "name", "description", "product number",
				"subtype id", "material id", "washcare id", "category id", "brand id", "subtype", "material",
				"washcare", "category", "brand "));
		System.out.println(
				"--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/6degree", "root", "root");
				Statement statement = connection.createStatement()) {
			String query2 = "SELECT prod.*, sub.name AS subtype , mat.name AS material , wash.type AS washcare ,"
					+ " cat.name AS category , brnd.name AS brand " + "  FROM product prod"
					+ " JOIN subtype sub ON (sub.isdeleted = 0 AND sub.id = prod.subtype_id) "
					+ " JOIN material mat ON(mat.isdeleted = 0 AND mat.id = prod.material_id) "
					+ " JOIN washcare wash ON(wash.isdeleted = 0 AND wash.id = prod.washcare_id) "
					+ " JOIN category cat ON(cat.isdeleted = 0 AND cat.id = prod.category_id) "
					+ " JOIN brand brnd ON(brnd.isdeleted = 0 AND brnd.id=prod.brand_id) "
					+ " WHERE prod.name LIKE '%redmi%' AND prod.isdeleted = 0;";
			boolean result = statement.execute(query2);

			ResultSet resultSet2 = statement.getResultSet();
			while (resultSet2.next()) {

				System.out.println(String.format(
						"%-15s %-20s %-8s %-15s %-30s %-100s %-25s %-15s %-20s %-15s"
								+ " %-15s %-15s %-12s %-20s %-20s %-24s %-15s",
						resultSet2.getLong(1), resultSet2.getDate(2), resultSet2.getInt(3), resultSet2.getDate(4),
						resultSet2.getString(5), resultSet2.getString(6), resultSet2.getString(7),
						resultSet2.getLong(8), resultSet2.getLong(9), resultSet2.getLong(10), resultSet2.getLong(11),
						resultSet2.getLong(12), resultSet2.getString(13), resultSet2.getString(14),
						resultSet2.getString(15), resultSet2.getString(16), resultSet2.getString(17)));
				System.out.println(
						"--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
