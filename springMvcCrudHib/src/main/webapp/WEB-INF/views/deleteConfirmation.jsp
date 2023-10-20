<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Delete Confirmation</title>
</head>
<body>
    <h2>Delete Confirmation</h2>

    <p>Are you sure you want to delete this book?</p>

    <!-- Form to confirm or cancel the deletion -->
    <form action="/delete/${book.id}" method="post">
        <input type="hidden" name="_method" value="delete"> <!-- Use POST with _method override -->
        <input type="submit" value="Confirm Delete">
        <a href="/">Cancel</a>
    </form>
</body>
</html>
