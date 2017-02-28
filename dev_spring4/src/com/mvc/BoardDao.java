package com.mvc;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;

import com.vo.BoardMasterVO;
import com.vo.BoardSubVO;

public class BoardDao {
   Logger logger = Logger.getLogger(BoardDao.class);
   public SqlSessionTemplate sqlSessionTemplate = null;
   public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
      this.sqlSessionTemplate = sqlSessionTemplate;
   }//세터를 만들어주자
   
   //Insert
   public int boardMasterInsert(BoardMasterVO pbmVO, BoardSubVO pbsVO) {
      int result = 0;
	   logger.info("boardMasterInsert호출성공");
	   sqlSessionTemplate.insert("boardMasterInsert",pbmVO);
	   
	   // TODO Auto-generated method stub
      return result;
   }
   public int boardSubInsert(BoardMasterVO pbmVO, BoardSubVO pbsVO) {
      // TODO Auto-generated method stub
      return 0;
   }
   
   //Delete
   public int boardMasterDelete(BoardMasterVO pbmVO, BoardSubVO pbsVO) {
      // TODO Auto-generated method stub
      return 0;
   }
   public int boardSubDelete(BoardMasterVO pbmVO, BoardSubVO pbsVO) {
      // TODO Auto-generated method stub
      return 0;
   }
   
   //Select:보드리스트
   public List<Map<String, Object>> getBoardList(BoardMasterVO pbmVO) {
     
	   logger.info("getBoardList(BoardMasterVO pbmVO) 호출성공");
	   List<Map<String,Object>> boardList = null;
	      boardList =
	   sqlSessionTemplate.selectList("getBoardList",pbmVO);
	   
	   // TODO Auto-generated method stub
      return boardList;
   }
   
   //Update
   public int boardMasterUpdate(BoardMasterVO pbmVO, BoardSubVO pbsVO) {
      // TODO Auto-generated method stub
      return 0;
   }

   public int boardSubUpdate(BoardMasterVO pbmVO, BoardSubVO pbsVO) {
      // TODO Auto-generated method stub
      return 0;
   }
}