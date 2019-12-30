<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html lang="en">
<head>
<title>Hello!</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<script src="//ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>

<body>
	<h2>Register</h2>
	<c:url var="url" value="/user/register"/>
	<form:form method="POST"  modelAttribute="userForm" action="${url}">
	<spring:bind path="roleId">
		<form:label path="roleId">Role</form:label>
			<form:select path="roleId" id="roleId">
				<option value="1">Admin</option>
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
		<form:input path="password" type="password"/>
		</spring:bind>
		<br />
		<input type="submit" value="Submit"/>
	</form:form>
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
