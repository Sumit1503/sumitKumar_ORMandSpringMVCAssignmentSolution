<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>SaveCustomer</title>
	</head>
	<body>
	<h1>CUSTOMER RELATIONSHIP MANAGEMENT</h1>
	<h2>Save Customer</h2>
	<form action="save" method="post">
	<table>
		<tr>
		<td align="right">First Name</td><td><input type="text" value="${customer.firstName}" name ="firstName"/></td>
		</tr>
		<tr>
		<td align="right">Last Name</td><td><input type="text" value="${customer.lastName}"name ="lastName"/></td>
		</tr>
		<tr>
		<td align="right">Email</td><td><input type="text" value="${customer.email}"name ="email"/></td>
		</tr>
		<tr>
		<td colspan="1"></td>
		<td colspan="1" align="left"><input type="hidden" value="${customer.customerId}" name="id" /><input type="submit" value="Save"/></td>
		</tr>
	</table>
	<a href="http://localhost:8080/CustomerRelationshipManagement/customer/list">Back To List</a>
	</form>
	</body>
</html>