package com.jibnawa.rauction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value="/jibnawa")//업무에 대한 폴더이름
public class JibnawaRauctionController {
	Logger logger = Logger.getLogger(JibnawaRauctionController.class);
	
	@Autowired
	public JibnawaRauctionLogic jibnawaRauctionLogic = null;

	@RequestMapping(value="JibnawaRauctionList.kosmo")
	public String jibnawaMember(@RequestParam Map<String,Object> paMap, ModelMap pMap){   
		logger.info("JibnawaRauction 호출 성공");
		
		
		List<Map<String,Object>> jibnawaRauctionList = null;
		
			
		jibnawaRauctionList = jibnawaRauctionLogic.jibnawaRauctionList(paMap);
		
		pMap.addAttribute("jibnawaRauctionList",jibnawaRauctionList);
		
		return "forward:./jsonjibnawaRauction.jsp";//응답페이지
	}
	@RequestMapping(value="bidaction.kosmo")
	public String bidaction(@RequestParam Map<String,Object> paMap, ModelMap pMap){   
		logger.info("bidaction 호출 성공");
		List<Map<String,Object>> jibnawaRauctionList = null;
		
		logger.info(paMap.get("AUC_COMM_ID"));
		
		/*jibnawaRauctionList = jibnawaRauctionLogic.jibnawaRauctionList(paMap);
		
		pMap.addAttribute("jibnawaRauctionList",jibnawaRauctionList);*/
		
		return "forward:./JibnawaRauctionList.kosmo";//응답페이지
	}
}
