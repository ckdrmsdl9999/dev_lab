package com.cookie;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.util.Action;
import com.util.ActionForward;

public class OnLineTestFrontController extends HttpServlet {
	Logger logger = Logger.getLogger(OnLineTestFrontController.class);
	public void doService(HttpServletRequest req
	        			, HttpServletResponse res)
	throws ServletException, IOException
	{
		String requestURI = req.getRequestURI();// -> /dev_web/XXX.test
		String contextPath = req.getContextPath();//-> /dev_web
		String command = requestURI.substring(contextPath.length());//-> /XXX.test
		logger.info("command:"+command);
		ActionForward forward = null;
		Action action = null;	    
		/*********************************************************************
		 * 답안지 작성 완료 후 제출 버튼을 클릭했을 때
		 * 답안지 제출 기능 구현하기
		 * DB연동 - 응시테이블에 추가하기
		 * :INSERT INTO take(exam_cd, test_no
		 *                 , take1, take2, take3
		 *                 , take4, take5) 
		 *            VALUES(?,?,?,?,?)
		 ********************************************************************/
		if("/onLineTest/marking.test".equals(command)){
			action = new OnLineTestAction();
			forward = action.execute(req, res);
		}
		/*********************************************************************
		 * 수험자 인증하기 구현
		 *********************************************************************/
		else if("/onLineTest/testLogin.test".equals(command)){
			action = new OnLineTestLoginAction();
			forward = action.execute(req, res);
		}
		/*********************************************************************
		 * 프로시저 호출 테스트
		 *********************************************************************/	
		else if("/onLineTest/proc_salupdate.test".equals(command)){
			logger.info("프로시저 테스트");
			OnLineTestDao otDao = new OnLineTestDao();
			otDao.proc_salupdate(7566);
			forward =  new ActionForward();
			forward.setRedirect(true);
			forward.setPath("./testIndex.jsp");
		}		
		if(forward.isRedirect()){//참일 때 sendRedirect
			res.sendRedirect(forward.getPath());//url-페이지이름:경로포함
		}
		else{//거짓일 때 forword
			RequestDispatcher view = 
					req.getRequestDispatcher
							(forward.getPath());
			view.forward(req, res);
		}		
	}	
	//콜백메소드
	@Override
	public void doGet(HttpServletRequest req
	        , HttpServletResponse res)
	throws ServletException, IOException
	{
		doService(req,res);
	}
	//콜백메소드
	@Override
	public void doPost(HttpServletRequest req
	        , HttpServletResponse res)
	throws ServletException, IOException
	{
		doService(req,res);
	}	
}
