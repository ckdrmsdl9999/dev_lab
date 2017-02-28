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
		logger.info("doGet호출 성공");
		HashMapBinder hmb = new HashMapBinder(req);
		Map<String, Object> pMap = 
				new HashMap<String,Object>();
		hmb.binder(pMap);
		//서버로 전송된 정보 출력해 보기
		Object keys[] = pMap.keySet().toArray();
		for(int i=0;i<keys.length;i++){
			String key = (String)keys[i];
			logger.info(key);
			logger.info(pMap.get(key));
		}
		//요청 객체에 주소번지 담기
		req.setAttribute("pMap", pMap);
		//sendRedirect
		RequestDispatcher view = 
				req.getRequestDispatcher("./formResult.jsp");
		view.forward(req,res);
	}
	public void doPost(HttpServletRequest req
	        , HttpServletResponse res)
    throws ServletException,IOException{
		logger.info("doPost호출 성공");
		HashMapBinder hmb = new HashMapBinder(req);
		Map<String, Object> pMap = 
				new HashMap<String,Object>();
		hmb.binder(pMap);
		//서버로 전송된 정보 출력해 보기
		Object keys[] = pMap.keySet().toArray();
		for(int i=0;i<keys.length;i++){
			String key = (String)keys[i];
			logger.info(key);
			logger.info(pMap.get(key));
		}
		//요청 객체에 주소번지 담기
		req.setAttribute("pMap", pMap);
		//sendRedirect
		RequestDispatcher view = 
				req.getRequestDispatcher("./formResult.jsp");
		view.forward(req,res);		
	}
}
