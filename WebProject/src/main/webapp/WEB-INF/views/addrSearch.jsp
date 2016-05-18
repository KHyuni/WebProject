<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.sql.*, org.springframework.web.context.*, org.springframework.web.context.support.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%!
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String query = "select sigungu_name from SIGUNGU_CODE where sido_name = ?";
%>

<%
	String sido_name = request.getParameter("sido_name");

	try{
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, sido_name);
		
		rs = pstmt.executeQuery();
%>
<tr>
	<td>
		시/도 : <%=rs.getString("sigungu_name")%>
	</td>
</tr>

<% 
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		if(rs != null){rs.close();}
		if(pstmt != null){pstmt.close();}
		if(conn != null){conn.close();}
	}
%>
