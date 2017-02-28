package com.mvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.util.HangulConversion;
import com.vo.EmpVO;

@Service
public class EmpLogic {
	Logger logger = Logger.getLogger(EmpController.class);
	
	@Autowired
	public SqlMapEmpDao sqlEmpDeptDao=null;
	
	/*************************************************************************************
	 * 업무명 : 사원목록 조회 구현
	 * @param  : Map<String,Object> 
	 * @return : List<Map<String,Object>>
	 *************************************************************************************/
	public List<EmpVO> getEmpList(Map<String,Object> pMap)
	{
		logger.info("getEmpList 호출 성공");
		List<EmpVO> empList = sqlEmpDeptDao.getEmpList(pMap);//DB
		return empList;
	}

	public int empDelete(Map<String, Object> pMap) {
		
		logger.info("empDelete 호출 성공");
		
		
		logger.info(pMap.get("empno").toString());
		StringTokenizer st = new StringTokenizer(pMap.get("empno").toString(),",");



		String[] list2 = new String[st.countTokens()];

		logger.info(st.countTokens());


		int i=0;
     
		while(st.hasMoreTokens()){   //토근이 있는동안 while문이 실행됨
   
			list2[i]=st.nextToken();// 토근을 list 변수에 저장
			logger.info(i+","+list2[i]);
			i++;
	
			}


			logger.info(list2.length);
		
		
		
		
		int result = sqlEmpDeptDao.empDelete(list2);//DB
		return result;
		
		
		
	}

	public List<EmpVO> getEmpList2(Map<String, Object> pMap) {
		logger.info("getEmpList2 호출 성공");
		
			logger.info(pMap.get("deptno").toString());
				StringTokenizer st = new StringTokenizer(pMap.get("deptno").toString(),",");
      
		/*		List<Object> list = new ArrayList();
				while(st.hasMoreTokens()){   //토근이 있는동안 while문이 실행됨
            list.add(st.nextToken()); // 토근을 list 변수에 저장
         
        }
       
        logger.info(list.size());*/
     
        String[] list2 = new String[st.countTokens()];
        
        logger.info(st.countTokens());
        
        
        int i=0;
             
        while(st.hasMoreTokens()){   //토근이 있는동안 while문이 실행됨
           
        	list2[i]=st.nextToken();// 토근을 list 변수에 저장
        	logger.info(i+","+list2[i]);
        	i++;
        	
        }
    	
   
        logger.info(list2.length);
		
		List<EmpVO> empList = sqlEmpDeptDao.getEmpList2(list2);//DB
		return empList;
	}

	public int empInsert(EmpVO eVO) {
		
		logger.info("empInsert");
		
		eVO.setEname(HangulConversion.toKor(eVO.getEname()));
		eVO.setJob(HangulConversion.toKor(eVO.getJob()));
		
		
		logger.info(eVO.getEname());
		
		
		int result = sqlEmpDeptDao.empInsert(eVO);
		
		return result;
	}

	public int empUpdate(EmpVO eVO) {

		logger.info("empUpdate");
		
		eVO.setEname(HangulConversion.toKor(eVO.getEname()));
		eVO.setJob(HangulConversion.toKor(eVO.getJob()));
		
		
		logger.info(eVO.getEname());
		
		
		int result = sqlEmpDeptDao.empUpdate(eVO);
		
		return result;
		
		
	}

	public void proc_salupdate(EmpVO eVO) {
		
		
		logger.info("proc_salupdate");
		
		
		
		sqlEmpDeptDao.proc_salupdate(eVO);
		
		
		
		
		
	}
}





