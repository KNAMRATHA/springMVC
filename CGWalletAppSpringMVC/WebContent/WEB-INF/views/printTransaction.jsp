<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<h2>Your transactions performed on the registered number </h2>
 <h5><br></h5><br>
 <table>
 <tr>
 <th>Mobile Number</th>
 <th>Transaction Type</th>
 <th>Amount</th>
 <th>Transaction Date</th>
 <th>Transaction Status</th>
 </tr>
 <c:forEach items="${transactions}" var="transactions">
 <tr>
 <td>${transactions.mobileNumber}</td>
 <td>${transactions.transactionType}</td>
 <td>${transactions.amount}</td>
 <td>${transactions.transactionDate}</td>
 <td>${transactions.transactionStatus}</td>
 </tr>
 </c:forEach>
 </table>

</center>
</body>
</html>