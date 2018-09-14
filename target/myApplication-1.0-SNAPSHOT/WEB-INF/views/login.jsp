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
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
 </head>
  <body>
     <jsp:include page="header.jsp"/>

<form class="form-horizontal" action="login_user" method="post">

<body id="LoginForm">
<div class="container">
<div class="login-form">
<div class="main-div">
    <div class="panel">
   <h2>Admin Login</h2>
   </div>
    <form id="Login">
        <div class="form-group">
            <input type="email" class="form-control" name="emailId" placeholder="Email Address" required>
        </div>

        <div class="form-group">
            <input type="password" class="form-control" name="password" placeholder="Password" required>
        </div>
        <div class="forgot">
        <a href="register.jsp">Register?</a>
</div>
        <button type="submit" class="btn btn-primary">Login</button>
    </form>
    </div>
    </div>
    </div>
    </div>
</body>
</html>
