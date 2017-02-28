package com.jibnawa.auctiontable;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;

import com.vo.jibnawaSubidVO;

public class JibnawaSubidDao {

	Logger logger = Logger.getLogger(JibnawaSubidDao.class);
	public SqlSessionTemplate sqlSessionTemplate=null;
	public void setSqlSessionTemplate(SqlSessionTemplate  sqlSessionTemplate){
		this.sqlSessionTemplate=sqlSessionTemplate;
	}
	public List<Map<String, Object>>getjbSubidList(jibnawaSubidVO jbsuVO) {
		logger.info("DAO : getjbSubidList 호출성공");
		List<Map<String, Object>>suList=null;
		suList=sqlSessionTemplate.selectList("getjbSubidList",jbsuVO);
		return suList;
	}
}
