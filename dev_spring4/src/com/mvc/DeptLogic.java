package com.mvc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.vo.EmpVO;
@Service
public class DeptLogic {
	Logger logger = Logger.getLogger(DeptLogic.class);
/*	<bean id="sqlMapDeptDao" class="com.mvc.SqlMapDeptDao">
	<property name="sqlSessionTemplate" ref="sqlSessionTemplate"/>
    </bean>*/
	@Autowired
	public SqlMapDeptDao sqlMapDeptDao=null;
	@Autowired
	public SqlMapEmpDao sqlMapEmpDao=null;
/*	public void setSqlMapDeptDao(SqlMapDeptDao sqlMapDeptDao) {
		this.sqlMapDeptDao = sqlMapDeptDao;
	}*/
	
	public List<HashMap> getDeptList(Map<String, Object> pMap,HttpServletRequest req) {
		logger.info("getDeptListȣ�� ����");
		List<HashMap> deptList = null;
		//����¡ ó�� ���� �߰� - start�� end������ �߰�
		int total =0;//��ü ���ڵ� ����
		total = sqlMapDeptDao.totalRecord();
		//total���� json���Ͽ� ������ datagrid�� �߰��˴ϴ�.
		//total���� datagrid�� �߰��� ���� �ƴϹǷ� ������ ����Ͽ� ����ϴ�.
		HttpSession session = req.getSession();
		session.setAttribute("total", total);
		//ȭ��(currentPage:pMap)���� �޾ƿ��� ��
		int page = 0;//���� ����ڰ� �ٶ󺸴� ������ ��ȣ(1,2,....)
		//�� �������� ó���Ǵ� �ο� ��(ȭ��:pMap)
		int pageSize = 0;
		if(pMap.get("page")!=null) 
			page = Integer.parseInt(pMap.get("page").toString());
		if(pMap.get("pageSize")!=null) 
			pageSize = Integer.parseInt(pMap.get("pageSize").toString());		
		int start = 0;//�������� ���� ��ȣ
		int end = 0;//�������� �� ��ȣ
		if(page > 0){
			start = ((page-1)*pageSize)+1;
			end = page*pageSize;
			pMap.put("start", start);
			//total�� end���� ������ end��� total���� ��� �ּ���.
			//�׷��� ������ end�� ��� �ּ���.
			if(end > total){
				pMap.put("end", total);
			}else{
				pMap.put("end", end);
			}
		}
		logger.info("start : "+start+", end : "+end);//1..10, 11..13
		deptList = sqlMapDeptDao.getDeptList(pMap);
		return deptList;
	}
	
	
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor={DataAccessException.class})
	   @Pointcut(value="execution(* com.mvc.*Logic.*(..))")
	   public void trTest(){
	      int dResult = 0;
	      int eResult = 0;
	      Map<String,Object> pMap = new HashMap<String,Object>();
	      EmpVO eVO = new EmpVO();
	      pMap.put("deptno", 80);
	      pMap.put("dname", "�ڵ���");
	      pMap.put("loc", "����");
	      
	      eVO.setEmpno(8001);
	      eVO.setEname("������");
	      eVO.setDeptno(80);
	      
	      try {
	         //�Ʒ��ڵ忡�� SqlException �߻������ϹǷ� ����ó�� Ȱ��
	         //Ŀ�԰� �ѹ�����
	         dResult = sqlMapDeptDao.deptInsert(pMap);
	         eResult = sqlMapEmpDao.empInsert(eVO);
	      } catch (DataAccessException de) {
	         throw de;
	      }
	      
	   }
	public int deptInsert(Map<String, Object> pMap) {
		logger.info("deptInsertȣ�� ����");
		int result = 0;
		result = sqlMapDeptDao.deptInsert(pMap);
		return result;
	}
	public int deptDelete(Map<String, Object> pMap) {
		logger.info("deptDeleteȣ�� ����");
		int result = 0;
		result = sqlMapDeptDao.deptDelete(pMap);
		return result;
	}
	public List<HashMap> getDeptnoList(Map<String, Object> pMap) {
		logger.info("getDeptnoListȣ�� ����");
		List<HashMap> deptList = null;
		deptList = sqlMapDeptDao.getDeptnoList(pMap);
		return deptList;
	}
	public int deptUpdate(Map<String, Object> pMap) {
		logger.info("deptUpdateȣ�� ����");
		int result = 0;
		result = sqlMapDeptDao.deptUpdate(pMap);
		return result;
	}
}






