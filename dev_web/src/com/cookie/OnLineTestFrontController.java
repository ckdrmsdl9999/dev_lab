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
		 * ����� �ۼ� �Ϸ� �� ���� ��ư�� Ŭ������ ��
		 * ����� ���� ��� �����ϱ�
		 * DB���� - �������̺� �߰��ϱ�
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
		 * ������ �����ϱ� ����
		 *********************************************************************/
		else if("/onLineTest/testLogin.test".equals(command)){
			action = new OnLineTestLoginAction();
			forward = action.execute(req, res);
		}
		/*********************************************************************
		 * ���ν��� ȣ�� �׽�Ʈ
		 *********************************************************************/	
		else if("/onLineTest/proc_salupdate.test".equals(command)){
			logger.info("���ν��� �׽�Ʈ");
			OnLineTestDao otDao = new OnLineTestDao();
			otDao.proc_salupdate(7566);
			forward =  new ActionForward();
			forward.setRedirect(true);
			forward.setPath("./testIndex.jsp");
		}		
		if(forward.isRedirect()){//���� �� sendRedirect
			res.sendRedirect(forward.getPath());//url-�������̸�:�������
		}
		else{//������ �� forword
			RequestDispatcher view = 
					req.getRequestDispatcher
							(forward.getPath());
			view.forward(req, res);
		}		
	}	
	//�ݹ�޼ҵ�
	@Override
	public void doGet(HttpServletRequest req
	        , HttpServletResponse res)
	throws ServletException, IOException
	{
		doService(req,res);
	}
	//�ݹ�޼ҵ�
	@Override
	public void doPost(HttpServletRequest req
	        , HttpServletResponse res)
	throws ServletException, IOException
	{
		doService(req,res);
	}	
}
