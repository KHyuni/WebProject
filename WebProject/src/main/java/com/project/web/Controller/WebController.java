package com.project.web.Controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.web.DAO.WebDAOImpl;
import com.project.web.Service.WebAddrPopupService;
import com.project.web.Service.WebMemberListService;
import com.project.web.Service.WebResultService;
import com.project.web.Service.WebServiceImpl;
import com.project.web.Util.Constant;
import com.project.web.VO.WebVO;

@Controller
public class WebController {
	
	WebServiceImpl serviceImpl = null;
	
	public JdbcTemplate template;
	
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
		System.out.println("result()"+"\n");
		
		//System.out.println("signUp()"+"\n");
		model.addAttribute("request", request);
		
		System.out.println("userId ==========> "+request.getParameter("userId"));
		
		serviceImpl = new WebResultService();
		serviceImpl.execute(model);
		
		return "/result";
	}
	
	@RequestMapping(value = "/adminPage")
	public String adminPage(){
		return "/adminPage";
	}
	
/*	@RequestMapping(value = "/memberList")
	public String memberList(Model model){
		System.out.println("memberList()");
		
		serviceImpl = new WebMemberListService();
		serviceImpl.execute(model);
		
		return "/memberList";
	}	*/
	
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
		
		serviceImpl = new WebAddrPopupService();
		serviceImpl.execute(model);
		
		return "/addrPopup";
	}
	
	@RequestMapping(value = "/addrSearch")
	public String addrSearch(){
		return "/addrSearch";
	}
	
}
