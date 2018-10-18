<!--
LoginForm.jsp
Created by Akihiro Yamada on 2018/08/22.
Copyright (c) 2018. All Rights Reserved.
 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メインページ</title>
</head>
<body>
残金総額:${member.balance }<br>

<form method="post">
    <c:forEach var="errMsg" items="${errMsgs }">
        <c:out value="${errMsg }"></c:out><br>
    </c:forEach>
	<table width="30%" align="left">
	    <tr>
	        <th>
	            内容
	        </th>
	        <th>
	            金額
	        </th>
	        <th align="left">
	            収入/支出
	        </th>
	    </tr>
	    <tr>
	        <td align="right">
	            <input type="text" name="detail" value="">
	        </td>
	        <td align="right">
	            <input type="text" name="price">円
	        </td>
	        <td>
	            <select name="isIncome">
	                <option value="true">
	                    収入
	                </option>
	                <option value="false">
	                    支出
	                </option>
	            </select>
	        </td>
	    </tr>
	    <tr>
	       <td>
	       </td>
	       <td>
	           <input type="hidden" name="command" value="RegistExchange">
               <input type="submit" value="収支登録"><br>
	       </td>
	    </tr>
	</table>
</form>

<table border="1" width="80%" align="center">
<tr>
    <th>
        日付
    </th>
    <th>
        内容
    </th>
    <th>
        支出
    </th>
    <th>
        収入
    </th>
</tr>
<c:forEach var="l" items="${log }">
<c:choose>
	<c:when test="${l.isIncome == false }">
		<tr>
		    <td>
		        <c:out value="${l.exchangeDateStr }"/>
		    </td>
		    <td>
		        <c:out value="${l.detail }"/>
		    </td>
		    <td align="right">
		        <c:out value="${l.amount }"/>
		    </td>
		    <td>
		    </td>
		</tr>
	</c:when>
	<c:otherwise>
		<tr>
			<td>
			   <c:out value="${l.exchangeDateStr }"/>
			</td>
			<td>
			   <c:out value="${l.detail }"/>
			</td>
			<td>
			</td>
			<td align="right">
			   <c:out value="${l.amount }"/>
			</td>
		</tr>
	</c:otherwise>
</c:choose>
</c:forEach>
</table>


</body>
</html>