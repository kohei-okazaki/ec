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
<link rel="icon" type="image/png" href="resources/images/favicon_login.png">
<link rel="stylesheet" type="text/css" href="resources/css/layout.css">
<script type="text/javascript" src="resources/js/ec.js"></script>
</head>

<body>
	<c:if test="${page == 0}"><h1 align="center">アカウント設定入力画面</h1></c:if>
	<c:if test="${page == 1}"><h1 align="center">アカウント設定確認画面</h1></c:if>
	<c:if test="${page == 2}"><h1 align="center">アカウント設定完了画面</h1></c:if>
	<c:if test="${page == 3}"><h1 align="center">アカウント設定詳細画面</h1></c:if>
	<table border="1">
		<tr>
			<th><c:out value="顧客ID" /></th>
			<td><c:out value="${sessionScope.seqCustomerId}" /></td>
		</tr>
	</table>

	<ul id="dropmenu">
		<li><a href="#">MENU</a>
			<ul>
				<li><a href="#">商品</a>
					<ul>
						<li><a href="#">商品購入</a>
							<ul>
								<li><a href="/ec-site/purchase.html">単品</a></li>
								<li><a href="/ec-site/purchase-file.html">ファイル</a></li>
							</ul>
						</li>
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
	<c:if test="${errorMessage != null}">
		<div align="center">
			<c:if test="${errorMessage}" />
		</div>
	</c:if>
<div id="base">
<c:if test="${page == 3}">
<form action="/ec-site/account-setting-input.html" method="get">
	<div align="center">
		<table border="1">
			<tr>
				<td><c:out value="顧客ID" /></td>
				<td><c:out value="${loginUser.seqCustomerId}" /></td>
			</tr>
			<tr>
				<td><c:out value="パスワード" /></td>
				<td><c:out value="${loginUser.password}" /></td>
			</tr>
			<tr>
				<td><c:out value="配送先都道府県" /></td>
				<td><c:out value="${deliveryInfo.prefectures}" /></td>
			</tr>
			<tr>
				<td><c:out value="配送先市区町村" /></td>
				<td><c:out value="${deliveryInfo.city}" /></td>
			</tr>
			<tr>
				<td><c:out value="配送先番地・部屋番号" /></td>
				<td><c:out value="${deliveryInfo.address}" /></td>
			</tr>
			<tr>
				<td><c:out value="登録日時" /></td>
				<td><c:out value="${regDate}" /></td>
			</tr>
		</table>
	</div>
	<input type="submit" value="変更">
</form>
</c:if>

<c:if test="${page == 0}">
<form action="/ec-site/account-setting-confirm.html" method="post">
	<div align="center">
		<table border="1">
			<tr>
				<td><c:out value="顧客ID" /></td>
				<td><c:out value="${loginUser.seqCustomerId}" /></td>
			</tr>
			<tr>
				<td><c:out value="パスワード" /></td>
				<td><input type="password" name="password" value="" placeholder="${loginUser.password}" /></td>
			</tr>
			<tr>
				<td><c:out value="配送先都道府県" /></td>
				<td><input type="text" name="prefectures" value="" placeholder="${deliveryInfo.prefectures}" /></td>
			</tr>
			<tr>
				<td><c:out value="配送先市区町村" /></td>
				<td><input type="text" name="city" value="" placeholder="${deliveryInfo.city}" /></td>
			</tr>
			<tr>
				<td><c:out value="配送先番地・部屋番号" /></td>
				<td><input type="text" name="address" value="" placeholder="${deliveryInfo.address}" /></td>
			</tr>
		</table>
	</div>
	<input type="submit" value="確認">
</form>
</c:if>

<c:if test="${page == 1}">
<form action="/ec-site/account-setting-complete.html" method="post">
	<div align="center">
		<table border="1">
			<tr>
				<td><c:out value="顧客ID" /></td>
				<td><c:out value="${loginUser.seqCustomerId}" /></td>
			</tr>
			<tr>
				<td><c:out value="パスワード" /></td>
				<td><c:out value="${loginUser.password}" /></td>
			</tr>
			<tr>
				<td><c:out value="配送先都道府県" /></td>
				<td><c:out value="${deliveryInfo.prefectures}" /></td>
			</tr>
			<tr>
				<td><c:out value="配送先市区町村" /></td>
				<td><c:out value="${deliveryInfo.city}" /></td>
			</tr>
			<tr>
				<td><c:out value="配送先番地・部屋番号" /></td>
				<td><c:out value="${deliveryInfo.address}" /></td>
			</tr>
			<tr>
				<td><c:out value="登録日時" /></td>
				<td><c:out value="${regDate}" /></td>
			</tr>
		</table>
	</div>
	<input type="submit" value="確定">
</form>
</c:if>

<c:if test="${page == 2}">
<form action="/ec-site/menu.html" method="get">
	<div align="center">
		<c:out value="変更完了しました。" />
	</div>
	<input type="submit" value="メニューへ戻る">
</form>
</c:if>
</div>
</body>
</html>