package com.jibnawa.member;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class JibnawaMemberLogic {
	Logger logger = Logger.getLogger(JibnawaMemberLogic.class);
	//public SqlMapDeptDao sqlMapDeptDao=null;
	@Autowired
	public JibnawaMemberDao jibnawaMemberDao=null;
	
	public void setSqlMapJibnawaDao(JibnawaMemberDao sqlMapJibnawaDao) {
		this.jibnawaMemberDao = sqlMapJibnawaDao;
	}
	public List<HashMap> jibnawaMember() {	
		List<HashMap> jibnawaMember = null;
		logger.info("jibnawaMemberList호출 성공");
		jibnawaMember = jibnawaMemberDao.jibnawaMember();
		return jibnawaMember;
	}
}