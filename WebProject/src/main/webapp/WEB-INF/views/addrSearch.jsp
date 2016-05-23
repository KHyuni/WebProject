<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0"/>
<link rel="stylesheet" type="text/css" href="css/addrPopup.css"/>
<title></title>
</head>
<body>

	<div class="selectBoxArea">
		 	<c:if test="${!empty searchSigungu}">
		 		&nbsp;&nbsp;&nbsp;시/군/구&nbsp;&nbsp;&nbsp;<select name="selectBox2" id="selectBox2" class="selectBox2">
		 			<c:forEach var="vo" items="${searchSigungu}" varStatus="i">
		 				<option value="${vo.sigungu_name}">${vo.sigungu_name}</option>
		 			</c:forEach>
		 		</select>
		 	</c:if>
	</div>
</body>
</html>