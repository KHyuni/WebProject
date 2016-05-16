<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0"/>
<link rel="stylesheet" type="text/css" href="css/index.css"/>
<title>Home</title>
</head>
<body>
	<header>
		<div>
			<div id="title">
				<h3> Spring 활용한 웹프로젝트 홈페이지 </h3>
			</div>
		</div>
	</header>
	<article>
		<form action="login" method="post">
			<table class="loginForm">
				<tr>
					<td>아이디 : </td>
					<td><input type="text" id="userId" name="userId" size="15"></td>
				</tr>
				<tr>
					<td>패스워드 : </td>
					<td><input type="password" id="userPwd" name="userPwd" size="15"/></td>
				</tr>
			</table>
			<div id="btnArea">
				<input type="submit" value="로그인"/>&nbsp;&nbsp;<input type="reset" value="취소"/>
			</div>
			<div id="linkArea">
				<p><a href="/web/signUp">회원가입</a></p>
			</div>
		</form>	
	</article>

<div>

	<!-- <div id="showCnt"></div> -->
</div>
</body>
<script type="text/javascript" src="js/index.js"></script>
</html>