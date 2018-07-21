<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<style>
.error {
	color: red;
	font-weight: bold;
}
</style>
</head>
<body>
	<center>
		<div style="background-color: green">
			<h3>Login here</h3>
		</div>
		<table>
			<form:form action="loginCustomer" method="post"
				modelAttribute="customer">
				<tr>
					<td>Mobile Number</td>
					<td><form:input path="mobileNo" size="30" /></td>
					<td><form:errors path="mobileNo" cssClass="error" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="Login"></td>
				</tr>
			</form:form>
	</center>
</body>
</html>