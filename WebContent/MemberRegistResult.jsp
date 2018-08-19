<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員登録完了</title>
</head>
<body>
<div align="center">
<p>以下の内容で登録しました</p>
<table>
<tr><td>氏名:</td><td>${member.name }</td></tr>
<tr><td>初期残高:</td><td>${member.balance }</td></tr>
<tr><td>メールアドレス:</td><td>${member.email }</td></tr>
<tr><td>パスワード:</td><td>セキュリティのため表示しません</td></tr>
</table>
</div>
<a href="LoginForm.jsp">ログインページへ戻る</a>
</body>
</html>