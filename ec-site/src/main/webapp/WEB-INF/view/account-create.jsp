<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="false"%>
<html>

<head>
<meta charset="UTF-8">
<title>アカウント作成画面</title>
<link rel="icon" type="image/png" href="resources/images/favicon_logout.png">
<link rel="stylesheet" type="text/css" href="resources/css/layout.css">
<script type="text/javascript" src="resources/js/ec.js"></script>
</head>

<body>
<div id="base">
<c:if test="${page == 0}">
	<h1 align="center">アカウント作成画面</h1>
</c:if>
<c:if test="${page == 1}">
	<h1 align="center">アカウント作成確認画面</h1>
</c:if>
<c:if test="${page == 2}">
	<h1 align="center">アカウント作成完了画面</h1>
</c:if>

<c:if test="${page == 0}">
<c:out value="新規作成するアカウントのパスワードを入力してください。" />
	<form action="/ec-site/account-create-confirm.html" method="post">
		<span class="fontawesome-lock"></span>
		<input type="password" name="password" placeholder="パスワード"/>
		<span class="fontawesome-check"></span>
		<input type="password" name="confirmPassword" placeholder="確認用パスワード"/>
		<table>
			<tr>
				<td><input type="submit" value="確　認" /></td>
				<td><input type="button" value="戻　る" onclick="history.back()" /></td>
			</tr>
		</table>
	</form>
</c:if>

<c:if test="${page == 1}">
<c:out value="以下の情報でアカウントを作成しますか？" />
	<form action="/ec-site/account-create-complete.html" method="post">
		<span class="fontawesome-lock"></span>
		<input type="text" name="password" value="${password}" disabled="disabled" />
		<input type="hidden" name="password" value="${password}" />
		<table>
			<tr>
				<td><input type="submit" value="作　成" /></td>
				<td><input type="button" value="戻　る" onclick="history.back()" /></td>
			</tr>
		</table>
	</form>
</c:if>

<c:if test="${page == 2}">
<c:out value="アカウント作成完了しました" />
	<form action="/ec-site/menu.html" method="post">
		<span class="fontawesome-user"></span>
		<input type="text" name="customerId" value="${customerId}" disabled="disabled" />
		<input type="hidden" name="customerId" value="${customerId}" />
		<span class="fontawesome-lock"></span>
		<input type="text" name="password" value="${password}" disabled="disabled" />
		<input type="hidden" name="password" value="${password}" />
		<input type="submit" value="Sign in" />
	</form>
</c:if>
</div>
</body>
</html>