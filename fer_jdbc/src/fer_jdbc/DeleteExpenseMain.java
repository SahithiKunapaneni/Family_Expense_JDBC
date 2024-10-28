package fer_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.rs.fer.util.DBUtil;

public class DeleteExpenseMain {

	public static void main(String[] args) {
		boolean isDeleteExpense = false;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			// 1 & 2

			connection = DBUtil.getConnection();
			// 3. create the statement object
			String query = "DELETE FROM EXPENSE WHERE ID =?";

			// 3.1 set the parameter values into the prepared Statement

			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setInt(1, 2);

			// 4.Execute the statement object

			int numberOfRecAffected = preparedStatement.executeUpdate();
			if (numberOfRecAffected > 0) {
				isDeleteExpense = true;
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {

			DBUtil.closeConnection(connection);
		}
		if (isDeleteExpense) {
			System.out.println("Expense Deleted  sucessfuly......");
		} else {
			System.out.println("Delete is failed");
		}
	}

}
