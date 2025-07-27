package com.servlet.implementationOfEmployee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.servlet.connectionProvider.ConnectionProvider;
import com.servlet.interfaceOperation.Employee;
import com.servlet.interfaceOperation.EmployeeService;

/**
 * Implementation of EmployeeService interface.
 * Handles CRUD operations for Employee records using JDBC and Oracle DB.
 */
public class EmployeeServiceImplementation implements EmployeeService {
    
    // Connection object for database access
    private Connection connection;

    /**
     * Inserts a new employee into the Employee table.
     * 
     * @param emp Employee object to be inserted
     * @return true if insertion was successful, false otherwise
     */
    @Override
    public boolean insertData(Employee emp) {
        boolean result = false;
        connection = ConnectionProvider.getConnection();  // Establish DB connection

        if (connection == null) {
            System.out.println("Connection is null.");
            return false;
        }

        // SQL query with place holders to prevent SQL injection
        String insertQuery = "INSERT INTO Employee (name, id, aadharNo) VALUES (?, ?, ?)";

        try (PreparedStatement psmt = connection.prepareStatement(insertQuery)) {
            // Set values from the Employee object
            psmt.setString(1, emp.getName());
            psmt.setInt(2, emp.getId());
            psmt.setString(3, emp.getAadharNo());

            int execute = psmt.executeUpdate();  // Execute the insert query

            if (execute >= 1) {
                result = true;  // At least one row affected
            }

        } catch (SQLException e) {
            System.err.println("Exception while inserting employee:");
            e.printStackTrace();
        }

        return result;
    }

    /**
     * Updates an employee's Aadhar number based on the current ID and old Aadhar.
     * 
     * @param id Employee ID
     * @param oldAadhar Old Aadhar number
     * @param newAadhar New Aadhar number to be updated
     * @return true if update is successful, false otherwise
     */
    @Override
    public boolean updateData(int id, String oldAadhar, String newAadhar) {
        boolean result = false;
        connection = ConnectionProvider.getConnection();

        String updateQuery = "UPDATE Employee SET aadharNo = ? WHERE aadharNo = ? AND id = ?";

        try (PreparedStatement psmt = connection.prepareStatement(updateQuery)) {
            psmt.setString(1, newAadhar);
            psmt.setString(2, oldAadhar);
            psmt.setInt(3, id);

            int executeUpdate = psmt.executeUpdate();

            if (executeUpdate >= 1) {
                result = true;  // Aadhar updated
            }

        } catch (SQLException e) {
            System.err.println("Exception while updating employee:");
            e.printStackTrace();
        }

        return result;
    }

    /**
     * Deletes an employee based on the given ID.
     * 
     * @param id Employee ID to be deleted
     * @return Number of rows affected (0 if no match found)
     */
    @Override
    public int deleteData(int id) {
        int result = 0;
        connection = ConnectionProvider.getConnection();

        String deleteQuery = "DELETE FROM Employee WHERE id = ?";

        try (PreparedStatement psmt = connection.prepareStatement(deleteQuery)) {
            psmt.setInt(1, id);

            result = psmt.executeUpdate();  // Returns number of rows deleted

        } catch (SQLException e) {
            System.err.println("Exception while deleting employee:");
            e.printStackTrace();
        }

        return result;
    }

    /**
     * Retrieves all employee records from the database.
     * 
     * @return List of Employee objects
     */
    @Override
    public List<Employee> selectData() {
        connection = ConnectionProvider.getConnection();

        String selectQuery = "SELECT * FROM Employee";

        List<Employee> listEmployee = new ArrayList<>();

        try (PreparedStatement psmt = connection.prepareStatement(selectQuery)) {
            ResultSet rs = psmt.executeQuery();

            // Iterate through result set and populate the employee list
            while (rs.next()) {
                // Assuming Employee has a constructor: Employee(String name, int id, String aadharNo)
                listEmployee.add(new Employee(rs.getString("name"), rs.getInt("id"), rs.getString("aadharNo")));
            }

        } catch (SQLException e) {
            System.err.println("Exception while selecting employees:");
            e.printStackTrace();
        }

        return listEmployee;
    }
}
