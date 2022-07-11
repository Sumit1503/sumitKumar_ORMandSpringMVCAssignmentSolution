<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CustomerRelationshipManagement</title>
</head>
<body>

	<h1>CUSTOMER RELATIONSHIP MANAGEMENT</h1>
	<!-- Add a button -->
	<a href="/CustomerRelationshipManagement/customer/showAddForm"
			class="btn btn-primary btn-sm mb-3"> Add Customer </a> 
	
	<table border="1" >
		<thead>
		<tr align="center"><th>First Name</th><th>Last Name</th><th>Email</th><th>Action</th><th>Action</th></tr>
		</thead>
		<tbody align="center">
			<c:forEach items="${Customers}" var ="customer">
				<tr>		
				<td>${customer.firstName}</td>
				<td>${customer.lastName}</td>
				<td>${customer.email}</td>
				<td><a href="update?id=${customer.customerId}">Update</a></td>
				<td>
				<a href="delete?id=${customer.customerId}" 
				onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a></td>						
				</tr>			
			</c:forEach>
		</tbody>
	</table>
		
</body>
</html>