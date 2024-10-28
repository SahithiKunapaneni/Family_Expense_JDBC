package fer_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.rs.fer.util.DBUtil;

public class EditExpenseMain {

	public static void main(String[] args) {
		boolean isEditExpense = false;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			// 1 & 2

			connection = DBUtil.getConnection();
			// 3. create the statement object
			String query = "UPDATE EXPENSE SET TYPE=?,DATE=?,PRICE=?,NUMBEROFITEMS =?,TOTAL=?,BYWHOM=? WHERE ID =? ";

			// 3.1 set the parameter values into the prepared Statement

			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, "cloths");
			preparedStatement.setString(2, "24-07-24");
			preparedStatement.setFloat(3, 2000);
			preparedStatement.setInt(4, 1);
			preparedStatement.setFloat(5, 2000);
			preparedStatement.setString(6, "sai");
			preparedStatement.setInt(7, 1);

			// 4.Execute the statement object

			int numberOfRecAffected = preparedStatement.executeUpdate();

			if (numberOfRecAffected > 0) {
				isEditExpense = true;
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {

			DBUtil.closeConnection(connection);
		}
		if (isEditExpense) {
			System.out.println("EXpense Updated sucessfuly......");
		} else {
			System.out.println("Expense Update is failed");
		}
	}

}
