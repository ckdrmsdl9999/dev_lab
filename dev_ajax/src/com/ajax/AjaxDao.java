package com.ajax;

import java.io.Reader;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import com.util.HangulConversion;
import com.vo.PictureVO;
import com.vo.WordVO;

public class AjaxDao {
	Logger logger = Logger.getLogger(AjaxDao.class);
	SqlSessionFactory sqlMapper = null;
	SqlSession sqlSes = null;
	String resource = "com/mybatis/MapperConfig.xml";

	public List<WordVO> getwordList(Map<String, Object> pMap) {

		logger.info("getwordList 호출 성공");
		List<WordVO> wordList = null;
		try {
			Reader reader = null;
			reader = Resources.getResourceAsReader(resource);
			sqlMapper = new SqlSessionFactoryBuilder().build(reader);
			sqlSes = sqlMapper.openSession();// 오라클서버와 커넥션 맺은상태
			reader.close();
			
			

			wordList = sqlSes.selectList("getwordList", pMap);
			// List<BookVO> bookList = null;

			logger.info(wordList.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return wordList;

	}

	public List<PictureVO> getPictureList(Map<String, Object> pMap) {
		
		logger.info("getPictureList 호출 성공");
		List<PictureVO> pictureList = null;
		try {
			Reader reader = null;
			reader = Resources.getResourceAsReader(resource);
			sqlMapper = new SqlSessionFactoryBuilder().build(reader);
			sqlSes = sqlMapper.openSession();// 오라클서버와 커넥션 맺은상태
			reader.close();
			
			logger.info(pMap.get("title"));

			pictureList = sqlSes.selectList("getPictureList", pMap);
			// List<BookVO> bookList = null;

			logger.info(pictureList.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pictureList;
		
		
	}

}
