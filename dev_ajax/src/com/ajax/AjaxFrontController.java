package com.ajax;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ajax.book.BookFrontController;
import com.ajax.book.BookInsertAction;
import com.ajax.book.BookSelectAction;
import com.util.Action;
import com.util.ActionForward;

public class AjaxFrontController extends HttpServlet {
	Logger logger = Logger.getLogger(AjaxFrontController.class);
	public void doService(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException
	{
		String requestURI = req.getRequestURI();// -> /dev_jquery/test.do
		String contextPath = req.getContextPath();//-> /dev_jquery
		String command = requestURI.substring(contextPath.length());//-> /test.do		
		ActionForward forward = new ActionForward();
		Action action = null;
		
		
		if("/ajax/searchWordResult.aja".equals(command)){
								
			logger.info("/ajax/searchWordResult.aja");
			
			action = new AjaxWordSelectAction();
					
			forward = action.execute(req, res);
			
			
		}     
		else if("/ajax/getPictureList.aja".equals(command)){
			
			action = new AjaxPictureSelectAction();
			
			forward = action.execute(req, res);
		}	
		else if("/ajax/getPictureDetail.aja".equals(command)){
			
			action = new AjaxPictureDetailAction();
			
			forward = action.execute(req, res);
		}	
		if(forward.isRedirect()){
			res.sendRedirect(forward.getPath());
		}
		else{
			RequestDispatcher view = req.getRequestDispatcher(forward.getPath());
			view.forward(req, res);
		}
	}		
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException
	{
		doService(req,res);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException
	{
		doService(req,res);
	}	
}
