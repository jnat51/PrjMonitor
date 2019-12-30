<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
    <title>Hello!</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>

<body>
<table border="1">
	<tr>
	<th>No.</th>
	<th>Role</th>
	<th>Name</th>
	<th>Email</th>
	<th>Username</th>
	</tr>
	<c:forEach var="user" items="${users}">
		<tr>
			<td></td>
			<td><c:out value="${user.role.roles}"></c:out></td>
			<td><c:out value="${user.name}"></c:out></td>
			<td><c:out value="${user.email}"></c:out></td>
			<td><c:out value="${user.username}"></c:out></td>
		</tr>
	</c:forEach>
</table>

</body>
</html>
