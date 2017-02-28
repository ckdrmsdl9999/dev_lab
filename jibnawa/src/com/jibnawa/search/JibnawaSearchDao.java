package com.jibnawa.search;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;

public class JibnawaSearchDao {
	Logger logger = Logger.getLogger(JibnawaSearchVO.class);
	public SqlSessionTemplate sqlSessionTemplate = null;
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}//세터를 만들어주자

	public List<HashMap<String, Object>> jibnawaSearch(Map<String, Object> pMap) {
		logger.info("jbDAO : jibnawaSearch");
		List<HashMap<String, Object>> mainLocal = null;
		
		if(pMap.get("LOCATION")==null){
		logger.info("pMap LOCATION:"+pMap.get("LOCATION"));
		  mainLocal = sqlSessionTemplate.selectList("jibnawaSearch", pMap);
		}else{
		logger.info("pMap LOCATION:"+pMap.get("LOCATION"));
				//pMap.get("LOCATION").toString();
		String sub_loc = pMap.get("LOCATION").toString();
		 mainLocal = sqlSessionTemplate.selectList("jibnawaSearch2", sub_loc);
		}
		return mainLocal;
	}

	public int jibnawaSearchInsert(Map<String, Object> pMap) {
		logger.info("dao : jibnawaSearchInsert");
		pMap.put("auc_comm", "ywk");
		pMap.put("acc_code", "ac_005");
		logger.info(pMap.get("rent_code"));
		int result = 0;
		result = sqlSessionTemplate.insert("ins", pMap);
		return result;
	}

}
