 🛒 E-Shopping (Spring Boot Project)

This is a simple **E-Shopping Application** built using **Spring Boot**.
It demonstrates how to develop a shopping web application where users can browse products, add them to the cart, and place orders.

This project is designed for **students and beginners** who want to learn **Spring Boot**, **Spring Data JPA**, and **basic web application development**.

---

## 🚀 Features

* User Registration & Login
* Browse Products
* Add to Cart / Remove from Cart
* Place Orders
* Admin can Manage Products (Add, Update, Delete)
* Database integration using **MySQL**
* REST APIs for backend operations

---

## 🛠️ Tech Stack

* **Backend:** Spring Boot, Spring MVC, Spring Data JPA
* **Database:** MySQL
* **Frontend:** JSP / Thymeleaf (as per your implementation)
* **Tools:** Maven, Eclipse/IntelliJ, Git

---

## 📂 Project Structure

```
E_Shopping_ByUsing_Spring_Boot
│── src/main/java/com/example/shopping     # Java source code
│   ├── controller                        # Controllers (handle requests)
│   ├── model                             # Entity classes
│   ├── repository                        # JPA Repositories
│   ├── service                           # Business logic
│── src/main/resources
│   ├── static                            # CSS, JS, Images
│   ├── templates                         # JSP/Thymeleaf pages
│   └── application.properties            # Database & project configs
│── pom.xml                               # Maven dependencies
```

---

## ⚙️ Setup & Run Project

### 1. Clone the Repository

```bash
git clone https://github.com/VenuKumari384/E_Shopping_ByUsing_Spring_Boot.git
```

### 2. Configure Database (MySQL)

* Create a database named `eshopping` in MySQL.
* Open `application.properties` and update:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/eshopping
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
```

### 3. Build & Run the Project

Using Maven:

```bash
mvn spring-boot:run
```

Or run directly from **Eclipse/IntelliJ** as a **Spring Boot App**.

### 4. Access Application

Open browser → [http://localhost:8080](http://localhost:8080)

---

## 🔗 Example REST API Endpoints

Students can test these APIs in **Postman**:

### 👤 User APIs

* **Register User** → `POST /api/users/register`
* **Login** → `POST /api/users/login`

### 📦 Product APIs

* **Get All Products** → `GET /api/products`
* **Get Product by ID** → `GET /api/products/{id}`
* **Add Product (Admin)** → `POST /api/products`
* **Update Product (Admin)** → `PUT /api/products/{id}`
* **Delete Product (Admin)** → `DELETE /api/products/{id}`

### 🛒 Cart APIs

* **View Cart** → `GET /api/cart/{userId}`
* **Add to Cart** → `POST /api/cart/{userId}/add/{productId}`
* **Remove from Cart** → `DELETE /api/cart/{userId}/remove/{productId}`

### 📦 Order APIs

* **Place Order** → `POST /api/orders/{userId}`
* **View User Orders** → `GET /api/orders/{userId}`

## 🎯 Who Can Use This Project?

* Students learning **Spring Boot basics**
* Beginners who want to understand **CRUD operations with MySQL**
* Anyone who wants to build a **mini-project for college**

---

## 🤝 Contribution

Contributions are welcome!

* Fork the repo
* Create a new branch
* Commit your changes
* Submit a Pull Request

---

## 📜 License

This project is for educational purposes only.

