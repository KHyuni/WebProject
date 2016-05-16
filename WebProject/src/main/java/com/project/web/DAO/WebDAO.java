package com.project.web.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;

import com.project.web.Util.Constant;
import com.project.web.VO.WebAddrVO;
import com.project.web.VO.WebVO;

public class WebDAO {

	JdbcTemplate template = null;
	
	public WebDAO() {
		template = Constant.template;
	}
	
	public void signUp(final String userId, final String userPwd, final String userName, final String userGender, final String userAddr1, final String userAddr2, final String userPhone, final String userEmail, final Timestamp regDate){
			
			template.update(new PreparedStatementCreator() {
				
				@Override
				public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
					String query = "insert into user_tb (userNo, userId, userPwd, userName, userGender, userAddr1, userAddr2, userPhone, userEmail, regDate) "
							+ "values(seq_user_tb.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
					PreparedStatement pstmt = conn.prepareStatement(query);
					pstmt.setString(1, userId);
					pstmt.setString(2, userPwd);
					pstmt.setString(3, userName);
					pstmt.setString(4, userGender);
					pstmt.setString(5, userAddr1);
					pstmt.setString(6, userAddr2);
					pstmt.setString(7, userPhone);
					pstmt.setString(8, userEmail);
					pstmt.setTimestamp(9, regDate);
					
					return pstmt;
				}
			});
			
		}
		
	public ArrayList<WebVO> memberList(){
		String query = "select userNo, userId, userName, userAddr1, userAddr2, userPhone, userEmail, regdate from user_tb order by userNo asc";
		return (ArrayList<WebVO>) template.query(query, new BeanPropertyRowMapper<WebVO>(WebVO.class));
	}
	
	public boolean checkId(String userId){
		
		System.out.println("checkId() ===========> userId =====> "+userId);
		
		boolean result = false;		
		
		Integer cnt = template.queryForObject(
			    "SELECT count(*) FROM user_tb WHERE userId = ?", Integer.class, userId);
		
		System.out.println("checkId() ===========> count =====> "+cnt);
		if(cnt > 0){
			result = true;
		}
		return result;
	}	
	
	public ArrayList<WebAddrVO> searchAddr(String sido_name, String sigungu_name, String hangjung_dong_name){
			
		System.out.println("시/도 = "+sido_name);
		System.out.println("시/군/구 = "+sigungu_name);
	
		String query = "select sido_name, sigungu_name, road_name, building_bonbun, building_bubun, zipcode, hangjung_dong_name, sigungu_building_name, hangjung_dong_name "
				+ "from building_info where sido_name = ? and sigungu_name = ? and hangjung_dong_name = ?";

		
		return (ArrayList<WebAddrVO>) template.query(query, new Object[]{sido_name,sigungu_name,hangjung_dong_name}, new BeanPropertyRowMapper<WebAddrVO>(WebAddrVO.class));

	}

}
