package com.rs.fer.service.impl;

import java.util.List;

import com.rs.fer.bean.Address;
import com.rs.fer.bean.Expense;
import com.rs.fer.bean.User;
import com.rs.fer.service.FERService;

import junit.framework.TestCase;

public class FERServiceImplTest extends TestCase {
	FERService ferService = new FERServiceImpl();

	// Login
	public void testLogin() {
		// 1.get the input
		String username = "Vinu";
		String password = "Vinu";
		// 2 call the service by passing the input to execute the bussiness logic
		boolean expected = true;
		boolean actual = ferService.login(username, password);

		// 3 assertion
		assertEquals(expected, actual);
	}

	public void testLoginBothInvalid() {
		// 1.get the input
		String username = "Sahithis";
		String password = "Sahithis";
		// 2 call the service by passing the input to execute the bussiness logic
		boolean expected = false;
		boolean actual = ferService.login(username, password);

		// 3 assertion
		assertEquals(expected, actual);
	}

	public void testLoginInvalidPassword() {
		// 1.get the input
		String username = "Sahithi";
		String password = "Admin";
		// 2 call the service by passing the input to execute the bussiness logic
		boolean expected = false;
		boolean actual = ferService.login(username, password);

		// 3 assertion
		assertEquals(expected, actual);
	}

	public void testLoginInvalidUsername() {
		// 1.get the input
		String username = "Vinu";
		String password = "Vinays";
		// 2 call the service by passing the input to execute the bussiness logic
		boolean expected = false;
		boolean actual = ferService.login(username, password);

		// 3 assertion
		assertEquals(expected, actual);
	}

	// Registration
	public void testRegistration() {
		// 1.get the input

		User user = new User();
		user.setFirstName("Vinu");
		user.setMiddleName("Kumar");
		user.setLastName("Bikki");
		user.setEmail("bikkisai@rs.com");
		user.setUsername("Vinu");
		user.setPassword("Vinu");
		user.setMobile("1234567890");

		// 2 call the service by passing the input to execute the bussiness logic
		boolean expected = true;
		boolean actual = ferService.registration(user);
		// 3 assertion
		assertEquals(expected, actual);
	}

	public void testRegistrationInvalid() {
		// 1.get the input

		User user = new User();
		user.setFirstName("Vinu");
		user.setMiddleName("Kumar");
		user.setLastName("Bikki");
		// user.setEmail("bikkisai@rs.com");
		// user.setUsername("Vinu");
		user.setPassword("Vinu");
		user.setMobile("1234567890");

		// 2 call the service by passing the input to execute the bussiness logic
		boolean expected = false;
		boolean actual = ferService.registration(user);
		// 3 assertion
		assertEquals(expected, actual);
	}
	// Add Expense

	public void testAddExpense() {
		// 1.get the input

		Expense expense = new Expense();
		expense.setType("Watch");
		expense.setDate("25-07-24");
		expense.setPrice(2000);
		expense.setNumberOfItems(1);
		expense.setTotal(2000);
		expense.setByWhom("sai");
		expense.setUserId(4);

		// 2 call the service by passing the input to execute the bussiness logic
		boolean expected = true;
		boolean actual = ferService.addExpense(expense);
		// 3 assertion

		assertEquals(expected, actual);

	}

	public void testAddExpenseInvaild() {
		// 1.get the input

		Expense expense = new Expense();
		// expense.setType("Watch");
		// expense.setDate("25-07-24");
		expense.setPrice(2000);
		expense.setNumberOfItems(1);
		expense.setTotal(2000);
		expense.setByWhom("sai");
		expense.setUserId(4);

		// 2 call the service by passing the input to execute the bussiness logic
		boolean expected = false;
		boolean actual = ferService.addExpense(expense);
		// 3 assertion

		assertEquals(expected, actual);

	}
	// EditExpense

	public void testEditExpense() {
		// 1.get the input

		Expense expense = new Expense();
		expense.setType("Milk");
		expense.setDate("21-07-24");
		expense.setPrice(20);
		expense.setNumberOfItems(5);
		expense.setTotal(100);
		expense.setByWhom("Me");
		expense.setId(5);

		// 2 call the service by passing the input to execute the bussiness logic
		boolean expected = true;
		boolean actual = ferService.editExpense(expense);
		// 3 assertion
		assertEquals(expected, actual);
	}

	public void testEditExpenseInvalid() {
		// 1.get the input

		Expense expense = new Expense();
		expense.setType("Milk");
		expense.setDate("21-07-24");
		 expense.setPrice(20);
		expense.setNumberOfItems(5);
		expense.setTotal(100);
		expense.setByWhom("Me");
		expense.setId(100);

		// 2 call the service by passing the input to execute the bussiness logic
		boolean expected = false;
		boolean actual = ferService.editExpense(expense);
		// 3 assertion
		assertEquals(expected, actual);
	}
	
	
	// Delete Expense

	public void testDelete() {
		// 1.get the input
		int expenseId = 11;

		// 2 call the service by passing the input to execute the bussiness logic
		boolean expected = true;
		boolean actual = ferService.deleteExpense(expenseId);
		assertEquals(expected, actual);

	}

	public void testDeleteInvalid() {
		// 1.get the input
		int expenseId = 6;

		// 2 call the service by passing the input to execute the bussiness logic
		boolean expected = false;
		boolean actual = ferService.deleteExpense(expenseId);
		assertEquals(expected, actual);

	}
	
	// Reset password

	public void testResetPassword() {
		// 1.get the input
		int userId = 25;
		String newPassword = "vinay";
		String currentPassword = "Vinu";
		// 2 call the service by passing the input to execute the bussiness logic
		boolean expected = true;
		boolean actual = ferService.resetPassword(userId, newPassword, currentPassword);
		assertEquals(expected, actual);
	}
	
