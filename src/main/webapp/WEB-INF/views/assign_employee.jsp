<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>assign</title>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
     <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script type="text/javascript">       
            function Success() {
               alert ("Assigned Successfully");
            }
        
      </script>
<style>
h3 {
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

</style>
</head>
<body> 
     <jsp:include page="header.jsp"/> 
<div class="topnav">
<h3 align="center">Assign Employees</h3>

<form action="display_project" method="post">
<div align="left">
<button class="btn">Home</button>
</form>
</div>
</div>

<table>
<tbody>
<tr>
    <th>Assign</th>
    <th>ID</th>
    <th>Name</th>
    <th>Role</th>
    <th>Salary</th>
    <th>Dob</th>
    <th>EmailId</th>
</tr>

 <form action="assign_employee" method="post">
    <input type="hidden" name="id" value=${project.id}>
<c:forEach var="employee" items="${employees}">    
    <tr>
    
   
    <td class="submission" colspan="1"><div align="center"> 
    <input type="checkbox" name="idOfEmployees" value=${employee.id}>
    </td>
     
    <td>${employee.id}</td>
    <td>${employee.name}</td>
    <td>${employee.role}</td>
    <td>${employee.salary}</td>
    <td>${employee.dob}</td>
    <td>${employee.emailId}</td>  
    
</tr>
</c:forEach>
</tbody>
</table>
<div align="center">

<button type="submit" class="w3-button w3-section w3-blue w3-ripple" onclick="Success();"> Assign </button>
</form>
</div>
</body>
<jsp:include page="footer.jsp"/>
</html>
