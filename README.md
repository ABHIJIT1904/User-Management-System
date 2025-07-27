# Employee Management System (Java + Servlets + OracleDB)

This is a **Java EE-based Employee Management System** using **JSP/Servlets**, **JDBC**, and **Oracle Database**. The application supports full CRUD operations (Create, Read, Update, Delete) on employee records.

---

## 🔧 Technologies Used

- Java (JDK 8+)
- Jakarta Servlet API (formerly Javax Servlet)
- Oracle JDBC
- Oracle Database (XE or SE/EE)
- Apache Tomcat or any Servlet-compatible web server
- HTML & CSS (for UI)
- Git & GitHub (for version control)

---

## 📁 Project Structure

```plaintext
src/
└── com.servlet
    ├── connectionProvider
    │   └── ConnectionProvider.java
    ├── implementationOfEmployee
    │   └── EmployeeServiceImplementation.java
    ├── interfaceOperation
    │   ├── Employee.java
    │   └── EmployeeService.java
    ├── operationToPerform
    │   ├── InsertServlet.java
    │   ├── DeleteServlet.java
    │   ├── UpdateServlet.java
    │   └── SelectServlet.java
web/
└── index.html



Features
Insert Employee: Add a new employee with name, ID, and Aadhar number.

View Employees: Display all employees in a table.

Update Employee: Update an employee’s Aadhar number based on ID and current Aadhar.

Delete Employee: Delete an employee record by ID.

Robust Exception Handling for invalid input or DB errors.

Responsive HTML/CSS UI using simple embedded styles.

🗄️ Database Configuration
DBMS: Oracle

Table Name: Employee

Sample SQL for table creation:

sql
Copy
Edit
CREATE TABLE Employee (
    name VARCHAR2(100),
    id NUMBER PRIMARY KEY,
    aadharNo VARCHAR2(20)
);
Connection Settings (inside ConnectionProvider.java):

java
Copy
Edit
String url = "jdbc:oracle:thin:@localhost:1521:orcl";
String userName = "advjava";
String password = "abhi";
Update these values based on your Oracle DB setup.

🚀 How to Run
Clone the repository:

bash
Copy
Edit
git clone https://github.com/your-username/your-repo-name.git
cd your-repo-name
Set up Oracle DB and create the Employee table as shown above.

Configure JDBC driver:

Ensure ojdbc8.jar or relevant Oracle JDBC driver is added to the project's build path or lib folder.

Deploy to Tomcat:

Import the project into Eclipse/IntelliJ as a Dynamic Web Project.

Deploy the WAR file to Tomcat or run directly via IDE.

Access the app:

bash
Copy
Edit
http://localhost:8080/YourAppName/index.html
