package com.project.web.DAO;

import java.sql.Timestamp;
import java.util.ArrayList;

import com.project.web.VO.WebAddrVO;
import com.project.web.VO.WebVO;

public interface WebDAOImpl {
	
	public void signUp(String userId, String userPwd, String userName, String userGender, String userAddr1, String userAddr2, String userPhone, String userEmail, Timestamp regDate);
	ArrayList<WebVO> memberList();
	ArrayList<WebAddrVO> findSido();

}

