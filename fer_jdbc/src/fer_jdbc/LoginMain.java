package fer_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.rs.fer.util.DBUtil;

public class LoginMain {

	public static void main(String[] args) {
		boolean isValidUser = false;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			// 1 & 2

			connection = DBUtil.getConnection();
			// 3. create the statement object
			String query = "SELECT * FROM USER WHERE USERNAME =? AND PASSWORD =?";

			// 3.1 set the parameter values into the prepared Statement

			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, "sahithi");
			preparedStatement.setString(2, "Admi");

			// 4.Execute the statement object

			ResultSet resultset = preparedStatement.executeQuery();

			while (resultset.next()) {
				isValidUser = true;
			}

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
              // 5
			DBUtil.closeConnection(connection);
		}
		if (isValidUser) {
			System.out.println("Welcome to the user : Sahithi");
		} else {
			System.out.println("Incorrect username/password please try again");
		}
	}

}
