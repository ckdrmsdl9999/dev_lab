package com.jibnawa.AuctionCon;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vo.jibnawaAuctionVO;


@Service
public class JibnawaAuctionConLogic {

Logger logger = Logger.getLogger(JibnawaAuctionConLogic .class);
@Autowired
public JibnawaAuctionConDao jibnawaAuctionConDao = null;

public List<Map<String, Object>> getauctionList(jibnawaAuctionVO aVO) {
	logger.info("getauctionList22222호출 성공");
	List<Map<String,Object>> auctionList=null;
	auctionList=jibnawaAuctionConDao.getauctionList(aVO);
	return auctionList;
}
}