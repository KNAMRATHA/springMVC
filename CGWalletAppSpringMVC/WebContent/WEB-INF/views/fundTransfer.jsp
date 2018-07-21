<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<div style="background-color: green">
<h3>Enroll here to register</h3>
</div>
<table>
<form:form action="fundTransferAction" method="post" modelAttribute="customer">


<tr>
<td>Target Mobile Number</td>
<td><form:input path="mobileNo" size="30"/></td>
<td><form:errors path="mobileNo" cssClass="error"/></td>
</tr>
<td>Amount transfered</td>
<td><form:input path="wallet.balance" size="30"/></td>
<td><form:errors path="wallet.balance" cssClass="error"/></td>
</tr>
<tr>
<td><input type="submit" value="Submit"></td>
</tr>
</form:form>
</table>
</center>
</body>
</html>