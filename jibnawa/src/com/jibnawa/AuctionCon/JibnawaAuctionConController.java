package com.jibnawa.AuctionCon;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vo.jibnawaAuctionVO;

@Controller
@RequestMapping(value="/jibnawa")//업무에 대한 폴더이름
public class JibnawaAuctionConController {
	Logger logger = Logger.getLogger(JibnawaAuctionConController.class);
	
	@Autowired                    
	public JibnawaAuctionConLogic jibnawaAuctionConLogic = null;
	@RequestMapping(value="getauctionList.kosmo")
	public String getauctionList(ModelMap pMap,@ModelAttribute jibnawaAuctionVO aVO){   
		logger.info("JibnawaAuctionConController:getauctionList 호출 성공2222");
		List<Map<String,Object>> auctionList = jibnawaAuctionConLogic.getauctionList(aVO);
		pMap.addAttribute("auctionList",auctionList);
		return "forward:./jSonauctionList.jsp";//응답페이지
	}
}
