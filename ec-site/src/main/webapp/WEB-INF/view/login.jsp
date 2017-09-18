<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="false"%>
<html>

<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
<link rel="stylesheet" type="text/css" href="resources/css/layout.css">
<script type="text/javascript" src="resources/js/ec.js"></script>
</head>

<body>
	<div id="base">
	<h1 align="center">ログイン画面</h1>
	<br>
	<form action="/ec-site/menu.html" method="post">
		<span class="fontawesome-user"></span>
		<input type="text" name="customerId" required="required" placeholder="顧客ID" />
		<span class="fontawesome-lock"></span>
		<input type="password" name="password" required="required" placeholder="パスワード" />
		<input type="submit" value="Sign in">
	</form>
	<form action="/ec-site/account-create.html" method="get">
		<input type="submit" value="Sign up">
	</form>
	</div>
</body>
</html>