# 🧾 Employee Management System (Java Servlet + Oracle DB)

This is a **Java EE-based web application** that allows users to manage employee records. It uses **Jakarta Servlets**, **JDBC**, and **Oracle Database** to perform all CRUD operations on the `Employee` table. Built with a modular architecture and clean UI, it ensures secure and maintainable code practices.

---

## 📌 Features

- ✅ Add new employees (Insert)
- ✅ View all employee details (Select)
- ✅ Update Aadhar number by ID (Update)
- ✅ Delete employee by ID (Delete)
- ✅ Clean, modular code using interfaces and implementation layers
- ✅ Styled HTML/CSS interface with user feedback
- ✅ Secure DB operations using Prepared Statements

---

## 🧱 Technologies Used

- Java 8+
- Jakarta Servlet API
- Oracle Database (XE/SE/EE)
- JDBC (Oracle JDBC driver)
- HTML & CSS
- Apache Tomcat (9.x or 10.x)
- Maven (optional)
- Git & GitHub

---

## 📁 Project Structure

```
project-root/
│
├── src/
│   └── com/servlet/
│       ├── connectionProvider/
│       │   └── ConnectionProvider.java
│       ├── interfaceOperation/
│       │   ├── Employee.java
│       │   └── EmployeeService.java
│       ├── implementationOfEmployee/
│       │   └── EmployeeServiceImplementation.java
│       └── operationToPerform/
│           ├── InsertServlet.java
│           ├── DeleteServlet.java
│           ├── UpdateServlet.java
│           └── SelectServlet.java
│
├── web/
│   ├── index.html
│   ├── insert.html
│   ├── update.html
│   ├── select.html
│   └── delete.html
│
└── README.md
```

---

## 🗄️ Database Setup

### 1. Oracle Table Script

```sql
CREATE TABLE Employee (
    name VARCHAR2(100),
    id NUMBER PRIMARY KEY,
    aadharNo VARCHAR2(20)
);
```

### 2. DB Connection Configuration (`ConnectionProvider.java`)

```java
String url = "jdbc:oracle:thin:@localhost:1521:orcl";
String userName = "advjava";
String password = "abhi";
```

Update the credentials based on your local Oracle DB settings.

---

## 🚀 How to Run

1. **Clone the Repository**
   ```bash
   git clone https://github.com/YOUR_USERNAME/YOUR_REPO_NAME.git
   cd YOUR_REPO_NAME
   ```

2. **Import into IDE**
   - Use Eclipse / IntelliJ / NetBeans
   - Import as a **Dynamic Web Project**

3. **Add Oracle JDBC Driver**
   - Download `ojdbc8.jar`
   - Add it to `WEB-INF/lib` or your project's classpath

4. **Deploy to Apache Tomcat**
   - Use Tomcat 9.x or 10.x
   - Run from IDE or deploy `.war` file manually

5. **Open in Browser**
   ```
   http://localhost:8080/YourAppName/index.html
   ```

---

## 🌐 Servlet Endpoints

| Servlet | URL Mapping      | Description               |
|---------|------------------|---------------------------|
| Insert  | `/InsertServlet` | Add new employee          |
| Update  | `/UpdateServlet` | Update employee Aadhar    |
| Delete  | `/DeleteServlet` | Delete employee by ID     |
| Select  | `/SelectServlet` | View all employee records |

---

## 🧠 Design Patterns & Architecture

- Singleton Pattern for DB Connection
- Interface-driven DAO/Service Layer
- MVC-aligned modular packaging
- Use of Prepared Statements for security
- Robust exception handling
- Clean front-end UI with validation

---

## 📜 License

This project is licensed under the [MIT License](LICENSE).

> Feel free to use, modify, and distribute this code in your own projects.

---

## 🙌 Contributing

Pull requests are welcome! For major changes, please open an issue first to discuss what you'd like to change.

---

## 💡 Author

**Abhijit Borchate**  
_Java Developer & Backend Enthusiast_
