package com.saumya.JDBCTryWithResource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Question3 {
	public static void main(String[] args) {
		System.out.println(
				"------------------------------------------------------------------------------------------------");
		System.out.println("3. Write a query to fetch the remaining quantity of the product which are sold?\n");
		System.out.println(
				"------------------------------------------------------------------------------------------------");

		System.out.println(String.format(" " + "%-15s %-20s %-40s %-25s", "product id", "variant id", "product name",
				"remaining"));
		System.out.println(
				"------------------------------------------------------------------------------------------------");

		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/6degree", "root", "root");
				Statement statement = connection.createStatement()) {
			String query3 = "SELECT prod.id AS productid , vari.id AS variantsid , prod.name AS productname , vari.quantity - SUM(odetail.quantity) AS remaining "
					+ "FROM product prod "
					+ "JOIN variants vari ON ( vari.isdeleted = 0 AND prod.id = vari.product_id ) "
					+ "JOIN orderdetails odetail ON ( odetail.isdeleted = 0 AND vari.id = odetail.variants_id ) "
					+ "WHERE prod.isdeleted = 0 " + "GROUP BY odetail.variants_id ;";
			boolean result = statement.execute(query3);

			ResultSet resultSet3 = statement.getResultSet();
			while (resultSet3.next()) {

				System.out.println(String.format("  " + "%-20s %-7s %-50s %-15s", resultSet3.getLong(1),
						resultSet3.getLong(2), resultSet3.getString(3), resultSet3.getInt(4)));
				System.out.println(
						"--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
