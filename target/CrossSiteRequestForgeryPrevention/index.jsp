<%-- 
    Document   : index
    Created on : Oct 4, 2018, 1:14:42 PM
    Author     : Chee Bhagyani
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Login</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  </head>
   
  <body>
    <div class="container">
    <form action="login" method="POST">
      <div class="form-group">
        <label for="email">Username</label>
        <input type="text" class="form-control" id="email" placeholder="Enter Username" name="username">
      </div>
      <div class="form-group">
        <label for="pwd">Password:</label>
        <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="password">
      </div>
      <input type="submit" value="Login"/>
    </form>
    </div>
   </body>
</html>
