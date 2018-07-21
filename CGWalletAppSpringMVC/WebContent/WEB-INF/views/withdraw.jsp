

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
		<div style="background-color: green">
			<h3>Withdraw</h3>
		</div>
		<table>
			<form:form action="withdrawAmount" method="post"
				modelAttribute="customer">
				<tr>
					<td>Enter amount</td>
					<td><form:input path="wallet.balance" size="30" /></td>
					<td><form:errors path="wallet.balance" cssClass="error" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="Withdraw"></td>
				</tr>
			</form:form>
	</center>
</body>
</html>