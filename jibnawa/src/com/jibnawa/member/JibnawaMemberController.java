package com.jibnawa.member;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.jibnawa.member.JibnawaMemberLogic;

@Controller
@RequestMapping(value="/main/admin")//업무에 대한 폴더이름
public class JibnawaMemberController {
	Logger logger = Logger.getLogger(JibnawaMemberController.class);
	//<bean id="deptLogic" class="com.mvc.DeptLogic"/>

	@Autowired
	public JibnawaMemberLogic jibnawaMemberLogic = null;

	@RequestMapping(value="jibnawaMember.kosmo")
	public String jibnawaMember(ModelMap pMap){   
		logger.info("jibnawaMember 호출 성공");
		List<HashMap> jibnawaMember = null;
		jibnawaMember = jibnawaMemberLogic.jibnawaMember();
		pMap.addAttribute("jibnawaMember",jibnawaMember);
		return "forward:./jibnawaMember.jsp";//응답페이지
	}
}
