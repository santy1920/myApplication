<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
     <meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
     <title>Employee Management</title>
     <meta name="viewport" content="width=device-width, initial-scale=1">
<link href="<c:url value="/resources/css/style.css" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

  </head>
  <body>
      <jsp:include page="header.jsp"/>

<div class="topnav">
<form action="logout_user" method="post">
<div align="right">
<button class="btn-danger" value="submit" onclick="return confirm('Want to Logout ?')"> Logout </button> </a>
</form>


<form action="display_employee" method="post">
<div align="center">
<button class="btn" style="margin-bottom:10px">Employee Management</button>
</div>
</form>

<form action="display_project" method="post">
<div align="center">
<button class="btn" style="margin-bottom:10px">Project Management</button>
</div>
</form>

<form action="display_client" method="post">
<div align="center">
<button class="btn" style="margin-bottom:10px">Client Management</button>
</form>
</div>
</div>
</div>
</body>
     <jsp:include page="footer.jsp"/>
</html>
