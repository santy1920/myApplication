<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>create</title>

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
}
h3 {
  width: 50%;
  height: 60px;
  margin: 10px;
  padding: 140px;
  display: inline;
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
<h2 align="center">Client Management</h2>

<form action="display_client" method="post">
<div align="left">
<button class="btn">Home</button>
</form>
</div>
</div>

<form:form method="post" action="add_client" modelAttribute="client" onsubmit="return Formvalidation()">

<div class="container">
	<div class="row"> 
	  <form role="form">
<h3>Client</h3>
<h3>Address</h3>
<hr />
<c:forEach items="${client.listOfAddresses}" varStatus="vs">
<form:hidden path="active" value="1"/>    

    <div class="form-group col-xs-10 col-sm-4 col-md-4 col-lg-4">
            <form:label path="name">Name</form:label>
            <form:input type="text" class="form-control" path="name" placeholder="Name" minlength="1" maxlength="20" required="required"/>
        </div>
 <div class="form-group col-xs-10 col-sm-4 col-md-4 col-lg-4">
<form:label path="listOfAddresses[${vs.index}].type" cssErrorClass="invalid">Type</form:label>
 <form:input placeholder="Type" path="listOfAddresses[${vs.index}].type" cssErrorClass="invalid "  required="required"/>
                    <form:label path="listOfAddresses[${vs.index}].type" cssErrorClass="icon invalid" />
                    <form:errors path="listOfAddresses[${vs.index}].type" cssClass="inline_invalid" />
                  </div>
       

        <div class="clearfix"></div>
        <div class="form-group col-xs-10 col-sm-4 col-md-4 col-lg-4">
            <form:label path="companyName">Company Name</form:label>
            <form:input type="text" class="form-control" path="companyName" minlength="1" maxlength="20" placeholder="Company Name" required="required"/>
        </div>
        
 <div class="form-group col-xs-10 col-sm-4 col-md-4 col-lg-4">
<form:label  path="listOfAddresses[${vs.index}].doorNumber" cssErrorClass="invalid">Door Number</form:label>
                    <form:input type="number" placeholder="DoorNumber" path="listOfAddresses[${vs.index}].doorNumber" cssErrorClass="invalid " required="required" />
                    <form:label path="listOfAddresses[${vs.index}].doorNumber" cssErrorClass="icon invalid" />
                    <form:errors path="listOfAddresses[${vs.index}].doorNumber" cssClass="inline_invalid" />
                  </div>
        
        <div class="clearfix"></div>
       <div class="form-group col-xs-10 col-sm-4 col-md-4 col-lg-4">
            <form:label path="emailId">EmailId</form:label>
            <form:input type="email" class="form-control" path="emailId" minlength="1" maxlength="20" placeholder="Email" required="required"/>
        </div>
<div class="form-group col-xs-10 col-sm-4 col-md-4 col-lg-4">
 <form:label  path="listOfAddresses[${vs.index}].street" cssErrorClass="invalid">Street</form:label>
                    <form:input placeholder="Street" path="listOfAddresses[${vs.index}].street" cssErrorClass="invalid " required="required" />
                    <form:label path="listOfAddresses[${vs.index}].street" cssErrorClass="icon invalid" />
                    <form:errors path="listOfAddresses[${vs.index}].street" cssClass="inline_invalid" />
                </div>

  <div class="clearfix"></div>
        
        <div class="form-group col-sm-5 col-sm-offset-2 col-md-4 col-md-offset-4">
<form:label  path="listOfAddresses[${vs.index}].city" cssErrorClass="invalid">City</form:label>
                    <form:input placeholder="City" path="listOfAddresses[${vs.index}].city" cssErrorClass="invalid " required="required" />
                    <form:label path="listOfAddresses[${vs.index}].city" cssErrorClass="icon invalid" />
                    <form:errors path="listOfAddresses[${vs.index}].city" cssClass="inline_invalid" />
                </div>

<div class="clearfix"></div>
        <div class="form-group col-sm-5 col-sm-offset-2 col-md-4 col-md-offset-4">
<form:label  path="listOfAddresses[${vs.index}].country" cssErrorClass="invalid">Country</form:label>
                    <form:input placeholder="Country" path="listOfAddresses[${vs.index}].country" cssErrorClass="invalid " required="required" />
                    <form:label path="listOfAddresses[${vs.index}].country" cssErrorClass="icon invalid" />
                    <form:errors path="listOfAddresses[${vs.index}].country" cssClass="inline_invalid" />
                </div>
    
<div class="clearfix"></div>
        <div class="form-group col-sm-5 col-sm-offset-2 col-md-4 col-md-offset-4">
<form:label  path="listOfAddresses[${vs.index}].pinCode" cssErrorClass="invalid">PinCode</form:label>
                    <form:input placeholder="PinCode" type="number" path="listOfAddresses[${vs.index}].pinCode" cssErrorClass="invalid "  required="required"/>
                    <form:label path="listOfAddresses[${vs.index}].pinCode" cssErrorClass="icon invalid" />
                    <form:errors path="listOfAddresses[${vs.index}].pinCode" cssClass="inline_invalid" />
                  </div>
            </c:forEach>

<br /><br />
	</div>
</div>

<p class="w3-center" align="center">
<button class="w3-button w3-section w3-blue w3-ripple" onclick="Success();"> Add </button>
</p>
</form:form>

<jsp:include page="footer.jsp"/>
</body>
