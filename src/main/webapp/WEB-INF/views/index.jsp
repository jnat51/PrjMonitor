<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html lang="en">
<head>
<title>Login</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<script src="//ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.js"></script>
<link href="bootstrap-4.3.1/css/bootstrap.min.css"/>
    <link href="bootstrap-4.3.1/js/bootstrap.min.js"/>
<script src="//ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>

<body>
	<h2>Welcome! Please login</h2>
	<c:url var="url" value="/user/login"/>

	<form:form method="POST" modelAttribute="loginForm" action="${url}">
		<br />
		<spring:bind path="email">
			<form:label path="email">Email</form:label>
			<form:input path="email" />
		</spring:bind>
		<br />
		<spring:bind path="password">
			<form:label path="password">Password</form:label>
			<form:input path="password" type="password"/>
		</spring:bind>
		<br />
		<button type="submit">Login</button>

	</form:form>
</body>
</html>