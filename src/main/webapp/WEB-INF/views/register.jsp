<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
  <head>
     <meta charset="UTF-8">
     <title>User Management</title>

<link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
 </head>
  <body>
     <jsp:include page="header.jsp"/>

<a href="login.jsp" <div class="controls">
        <button class="btn btn-success">Back</button>
      </div> </a>

<form:form class="form-horizontal" action="register_user" method="post">
  <fieldset>
    <div id="legend">
      <legend class="">Register</legend>
    </div>
 
    <div class="control-group">
      <form:label class="control-label" path="emailId">Email</label>
      <div class="controls">
        <form:input type="email" path="emailId" placeholder="Email Address" class="input-xlarge" required="required"/>
      </div>
    </div>
 
    <div class="control-group">
      <form:label class="control-label" path="password">Password</label>
      <div class="controls">
        <form:input type="password" path="password" placeholder="Password" class="input-xlarge" required="required"/>
      </div>
    </div>
 
    <div class="control-group">
      <div class="controls">
        <button class="btn btn-success">Register</button>
      </div>
    </div>
  </fieldset>
</form:form>
</body>
</html>
