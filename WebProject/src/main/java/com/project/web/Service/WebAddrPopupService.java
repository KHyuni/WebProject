package com.project.web.Service;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.project.web.DAO.WebDAO;
import com.project.web.VO.WebAddrVO;

public class WebAddrPopupService implements WebServiceImpl{

	@Override
	public void execute(Model model) {
		
		WebDAO dao = new WebDAO();
		
		String sido_name = "서울특별시";
		String sigungu_name = "마포구";
		String hangjung_dong_name = "상암동";
		
		ArrayList<WebAddrVO> vo = dao.searchAddr(sido_name, sigungu_name, hangjung_dong_name);
		int rowNum = vo.size();
		System.out.println(rowNum);
		model.addAttribute("searchAddr", vo);
		model.addAttribute("totalCnt", rowNum);
		
	}

}
