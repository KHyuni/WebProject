<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0"/>
<link rel="stylesheet" type="text/css" href="css/signUp.css"/> 
<title>Sign Up (회원 가입)</title>
</head>

<body>
<div id="signUpForm">
	<h1>회원 가입 페이지</h1>
	<form action="checkInfo" method="post" id="frm">
		<table>
			<tr>
				<td>아이디 : </td>
				<td><input type="text" name="userId" id="userId" class="userId" size="14" maxlength="16"/></td>
				<td class="checkMsg">※ 영문, 숫자 포함 6~16문자<br/></td>
			</tr>
			<tr>
				<td></td>
				<td id="idChkMsg"></td>
			</tr>
			<tr>
				<td>패스워드 : </td>
				<td><input type="password" name="userPwd" id="userPwd" class="userPwd" size="14" maxlength="18"/></td>
				<td class="checkMsg">※ 영문/숫자, 특수문자 포함 6~18문자<br/></td>
			</tr>
			<tr>
				<td></td>
				<td id="userPwdMsg"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="password" name="userPwd1" id="userPwd1" class="userPwd1" size="14" maxlength="18"/><br/></td>
			</tr>
			<tr>
				<td>이름 : </td>
				<td><input type="text" name="userName" id="userName" class="userName" size="14" maxlength="20"/><br/></td>
			</tr>
			<tr>
				<td>성별</td>
				<td>남자<input type="radio" name="userGender" value="남자"/>&nbsp;여자<input type="radio" name="userGender" value="여자"/></td>
			</tr>
			<tr>
				<td>주소 : </td>
<!-- 				<td><input type="text" name="userAddr1" id="userAddr1" class="userAddr1" size="30" maxlength="50" readonly="readonly"/></td> -->
				<td><input type="text" name="userAddr1" id="userAddr1" class="userAddr1" size="30" maxlength="50"/></td>
				<td><button type="button" class="searchAddr">검색</button><br/></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="text" name="userAddr2" id="userAddr2" class="userAddr2" size="30" maxlength="50"/></td>
			</tr>
			<tr>
				<td>전화번호 : </td>
				<td><input type="tel" name="userPhone" id="userPhone" class="userPhone" size="15" maxlength="15"/><br/></td>
			</tr>
			<tr>
				<td>이메일 : </td>
				<td><input type="email" name="userEmail" id="userEmail" class="userEmail" size="20" maxlength="50"/><br/></td>
			</tr>
			<tr>
				<td rowspan="2"><input type="submit" value="확인" class="sendBtn"/>&nbsp;&nbsp;<input type="reset" value="취소"/></td>
			</tr>
		</table>
	</form>
</div>
</body>
<footer></footer>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript" src="js/signUp.js"></script>
</html>