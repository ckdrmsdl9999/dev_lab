package com.mvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.dao.DataAccessException;

import com.vo.EmpVO;

public class SqlMapEmpDao {
	Logger logger = Logger.getLogger(SqlMapEmpDao.class);
	public SqlSessionTemplate sqlSessionTemplate = null;
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	/* public String proc_salupdate(){
		
		EmpVO eVO = new EmpVO();
		
		eVO.setEmpno(7499);
		
		sqlSessionTemplate.select("proc_salupdate", eVO);
		
		String msg = eVO.getMsg();
		
		return msg;
	} */
	
	
	
	
	public List<EmpVO> getEmpList(Map<String, Object> pMap) {
		
	
		
		
		logger.info("SqlMapEmpDao호출 성공");
		List<EmpVO> empList = null;
		empList
				=sqlSessionTemplate.selectList("getEmpList",pMap);
		return empList;
		
		
		
	}
	public List<EmpVO> getEmpList2(String[] list2) {
		
	
		
	
		
		logger.info("SqlMapEmpDao호출 성공");
		List<EmpVO> empList = null;
		empList
				=sqlSessionTemplate.selectList("getEmpList2",list2);
		return empList;
		
		
		
	}
	
	
	public int empDelete(String[] list2) {
		
		logger.info("SqlMapEmpDao empDelete호출 성공");
		
	
		
		
		int result = sqlSessionTemplate.delete("empDeleteALL",list2);
		
		return result;
	}
	public int empInsert(EmpVO eVO) throws DataAccessException{

		int result = 0;
		
		
		
		try {
			
			logger.info("SqlMapEmpDao empDelete호출 성공");
			
			result = sqlSessionTemplate.insert("empInsert",eVO);
			
		} catch(Exception e) {
			logger.info(e.toString());
		}
		finally {
			return result;
		}
				
		
		
		
	}
	public int empUpdate(EmpVO eVO) {

	int result = 0;
		
		
		
		try {
			
			logger.info("SqlMapEmpDao empDelete호출 성공");
			
			
			
			result = sqlSessionTemplate.insert("empUpdate",eVO);
			
		} catch(Exception e) {
			logger.info(e.toString());
		}
		finally {
			return result;
		}
				
		
		
	}

	public void proc_salupdate(EmpVO eVO) {
		
		
		logger.info("SqlMapEmpDao empDelete호출 성공");
		
	
		
		
		sqlSessionTemplate.selectOne("proc_salupdate",eVO);
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
}
