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

import com.project.web.DAO.WebDAOImpl;
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
	
	@RequestMapping(value = "/")
	public String home() {
		
		return "index";
	}
	
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
		
		WebDAOImpl dao = sqlSession.getMapper(WebDAOImpl.class);
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
		WebDAOImpl dao = sqlSession.getMapper(WebDAOImpl.class);
		model.addAttribute("memberList", dao.memberList());
		
		return "/memberList";
	}

	
	@RequestMapping(value = "/addrPopup")
	public String resultAddr(Model model){
		System.out.println("addrPopup()");
		WebDAOImpl dao = sqlSession.getMapper(WebDAOImpl.class);
		model.addAttribute("searchAddr", dao.findSido());

		
		return "/addrPopup";
	}
	
	@RequestMapping(value = "/addrSearch")
	public String addrSearch(HttpServletRequest request, Model model){
		String sido_name = request.getParameter("sido_name");
		System.out.println("addrSearch() 호출 = "+sido_name);
		WebDAOImpl dao = sqlSession.getMapper(WebDAOImpl.class);
		int rowNum = dao.addrSearch(sido_name).size();
		System.out.println("addrSearch 건수 = "+rowNum);
		model.addAttribute("searchSigungu", dao.addrSearch(sido_name));
		model.addAttribute("totalCnt", rowNum);
		
		return "/addrSearch";
	}
	
}
