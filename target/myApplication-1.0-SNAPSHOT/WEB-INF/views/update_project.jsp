<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<title>modify</title>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
 <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script type="text/javascript">       
            function Success() {
               window.alert ("Updated Successfully");
            }
        
      </script>
<style>
h2 {
  color: white;
}
h3 {
  font-size: 25px;
}
h3 {
  width: 50%;
  height: 60px;
  margin: 10px;
  padding: 20px;
}

button {
    background-color: #4CAF50;
    color: white;
    padding: 5px 5px; 
    font-size: 15px;
      margin: 20px;
    cursor: pointer; 
}
</style>​
</head>
     
<body>

<jsp:include page="header.jsp"/>
<div class="topnav"> 
<h2 align="center">Update Project</h2>

<form action="display_project" method="post">
<div align="left">
<button class="btn">Home</button>
</form>
</div>
</div>

<form:form method="post" action="modify_project" modelAttribute="project" onsubmit="return Formvalidation()">

<form:hidden path="id" value="${project.id}"/>
<form:hidden path="active" value="${project.active}"/>

<div class="container">
	<div class="row"> 
	  <form role="form">
        <h3>Project</h3> 
 <div class="form-group col-xs-10 col-sm-4 col-md-4 col-lg-4">
            <form:label path="name">Name</form:label>
            <form:input type="text" class="form-control" path="name" placeholder="Name" minlength="1" maxlength="20" value= "${project.name}" required="required"/>
        </div>
<div class="clearfix"></div>
<div class="form-group col-xs-10 col-sm-4 col-md-4 col-lg-4">
            <form:label path="client">Client Name</form:label>
            <form:input type="text" class="form-control" path="client" minlength="1" maxlength="20" placeholder="Client Name" value= "${project.client}" required="required"/>
        </div>
<div class="clearfix"></div>
<p class="w3-center" align="left">
<button class="w3-button w3-section w3-blue w3-ripple" onclick="Success();"> Update </button>
</p>
<br /><br />
	</div>
</div>

</form:form>

</script>
</form>

</body>
</html> 

