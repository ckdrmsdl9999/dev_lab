package com.jibnawa.search;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.util.HangulConversion;


@Controller
@RequestMapping(value="/jibnawa")//������ ���� �����̸�
public class JibnawaSearchController {
	Logger logger = Logger.getLogger(JibnawaSearchController.class);
	//<bean id="deptLogic" class="com.mvc.DeptLogic"/>

	@Autowired
	public JibnawaSearchLogic jibnawaSearchLogic = null;

	@RequestMapping(value="jibnawaSearch.kosmo")
	public String jibnawaSearch(ModelMap rMap,@RequestParam Map<String,Object> pMap){   
		
		/*pMap.put("loc", rec);
		bookVO.setLoc(rec);//modelattribute*/	
		logger.info("jibnawaSearch ȣ�� ����");
		logger.info("jibnawaSearch ȣ�� ����");
		logger.info(HangulConversion.toKor((String)pMap.get("LOCATION")));
		List<HashMap<String,Object>> mainLocal = null;
		mainLocal = jibnawaSearchLogic.jibnawaSearch(pMap);
		rMap.addAttribute("mainLocal", mainLocal);
		return "forward:../main/search/jibnawaMainLocal.jsp";//����������
	}
	@RequestMapping(value="jibnawaSearchInsert.kosmo")
	public String jibnawaSearchInsert(@RequestParam Map<String,Object> pMap){   
		
		/*pMap.put("loc", rec);
		bookVO.setLoc(rec);//modelattribute*/	
		logger.info("jibnawaSearchInsert ȣ�� ����");
		logger.info(pMap.get("check_in_date"));
		int result=0;
		result = jibnawaSearchLogic.jibnawaSearchInsert(pMap);
		return "redirect:../main/fast/fast3.jsp";//����������
	}
}
