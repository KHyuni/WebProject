<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0"/>
<link rel="stylesheet" type="text/css" href="css/memberList.css"/>
<title></title>
</head>
<body>
	<div>
		<table>
			<tr class="memberListTitle">
				<td>회원번호</td>
				<td>아이디</td>
				<td>이름</td>
				<td>성별</td>
				<td>주소</td>
				<td>전화번호</td>
				<td>이메일</td>
				<td>가입일</td>
			</tr>
			<c:forEach items="${memberList}" var="vo">
			<tr class="memberListData">
				<td>${vo.userNo}</td>
				<td>${vo.userId}</td>
				<td>${vo.userName}</td>
				<td>${vo.userGender}</td>
				<td>${vo.userAddr1}&nbsp;${vo.userAddr2}</td>
				<td>${vo.userPhone}</td>
				<td>${vo.userEmail}</td>
				<td>${vo.regDate}</td>	
			</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>