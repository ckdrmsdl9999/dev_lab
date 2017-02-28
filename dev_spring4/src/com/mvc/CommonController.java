package com.mvc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vo.ZipCodeVO;

@Controller
@RequestMapping(value="/common")
public class CommonController {
	
	Logger logger = Logger.getLogger(CommonController.class);
	
	@Autowired
	public CommonLogic commonLogic = null;
	//<bean id="commonLogic" class="com.mvc.commonLogic"/>
	
	
	
/*	@RequestMapping(value="getZipCodeList.kosmo") 
	public String getZipCodeList(@RequestParam Map<String,Object> pMap,HttpServletRequest req){
		
		logger.info("getZipCodeList 호출 성공");
		List<HashMap> commonList = null;
		//pMap.put("dong", "가산");
		commonList = commonLogic.getZipCodeList(pMap,req);
		req.setAttribute("commonList",commonList);
		return "forward:./jSongetZipCodeList.jsp";//응답페이지
		
		
		
	}*/
	
	@RequestMapping(value="getZipCodeList.kosmo") 
	public String getZipCodeList(@ModelAttribute ZipCodeVO zVO,HttpServletRequest req){
		
				
		
		logger.info("getZipCodeList 호출 성공");
		List<Map<String,Object>> commonList = null;
		//pMap.put("dong", "가산");
		logger.info(zVO.getDong());
		commonList = commonLogic.getZipCodeList(zVO);
		req.setAttribute("commonList",commonList);
		return "forward:./jSongetZipCodeList.jsp";//응답페이지
		

}
}

