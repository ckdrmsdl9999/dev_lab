package com.jibnawa.AuctionCon;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;

import com.vo.jibnawaAuctionVO;

public class JibnawaAuctionConDao {
	Logger logger = Logger.getLogger(JibnawaAuctionConDao.class);
	public SqlSessionTemplate sqlSessionTemplate = null;
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
/*	
	public List<HashMap> auctionList() {
		logger.info("auctionList 호출 성공");
		List<HashMap> auctionList = null;
		auctionList = sqlSessionTemplate.selectList("auctionList");
				
		return auctionList;

	}*/

	public List<Map<String, Object>> getauctionList(jibnawaAuctionVO aVO) {
		logger.info("auctionList2222 호출 성공");
		List<Map<String,Object>> auctionList = null;
		auctionList = sqlSessionTemplate.selectList("auctionList",aVO);
				
		return auctionList;
	}
}