	public void testResetPasswordInvalid() {
		// 1.get the input
		int userId = 26;
		String newPassword = "Vinay";
		String currentPassword = "vinu";
		// 2 call the service by passing the input to execute the bussiness logic
		boolean expected = false;
		boolean actual = ferService.resetPassword(userId, newPassword, currentPassword);
		assertEquals(expected, actual);
	}
	
	// Update Profile
	public void testUpdateProfile() {
		// 1.get the input

				int UserId = 20;

				// 2 call the service by passing the input to execute the bussiness logic


				User user = ferService.getUser(UserId);
				// update Name screen field values
				user.setFirstName("Sai");
				user.setMiddleName("Pavan");
				user.setLastName("Kumar");

				// update contact information
				user.setEmail("sai@gmail.com");
				user.setMobile("9848169719");

				// update Address
				Address address = user.getAddress();

				address.setLineone("5-30");
				address.setLinetwo("Chintalapadu");
				address.setCity("Nandigama");
				address.setState("AP");
				address.setPinCode("500311");
				address.setCountry("IND");
                boolean expected = true;
				boolean actual = ferService.updateUser(user);
				assertEquals(expected, actual);
		
	}
	
	/*
	public void testUpdateProfileInvalid() {
		// 1.get the input

				int UserId = 200;

				// 2 call the service by passing the input to execute the bussiness logic

				User user = ferService.getUser(UserId);
				// update Name screen field values
				user.setFirstName("Sai");
				user.setMiddleName("Pavan");
				user.setLastName("Kumar");

				// update  contact information
				user.setEmail("sai@gmail.com");
				user.setMobile("9848169719");

				// update Address
				Address address = user.getAddress();

				address.setLineone("5-30");
				address.setLinetwo("Chintalapadu");
				address.setCity("Nandigama");
				address.setState("AP");
				address.setPinCode("50031");
				address.setCountry("IND");
                boolean expected = false;
				boolean actual = ferService.updateUser(user);
				assertEquals(expected, actual);
		
	}
	*/
	// get expense
	public void testGetExpense() {
		// 1.get the input

				int ExpenseId = 10;

				// 2 call the service by passing the input to execute the bussiness logic
                
				Expense expense = ferService.getExpense(ExpenseId);
				assertNotNull(expense);
	}
	public void testGetExpenseNotFound() {
		// 1.get the input

				int ExpenseId = 4;

				// 2 call the service by passing the input to execute the bussiness logic
                
				Expense expense = ferService.getExpense(ExpenseId);
				assertNull(expense);
	}
	// get user
	public void testGetUser() {
		// 1.get the input

				int UserId = 2;

				// 2 call the service by passing the input to execute the bussiness logic

				User user = ferService.getUser(UserId);
				assertNotNull(user);
	}
	public void testGetUserNotFound() {
		// 1.get the input

				int UserId = 200;

				// 2 call the service by passing the input to execute the bussiness logic

				User user = ferService.getUser(UserId);
				assertNull(user);
	}
	
	// get expense options
	public void testGetExpenseOptions() {
		// 1.get the input

				int userId = 2;

				// 2 call the service by passing the input to execute the bussiness logic

				List<Expense> expenses = ferService.getExpenseOptions(userId);
                boolean expectedIsEmpty =false;
                boolean actualIsEmpty =expenses.isEmpty();
                assertEquals(expectedIsEmpty, actualIsEmpty);
		
	}
	public void testGetExpenseOptionsNotFound() {
		// 1.get the input

				int userId = 500;

				// 2 call the service by passing the input to execute the bussiness logic

				List<Expense> expenses = ferService.getExpenseOptions(userId);
                boolean expectedIsEmpty =true;
                boolean actualIsEmpty =expenses.isEmpty();
                assertEquals(expectedIsEmpty, actualIsEmpty);
		
	}
	
	// get expense report 
	public void testGetExpenseReport() {
		// 1.get the input

				int userId = 2;
				String expenseType = "Milk";
				String fromDate = "20-07-24";
				String toDate = "25-07-24";

				// 2 call the service by passing the input to execute the bussiness logic

				List<Expense> expenses = ferService.getExpenseReport(userId, expenseType, fromDate, toDate);
                boolean expectedIsEmpty=false;
                boolean acutualIsEmpty =expenses.isEmpty();
                assertEquals(expectedIsEmpty, acutualIsEmpty);
                
	}
	
	public void testGetExpenseReportNotFound() {
		// 1.get the input

				int userId = 2;
				String expenseType = "Tea";
				String fromDate = "20-07-24";
				String toDate = "25-07-24";

				// 2 call the service by passing the input to execute the bussiness logic

				List<Expense> expenses = ferService.getExpenseReport(userId, expenseType, fromDate, toDate);
                boolean expectedIsEmpty=true;
                boolean acutualIsEmpty =expenses.isEmpty();
                assertEquals(expectedIsEmpty, acutualIsEmpty);
                
	}
	public void testGetExpenseReportNotFoundId() {
		// 1.get the input

				int userId = 100;
				String expenseType = "Tea";
				String fromDate = "20-07-24";
				String toDate = "25-07-24";

				// 2 call the service by passing the input to execute the bussiness logic

				List<Expense> expenses = ferService.getExpenseReport(userId, expenseType, fromDate, toDate);
                boolean expectedIsEmpty=true;
                boolean acutualIsEmpty =expenses.isEmpty();
                assertEquals(expectedIsEmpty, acutualIsEmpty);
                
	}
	
}
