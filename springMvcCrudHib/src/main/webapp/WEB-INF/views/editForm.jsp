<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
  <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Edit Book</title>
</head>
<body>
    <h2>Edit Book</h2>

    <form:form action="/edit/${book.id}" method="post" modelAttribute="book">

        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="${book.name}" required><br><br>

        <label for="author">Author:</label>
        <input type="text" id="author" name="author" value="${book.author}" required><br><br>

        <!-- Add more input fields for other properties if needed -->

        <input type="submit" value="Edit">
    </form:form>

    <a href="/">Back to Home</a>
</body>
</html>
