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
	<div>
		<p class="addrTitle" align="center">주소검색</p>
	</div>
	<div>
		<p class="notice">※ 찾고자 하는 도로명주소 또는 건물명을 선택해주세요.</p>
	</div>
	<div class="checkBoxArea">
		&nbsp;&nbsp;<input type="radio" name="checkForSearch" id="checkForSearch1" checked="checked" value="roadSearch" onclick="checkBtn(1);"> 도로명주소 검색
		<input type="radio" name="checkForSearch" id="checkForSearch2" value="buildSearch" onclick="checkBtn(2);"> 건물명 검색
	</div>
	 <div class="totalCnt">
	 	(총${totalCnt}건)
	 </div>
	<div class="selectBoxArea">
		 <div class="innerBox1">
		 	<c:if test="${!empty searchAddr}">
		 		&nbsp;&nbsp;시/도&nbsp;&nbsp;&nbsp;&nbsp;<select name="selectBox1" id="selectBox1" class="selectBox1">
		 			<c:forEach var="vo" items="${searchAddr}" varStatus="i">
		 				<option value="${vo.sido_name}">${vo.sido_name}</option>
		 			</c:forEach>
		 		</select>
		 	</c:if>
		 	<c:if test="${!empty searchAddr}">
		 		&nbsp;&nbsp;&nbsp;시/군/구&nbsp;&nbsp;&nbsp;<select name="selectBox2" id="selectBox2" class="selectBox2">
		 			<c:forEach var="vo" items="${searchAddr}" varStatus="i">
		 				<option value="${vo.sigungu_name}">${vo.sigungu_name}</option>
		 			</c:forEach>
		 		</select>
		 	</c:if>
		 </div>
		 <div id="innerBox2">
		    &nbsp;&nbsp;도로명&nbsp;&nbsp;<input type="text" name="roadName" class="roadName" size="15">
		    &nbsp;&nbsp;&nbsp;건물번호&nbsp;&nbsp;<input type="text" name="buildingBonbun" class="buildingBonbun" size="5"> - 
		    <input type="text" name="buildingBonbun" class="buildingBubun" size="5">
		    <button type="button" class="searchBtn">검색</button>
		 </div>
		 <div id="innerBox3" style="display:none;">
		    건물명&nbsp;&nbsp;<input type="text" name="buildingName" class="buildingName" size="40"/>
		    <button type="button" class="searchBtn">검색</button>
		 </div>
	</div>
	<div>
		 <p class="notice">※ 해당되는 주소를 선택해주세요</p>
	</div>
	<div class="addressArea">
		<table class="innerAddressTb">
			<tr class="addrAreaTitle">
				<td class="zipcodeTitle">우편번호</td>
				<td class="addressTitle">주소</td>
			</tr>
			<tr class="addrAreaData">
				<td>Data Binding Point</td>
			</tr>
		</table>
	</div>
	<div>
		<p class="notice">※ 상세주소 입력 후 '확인' 버튼을 눌러주세요</p>
	</div>
	<div class="addrLastArea">
		<div class="roadNameAddr">
		도로명주소<input type="text" name="addr1" class="addr1" value="03934"/><input type="text" name="addr2" class="addr2" value="서울특별시 마포구 성암로"/>
		</div>
		<div class="detailAddr">
		상세주소입력<input type="text" name="addr3" class="addr3"/><input type="text" name="addr4" class="addr4" value="(성산제2동,남양빌라)"/>
		</div>
	</div>
	<div class="saveBtnArea">
		<button type="button" class="saveBtn">저장</button>
	</div>
</body>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript" src="js/addrPopup.js"></script>
</html>