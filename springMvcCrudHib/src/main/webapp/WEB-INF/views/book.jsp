<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
  <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
      <!DOCTYPE html>
      <html lang="en">
      <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Book Page</title>
        <style type="text/css">
          .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #ccc;
          }
          .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #fff;
          }
          .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #f0f0f0;
          }
          .tg .tg-4eph {
            background-color: #f9f9f9
          }
        </style>
      </head>
      <body>
        <a href="http://localhost:8080/addbook">Add New Book</a>
        <h2>Books List</h2>
        <table class="tg">
          <tr>
            <th width="80"> ID</th>
            <th width="120">NAME</th>
            <th width="120">AUTHOR </th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
          </tr>

          <c:forEach items="${books}" var="book">
            <tr>
              <td>${book.id}</td>
              <td>${book.name}</td>
              <td>${book.author}</td>
              <td><a href="<c:url value='/edit/${book.id}' />">Edit</a></td>
              <td><a href="<c:url value='/delete/${book.id}' />">Delete</a></td>
            </tr>
          </c:forEach>
        </table>
      </body>