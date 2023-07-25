package com.saumya.JDBCTryWithResource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Question1 {
	public static void main(String[] args) {
		System.out.println("1. Write a Query to fetch shipment all data based on store or designer ?");
		System.out.println(
				"-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println(String.format("%-15s %-15s %-15s %-15s %-20s %-15s %-25s %-20s %-40s", "shipment id",
				"created_at", "deleted_at", "updated_at", "order details id", "status id", "logistic partner", "status",
				"product name"));
		System.out.println(
				"-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/6degree", "root", "root");
				Statement statement = connection.createStatement()) {
			String query1 = "SELECT distinct ship.* , sts.name AS status , prod.name AS productname\r\n"
					+ "FROM shipment ship\r\n"
					+ "JOIN status sts ON ( sts.isdeleted = 0 AND ship.status_id = sts.id )\r\n"
					+ "JOIN orderdetails odetail ON ( odetail.isdeleted = 0  AND ship.orderdetails_id = odetail.id )\r\n"
					+ "JOIN variants vari ON ( vari.isdeleted = 0 AND odetail.variants_id = vari.id )\r\n"
					+ "JOIN inventory invent ON ( invent.isdeleted = 0 AND vari.id = invent.variants_id )\r\n"
					+ "JOIN product prod ON ( prod.isdeleted = 0 AND vari.product_id = prod.id )\r\n"
					+ "JOIN store stor ON ( stor.isdeleted = 0 AND invent.store_id = stor.id )\r\n"
					+ "JOIN brand brnd ON ( brnd.isdeleted = 0 AND prod.brand_id = brnd.id ) \r\n"
					+ "JOIN designer design ON ( design.isdeleted = 0 AND brnd.designer_id = design.id ) \r\n"
					+ "WHERE ( stor.id = 3 OR design.id = 1 ) AND ship.isdeleted = 0 \r\n" + "ORDER BY id ASC ;";
			boolean result = statement.execute(query1);

			ResultSet resultSet1 = statement.getResultSet();
			while (resultSet1.next()) {
				System.out.println(String.format(" %-15s %-20s %-10s %-20s %-20s %-15s %-15s %-20s %-15s",
						resultSet1.getLong(1), resultSet1.getDate(2), resultSet1.getInt(3), resultSet1.getDate(4),
						resultSet1.getLong(5), resultSet1.getLong(6), resultSet1.getString(7), resultSet1.getString(8),
						resultSet1.getString(9)));
				System.out.println(
						"-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
