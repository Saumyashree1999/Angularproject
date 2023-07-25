//2. Write a Query to search a product based on name?
package CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcQuery {
	public static void main(String[] args) {

		MySqlConnection mySqlConnection = new MySqlConnection();
		ResultSet resultSet1 = mySqlConnection.getResultSet(mySqlConnection.question1);
		System.out.println("1. Write a Query to fetch shipment all data based on store or designer ?");
		System.out.println(
				"-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println(String.format("%-15s %-15s %-15s %-15s %-20s %-15s %-25s %-20s %-40s", "shipment id",
				"created_at", "deleted_at", "updated_at", "order details id", "status id", "logistic partner", "status",
				"product name"));
		System.out.println(
				"-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		try {
			while (resultSet1.next()) {
				System.out.println(String.format(" %-15s %-20s %-10s %-20s %-20s %-15s %-15s %-20s %-15s",
						resultSet1.getLong(1), resultSet1.getDate(2), resultSet1.getInt(3), resultSet1.getDate(4),
						resultSet1.getLong(5), resultSet1.getLong(6), resultSet1.getString(7), resultSet1.getString(8),
						resultSet1.getString(9)));
				System.out.println(
						"-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			}

			// mySqlConnection.closeConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			mySqlConnection.closeConnection();

		}
		System.out.println("\n\n\n" + "2. Write a Query to search a product based on name?");
		System.out.println(
				"-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		ResultSet resultSet2 = mySqlConnection.getResultSet(mySqlConnection.question2);

		System.out.println(String.format(
				"%-15s %-15s %-12s %-20s %-50s %-75s %-20s %-20s %-15s %-15s %-18s %-17s %-15s %-18s %-23s %-21s %-15s",
				"product_id", "created_at", "deleted_at", "updated_at", "name", "description", "product number",
				"subtype id", "material id", "washcare id", "category id", "brand id", "subtype", "material",
				"washcare", "category", "brand "));
		System.out.println(
				"--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		try {
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
		} finally {
			mySqlConnection.closeConnection();

		}
		System.out
				.println("\n\n\n" + "3. Write a query to fetch the remaining quantity of the product which are sold?");
		System.out.println("----------------------------------------------------------------------------------------");
		ResultSet resultSet3 = mySqlConnection.getResultSet(mySqlConnection.question3);
		System.out.println(String.format(" " + "%-15s %-20s %-40s %-25s", "product id", "variant id", "product name",
				"remaining"));
		System.out.println("----------------------------------------------------------------------------------------");
		try {
			while (resultSet3.next()) {
				System.out.println(String.format("  " + "%-20s %-7s %-50s %-15s", resultSet3.getLong(1),
						resultSet3.getLong(2), resultSet3.getString(3), resultSet3.getInt(4)));
				System.out.println(
						"----------------------------------------------------------------------------------------");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			mySqlConnection.closeConnection();

		}
	}
}
