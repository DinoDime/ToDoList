<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sign in or sign up</title>
</head>
<body>	
	<h3>Sign In</h3>
	
	<form method="post" action="/login">
		Your Email: <input type="text" name="email" /><br />
		Your Password: <input type="password" name="password" /><br />
		<input type="submit" />
	</form>
	
	<h3>Register a New Account</h3>
	
	<form method="post" action="/register">
		Your Email: <input type="text" name="email" /><br />
		Your Password: <input type="password" name="password" /><br />
		<input type="submit" />
	</form>
</body>
</html>