package com.jibnawa.auctiontable;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vo.jibnawaTenderVO;

@Service
public class JibnawaTenderLogic {
	Logger logger = Logger.getLogger(JibnawaTenderLogic .class);
	@Autowired
	public JibnawaTenderDao jbTenderDao = null;
	public List<Map<String, Object>>getjbTenderList(jibnawaTenderVO tVO) {
		logger.info("getjbTenderList호출 성공");
		List<Map<String,Object>>tenderList=null;
		tenderList=jbTenderDao.getjbTenderList(tVO);
		return tenderList;
	}


}
