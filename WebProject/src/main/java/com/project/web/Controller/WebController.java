package com.project.web.Controller;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.web.DAO.WebDAO;
import com.project.web.Service.WebServiceImpl;
import com.project.web.Util.Constant;
import com.project.web.VO.WebVO;

@Controller
public class WebController {

	public JdbcTemplate template;
	WebServiceImpl serviceImpl = null;
	
	@Autowired
	private SqlSession sqlSession;
	
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		Constant.template = this.template;
	}
	
/*	@RequestMapping(value = "/")
	public String home() {
		
		return "index";
	}*/
	
	@RequestMapping(value = "/idCheck")
	public String idCheck(){

		return "/idCheck";
	}
	
	@RequestMapping(value = "/signUp")
	public String signUp() {	
		
		return "/signUp";
	}
	
	@RequestMapping(value = "/checkInfo", method=RequestMethod.POST)
	public String checkInfo(WebVO webVO, Model model){
		
		model.addAttribute("webVo",webVO);
		
		return "/checkInfo";
	}
	
	
	@RequestMapping(value = "/result")
	public String result(HttpServletRequest request, Model model){
	
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		String userName = request.getParameter("userName");
		String userGender = request.getParameter("userGender");
		String userAddr1 = request.getParameter("userAddr1");
		String userAddr2 = request.getParameter("userAddr2");
		String userPhone = request.getParameter("userPhone");
		String userEmail = request.getParameter("userEmail");
		Timestamp regDate = new Timestamp(System.currentTimeMillis()); 
		
		if(userGender.equals("남자")){
			userGender = "M";
		}else{
			userGender = "F";
		}
		
		WebDAO dao = sqlSession.getMapper(WebDAO.class);
		dao.signUp(userId,userPwd,userName,userGender,userAddr1,userAddr2,userPhone,userEmail,regDate);
		
		
		return "/result";
	}
	
	@RequestMapping(value = "/adminPage")
	public String adminPage(){
		return "/adminPage";
	}
	
	@RequestMapping(value = "/memberList")
	public String memberList(Model model){
		System.out.println("memberList()");
		WebDAO dao = sqlSession.getMapper(WebDAO.class);
		model.addAttribute("memberList", dao.memberList());
		int rowNum = dao.memberList().size();
		model.addAttribute("rowNum", rowNum);
		
		return "/memberList";
	}

	
	@RequestMapping(value = "/addrPopup")
	public String resultAddr(Model model){
		System.out.println("addrPopup()");
		WebDAO dao = sqlSession.getMapper(WebDAO.class);
		model.addAttribute("searchAddr", dao.findSido());

		
		return "/addrPopup";
	}
	
	@RequestMapping(value = "/addrSearch")
	public String addrSearch(HttpServletRequest request, Model model){
		String sido_name = request.getParameter("sido_name");
		WebDAO dao = sqlSession.getMapper(WebDAO.class);
		model.addAttribute("searchSigungu", dao.addrSearch(sido_name));
		
		return "/addrSearch";
	}
	
	@RequestMapping(value = "/addrSearch1")
	public String addrSearch1(HttpServletRequest request, Model model){
		//도로명 주소 검색
		String sido_name = request.getParameter("sido_name");
		String sigungu_name = request.getParameter("sigungu_name");
		String road_name = request.getParameter("road_name");
		String bonbun = request.getParameter("bonbun").trim();
		String bubun  = request.getParameter("bubun").trim();	
			if(bonbun == null || bonbun.equals("")){
				bonbun = "0";
			}
			if(bubun == null || bubun.equals("")){
				bubun = "0";
			}
		int building_bonbun = Integer.parseInt(bonbun);
		int building_bubun = Integer.parseInt(bubun);
				
		
		System.out.println("addrSearch1() 실행");
		
		WebDAO dao = sqlSession.getMapper(WebDAO.class);
		if(building_bonbun == 0){
			model.addAttribute("searchRoadName", dao.addrSearch1(sido_name, sigungu_name, road_name));
			int rowNum = dao.addrSearch1(sido_name, sigungu_name, road_name).size();
			model.addAttribute("rowNum", rowNum);
		}else{
			model.addAttribute("searchRoadName", dao.addrSearch2(sido_name, sigungu_name, road_name, building_bonbun, building_bubun));
			int rowNum = dao.addrSearch2(sido_name, sigungu_name, road_name, building_bonbun, building_bubun).size();
			model.addAttribute("rowNum", rowNum);
		}
		return "/addrSearch1";
	}
	
	@RequestMapping(value = "/addrSearch3")
	public String addrSearch2(HttpServletRequest request, Model model){
		//빌딩이름 검색
		String sido_name = request.getParameter("sido_name");
		String sigungu_name = request.getParameter("sigungu_name");
		String sigungu_building_name = request.getParameter("buildingName");
		sigungu_building_name = sigungu_building_name.toUpperCase();
		WebDAO dao = sqlSession.getMapper(WebDAO.class);
		model.addAttribute("searchBuildingName", dao.addrSearch3(sido_name, sigungu_name, sigungu_building_name));
		int rowNum = dao.addrSearch3(sido_name, sigungu_name, sigungu_building_name).size();
		model.addAttribute("rowNum",rowNum);
		return "/addrSearch3";
	}
	
	@RequestMapping(value = "/")
	public String tempMain(){
		
		return "/tempMain";
	}
}
