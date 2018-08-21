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
<title>家計簿アプリケーション-ログイン画面</title>
</head>
<body>

<div align="center">
<form action="ManagementServlet" method="post">
<table>
<tr><td>ユーザー名:<input type="text" name="userName"><br></td></tr>
<tr><td>パスワード:<input type="password" name="password"><br></td></tr>
<tr><td align="right"><input type="hidden" name="command" value="CheckUser">
<input type="submit" value="ログイン"><br></td></tr>
<tr><td align="right"><a href="MemberRegistForm.jsp">新規登録はこちら</a></td></tr>
</table>
</form>
</div>

</body>
</html>