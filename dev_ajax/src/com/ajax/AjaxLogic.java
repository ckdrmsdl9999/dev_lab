package com.ajax;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.ajax.book.BookDao;
import com.vo.BookVO;
import com.vo.PictureVO;
import com.vo.WordVO;

public class AjaxLogic {
	Logger logger = Logger.getLogger(AjaxLogic.class);

	public List<WordVO> getwordList(HttpServletRequest req, Map<String, Object> pMap) {
		
		
		logger.info("getwordList 호출 성공");
		List<WordVO> wordList = null;
		
		AjaxDao aDao = new AjaxDao();
		
		wordList = aDao.getwordList(pMap);
		
		
		return wordList;
	}

	public List<PictureVO> getPictureList(HttpServletRequest req, Map<String, Object> pMap) {
		
		
		
		logger.info("Logic : getPictureList 호출 성공");
		List<PictureVO> pictureList = null;
		
		AjaxDao aDao = new AjaxDao();
		
		pictureList = aDao.getPictureList(pMap);
		
		
		return pictureList;
		
		
	}

}
