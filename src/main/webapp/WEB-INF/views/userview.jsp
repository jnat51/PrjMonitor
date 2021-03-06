<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
    <title>Hello!</title>
    <link href="bootstrap-4.3.1/css/bootstrap.min.css"/>
    <link href="bootstrap-4.3.1/js/bootstrap.min.js"/>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>

<body>
<div class="navbar">
  <a href="/home">Home</a>
  <a href="/test">News</a>
  <a href="/userview">User</a>
  <a href="/">Logout</a>
</div>
<table border="1">
	<tr>
	<th>No.</th>
	<th>Role</th>
	<th>Name</th>
	<th>Email</th>
	<th>Username</th>
	</tr>
	<% int id = 1 ; %>
	<c:forEach var="user" items="${users}">
		<tr>
			<td><%=id %></td>
			<td><c:out value="${user.role.roles}"></c:out></td>
			<td><c:out value="${user.name}"></c:out></td>
			<td><c:out value="${user.email}"></c:out></td>
			<td><c:out value="${user.username}"></c:out></td>
		</tr>
		<%id++;%>
	</c:forEach>
</table>

</body>
</html>
