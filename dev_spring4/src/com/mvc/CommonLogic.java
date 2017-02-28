package com.mvc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vo.ZipCodeVO;

@Service
public class CommonLogic {

	Logger logger = Logger.getLogger(CommonLogic.class);

		@Autowired
		public SqlMapCommonDao sqlMapCommonDao=null;
	
		
		public List<HashMap> getZipCodeList(Map<String, Object> pMap, HttpServletRequest req) {
			logger.info("getZipCodeList호출 성공");
			List<HashMap> commonList = null;
			//페이징 처리 로직 추가 - start와 end변수를 추가
			
			
			commonList = sqlMapCommonDao.getCommonList(pMap);
			
			
			
			return commonList;
		}


		public List<Map<String, Object>> getZipCodeList(ZipCodeVO zVO) {
			
			logger.info("getZipCodeList호출 성공");
			List<Map<String, Object>> commonList = null;
			//페이징 처리 로직 추가 - start와 end변수를 추가
			
			
			commonList = sqlMapCommonDao.getCommonList(zVO);
			
			
			
			return commonList;
		}
		
}


