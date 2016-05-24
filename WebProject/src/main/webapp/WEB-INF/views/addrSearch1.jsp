<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div>
		<c:if test="${!empty searchRoadName}">
	 			<c:forEach var="vo" items="${searchRoadName}" varStatus="i">
	 				${vo.sido_name} ${vo.sigungu_name} ${vo.road_name} ${vo.building_bonbun} ${vo.building_bubun} ${vo.sigungu_building_name} ${vo.zipcode}<br/>
	 			</c:forEach>
	 	</c:if>
</div>