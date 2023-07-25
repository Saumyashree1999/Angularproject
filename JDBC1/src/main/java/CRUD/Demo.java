package CRUD;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Demo {
	public static void main(String[] args) {

		MySqlConnection mySqlConnection = new MySqlConnection();
		ResultSet resultSet1 = mySqlConnection.getResultSet(mySqlConnection.question1);
		System.out.println("1. Write a Query to fetch shipment all data based on store or designer ?\n");

		System.out.println(
				"shipment id" + String.format("%7s", "") + "created_at" + String.format("%10s", "") + "deleted_at"
						+ String.format("%10s", "") + "updated_at" + String.format("%7s", "") + "order details id"
						+ String.format("%7s", "") + "status id" + String.format("%10s", "") + "logistic partner"
						+ String.format("%15s", "") + "status" + String.format("%30s", "") + "product name" + "\n");

		try {
			while (resultSet1.next()) {

				System.out.print(resultSet1.getLong(1) + "\t" + String.format("%10s", "") + resultSet1.getDate(2)
						+ String.format("%15s", "") + resultSet1.getInt(3) + String.format("%15s", "")
						+ resultSet1.getDate(4) + String.format("%12s", "") + resultSet1.getLong(5)
						+ String.format("%20s", "") + resultSet1.getLong(6) + String.format("%20s", "")
						+ resultSet1.getString(7) + String.format("%15s", "") + resultSet1.getString(8)
						+ String.format("%20s", "") + resultSet1.getString(9) + "\n");
			}
			mySqlConnection.closeConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("--------------------------------------------------------");
		System.out.println("3. Write a query to fetch the remaining quantity of the product which are sold?");
		ResultSet resultSet3 = mySqlConnection.getResultSet(mySqlConnection.question3);

		System.out.println("product id" + String.format("%7s", "") + "variant id" + String.format("%10s", "")
				+ "product name" + String.format("%30s", "") + "remaining" + "\n");
		try {
			while (resultSet3.next()) {
				System.out.println(resultSet3.getLong(1) + String.format("%20s", "") + resultSet3.getLong(2)
						+ String.format("%7s", "") + "\t" + resultSet3.getString(3) + String.format("%18s", "")
						+ resultSet3.getInt(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
