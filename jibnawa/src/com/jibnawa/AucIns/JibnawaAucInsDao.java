package com.jibnawa.AucIns;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;

public class JibnawaAucInsDao {
	Logger logger = Logger.getLogger(JibnawaAucInsDao.class);
	public SqlSessionTemplate sqlSessionTemplate = null;
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	/*public List<HashMap> jibnawaMember() {
		logger.info("jibnawaMember 호출 성공");
		List<HashMap> jibnawaMember = null;
		jibnawaMember
				=sqlSessionTemplate.selectList("jibnawaMember");
		logger.info("jibnawaMember 호출 성공");
		return jibnawaMember;
	}*/
	
	public int jibnawaInsert(Map<String, Object> pMap) {
		logger.info("jibnawaInsert호출 성공");
		logger.info(pMap.get("region_code"));
		logger.info(pMap.get("sub_area_code"));
		logger.info(pMap.get("acc_start_date"));
		logger.info(pMap.get("acc_end_date"));
		logger.info(pMap.get("auc_start_date"));
		logger.info(pMap.get("auc_end_date"));
		logger.info(pMap.get("contract_price"));
		logger.info(pMap.get("contract_price_end"));
		logger.info(pMap.get("headcount"));
		
		int result = 0;
		result = 
				sqlSessionTemplate.insert("jibnawaInsert",pMap);
		logger.info("jibnawaInsert입력 성공");
		return result;
	}
	public List<HashMap> getRegioncodeList(Map<String, Object> pMap) {
		logger.info("getRegioncodeList호출 성공");
		List<HashMap> RegioncodeList = null;
		
		logger.info(pMap.get("region_code"));
		logger.info(pMap.get("sub_area_code"));
		logger.info(pMap.get("acc_start_date"));
		logger.info(pMap.get("acc_end_date"));
		logger.info(pMap.get("auc_start_date"));
		logger.info(pMap.get("auc_end_date"));
		
		
		
		RegioncodeList = 
				sqlSessionTemplate.selectList("RegioncodeList",pMap);
		return RegioncodeList;
	}
}
