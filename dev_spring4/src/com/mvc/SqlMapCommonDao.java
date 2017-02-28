package com.mvc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;

import com.vo.ZipCodeVO;

public class SqlMapCommonDao {
	Logger logger = Logger.getLogger(SqlMapCommonDao.class);
	public SqlSessionTemplate sqlSessionTemplate = null;
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	

	public List<HashMap> getCommonList(Map<String, Object> pMap) {
		logger.info("getCommonList호출 성공");
		List<HashMap> CommonList = null;
		CommonList
				=sqlSessionTemplate.selectList("getCommonList",pMap);
		return CommonList;
	}



	public List<Map<String, Object>> getCommonList(ZipCodeVO zVO) {
		logger.info("getCommonList호출 성공");
		List<Map<String, Object>> CommonList = null;
		CommonList
				=sqlSessionTemplate.selectList("getCommonList2",zVO);
		return CommonList;
	}
	
	
	
	
	
	
	
}
