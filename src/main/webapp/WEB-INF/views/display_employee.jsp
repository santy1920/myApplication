<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
  <head>
     <meta charset="UTF-8">
     <title>Employee Management</title>
     
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
     <meta name="viewport" content="width=device-width, initial-scale=1">
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
     <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    
<style>
h2 {
  color: white;
}
table{ 
    width: 100%;
    background-color: white;
    border-collapse: collapse;
}
td, th {
    text-align: center;
    padding: 5px;
}
table, th, td {
    border: 1px;
    border: 1px solid black;
}
th {
    background-color: #4CAF50;
    height: 50px;
    border: 1px solid black;
}
tr:hover {
    background-color: #cccccc;
}

button {
    background-color: #4CAF50;
    color: white;
    padding: 5px 5px; 
    font-size: 15px;
    cursor: pointer; 
}

</style>​     
  </head>
  <body>
 
     <jsp:include page="header.jsp"/>

 <div class="topnav">
 
<h2 align="center">Employee Management</h2>
 <form action="display_employee" method="post">
<div align="left">
<button class="btn">Home</button>
</div>
</div>
</form>

<table>
<tbody>
<tr>
    <th>ID</th>
    <th>Name</th>
    <th>Role</th>
    <th>Salary</th>
    <th>Dob</th>
    <th>EmailId</th>
</tr>
    <tr>
    <td>${employee.id}</td>
    <td>${employee.name}</td>
    <td>${employee.role}</td>
    <td>${employee.salary}</td>
    <td>${employee.dob}</td>
    <td>${employee.emailId}</td>

</tr>
</tbody>
</table>

</body>


</html>       

