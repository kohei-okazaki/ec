<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="true"%>
<html>

<head>
<meta charset="UTF-8">
<title>アカウント設定画面</title>
<link rel="stylesheet" type="text/css" href="resources/css/layout.css">
<script type="text/javascript" src="resources/js/ec.js"></script>
</head>

<body>
	<h1 align="center">アカウント設定画面</h1>
	<table border="1">
		<tr>
			<th><c:out value="顧客ID" /></th>
			<td><c:out value="${sessionScope.customerId}" /></td>
		</tr>
	</table>

	<ul id="dropmenu">
		<li><a href="#">MENU</a>
			<ul>
				<li><a href="#">商品</a>
					<ul>
						<li><a href="/ec-site/purchase.html">商品購入</a></li>
						<li><a href="/ec-site/history.html">購入履歴</a></li>
					</ul>
				</li>
				<li><a href="#">子メニュー2</a>
					<ul>
						<li><a href="#">孫メニュー1</a></li>
						<li><a href="#">孫メニュー2</a></li>
						<li><a href="#">孫メニュー3</a></li>
						<li><a href="#">孫メニュー4</a></li>
					</ul>
				</li>
				<li><a href="#">子メニュー3</a>
					<ul>
						<li><a href="#">孫メニュー1</a></li>
						<li><a href="#">孫メニュー2</a></li>
						<li><a href="#">孫メニュー3</a>
							<ul>
								<li><a href="#">ひ孫メニュー1</a></li>
								<li><a href="#">ひ孫メニュー2</a></li>
								<li><a href="#">ひ孫メニュー3</a></li>
								<li><a href="#">ひ孫メニュー4</a></li>
							</ul></li>
						<li><a href="#">孫メニュー4</a></li>
					</ul>
				</li>
				<li><a href="#">子メニュー4</a>
					<ul>
						<li><a href="#">孫メニュー1</a></li>
						<li><a href="#">孫メニュー2</a></li>
						<li><a href="#">孫メニュー3</a></li>
						<li><a href="#">孫メニュー4</a></li>
					</ul>
				</li>
				<li><a href="/ec-site/menu.html">TOP</a></li>
			</ul>
		</li>
		<li><a href="#">設定</a>
			<ul>
				<li><a href="/ec-site/account-setting.html">アカウント設定</a></li>
				<li><a href="#">出力設定</a></li>
			</ul>
		</li>
		<li><a href="/ec-site/login.html">ログアウト</a></li>
	</ul>

	<div align="center">
		<table border="1">
			<tr>
				<td><c:out value="顧客ID" /></td>
				<td><c:out value="${customerId}" /></td>
			</tr>
			<tr>
				<td><c:out value="パスワード" /></td>
				<td><c:out value="${password}" /></td>
			</tr>
			<tr>
				<td><c:out value="登録日時" /></td>
				<td><c:out value="${regDate}" /></td>
			</tr>
		</table>
	</div>
</body>
</html>