
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<style >
.error{
color: red;
font-weight: bold;
}
</style>
</head>
<body>
<center>
<div style="background-color: green">
<h3>Enroll here to register</h3>
</div>
<table>
<form:form action="registerCustomer" method="post" modelAttribute="customer">

<tr>
<td>Name</td>
<td><form:input path="name" size="30"/></td>
<td><form:errors path="name" cssClass="error"/></td>
</tr>
<tr>
<td>Mobile Number</td>
<td><form:input path="mobileNo" size="30"/></td>
<td><form:errors path="mobileNo" cssClass="error"/></td>
</tr>
<tr>
<td>Amount</td>
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