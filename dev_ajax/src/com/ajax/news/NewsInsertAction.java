package com.ajax.news;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.util.Action;
import com.util.ActionForward;

public class NewsInsertAction implements Action {
	Logger logger = Logger.getLogger(NewsInsertAction.class);
	@Override
	public ActionForward execute(HttpServletRequest req
			                   , HttpServletResponse res) 
    throws ServletException, IOException {
		logger.info("execute ȣ�� ����");
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		forward.setPath("./getNewsList.do");
		return forward;
	}

}
