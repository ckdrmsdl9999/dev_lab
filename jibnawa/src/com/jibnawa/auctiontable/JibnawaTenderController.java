package com.jibnawa.auctiontable;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vo.jibnawaTenderVO;


@Controller
@RequestMapping(value="/jibnawa")
public class JibnawaTenderController {
	Logger logger =Logger.getLogger(JibnawaTenderController.class);
	@Autowired
	public JibnawaTenderLogic jibnawaTenderLogic =null;
	@RequestMapping(value="getjbTenderList.kosmo")
	public String getjbTenderList(ModelMap pMap,@ModelAttribute jibnawaTenderVO tVO){
		logger.info("getjbTenderList 호출 성공");
		List<Map<String,Object>> tenderList=jibnawaTenderLogic.getjbTenderList(tVO);
		pMap.addAttribute("tenderList",tenderList);
		return "forward:./jSonjbTenderList.jsp" ; //WEB-INF/jsp/.jsp
	}

}
