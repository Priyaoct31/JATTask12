package mysqltask;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Task12 {

	public static void main(String[] args)  {
		
		String createTableSQL = "CREATE TABLE emplpriya ("
                + "empcode INT NOT NULL, "
                + "empname VARCHAR(50), "
                + "empage INT, "
                + "esalary DECIMAL(10, 2), "
                + "PRIMARY KEY (empcode)"
                + ")";
		String insertDataSQL = "INSERT INTO emplpriya (empcode, empname, empage, esalary) VALUES (?, ?, ?, ?)";
		
		
		try {
			
			//Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/priya", "root", "Priya@143");
			Statement stmt = con.createStatement();

            // Execute the query to create the table
            stmt.executeUpdate(createTableSQL);
            System.out.println("Table 'emplpriya' created successfully or already exists.");

            // Prepare statement to insert data into the employee table
            PreparedStatement pstmt = con.prepareStatement(insertDataSQL);

            // Insert multiple rows of employee data
            // Employee 1
            pstmt.setInt(1, 101);
            pstmt.setString(2, "Jenny");
            pstmt.setInt(3, 25);
            pstmt.setBigDecimal(4, new java.math.BigDecimal("10000"));
            pstmt.executeUpdate();

            // Employee 2
            pstmt.setInt(1, 102);
            pstmt.setString(2, "Jacky");
            pstmt.setInt(3, 30);
            pstmt.setBigDecimal(4, new java.math.BigDecimal("20000"));
            pstmt.executeUpdate();

            // Employee 3
            pstmt.setInt(1, 103);
            pstmt.setString(2, "Joe");
            pstmt.setInt(3, 20);
            pstmt.setBigDecimal(4, new java.math.BigDecimal("40000"));
            pstmt.executeUpdate();

            // Employee 4
            pstmt.setInt(1, 104);
            pstmt.setString(2, "John");
            pstmt.setInt(3, 40);
            pstmt.setBigDecimal(4, new java.math.BigDecimal("80000"));
            pstmt.executeUpdate();

            // Employee 5
            pstmt.setInt(1, 105);
            pstmt.setString(2, "Shameer");
            pstmt.setInt(3, 25);
            pstmt.setBigDecimal(4, new java.math.BigDecimal("90000"));
            pstmt.executeUpdate();

            System.out.println("Data inserted successfully into 'emplpriya' table.");
			
		}
		
		catch(Exception e) {
			
			System.out.println(e.toString());
		}
		

	}

}
