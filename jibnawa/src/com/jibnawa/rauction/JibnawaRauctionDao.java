package com.jibnawa.rauction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;

public class JibnawaRauctionDao {
	Logger logger = Logger.getLogger(JibnawaRauctionDao.class);
	public SqlSessionTemplate sqlSessionTemplate = null;
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	public List<Map<String, Object>> jibnawaRauctionList(Map<String, Object> paMap) {
		
		logger.info("jibnawaRauction 호출 성공");
		List<Map<String,Object>> jibnawaRauctionList = null;
		jibnawaRauctionList
				=sqlSessionTemplate.selectList("jibnawaRauctionList",paMap);
	
		logger.info(jibnawaRauctionList.get(0).get("BID_EMAIL")); 
		
		return jibnawaRauctionList;
		
	}
}
