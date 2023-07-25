package CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySqlConnection {

	private ResultSet resultSet = null;
	private Connection connection = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;

	String question1 = "SELECT distinct ship.* , sts.name AS status , prod.name AS productname\r\n"
			+ "FROM shipment ship\r\n" + "JOIN status sts ON ( sts.isdeleted = 0 AND ship.status_id = sts.id )\r\n"
			+ "JOIN orderdetails odetail ON ( odetail.isdeleted = 0  AND ship.orderdetails_id = odetail.id )\r\n"
			+ "JOIN variants vari ON ( vari.isdeleted = 0 AND odetail.variants_id = vari.id )\r\n"
			+ "JOIN inventory invent ON ( invent.isdeleted = 0 AND vari.id = invent.variants_id )\r\n"
			+ "JOIN product prod ON ( prod.isdeleted = 0 AND vari.product_id = prod.id )\r\n"
			+ "JOIN store stor ON ( stor.isdeleted = 0 AND invent.store_id = stor.id )\r\n"
			+ "JOIN brand brnd ON ( brnd.isdeleted = 0 AND prod.brand_id = brnd.id ) \r\n"
			+ "JOIN designer design ON ( design.isdeleted = 0 AND brnd.designer_id = design.id ) \r\n"
			+ "WHERE ( stor.id = 3 OR design.id = 1 ) AND ship.isdeleted = 0 \r\n" + "ORDER BY id ASC ;";

	String question2 = "SELECT prod.*, sub.name AS subtype , mat.name AS material , wash.type AS washcare ,"
			+ " cat.name AS category , brnd.name AS brand " + "  FROM product prod"
			+ " JOIN subtype sub ON (sub.isdeleted = 0 AND sub.id = prod.subtype_id) "
			+ " JOIN material mat ON(mat.isdeleted = 0 AND mat.id = prod.material_id) "
			+ " JOIN washcare wash ON(wash.isdeleted = 0 AND wash.id = prod.washcare_id) "
			+ " JOIN category cat ON(cat.isdeleted = 0 AND cat.id = prod.category_id) "
			+ " JOIN brand brnd ON(brnd.isdeleted = 0 AND brnd.id=prod.brand_id) "
			+ " WHERE prod.name LIKE '%redmi%' AND prod.isdeleted = 0;";

	String question3 = "SELECT prod.id AS productid , vari.id AS variantsid , prod.name AS productname , vari.quantity - SUM(odetail.quantity) AS remaining "
			+ "FROM product prod " + "JOIN variants vari ON ( vari.isdeleted = 0 AND prod.id = vari.product_id ) "
			+ "JOIN orderdetails odetail ON ( odetail.isdeleted = 0 AND vari.id = odetail.variants_id ) "
			+ "WHERE prod.isdeleted = 0 " + "GROUP BY odetail.variants_id ;";

	public ResultSet getResultSet(String query) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/6degree", "root", "root");

			this.preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			// this.statement = connection.createStatement();

			// boolean result = statement.execute(query);

			// resultSet = statement.getResultSet();
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return this.resultSet;

	}

	public void closeConnection() {
		try {
			this.connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
