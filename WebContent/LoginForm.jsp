<!--
LoginForm.jsp
Created by Akihiro Yamada on 2018/07/25.
Copyright (c) 2018. All Rights Reserved.
 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/common.css" />

<title>家計簿アプリケーション-ログイン画面</title>
</head>
<body>

<div align="center">
	${errMsg }<br>
	<form action="ManagementServlet" method="post">
		<table>
			<tr>
			   <td>
			       メールアドレス:
			   </td>
			   <td>
			       <input type="text" name="email">
			   </td>
			</tr>
			<tr>
			   <td>
			       パスワード:
			   </td>
			   <td>
			       <input type="password" name="password">
			   </td>
			</tr>
			<tr>
			   <td>
			   </td>
			   <td align="right">
			       <input type="hidden" name="command" value="CheckUser">
			       <input type="submit" value="ログイン">
			   </td>
			</tr>
			<tr>
			   <td>
			   </td>
			   <td align="right">
			       <a href="MemberRegistForm.jsp">
			           新規登録はこちら
			       </a>
			   </td>
		    </tr>
		</table>
	</form>
</div>

</body>
</html>