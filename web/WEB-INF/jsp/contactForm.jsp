<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Contact to me</title>
</head>
<body>
    <div align="center">
        <h1>Contact</h1>
        <form action="${pageContext.request.contextPath}/contacts/update" method="POST" >
          <input type="hidden" name="id" value="${contact.id}" />
          <table>
              <tr>
                  <td>Name:</td>
                  <td><input type="text" name="name" value="${contact.name}"/></td>
              </tr>
              <tr>
                  <td>Email:</td>
                  <td><input type="email" name="email" value="${contact.email}"/></td>
              </tr>
              <tr>
                  <td>Address:</td>
                  <td><input type="text" name="add" value="${contact.address}"/></td>
              </tr>
              <tr>
                  <td>Telephone:</td>
                  <td><input type="tel" name="tel" value="${contact.telephone}"/></td>
              </tr>
              <tr>
                  <td colspan="2" align="center"><input type="submit" value="Submit"></td>
              </tr>
          </table>
        </form>
    </div>
</body>
</html>
