<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="true"%>
<html>

<head>
<meta charset="UTF-8">
<title>商品購入画面(一括)</title>
<link rel="icon" type="image/png" href="resources/images/favicon_login.png">
<link rel="stylesheet" type="text/css" href="resources/css/layout.css">
<script type="text/javascript" src="resources/js/ec.js"></script>
</head>

<body>
<c:if test="${page == 0}"><h1 align="center">商品購入画面 (一括)</h1></c:if>
<c:if test="${page == 1}"><h1 align="center">購入確認画面 (一括)</h1></c:if>
<c:if test="${page == 2}"><h1 align="center">購入完了画面 (一括)</h1></c:if>
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

<div id="base">
	<c:if test="${page == 0}">
	<form action="/ec-site/purchase-file-confirm.html" method="post" enctype="multipart/form-data">

		<input type="file" name="file" value="Fileを選択" />
		<input type="submit" value="upload" />

	</form>
	</c:if>

	<c:if test="${page == 1}">
	<form action="/ec-site/purchase-complete.html" method="post">
		<input type="hidden" name="itemName" value="${itemName}" />
		<input type="hidden" name="itemCount" value="${itemCount}" />
		<input type="hidden" name="itemPrice" value="${itemPrice}" />
		<table>
			<tr>
				<td><input type="submit" value="確　定" /></td>
				<td><input type="button" value="戻　る" onclick="history.back()" /></td>
			</tr>
		</table>
	</form>
	</c:if>

	<c:if test="${page == 2}">
	<div align="center">
		<c:out value="商品購入完了しました" />
	</div>
	<form action="/ec-site/menu.html" method="get">
		<span class="fontawesome-list"></span>
		<input type="text" name="itemName" value="${itemName}" disabled="disabled" />
		<span class="fontawesome-plus"></span>
		<input type="text" name="itemCount" value="${itemCount}" disabled="disabled" />
		<span class="fontawesome-money"></span>
		<input type="text" name="itemPrice" value="${itemPrice}" disabled="disabled" />

		<input type="submit" value="メニュー画面へ"/>
	</form>
	</c:if>

</div>

</body>
</html>