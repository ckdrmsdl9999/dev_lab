package com.ajax;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.util.Action;
import com.util.ActionForward;
import com.util.HangulConversion;
import com.vo.PictureVO;

public class AjaxPictureSelectAction implements Action {

	Logger logger = Logger.getLogger(AjaxPictureSelectAction.class);
	
	
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		logger.info("AjaxPictureSelectAction");
		
			
		Map<String,Object>pMap = new HashMap<String,Object>();
      
		
		pMap.put("pnum",req.getParameter("pnum"));
		
		pMap.put("word",req.getParameter("word"));

        
        AjaxLogic ajLogic = new AjaxLogic();
       
        List<PictureVO> pictureList=ajLogic.getPictureList(req,pMap);
        
        				
		req.setAttribute("pictureList",pictureList);
		//페이지 이동 - 응답페이지 호출
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);//true:sendRedirect(유지안된다), false:forward(유지)
		forward.setPath("./pictureContentView.jsp");
		return forward;
	}

}
