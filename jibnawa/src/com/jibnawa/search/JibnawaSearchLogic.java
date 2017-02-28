package com.jibnawa.search;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class JibnawaSearchLogic {
Logger logger = Logger.getLogger(JibnawaSearchLogic.class);
	
	@Autowired
	public JibnawaSearchDao jibnawaSearchDao=null;
	
	public List<HashMap<String, Object>> jibnawaSearch(Map<String, Object> pMap) {

		logger.info("logic : getZipCodeList");
		List<HashMap<String,Object>> mainLocal = null;
		mainLocal=jibnawaSearchDao.jibnawaSearch(pMap);
		return mainLocal;
	}

	public int jibnawaSearchInsert(Map<String, Object> pMap) {
		logger.info("logic : jibnawaSearchInsert");
		int result = 0;
		result = jibnawaSearchDao.jibnawaSearchInsert(pMap);
		return result;
	}
}
