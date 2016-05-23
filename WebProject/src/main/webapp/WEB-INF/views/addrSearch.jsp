<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="selectBoxArea">
	 	<c:if test="${!empty searchSigungu}">
	 			<c:forEach var="vo" items="${searchSigungu}" varStatus="i">
	 				<option value="${vo.sigungu_name}">${vo.sigungu_name}</option>
	 			</c:forEach>
	 	</c:if>
</div>
<script>
	
</script>


<div>
${totalCnt}
</div>