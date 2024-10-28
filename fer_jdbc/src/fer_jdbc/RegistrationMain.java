package fer_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.rs.fer.util.DBUtil;

public class RegistrationMain {

	public static void main(String[] args) {
		boolean isRegister = false;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			// 1 & 2

			connection = DBUtil.getConnection();
			// 3. create the statement object
			String query = "INSERT INTO USER (FIRSTNAME,MIDDLENAME,LASTNAME,EMAIL,USERNAME,PASSWORD,MOBILE) VALUES (?,?,?,?,?,?,?)";

			// 3.1 set the parameter values into the prepared Statement

			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, "mamatha");
			preparedStatement.setString(2, "");
			preparedStatement.setString(3, "bikki");
			preparedStatement.setString(4, "bikki@gmail.com");
			preparedStatement.setString(5, "mamatha");
			preparedStatement.setString(6, "Admin");
			preparedStatement.setString(7, "34567890");

			// 4.Execute the statement object

			int numberOfRecAffected = preparedStatement.executeUpdate();
			if (numberOfRecAffected > 0) {
				isRegister = true;
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			// 5
			DBUtil.closeConnection(connection);
		}
		if (isRegister) {
			System.out.println("User registration is done sucessfuly......");
		} else {
			System.out.println("User registration is failed");
		}
	}

}
