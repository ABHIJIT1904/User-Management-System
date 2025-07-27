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
