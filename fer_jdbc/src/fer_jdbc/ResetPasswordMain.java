package fer_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.rs.fer.util.DBUtil;

public class ResetPasswordMain {

	public static void main(String[] args) {
		boolean isResetPassword = false;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			// 1 & 2

			connection = DBUtil.getConnection();
			// 3. create the statement object
			String query = "UPDATE USER SET PASSWORD =? WHERE ID =? AND PASSWORD =?";

			// 3.1 set the parameter values into the prepared Statement

			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, "sai");
			preparedStatement.setInt(2, 1);
			preparedStatement.setString(3, "Admin");

			// 4.Execute the statement object

			int numberOfRecAffected = preparedStatement.executeUpdate();

			if (numberOfRecAffected > 0) {
				isResetPassword = true;
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {

			// 5
			DBUtil.closeConnection(connection);
		}
		if (isResetPassword) {
			System.out.println("Password  Updated sucessfuly......");
		} else {
			System.out.println("Password Update is failed");
		}
	}

}
