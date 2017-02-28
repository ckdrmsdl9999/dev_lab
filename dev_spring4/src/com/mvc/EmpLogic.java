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
	 * ������ : ������ ��ȸ ����
	 * @param  : Map<String,Object> 
	 * @return : List<Map<String,Object>>
	 *************************************************************************************/
	public List<EmpVO> getEmpList(Map<String,Object> pMap)
	{
		logger.info("getEmpList ȣ�� ����");
		List<EmpVO> empList = sqlEmpDeptDao.getEmpList(pMap);//DB
		return empList;
	}

	public int empDelete(Map<String, Object> pMap) {
		
		logger.info("empDelete ȣ�� ����");
		
		
		logger.info(pMap.get("empno").toString());
		StringTokenizer st = new StringTokenizer(pMap.get("empno").toString(),",");



		String[] list2 = new String[st.countTokens()];

		logger.info(st.countTokens());


		int i=0;
     
		while(st.hasMoreTokens()){   //����� �ִµ��� while���� �����
   
			list2[i]=st.nextToken();// ����� list ������ ����
			logger.info(i+","+list2[i]);
			i++;
	
			}


			logger.info(list2.length);
		
		
		
		
		int result = sqlEmpDeptDao.empDelete(list2);//DB
		return result;
		
		
		
	}

	public List<EmpVO> getEmpList2(Map<String, Object> pMap) {
		logger.info("getEmpList2 ȣ�� ����");
		
			logger.info(pMap.get("deptno").toString());
				StringTokenizer st = new StringTokenizer(pMap.get("deptno").toString(),",");
      
		/*		List<Object> list = new ArrayList();
				while(st.hasMoreTokens()){   //����� �ִµ��� while���� �����
            list.add(st.nextToken()); // ����� list ������ ����
         
        }
       
        logger.info(list.size());*/
     
        String[] list2 = new String[st.countTokens()];
        
        logger.info(st.countTokens());
        
        
        int i=0;
             
        while(st.hasMoreTokens()){   //����� �ִµ��� while���� �����
           
        	list2[i]=st.nextToken();// ����� list ������ ����
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





