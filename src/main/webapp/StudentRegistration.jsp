<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Student Registration</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f8ff; /* Light blue background */
            margin: 0;
            padding: 0;
        }
        .form-container, .retrieve-container {
            max-width: 500px;
            margin: 50px auto;
            padding: 20px;
            background: #ffffff;
            border-radius: 8px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }
        h1, h2 {
            text-align: center;
            color: #333;
        }
        label {
            display: block;
            margin-top: 15px;
            font-weight: bold;
        }
        input[type="text"], input[type="email"], input[type="number"], button {
            width: 100%;
            padding: 10px;
            margin-top: 5px;
            border: 1px solid #ddd;
            border-radius: 4px;
        }
        button {
            background-color: #4caf50;
            color: white;
            border: none;
            cursor: pointer;
        }
        button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <!-- Student Registration Form -->
    <div class="form-container">
        <h1>Student Registration</h1>
        <form action="StudentServlet" method="POST">
            <label for="name">Full Name:</label>
            <input type="text" id="name" name="name" placeholder="Enter your full name" required>

            <label for="email">Email Address:</label>
            <input type="email" id="email" name="email" placeholder="Enter your email" required>

            <label for="age">Age:</label>
            <input type="number" id="age" name="age" placeholder="Enter your age" required>

            <button type="submit">Register</button>
        </form>
    </div>

    <!-- Retrieve Student Info Section -->
    <div class="retrieve-container">
        <h2>Retrieve Student Info</h2>
        <form action="RetrieveStudent" method="GET">
            <label for="rollNumber">Enter Roll Number:</label>
            <input type="text" id="rollNumber" name="rollNumber" placeholder="Enter roll number" required>

            <button type="submit">Retrieve Info</button>
        </form>
    </div>
</body>
</html>