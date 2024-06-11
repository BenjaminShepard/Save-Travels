<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html data-bs-theme="dark">
<head>
<meta charset="ISO-8859-1">
<title>Travel Expenses</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
	<h1>All Travel Expenses</h1>
	
	<table>
		<thead>
			<tr>
			<th>Expense</th>
			<th>Vendor</th>
			<th>Amount</th>
			<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${travels}" var="travel">
				<tr>
					<td>${travel.expense}</td>
					<td>${travel.vendor}</td>
					<td>${travel.amount}</td>
					<td><a href="/travels/${travel.id}/edit">Edit</a></td>
					<td><a href="/travels/${travel.id}/show">Expense Details</a></td>
					<td>
						<form action="/travels/${travel.id}" method="post">
							<input type="hidden" name="_method" value="delete">
							<input type="submit" value="Delete">
						</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<h2>Add an Expense</h2>
	<form:form action="/createtravel" method="post" modelAttribute="travel">
		<p>
			<form:label path="expense">Name</form:label>
			<form:errors path="expense"/>
			<form:input path="expense"/>
		</p>
		<p>
			<form:label path="vendor">Vendor</form:label>
			<form:errors path="vendor"/>
			<form:input path="vendor"/>
		</p>
		<p>
			<form:label path="amount">Amount</form:label>
			<form:errors path="amount"/>
			<form:input path="amount"/>
		</p>
		<p>
			<form:label path="description">Description</form:label>
			<form:errors path="description"/>
			<form:textarea path="description"/>
		</p>
		<button type="submit">Submit</button>
	</form:form>
</body>
</html>