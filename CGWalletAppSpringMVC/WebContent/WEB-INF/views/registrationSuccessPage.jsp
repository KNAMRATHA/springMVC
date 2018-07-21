<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<html>
<head>

<title>Insert title here</title>
</head>
<body>
<center>
<h2>Welcome ${customer.name}</h2><br>
<h3>Your registered mobile number is :- ${customer.mobileNo}</h3>
<h3>Your current balance is :- ${customer.wallet.balance}</h3>

</center>
</body>
</html>