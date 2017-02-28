package com.jibnawa.member;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;

public class JibnawaMemberDao {
	Logger logger = Logger.getLogger(JibnawaMemberDao.class);
	public SqlSessionTemplate sqlSessionTemplate = null;
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	public List<HashMap> jibnawaMember() {
		logger.info("jibnawaMember 호출 성공");
		List<HashMap> jibnawaMember = null;
		jibnawaMember
				=sqlSessionTemplate.selectList("jibnawaMember");
		logger.info("jibnawaMember 호출 성공");
		return jibnawaMember;
	}
}
