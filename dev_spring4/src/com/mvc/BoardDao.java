package com.mvc;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.dao.DataAccessException;

import com.vo.BoardMasterVO;
import com.vo.BoardSubVO;

public class BoardDao {
	Logger logger = Logger.getLogger(BoardDao.class);
	public SqlSessionTemplate sqlSessionTemplate = null;
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	public int getBgroup(BoardMasterVO pbmVO)
	{
		int b_group = 0;
		b_group = sqlSessionTemplate.selectOne("getBgroup",pbmVO);
		return b_group;
	}
	public int bStepUpdate(BoardMasterVO pbmVO){
		int result = 0;
		result = sqlSessionTemplate.update("bStepUpdate",pbmVO);
		return result;
	}
	public int boardMasterInsert(BoardMasterVO pbmVO) throws DataAccessException {
		int result = 0;
		sqlSessionTemplate.insert("boardMasterInsert",pbmVO);
		return result;
	}
	public int boardSubInsert(BoardSubVO pbsVO) throws DataAccessException {
		int result = 0;
		sqlSessionTemplate.insert("boardSubInsert",pbsVO);
		return result;
	}
	public List<Map<String, Object>> getBoardList(BoardMasterVO pbmVO) {
		List<Map<String, Object>> boardList = null;
		boardList = sqlSessionTemplate.selectList("getBoardList",pbmVO);
		return boardList;
	}
	public int boardMasterUpdate(BoardMasterVO pbmVO) {
		// TODO Auto-generated method stub
		return 0;
	}
	public int boardSubUpdate(BoardSubVO pbsVO) {
		// TODO Auto-generated method stub
		return 0;
	}
	public int boardMasterDelete(BoardMasterVO pbmVO) {
		// TODO Auto-generated method stub
		return 0;
	}
	public int boardSubDelete(BoardSubVO pbsVO) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
