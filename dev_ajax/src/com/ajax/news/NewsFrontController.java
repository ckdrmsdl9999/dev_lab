package com.ajax.news;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.util.Action;
import com.util.ActionForward;

public class NewsFrontController extends HttpServlet {
	Logger logger = Logger.getLogger(NewsFrontController.class);
	public void doService(HttpServletRequest req, HttpServletResponse res)
	throws ServletException,IOException
	{
		logger.info("doService ȣ�� ����");
		String requestURI = req.getRequestURI();// -> /dev_jquery/test.do
		String contextPath = req.getContextPath();//-> /dev_jquery
		String command = requestURI.substring(contextPath.length());//-> /test.do
		logger.info("requestURI:"+requestURI
				+",   contextPath:"+contextPath
				+",   command:"+command);
		ActionForward forward = null;
		Action action = null;//Interface
		if("/test.do".equals(command)){
			//��������� �����´�.
			logger.info("test.do ȣ�� ����");
		}   
		//���� ��� ��������-SELECT
		else if("/ajax/getNewsList.do".equals(command)){
			logger.info("���� ��� �������� ȣ�� ����");
			action = new NewsSelectAction();
			forward = action.execute(req, res);
			List<String> list = new ArrayList<String>();
			//insert here - ���� �����͸� 3�� ��Ƽ� ȭ�鿡 ����ϱ�
		}
		//������ ����� ��
		else if("/ajax/newsInsert.do".equals(command)){
			logger.info("���� ��� ȣ�� ����");
			action = new NewsInsertAction();
			forward = action.execute(req, res);
		}
		//������ ������ ��
		else if("/ajax/newsUpdate.do".equals(command)){
			logger.info("���� ���� ȣ�� ����");
		}
		//������ ������ ��
		else if("/ajax/newsDelete.do".equals(command)){
			logger.info("���� ���� ȣ�� ����");
		}	
		//���������� ȣ�� ó��
		if(forward.isRedirect()){
			res.sendRedirect(forward.getPath());
		}
		else{
			RequestDispatcher view = 
					req.getRequestDispatcher(forward.getPath());
			view.forward(req, res);
		}
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException,IOException
	{
		doService(req,res);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws ServletException,IOException
	{
		doService(req,res);
	}	
}
