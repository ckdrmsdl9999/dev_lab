package com.mvc;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vo.DeptVO;

@Controller
@RequestMapping(value="/dept")
public class DeptController {
	Logger logger = Logger.getLogger(DeptController.class);
	//<bean id="deptLogic" class="com.mvc.DeptLogic"/>
	@Autowired
	public DeptLogic deptLogic = null;
	@RequestMapping(value="/dept/testResult.kosmo")
	public String test(){
		logger.info("test호출 성공");
		return "redirect:testResult.jsp";
	}
	@RequestMapping(value="trTest.kosmo")
	public String trTest(){
		
		logger.info("trTest호출성공");
		
		deptLogic.trTest();
		
		
		return "redirect:testResult.jsp";
	}
	@RequestMapping(value="/dept/testResult2.kosmo")
	public void test(HttpServletResponse res) throws ServletException,IOException{
		logger.info("test호출 성공");
		res.sendRedirect("testResult.jsp");
	}
	
/**************************************************************
 * 	부서목록 조회 구현
 * 똑같은 조회업무인 경우지만 응답페이지가 서로 다른 경우라면
 * 로직클래스와 Dao클래스는 하나로 사용하더라도 컨트롤클래스는
 * 나누어 관리하자.
 * @param rMap
 * @param pMap
 * @return
 *************************************************************/
	@RequestMapping(value="getDeptList.kosmo") 
	public String getDeptList(ModelMap rMap, @RequestParam Map<String,Object> pMap, HttpServletRequest req){   
		logger.info("getDeptList 호출 성공");
		List<HashMap> deptList = null;
		deptList = deptLogic.getDeptList(pMap,req);
		rMap.addAttribute("deptList",deptList);
		return "forward:./jSonDeptList.jsp";//응답페이지
	}
	/**************************************************************
	 * 	부서정보 상세 조회 구현 - 1건 조회
	 * 똑같은 조회업무인 경우지만 응답페이지가 서로 다른 경우라면
	 * 로직클래스와 Dao클래스는 하나로 사용하더라도 컨트롤클래스는
	 * 나누어 관리하자.
	 * @param rMap
	 * @param pMap
	 * @return
	 *************************************************************/	
	@RequestMapping(value="getDeptRead.kosmo")
	public String getDeptRead(ModelMap rMap, @RequestParam Map<String,Object> pMap){   
		logger.info("getDeptRead 호출 성공");
		List<HashMap> deptList = null;
		deptList = deptLogic.getDeptList(pMap,null);
		rMap.addAttribute("deptList",deptList);
		return "forward:./deptUpdForm.jsp";//응답페이지
	}	
	@RequestMapping(value="getDeptnoList.kosmo")
	public String getDeptnoList(@ModelAttribute DeptVO dvo,ModelMap rMap, @RequestParam Map<String,Object> pMap){   
		logger.info("getDeptnoList 호출 성공");
		List<HashMap> deptList = null;
		logger.info(dvo.getDeptno());
		logger.info(rMap.get("deptno"));
		deptList = deptLogic.getDeptnoList(pMap);
		rMap.addAttribute("deptList",deptList);
		return "forward:./jSonDeptnoList.jsp";//응답페이지
	}	
	/***********************************************************************************
	 * 부서정보 삭제하기
	 * 파라미터 타입을 dVO타입으로 변환하여 처리해 봅시다.
	 * @param pMap 화면에서 사용자가 선택한 로우에 부서번호 가져오기
	 * @return
	 **********************************************************************************/
	@RequestMapping(value="deptDelete.kosmo")
	public String deptDelete(@RequestParam Map<String,Object> pMap){
		logger.info("deptDelete 호출 성공 : "+pMap.get("deptno"));
		int result = 0;
		result = deptLogic.deptDelete(pMap);  
		logger.info("result:"+result);
		return "redirect:getDeptList.jsp?result="+result;//응답페이지
	}
	@RequestMapping(value="deptUpdate.kosmo")
	public String deptUpdate(@RequestParam Map<String,Object> pMap){
		logger.info("deptUpdate 호출 성공");
		int result = 0;
		result = deptLogic.deptUpdate(pMap);
		logger.info("result:"+result);
		return "redirect:deptInsertSuccess.jsp";//응답페이지
	}	
	@RequestMapping(value="deptInsert.kosmo")
	public String deptInsert(@RequestParam Map<String,Object> pMap){
		logger.info("deptInsert -호출 성공");
		int result = 0;
		result = deptLogic.deptInsert(pMap);
		logger.info("result:"+result);
		return "redirect:getDeptList.jsp?result="+result;//응답페이지
	}
}







