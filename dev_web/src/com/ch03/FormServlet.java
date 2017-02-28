package com.ch03;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.util.HashMapBinder;

public class FormServlet extends HttpServlet {
	Logger logger = Logger.getLogger(FormServlet.class);
	public void doGet(HttpServletRequest req
			        , HttpServletResponse res)
	throws ServletException,IOException{
		logger.info("doGetȣ�� ����");
		HashMapBinder hmb = new HashMapBinder(req);
		Map<String, Object> pMap = 
				new HashMap<String,Object>();
		hmb.binder(pMap);
		//������ ���۵� ���� ����� ����
		Object keys[] = pMap.keySet().toArray();
		for(int i=0;i<keys.length;i++){
			String key = (String)keys[i];
			logger.info(key);
			logger.info(pMap.get(key));
		}
		//��û ��ü�� �ּҹ��� ���
		req.setAttribute("pMap", pMap);
		//sendRedirect
		RequestDispatcher view = 
				req.getRequestDispatcher("./formResult.jsp");
		view.forward(req,res);
	}
	public void doPost(HttpServletRequest req
	        , HttpServletResponse res)
    throws ServletException,IOException{
		logger.info("doPostȣ�� ����");
		HashMapBinder hmb = new HashMapBinder(req);
		Map<String, Object> pMap = 
				new HashMap<String,Object>();
		hmb.binder(pMap);
		//������ ���۵� ���� ����� ����
		Object keys[] = pMap.keySet().toArray();
		for(int i=0;i<keys.length;i++){
			String key = (String)keys[i];
			logger.info(key);
			logger.info(pMap.get(key));
		}
		//��û ��ü�� �ּҹ��� ���
		req.setAttribute("pMap", pMap);
		//sendRedirect
		RequestDispatcher view = 
				req.getRequestDispatcher("./formResult.jsp");
		view.forward(req,res);		
	}
}
