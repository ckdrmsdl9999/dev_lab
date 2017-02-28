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
@RequestMapping(value="/jibnawa")//������ ���� �����̸�
public class JibnawaRauctionController {
	Logger logger = Logger.getLogger(JibnawaRauctionController.class);
	
	@Autowired
	public JibnawaRauctionLogic jibnawaRauctionLogic = null;

	@RequestMapping(value="JibnawaRauctionList.kosmo")
	public String jibnawaMember(@RequestParam Map<String,Object> paMap, ModelMap pMap){   
		logger.info("JibnawaRauction ȣ�� ����");
		
		
		List<Map<String,Object>> jibnawaRauctionList = null;
		
			
		jibnawaRauctionList = jibnawaRauctionLogic.jibnawaRauctionList(paMap);
		
		pMap.addAttribute("jibnawaRauctionList",jibnawaRauctionList);
		
		return "forward:./jsonjibnawaRauction.jsp";//����������
	}
	@RequestMapping(value="bidaction.kosmo")
	public String bidaction(@RequestParam Map<String,Object> paMap, ModelMap pMap){   
		logger.info("bidaction ȣ�� ����");
		List<Map<String,Object>> jibnawaRauctionList = null;
		
		logger.info(paMap.get("AUC_COMM_ID"));
		
		/*jibnawaRauctionList = jibnawaRauctionLogic.jibnawaRauctionList(paMap);
		
		pMap.addAttribute("jibnawaRauctionList",jibnawaRauctionList);*/
		
		return "forward:./JibnawaRauctionList.kosmo";//����������
	}
}
