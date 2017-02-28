package com.jibnawa.AucIns;

import java.io.IOException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller 
@RequestMapping(value="/jibnawa")
public class JibnawaAucInsController {
	Logger logger = Logger.getLogger(JibnawaAucInsController.class);

	@Autowired
	public JibnawaAucInsLogic jibnawaAucInsLogic = null;

	@RequestMapping(value="jibnawaInsert.kosmo")
	public String jibnawaInsert(@RequestParam Map<String,Object> pMap){
		logger.info("jibnawaInsert 호출 성공");
		int result = 0;
		logger.info(pMap.get("region_code"));
		logger.info(pMap.get("sub_area_code"));
		logger.info(pMap.get("acc_start_date"));
		logger.info(pMap.get("acc_end_date"));
		logger.info(pMap.get("auc_start_date"));
		logger.info(pMap.get("auc_end_date"));
		result = jibnawaAucInsLogic.jibnawaInsert(pMap);
		logger.info("result :"+result);
		return "forward:./jungsungsil.jsp";//리턴값에 응답페이지가 오면됨 (String으로)
	}
	/*@RequestMapping(value="getRegioncodeList.kosmo")
	public String getRegioncodeList(ModelMap rMap, @RequestParam Map<String,Object> pMap){
		logger.info("getRegioncodeList 호출 성공");
		List<HashMap> RegioncodeList = null;
		RegioncodeList = jibnawaMemberLogic.getRegioncodeList(pMap);
		rMap.addAttribute("RegioncodeList", RegioncodeList);
		return "forward:./jSonRegioncodeList.jsp"; 
	}*/
}
