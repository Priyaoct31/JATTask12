package com.WDB2.Selenium;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class MySQLRead {

	public static void main(String[] args) throws SQLException {

		String URL = "jdbc:mysql://localhost:3306/jatdb2";
		String uname = "root";
		String psw = "1234";

		// Creating connection to mysql db
		Connection con = DriverManager.getConnection(URL, uname, psw);

		// Create statement object to create statement
		Statement s = con.createStatement();

		// Execute the query
		ResultSet rs = s.executeQuery("Select * from creadentials");
        
		/*///  counting the number of rows in resultset
		int rowCount=0;
		while (rs.next())
		{
			rowCount++;
		}
		System.out.println("Total rows in result set are :" +rowCount );
		
		// go to next record as it points to the recoed before first record
		rs.beforeFirst();
		*/
		
		// Iterating thru the result set and data driving the test
		while(rs.next()) {

			// Reading the values from resultsset - method - getstring
			String username = rs.getString("username");
			String password = rs.getString("password");
			
			WebDriver driver = new EdgeDriver();
			driver.get("https://www.saucedemo.com/");
			// Enter unsername
			driver.findElement(By.id("user-name")).sendKeys(username);
			// Enter Password
			driver.findElement(By.id("password")).sendKeys(password);
			// Clicking on login
			driver.findElement(By.id("login-button")).click();
			//driver.close();

		}
		
		
		

	}

}
