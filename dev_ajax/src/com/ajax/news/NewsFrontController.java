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
		logger.info("doService 호출 성공");
		String requestURI = req.getRequestURI();// -> /dev_jquery/test.do
		String contextPath = req.getContextPath();//-> /dev_jquery
		String command = requestURI.substring(contextPath.length());//-> /test.do
		logger.info("requestURI:"+requestURI
				+",   contextPath:"+contextPath
				+",   command:"+command);
		ActionForward forward = null;
		Action action = null;//Interface
		if("/test.do".equals(command)){
			//뉴스목록을 가져온다.
			logger.info("test.do 호출 성공");
		}   
		//뉴스 목록 가져오기-SELECT
		else if("/ajax/getNewsList.do".equals(command)){
			logger.info("뉴스 목록 가져오기 호출 성공");
			action = new NewsSelectAction();
			forward = action.execute(req, res);
			List<String> list = new ArrayList<String>();
			//insert here - 샘플 데이터를 3건 담아서 화면에 출력하기
		}
		//뉴스를 등록할 때
		else if("/ajax/newsInsert.do".equals(command)){
			logger.info("뉴스 등록 호출 성공");
			action = new NewsInsertAction();
			forward = action.execute(req, res);
		}
		//뉴스를 수정할 때
		else if("/ajax/newsUpdate.do".equals(command)){
			logger.info("뉴스 수정 호출 성공");
		}
		//뉴스를 삭제할 때
		else if("/ajax/newsDelete.do".equals(command)){
			logger.info("뉴스 삭제 호출 성공");
		}	
		//응답페이지 호출 처리
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
