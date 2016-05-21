<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.sql.*, org.springframework.web.context.*, org.springframework.web.context.support.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<html>
<body>
	<%
		HttpServletRequest req = null;
		String sido_name = req.getParameter("sido_name");
	%>
	<%=sido_name%>
</body>
</html>