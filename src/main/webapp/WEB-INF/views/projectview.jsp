<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
    <title>Hello!</title>
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
	<th>Project Code</th>
	<th>Name</th>
	<th>Description</th>
	<th>Project Year</th>
	<th>Date Created</th>
	<th>Date Updated</th>
	</tr>
	<% int id = 1 ; %>
	<c:forEach var="project" items="${projects}">
		<tr>
			<td><%=id%></td>
			<td><c:out value="${project.projectCode}"></c:out></td>
			<td><c:out value="${project.name}"></c:out></td>
			<td><c:out value="${project.description}"></c:out></td>
			<td><c:out value="${project.projectYear}"></c:out></td>
			<td><c:out value="${project.dateCreated}"></c:out></td>
			<td><c:out value="${project.dateUpdated}"></c:out></td>
		</tr>
		<%id++;%>
	</c:forEach>
</table>

</body>
</html>
