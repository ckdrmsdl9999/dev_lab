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
		logger.info("testȣ�� ����");
		return "redirect:testResult.jsp";
	}
	@RequestMapping(value="trTest.kosmo")
	public String trTest(){
		
		logger.info("trTestȣ�⼺��");
		
		deptLogic.trTest();
		
		
		return "redirect:testResult.jsp";
	}
	@RequestMapping(value="/dept/testResult2.kosmo")
	public void test(HttpServletResponse res) throws ServletException,IOException{
		logger.info("testȣ�� ����");
		res.sendRedirect("testResult.jsp");
	}
	
/**************************************************************
 * 	�μ���� ��ȸ ����
 * �Ȱ��� ��ȸ������ ������� ������������ ���� �ٸ� �����
 * ����Ŭ������ DaoŬ������ �ϳ��� ����ϴ��� ��Ʈ��Ŭ������
 * ������ ��������.
 * @param rMap
 * @param pMap
 * @return
 *************************************************************/
	@RequestMapping(value="getDeptList.kosmo") 
	public String getDeptList(ModelMap rMap, @RequestParam Map<String,Object> pMap, HttpServletRequest req){   
		logger.info("getDeptList ȣ�� ����");
		List<HashMap> deptList = null;
		deptList = deptLogic.getDeptList(pMap,req);
		rMap.addAttribute("deptList",deptList);
		return "forward:./jSonDeptList.jsp";//����������
	}
	/**************************************************************
	 * 	�μ����� �� ��ȸ ���� - 1�� ��ȸ
	 * �Ȱ��� ��ȸ������ ������� ������������ ���� �ٸ� �����
	 * ����Ŭ������ DaoŬ������ �ϳ��� ����ϴ��� ��Ʈ��Ŭ������
	 * ������ ��������.
	 * @param rMap
	 * @param pMap
	 * @return
	 *************************************************************/	
	@RequestMapping(value="getDeptRead.kosmo")
	public String getDeptRead(ModelMap rMap, @RequestParam Map<String,Object> pMap){   
		logger.info("getDeptRead ȣ�� ����");
		List<HashMap> deptList = null;
		deptList = deptLogic.getDeptList(pMap,null);
		rMap.addAttribute("deptList",deptList);
		return "forward:./deptUpdForm.jsp";//����������
	}	
	@RequestMapping(value="getDeptnoList.kosmo")
	public String getDeptnoList(@ModelAttribute DeptVO dvo,ModelMap rMap, @RequestParam Map<String,Object> pMap){   
		logger.info("getDeptnoList ȣ�� ����");
		List<HashMap> deptList = null;
		logger.info(dvo.getDeptno());
		logger.info(rMap.get("deptno"));
		deptList = deptLogic.getDeptnoList(pMap);
		rMap.addAttribute("deptList",deptList);
		return "forward:./jSonDeptnoList.jsp";//����������
	}	
	/***********************************************************************************
	 * �μ����� �����ϱ�
	 * �Ķ���� Ÿ���� dVOŸ������ ��ȯ�Ͽ� ó���� ���ô�.
	 * @param pMap ȭ�鿡�� ����ڰ� ������ �ο쿡 �μ���ȣ ��������
	 * @return
	 **********************************************************************************/
	@RequestMapping(value="deptDelete.kosmo")
	public String deptDelete(@RequestParam Map<String,Object> pMap){
		logger.info("deptDelete ȣ�� ���� : "+pMap.get("deptno"));
		int result = 0;
		result = deptLogic.deptDelete(pMap);  
		logger.info("result:"+result);
		return "redirect:getDeptList.jsp?result="+result;//����������
	}
	@RequestMapping(value="deptUpdate.kosmo")
	public String deptUpdate(@RequestParam Map<String,Object> pMap){
		logger.info("deptUpdate ȣ�� ����");
		int result = 0;
		result = deptLogic.deptUpdate(pMap);
		logger.info("result:"+result);
		return "redirect:deptInsertSuccess.jsp";//����������
	}	
	@RequestMapping(value="deptInsert.kosmo")
	public String deptInsert(@RequestParam Map<String,Object> pMap){
		logger.info("deptInsert -ȣ�� ����");
		int result = 0;
		result = deptLogic.deptInsert(pMap);
		logger.info("result:"+result);
		return "redirect:getDeptList.jsp?result="+result;//����������
	}
}







