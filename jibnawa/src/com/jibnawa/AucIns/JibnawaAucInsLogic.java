package com.jibnawa.AucIns;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class JibnawaAucInsLogic {
	Logger logger = Logger.getLogger(JibnawaAucInsLogic.class);
	
	@Autowired
	public JibnawaAucInsDao jibnawaMemberDao=null;
	
	public void setSqlMapJibnawaDao(JibnawaAucInsDao sqlMapJibnawaDao) {
		this.jibnawaMemberDao = sqlMapJibnawaDao;
	}
	/*public List<HashMap> jibnawaMember() {	
		List<HashMap> jibnawaMember = null;
		logger.info("jibnawaMemberList호출 성공");
		jibnawaMember = jibnawaMemberDao.jibnawaMember();
		return jibnawaMember;
	}*/
	public int jibnawaInsert(Map<String, Object> pMap) {
		logger.info("jibnawaInsert호출 성공");
		int result = 0;
		result = jibnawaMemberDao.jibnawaInsert(pMap);
		return result;
	}
	public List<HashMap> getRegioncodeList(Map<String, Object> pMap) {
		logger.info("getRegioncodeList호출 성공");
	      List<HashMap> RegioncodeList = null;
	      RegioncodeList=jibnawaMemberDao.getRegioncodeList(pMap);
	      return RegioncodeList;
	}
	
}