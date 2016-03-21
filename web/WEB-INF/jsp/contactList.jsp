<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<title></title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources//css/bootstrap-theme.min.css">
<script src="${pageContext.request.contextPath}/resources/js/jquery-1.12.1.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/contact_list.js"></script>
</head>
<body>
    <div class="container">
            <h1>Contact List</h1>
            <h3><a href="${pageContext.request.contextPath}/contacts/new">New Contact</a></h3>
            <table class="table table-striped">
                <thead><tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Telephone</th>
                    <th>Address</th>
                    <th>Action</th>
                </tr></thead>
                <tbody>
                <c:forEach items="${contacts}" var="contact">
                    <tr>
                        <td class="id" data-id="${contact.id}">${contact.id}</td>
                        <td>${contact.name}</td>
                        <td>${contact.email}</td>
                        <td>${contact.telephone}</td>
                        <td>${contact.address}</td>
                        <td>
                            <a id="edit" href="/contacts/edit?id=${contact.id}" class="btn btn-primary">Edit</a>
                            <button id="delete" type="button" class="btn btn-danger">Delete</button>
                        </td>
                    </tr>
                </c:forEach>

                </tbody>
            </table>

        </div>
</body>
</html>