package com.project.web.DAO;

import java.sql.Timestamp;
import java.util.ArrayList;

import com.project.web.VO.WebAddrVO;
import com.project.web.VO.WebVO;

public interface WebDAO {
	
	public void signUp(String userId, String userPwd, String userName, String userGender, String userAddr1, String userAddr2, String userPhone, String userEmail, Timestamp regDate);
	ArrayList<WebVO> memberList();
	ArrayList<WebAddrVO> findSido();
	ArrayList<WebAddrVO> addrSearch(String sido_name);
	ArrayList<WebAddrVO> addrSearch1(String sido_name,String sigungu_name, String road_name);
	ArrayList<WebAddrVO> addrSearch2(String sido_name,String sigungu_name, String road_name, int building_bonbun, int building_bubun);
	ArrayList<WebAddrVO> addrSearch3(String sido_name,String sigungu_name, String sigungu_building_name);

}

