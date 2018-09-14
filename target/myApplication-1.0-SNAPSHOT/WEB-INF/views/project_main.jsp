<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
     <meta charset="UTF-8">
     <title>Project Management</title>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

     <meta name="viewport" content="width=device-width, initial-scale=1">
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
  <h2 align="center">Project Management</h2>
  <a href="project_index" <button class="btn"><i class="fa fa-home"></i> Home</button> </a>
  <a href="create_project" <button class="btn"><i class="fa fa-male"></i>Add Project</button></a>
 </div>  

<form action="search_project" method="post">
 
<div class="container">
	<div class="row">
	    <div class="col-md-16">
	        <form class="navbar-form navbar-left" role="search">
	         <div class="input-group">
	            <input class="form-control" placeholder="search by id" name="id" type="Number" placeholder="id" min="1" max="100" required>
	            <span class="input-group-btn"><button type="submit" class="btn btn-default">Search</button></span>
	          </div>
	        </form>
	    </div>
	</div>
</div>

</form>

<h3 class="w3-center" align="center">Projects</h3>
<table>
<tbody>
<tr>
    <th>ID</th>
    <th>Name</th>
    <th>Client</th>

</tr>
<c:forEach var="project" items="${projects}">    
    <tr>
    <td>${project.id}</td>
    <td>${project.name}</td>
    <td>${project.client}</td>

   <td class="submission" colspan="2"><div align="center">
    <form action="select_employee" method="post"><button class="btn"><i class="material-icons" style="font-size:18px">group_add</i>
</button> </td>
    <input type="hidden" name="id" value=${project.id}>
    </form>   
   
    <td class="submission" colspan="2"><div align="center">
    <form action="update_project" method="post"><button class="btn"><i class="fa fa-wrench"></i>
</button> </td>
    <input type="hidden" name="id" value=${project.id}>
    </form>   

     <td class="submission" colspan="2"><div align="center">
     <form action ="delete_project" method="post">
    <button type="submit"  class="btn-danger" onclick="return confirm('Want to delete : ${project.id} ?')"><i class="fa fa-trash"></i></button> </td>
<input type="hidden" name="id" value=${project.id}>
          </form>
   
</tr>
</c:forEach>
</tbody>
</table>

</body>
<jsp:include page="footer.jsp"/>

</html>