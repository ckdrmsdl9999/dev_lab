package com.jibnawa.rauction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class JibnawaRauctionLogic {
	Logger logger = Logger.getLogger(JibnawaRauctionLogic.class);
	//public SqlMapDeptDao sqlMapDeptDao=null;
	@Autowired
	public JibnawaRauctionDao jibnawaRauctionDao=null;
	
	public void setSqlMapJibnawaDao(JibnawaRauctionDao sqlMapJibnawaDao) {
		this.jibnawaRauctionDao = sqlMapJibnawaDao;
	}
	
	public List<Map<String, Object>> jibnawaRauctionList(Map<String, Object> paMap) {
		
		List<Map<String,Object>> jibnawaRauctionList = null;
		logger.info("JibnawaRauctionList호출 성공");
		jibnawaRauctionList = jibnawaRauctionDao.jibnawaRauctionList(paMap);
		
		return jibnawaRauctionList;
	}
}