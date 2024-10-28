package fer_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.rs.fer.util.DBUtil;

public class GetUserMain {

	public static void main(String[] args) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			// 1 & 2

			connection = DBUtil.getConnection();
			// 3. create the statement object
			String query = "SELECT U.*,A.* FROM USER U LEFT JOIN ADDRESS A ON U.ID=A.USERID WHERE U.ID=?  ";

			// 3.1 set the parameter values into the prepared Statement

			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setInt(1, 1);

			// 4.Execute the statement object

			ResultSet resultset = preparedStatement.executeQuery();

			while (resultset.next()) {
				// a get the column data

				// user column data
				int id = resultset.getInt(1);
				String firstname = resultset.getString(2);
				String middlename = resultset.getString(3);
				String lastname = resultset.getString(4);
				String email = resultset.getString(5);
				String Username = resultset.getString(6);
				String Password = resultset.getString(7);
				String mobile = resultset.getString(8);

				// address column data
				int addrID = resultset.getInt(9);
				String lineone = resultset.getString(10);
				String linetwo = resultset.getString(11);
				String city = resultset.getString(12);
				String state = resultset.getString(13);
				String pincode = resultset.getString(14);
				String country = resultset.getString(15);
				int uid = resultset.getInt(16);

				// b print the data into the console

				// name info
				System.out.println(".....Name Info......");
				System.out.println("First Name :" + firstname);
				System.out.println("Middle Name :" + middlename);
				System.out.println("Last Name :" + lastname);
				System.out.println("........................");
				System.out.println(".....Contact Info......");
				System.out.println("Email Id :" + email);
				System.out.println("Mobile :" + mobile);

				System.out.println(".....Address......");

				System.out.println("ID:" + id);
				System.out.println("Line1 :" + lineone);
				System.out.println("Line2:" + linetwo);
				System.out.println("City :" + city);
				System.out.println("State :" + state);
				System.out.println("Pin Code:" + pincode);
				System.out.println("Country :" + country);
				
			}

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			// 5
			DBUtil.closeConnection(connection);
		}

	}

}
