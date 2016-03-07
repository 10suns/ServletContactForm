<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Contact Manager Home</title>
    </head>
    <body>
      <div align="center">
          <h1>Contact List</h1>
          <h3><a href="${pageContext.request.contextPath}/contacts/new">New Contact</a></h3>
          <table border="1">
            <th>Name</th>
            <th>Email</th>
            <th>Address</th>
            <th>Telephone</th>
            <th>Action</th>

        <c:forEach var="contact" items="${contacts}">
          <tr>
            <td>${contact.name}</td>
            <td>${contact.email}</td>
            <td>${contact.address}</td>
            <td>${contact.telephone}</td>
            <td>
              <a href="${pageContext.request.contextPath}/contacts/edit?id=${contact.id}">Edit</a>
              &nbsp;&nbsp;&nbsp;&nbsp;
              <a href="${pageContext.request.contextPath}/contacts/delete?id=${contact.id}">Delete</a>
            </td>
          </tr>
        </c:forEach>
      </table>
      </div>
    </body>
</html>
