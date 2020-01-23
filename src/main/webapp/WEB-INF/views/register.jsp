<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html lang="en">
<head>
<title>Hello!</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style>

</style>

</head>

<body>
	<div align="center">
		<h2>Register</h2>
		<c:url var="url" value="/user/register" />
		<form:form method="POST" modelAttribute="userForm" action="${url}" align="left">
			<spring:bind path="roleId">
				<form:label path="roleId">Role</form:label>
				<form:select path="roleId" id="roleId">
					<c:forEach var="role" items="${roles}">
						<%
							long id = 1;
						%>
						<option value=<%=id%>>${role.roles}</option>
						<%
							id++;
						%>
					</c:forEach>
				</form:select>
			</spring:bind>
			<br />
			<spring:bind path="name">
				<form:label path="name">Name</form:label>
				<form:input path="name" />
			</spring:bind>
			<br />
			<spring:bind path="email">
				<form:label path="email">Email</form:label>
				<form:input path="email" />
			</spring:bind>
			<br />
			<spring:bind path="username">
				<form:label path="username">Username</form:label>
				<form:input path="username" />
			</spring:bind>
			<br />
			<spring:bind path="password">
				<form:label path="password">Password</form:label>
				<form:input path="password" type="password" />
			</spring:bind>
			<br />
			<input class="btn btn-success" type="submit" value="Submit" />
		</form:form>
	</div>
</body>
<script type="text/javascript">
	// $.ajax({
	// 	url:"/role/",
	// 	type:"GET",
	// 	dataType:"json",
	// 	success:function(result){alert(result);}
	// });

	// $(document).ready(function(){

	//     $.ajax({
	//         url: "/role",
	//         type: 'GET',
	//         dataType: 'json',
	//         success: function(value, data){
	//             console.log(data);
	//         }
	//     });

	// });
</script>
</html>
