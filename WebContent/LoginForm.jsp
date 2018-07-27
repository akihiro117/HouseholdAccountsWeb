<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>家計簿アプリケーション-ログイン画面</title>
</head>
<body>
<form action="ManagementServlet" method="post">
<div align="center">
<table>
<tr><td>ユーザー名:<input type="text" name="userName"><br></td></tr>
<tr><td>パスワード:<input type="password" name="password"><br></td></tr>
<input type="hidden" name="command" value="CheckUser">
<tr><td align="right"><input type="submit" value="ログイン"><br></td></tr>
<tr><td align="right"><a href="RegistUser.jsp">新規登録</a></td></tr>
</table>
</div>
</form>
</body>
</html>