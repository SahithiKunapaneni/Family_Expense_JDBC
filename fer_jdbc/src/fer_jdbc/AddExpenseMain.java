package fer_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.rs.fer.util.DBUtil;

public class AddExpenseMain {

	public static void main(String[] args) {
		boolean isAddExpense = false;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			// 1 & 2

			connection = DBUtil.getConnection();
			// 3. create the statement object
			String query = "INSERT INTO EXPENSE (TYPE,DATE,PRICE,NUMBEROFITEMS,TOTAL,BYWHOM,USERID) VALUES (?,?,?,?,?,?,?)";

			// 3.1 set the parameter values into the prepared Statement

			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, "coffee");
			preparedStatement.setString(2, "24-07-24");
			preparedStatement.setFloat(3, 30);
			preparedStatement.setInt(4, 5);
			preparedStatement.setFloat(5, 150);
			preparedStatement.setString(6, "Me");
			preparedStatement.setInt(7, 2);

			// 4.Execute the statement object

			int numberOfRecAffected = preparedStatement.executeUpdate();

			if (numberOfRecAffected > 0) {
				isAddExpense = true;
			}

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {

			// 5
			DBUtil.closeConnection(connection);
		}
		if (isAddExpense) {
			System.out.println("EXpense Added sucessfuly......");
		} else {
			System.out.println("Expense Add is failed");
		}
	}

}
