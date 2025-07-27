package com.servlet.interfaceOperation;

/**
 * Employee class represents a simple data model for employee information.
 * It includes fields for name, ID, and Aadhar number, along with standard getters, setters, and a toString method.
 */
public class Employee {
    
    // Private fields representing employee attributes
    private String name;
    private int id;
    private String aadharNo;

    /**
     * Parameterized constructor to create a new Employee object.
     * 
     * @param name Employee's name
     * @param id Employee ID
     * @param aadharNo Employee's Aadhar number
     */
    public Employee(String name, int id, String aadharNo) {
        super(); // Optional, as Object's constructor is called by default
        this.name = name;
        this.id = id;
        this.aadharNo = aadharNo;
    }

    // Getter and setter methods for the name field
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and setter methods for the id field
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter and setter methods for the aadharNo field
    public String getAadharNo() {
        return aadharNo;
    }

    public void setAadharNo(String aadharNo) {
        this.aadharNo = aadharNo;
    }

    /**
     * Returns a string representation of the Employee object.
     */
    @Override
    public String toString() {
        return "Employee [name=" + name + ", id=" + id + ", aadharNo=" + aadharNo + "]";
    }
}
