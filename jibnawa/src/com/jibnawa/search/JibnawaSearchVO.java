package com.jibnawa.search;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;


public class JibnawaSearchVO {
	Logger logger = Logger.getLogger(JibnawaSearchVO.class);
	public SqlSessionTemplate sqlSessionTemplate = null;
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}//세터를 만들어주자
	
	public List<HashMap<String,Object>> getZipCodeList() {
		logger.info("DAO : getZipCodeList");
		List<HashMap<String,Object>> zipList = null;
		zipList=sqlSessionTemplate.selectList("getZipCodeList");
		return zipList;
	}
}
