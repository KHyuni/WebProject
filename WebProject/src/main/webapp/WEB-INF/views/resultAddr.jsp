<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0"/>
<link rel="stylesheet" type="text/css" href="css/resultAddr.css"/>
<title></title>
</head>
<body>
<!-- 데이터 결과 확인을 위한 테스트 페이지 -->
<div>
		<table>
			<tr>
				<td class="totalCnt" colspan="7">[총${totalCnt}건]<br/></td>
			</tr>
			<tr class="tableTitle">
				<td>시/도</td>
				<td>시/군/구</td>
				<td>도로명</td>
				<td>번지</td>
				<td>우편번호</td>
				<td>행정동</td>
				<td>건물이름</td>
			</tr>
			<c:forEach items="${searchAddr}" var="vo">
			<tr class="tableData">
				<td>${vo.sido_name}</td>
				<td>${vo.sigungu_name}</td>
				<td>${vo.road_name}</td>
				<td>${vo.building_bonbun}&nbsp;${vo.building_bubun}</td>
				<td>${vo.zipcode}</td>
				<td>${vo.hangjung_dong_name}</td>
				<td>${vo.sigungu_building_name}</td>
			</tr>
			</c:forEach>
			<tr>
				<td></td>
			</tr>
		</table>
	</div>
</body>
</html>