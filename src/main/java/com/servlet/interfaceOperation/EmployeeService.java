package com.servlet.interfaceOperation;

import java.util.List;

/**
 * EmployeeService interface defines the contract for operations related to Employee data.
 * 
 * This abstraction allows different implementations (e.g., JDBC, JPA, mock services) to be used interchangeably
 * without affecting the rest of the application.
 */
public interface EmployeeService {

    /**
     * Inserts a new employee record into the data source.
     * 
     * @param emp Employee object containing data to be inserted
     * @return true if insertion is successful, false otherwise
     */
    public abstract boolean insertData(Employee emp);

    /**
     * Updates an employee's Aadhar number based on their ID and old Aadhar number.
     * 
     * @param id Employee ID
     * @param oldAadhar Current Aadhar number (used to validate the update)
     * @param newAadhar New Aadhar number to be updated
     * @return true if update is successful, false otherwise
     */
    public abstract boolean updateData(int id, String oldAadhar, String newAadhar);

    /**
     * Deletes an employee record based on their ID.
     * 
     * @param id ID of the employee to delete
     * @return Number of records deleted (0 if no matching record found)
     */
    public abstract int deleteData(int id);

    /**
     * Retrieves all employee records from the data source.
     * 
     * @return List of Employee objects
     */
    public abstract List<Employee> selectData();
}
