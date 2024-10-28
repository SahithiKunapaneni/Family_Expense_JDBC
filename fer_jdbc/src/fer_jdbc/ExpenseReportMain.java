package fer_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.rs.fer.util.DBUtil;

public class ExpenseReportMain {

	public static void main(String[] args) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			// 1 & 2

			connection = DBUtil.getConnection();
			// 3. create the statement object
			String query = "SELECT * FROM EXPENSE WHERE USERID =? AND TYPE =? AND DATE BETWEEN ? AND ? ";

			// 3.1 set the parameter values into the prepared Statement

			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setInt(1, 2);
			preparedStatement.setString(2, "Tea");
			preparedStatement.setString(3, "22-07-24");
			preparedStatement.setString(4, "24-07-24");

			// 4.Execute the statement object

			ResultSet resultset = preparedStatement.executeQuery();

			while (resultset.next()) {
				// a get the column data

				int id = resultset.getInt(1);
				String type = resultset.getString(2);
				String date = resultset.getString(3);
				Float price = resultset.getFloat(4);
				int numberofitems = resultset.getInt(5);
				float total = resultset.getFloat(6);
				String byWhom = resultset.getString(7);

				// b print the data into the console

				System.out.println("ID :" + id);
				System.out.println("Expense Type :" + type);
				System.out.println("Date :" + date);
				System.out.println("Price :" + price);
				System.out.println("Number of Items :" + numberofitems);
				System.out.println("Total :" + total);
				System.out.println("By Whom :" + byWhom);

				System.out.println("...........................");

			}

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {

			DBUtil.closeConnection(connection);
		}

	}

}