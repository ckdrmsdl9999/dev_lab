package com.jibnawa.auctiontable;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;

import com.vo.jibnawaTenderVO;

public class JibnawaTenderDao {
	Logger logger = Logger.getLogger(JibnawaTenderDao.class);
	public SqlSessionTemplate sqlSessionTemplate=null;
	public void setSqlSessionTemplate(SqlSessionTemplate  sqlSessionTemplate){
		this.sqlSessionTemplate=sqlSessionTemplate;
}
	public List<Map<String, Object>> getjbTenderList(jibnawaTenderVO tVO) {
		logger.info("getjbTenderList 호출성공");
		List<Map<String, Object>>tenderList=null;
		tenderList=sqlSessionTemplate.selectList("getjbTenderList",tVO);
		return tenderList;
	}

}
