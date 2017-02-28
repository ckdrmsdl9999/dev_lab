package com.jibnawa.auctiontable;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vo.jibnawaSubidVO;

@Controller
@RequestMapping(value="/jibnawa")
public class JibnawaSubidController {
	Logger logger =Logger.getLogger(JibnawaSubidController.class);
	@Autowired
	public JibnawaSubidLogic jibnawaSubidLogic =null;
	@RequestMapping(value="getjbSubidList.kosmo")
	public String getjbSubidList(ModelMap pMap,@ModelAttribute jibnawaSubidVO jbsuVO){
		logger.info("getjbSubidList 호출 성공");
		List<Map<String,Object>> suList=jibnawaSubidLogic.getjbSubidList(jbsuVO);
		pMap.addAttribute("suList",suList);
		return "forward:./jSonjbSu_bidList.jsp" ; //WEB-INF/jsp/.jsp
	}
	
}
