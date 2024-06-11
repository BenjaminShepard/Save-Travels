<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html data-bs-theme="dark">
<head>
<meta charset="ISO-8859-1">
<title>Edit</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
	<h1>Edit Expense</h1>
	<form:form action="/travels/${travel.id}" method="post" modelAttribute="travel">
		<input type="hidden" name="_method" value="put">
		
			<form:label path="expense">Expense Name</form:label>
			<form:errors path="expense"/>
			<form:input path="expense"/>
			
			<form:label path="vendor">Vendor</form:label>
			<form:errors path="vendor"/>
			<form:input path="vendor"/>
			
			<form:label path="amount">Amount</form:label>
			<form:errors path="amount"/>
			<form:input path="amount"/>
			
			<form:label path="description">Description</form:label>
			<form:errors path="description"/>
			<form:input path="description"/>
			
			<input type="submit" value="Submit">
			
	</form:form>
	
	<a href="/">Back To All Expenses</a>
</body>
</html>