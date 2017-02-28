package com.mvc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.dao.DataAccessException;

import com.vo.DeptVO;

public class SqlMapDeptDao {
	Logger logger = Logger.getLogger(SqlMapDeptDao.class);
	public SqlSessionTemplate sqlSessionTemplate = null;
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	//��ü ���ڵ� ���� �������� - 13
	public int totalRecord() {
		
		logger.info("totalRecordȣ�� ����");
		int result = 0;
		result =sqlSessionTemplate.selectOne("totalRecord");
		return result;
	}	
	public List<HashMap> getDeptList(Map<String, Object> pMap) {
		logger.info("getDeptListȣ�� ����");
		List<HashMap> deptList = null;
		deptList
				=sqlSessionTemplate.selectList("getDeptList",pMap);
		return deptList;
	}
	//Ŀ�Ը��
	public int deptInsert(Map<String, Object> pMap) throws DataAccessException {
		logger.info("deptInsertȣ�� ����");
		int result = 0;
		
		
		
		result = sqlSessionTemplate.insert("deptInsert",pMap);
		return result;
	}
	/**********************************************************************************
	 * ���̹���Ƽ���� typealias Ȱ���� ����
	 * @param pMap
	 * @return
	 *********************************************************************************/
	public int deptDelete(Map<String, Object> pMap) {
		logger.info("deptDeleteȣ�� ����");
		DeptVO dVO = new DeptVO();
		String sdeptno = pMap.get("deptno").toString();
		int deptno = 0;
		if(sdeptno !=null) deptno = Integer.parseInt(sdeptno);
		dVO.setDeptno(deptno);
		int result = 0;
		result = sqlSessionTemplate.delete("deptDelete",dVO);
		logger.info("result : "+result);
		return result;
	}
	public List<HashMap> getDeptnoList(Map<String, Object> pMap) {
		logger.info("getDeptnoListȣ�� ����");
		List<HashMap> deptList = null;
		deptList
				=sqlSessionTemplate.selectList("getDeptnoList",pMap);
		return deptList;
	}
	public int deptUpdate(Map<String, Object> pMap) {
		logger.info("deptUpdateȣ�� ����");
		int result = 0;
		result = sqlSessionTemplate.update("deptUpdate",pMap);
		return result;
	}

}
