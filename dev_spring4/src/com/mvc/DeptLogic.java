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
		logger.info("getDeptList호출 성공");
		List<HashMap> deptList = null;
		//페이징 처리 로직 추가 - start와 end변수를 추가
		int total =0;//전체 레코드 갯수
		total = sqlMapDeptDao.totalRecord();
		//total값을 json파일에 담으면 datagrid에 추가됩니다.
		//total값은 datagrid에 추가될 값이 아니므로 세션을 사용하여 담습니다.
		HttpSession session = req.getSession();
		session.setAttribute("total", total);
		//화면(currentPage:pMap)에서 받아오는 값
		int page = 0;//현재 사용자가 바라보는 페이지 번호(1,2,....)
		//한 페이지에 처리되는 로우 수(화면:pMap)
		int pageSize = 0;
		if(pMap.get("page")!=null) 
			page = Integer.parseInt(pMap.get("page").toString());
		if(pMap.get("pageSize")!=null) 
			pageSize = Integer.parseInt(pMap.get("pageSize").toString());		
		int start = 0;//페이지의 시작 번호
		int end = 0;//페이지의 끝 번호
		if(page > 0){
			start = ((page-1)*pageSize)+1;
			end = page*pageSize;
			pMap.put("start", start);
			//total이 end보다 작으면 end대신 total값을 담아 주세요.
			//그렇지 않으면 end를 담아 주세요.
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
	      pMap.put("dname", "자동차");
	      pMap.put("loc", "평택");
	      
	      eVO.setEmpno(8001);
	      eVO.setEname("김유신");
	      eVO.setDeptno(80);
	      
	      try {
	         //아래코드에서 SqlException 발생가능하므로 예외처리 활용
	         //커밋과 롤백적용
	         dResult = sqlMapDeptDao.deptInsert(pMap);
	         eResult = sqlMapEmpDao.empInsert(eVO);
	      } catch (DataAccessException de) {
	         throw de;
	      }
	      
	   }
	public int deptInsert(Map<String, Object> pMap) {
		logger.info("deptInsert호출 성공");
		int result = 0;
		result = sqlMapDeptDao.deptInsert(pMap);
		return result;
	}
	public int deptDelete(Map<String, Object> pMap) {
		logger.info("deptDelete호출 성공");
		int result = 0;
		result = sqlMapDeptDao.deptDelete(pMap);
		return result;
	}
	public List<HashMap> getDeptnoList(Map<String, Object> pMap) {
		logger.info("getDeptnoList호출 성공");
		List<HashMap> deptList = null;
		deptList = sqlMapDeptDao.getDeptnoList(pMap);
		return deptList;
	}
	public int deptUpdate(Map<String, Object> pMap) {
		logger.info("deptUpdate호출 성공");
		int result = 0;
		result = sqlMapDeptDao.deptUpdate(pMap);
		return result;
	}
}






