package fer_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.rs.fer.util.DBUtil;

public class UpdateUserMain {

	public static void main(String[] args) {
		boolean isUserUpdate = false;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			// 1 & 2

			connection = DBUtil.getConnection();
			// 3. create the statement object
			String query = "UPDATE USER SET FIRSTNAME =?,MIDDLENAME=?,LASTNAME =?,EMAIL=?,MOBILE =?  WHERE ID =?";

			// 3.1 set the parameter values into the prepared Statement

			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, "Mamatha");
			preparedStatement.setString(2, "");
			preparedStatement.setString(3, "Bikki");
			preparedStatement.setString(4, "bikkimamatha@gmail.com");
			preparedStatement.setString(5, "3456789012");
			preparedStatement.setInt(6, 3);

			// 4.Execute the statement object

			int numberOfRecAffected = preparedStatement.executeUpdate();
			if (numberOfRecAffected > 0) {
				int addressId = 1;
				if (addressId == 0) {
					// insert
					query = "INSERT INTO ADDRESS (LINE1,LINE2,CITY,STATE,PINCODE,COUNTRY,USERID) VALUES (?,?,?,?,?,?,?)";

					preparedStatement = connection.prepareStatement(query);
					preparedStatement.setString(1, "100 FT");
					preparedStatement.setString(2, "Madhapur");
					preparedStatement.setString(3, "HYD");
					preparedStatement.setString(4, "TG");
					preparedStatement.setString(5, "500008");
					preparedStatement.setString(6, "IND");
					preparedStatement.setInt(7, 1);

					numberOfRecAffected = preparedStatement.executeUpdate();

				} else {
					query = "UPDATE ADDRESS SET LINE1=?,LINE2 =?,CITY=?,STATE =?,PINCODE =?,COUNTRY =? WHERE ID =?";
					preparedStatement = connection.prepareStatement(query);
					preparedStatement.setString(1, "100 FT ROAD");
					preparedStatement.setString(2, "Madhapur");
					preparedStatement.setString(3, "HYDERBAD");
					preparedStatement.setString(4, "TG");
					preparedStatement.setString(5, "5000081");
					preparedStatement.setString(6, "IND");
					preparedStatement.setInt(7, 1);

					numberOfRecAffected = preparedStatement.executeUpdate();
				}

				if (numberOfRecAffected > 0) {
					isUserUpdate = true;
				}
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {

			// 5
			DBUtil.closeConnection(connection);
		}
		if (isUserUpdate) {
			System.out.println("User Profile Updated sucessfuly......");
		} else {
			System.out.println("User Profile Update  is failed");
		}
	}

}
