package compteClient.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBC {

	private final static String BDPATH = "jdbc:mysql://localhost:3306/clients";
	private final static String DBUSER = "admin";
	private final static String DBPASSWORD = "admin";

	private static Connection connection;

	public void connecter() throws ClassNotFoundException, SQLException {
		// Load the database driver
		Class.forName("com.mysql.jdbc.Driver");
		// Create the jdbc connection
		connection = DriverManager.getConnection(BDPATH, DBUSER, DBPASSWORD);
	}

	public void insertData(String utilisateur, String password, String mail, String questionSecrete,
			String reponseSecrete, String nom, String prenom) throws SQLException {
		Statement statement = null;

		try {
			statement = connection.createStatement();
			String sql = "INSERT INTO clients (`utilisateur`,`password`,`mail`,`question_secrete`,`reponse_secrete`,`nom`, `prenom`) VALUES ('"
					+ utilisateur + "', '" + password + "', '" + mail + "', '" + questionSecrete + "', '"
					+ reponseSecrete + "', '" + nom + "', '" + prenom + "')";
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("An error occured trying to insert the new data !");
		} finally {
			statement.close();
		}

		System.out.println();
	}

	// public static void insertData(String nom, String prenom) throws SQLException
	// {
	// Statement statement = null;
	//
	// try {
	// statement = connection.createStatement();
	// String sql = "INSERT INTO `apprenant` (`nom`, `prenom`) VALUES ('" + nom +
	// "', '" + prenom + "')";
	// statement.executeUpdate(sql);
	// }
	// catch(SQLException e){
	// System.out.println("An error occured trying to insert the new data !");
	// }
	// finally{
	// statement.close();
	// }
	//
	// System.out.println();
	// }

	public static void showData() throws SQLException {
		Statement statement = null;
		ResultSet rs = null;

		// Create the statement
		statement = connection.createStatement();
		String sql = "SELECT * FROM clients";

		// Execute the query
		rs = statement.executeQuery(sql);

		// Loop on the results extracted from the database
		System.out.println("Liste actuelle des clients :");
		while (rs.next()) {
			System.out.println(
					"  - " + rs.getString("idclients") + " : " + rs.getString("prenom") + " " + rs.getString("nom"));
		}

		statement.close();

		System.out.println();
	}
}
