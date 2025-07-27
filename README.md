🧾 Employee Management System (Java Servlet + Oracle DB)

This is a **Java EE-based web application** for managing employee records using **JDBC**, **Oracle Database**, and **Jakarta Servlets**. It allows users to perform full CRUD operations (Create, Read, Update, Delete) on an `Employee` table.



 📌 Features

- ✅ Add new employees (Insert)
- ✅ View all employee details (Select)
- ✅ Update Aadhar number by ID (Update)
- ✅ Delete employee by ID (Delete)
- ✅ Clean, modular code structure using interface and implementation layers
- ✅ User feedback and styled messages in UI
- ✅ Secure database operations with prepared statements



 🧱 Technologies Used

- Java 8+
- Jakarta Servlet API (formerly Javax)
- Oracle Database (XE, SE, or EE)
- JDBC (Oracle JDBC driver)
- HTML & CSS
- Apache Tomcat (or any compatible servlet container)
- Maven (optional)
- Git & GitHub



📁 Project Structure

project-root/
│
├── src/
│ └── com/servlet/
│ ├── connectionProvider/ # Handles DB connection
│ │ └── ConnectionProvider.java
│ ├── interfaceOperation/ # Interfaces and POJO
│ │ ├── Employee.java
│ │ └── EmployeeService.java
│ ├── implementationOfEmployee/ # Service implementation
│ │ └── EmployeeServiceImplementation.java
│ └── operationToPerform/ # Servlets (Insert, Update, Delete, Select)
│ ├── InsertServlet.java
│ ├── DeleteServlet.java
│ ├── UpdateServlet.java
│ └── SelectServlet.java
│
├── web/ # Web content
│ ├── index.html # Home page
│ ├── insert.html
│ ├── update.html
│ ├── select.html
│ └── delete.html
│
└── README.md # Project documentation

 Database Setup

1. **Oracle Table Script**:

```sql
CREATE TABLE Employee (
    name VARCHAR2(100),
    id NUMBER PRIMARY KEY,
    aadharNo VARCHAR2(20)
);
Connection Configuration (inside ConnectionProvider.java):


String url = "jdbc:oracle:thin:@localhost:1521:orcl";
String userName = "advjava";
String password = "abhi";
Update these fields according to your local Oracle DB setup.

🚀 How to Run
1. Clone the Repository

git clone https://github.com/YOUR_USERNAME/YOUR_REPO_NAME.git
cd YOUR_REPO_NAME
2. Import Project into IDE
Use Eclipse, IntelliJ IDEA, or NetBeans

Import as a Dynamic Web Project

3. Add Oracle JDBC Driver
Download the latest ojdbc8.jar (or compatible)

Add it to WEB-INF/lib or your project build path

4. Deploy to Server
Use Apache Tomcat (9.x or 10.x)

Deploy the .war file or run directly from your IDE

5. Access Application
Open your browser and go to:

http://localhost:8080/YourAppName/index.html
🌐 Servlet Endpoints
Servlet	URL Mapping	Description
Insert	/InsertServlet	Insert new employee
Update	/UpdateServlet	Update Aadhar number
Delete	/DeleteServlet	Delete employee by ID
Select	/SelectServlet	View all employees

🧠 Design Pattern & Architecture
Singleton pattern for database connection (via ConnectionProvider)

DAO/Service Layer abstraction using interface (EmployeeService)

MVC-aligned modular packaging

Prepared Statements to prevent SQL injection

Exception handling for robustness

Clean HTML/CSS UI for easy interaction


📜 License
This project is licensed under the MIT License.
Feel free to use, modify, and share it.
