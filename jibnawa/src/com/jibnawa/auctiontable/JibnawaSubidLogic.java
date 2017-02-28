package com.jibnawa.auctiontable;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vo.jibnawaSubidVO;

@Service
public class JibnawaSubidLogic {
	Logger logger = Logger.getLogger(JibnawaSubidLogic.class);
	@Autowired
	public JibnawaSubidDao jbSu_bidDao = null;

	public List<Map<String, Object>>getjbSubidList(jibnawaSubidVO jbsuVO) {
		logger.info("getjbSubidList 호출 성공");
		List<Map<String,Object>> suList=null;
		suList=jbSu_bidDao.getjbSubidList(jbsuVO);
		return suList;
	}
	

}
