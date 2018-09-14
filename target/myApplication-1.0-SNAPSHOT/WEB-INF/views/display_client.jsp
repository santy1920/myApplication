<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>display</title>

<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
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

</style>
</head>
<body>  
     <jsp:include page="header.jsp"/>
<div class="topnav">

  <form action="display_client" method="post">

<h2 align="center">Client Management</h2>

<div align="left">
<button class="btn">Home</button>
</div>
</div>
</form>

<h3 class="w3-center" align="center">Client</h3>
<table>
<tbody>
<tr>
    <th>ID</th>
    <th>Name</th>
    <th>CompanyName</th>
    <th>EmailId</th>
</tr>
 
<tr>
    <td><c:out value="${client.id}"></c:out></td>
    <td><c:out value="${client.name}"></c:out></td>
    <td><c:out value="${client.companyName}"></c:out></td>
    <td><c:out value="${client.emailId}"></c:out></td>
</tr>
</tbody>
</table>

<table>
<tbody>
<tr>
    <th>ID</th>
    <th>Name</th>
    <th>Client</th>
    
</tr>  
<h3 class="w3-center" align="center">Projects</h3>
<form action="remove_project" method="post">
    <input type="hidden" name="id" value="${client.id}"> 
<c:forEach var="project" items="${client.getProjects()}">  

    <tr>
    <td>${project.id}</td>
    <td>${project.name}</td>
    <td>${project.client}</td>
    
    
    <td class="submission" colspan="1"><div align="center"> 
    <input type="checkbox" name="idOfProjects" value="${project.id}">
    </td>

       
</tr>

</c:forEach>

</tbody>
</table>
<div align="right">
<input type="submit"  class="btn-danger" value= "remove" onclick="return confirm('Want to remove selected projects ?')"> 
</form>
</form>

</body>
<jsp:include page="footer.jsp"/>
</html>
