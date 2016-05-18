package com.project.web.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

import com.project.web.Util.Constant;
import com.project.web.VO.WebAddrVO;
import com.project.web.VO.WebVO;

public class WebDAO implements WebDAOImpl{

	JdbcTemplate template = null;
	
	public WebDAO() {
		template = Constant.template;
	}
	@Override
	public void signUp(final String userId, final String userPwd, final String userName, final String userGender, final String userAddr1, final String userAddr2, final String userPhone, final String userEmail,final Timestamp regDate){
	
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
		boolean result = false;		

		Integer cnt = template.queryForObject(
			    "SELECT count(*) FROM user_tb WHERE userId = ?", Integer.class, userId);
		
		if(cnt > 0){
			result = true;
		}
		return result;
	}
	
	
	public ArrayList<WebAddrVO> findSido(){
		String query = "SELECT /*+USE_HASH_AGGREGATION*/ sido_name FROM SIGUNGU_CODE GROUP BY sido_name HAVING COUNT(*) >= 1 ORDER BY sido_name";
		return (ArrayList<WebAddrVO>) template.query(query, new BeanPropertyRowMapper<WebAddrVO>(WebAddrVO.class));
	}


/*	public ArrayList<WebAddrVO> findSigunGu(){

	}*/
	
}
