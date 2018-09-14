<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>display</title>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script type="text/javascript">       
            function Success() {
               alert ("Added Successfully");
            }
        
      </script>
<style>
h2 {
  color: white;
}
h3 {
  font-size: 25px;
  margin: 10px;
  padding: 10px;
}


button {
    background-color: #4CAF50;
    color: white;
    padding: 5px ; 
    margin: 20px;
    font-size: 15px;
    cursor: pointer; 
}

</style>
</head>
<body>  
     <jsp:include page="header.jsp"/>
<div class="topnav">
<h2 align="center">Project Management</h2>
 
<form action="display_project" method="post">
<div align="left">
<button class="btn">Home</button>
</form>
</div>
</div>
<form:form method="post" action="add_project" modelAttribute="project" onsubmit="return Formvalidation()">
<div class="container">
	<div class="row"> 
	  <form role="form">
        <h3>Project</h3> 

<form:hidden path="active" value="1"/>    
 <div class="form-group col-xs-10 col-sm-4 col-md-4 col-lg-4">
            <form:label path="name">Name</form:label>
            <form:input type="text" class="form-control" path="name" placeholder="Name" minlength="1" maxlength="20" required="required"/>
        </div>
<div class="clearfix"></div>
<div class="form-group col-xs-10 col-sm-4 col-md-4 col-lg-4">
            <form:label path="client">Client Name</form:label>
            <form:input type="text" class="form-control" path="client" minlength="1" maxlength="20" placeholder="Client Name" required="required"/>
        </div>
<div class="clearfix"></div>
<p class="w3-center" align="left">
<button class="w3-button w3-section w3-blue w3-ripple" onclick="Success();"> Add </button>
</p>
<br /><br />
	</div>
</div>




</form:form>

</body>
<jsp:include page="footer.jsp"/>
</html>
