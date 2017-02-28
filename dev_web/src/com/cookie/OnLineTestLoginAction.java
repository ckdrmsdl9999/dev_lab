package com.cookie;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.util.Action;
import com.util.ActionForward;
import com.vo.ExamineeVO;
import com.vo.TakeVO;

public class OnLineTestLoginAction implements Action {
	Logger logger = Logger.getLogger(OnLineTestLoginAction.class);
	/**********************************************************************************
	 * ������ �����ϱ� ����
	 * @param test_no, exam_cd �����ڵ�� �����ȣ
	 * @return ActionForward(���������� URL, forward����)
	 *********************************************************************************/
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		logger.info("execute ȣ�� ����:"+req.getParameter("test_no")
		           +", �����ڵ�:"+req.getParameter("exam_cd"));
		ActionForward forward = new ActionForward();
		OnLineTestLogic testLogic = new OnLineTestLogic();
		ExamineeVO peVO = new ExamineeVO();
		TakeVO tVO = new TakeVO();
		tVO.setExam_cd(req.getParameter("exam_cd"));
		peVO.setTest_no(req.getParameter("test_no"));
		//insert here
		peVO.settVO(tVO);
		logger.info(peVO.getTest_no()+", "+peVO.gettVO().getExam_cd());
		ExamineeVO reVO = testLogic.testLogin(peVO);
		//insert here - ��Ű�� ����,�����ȣ,�����ڵ� ����ּ���.
		if(reVO !=null){//������ �����ߴ�?
			Cookie cookie1 = 
			new Cookie("cname",URLEncoder.encode(reVO.getT_name(),"utf-8"));
			Cookie cookie2 = new Cookie("ctestno",reVO.getTest_no());
			Cookie cookie3 = new Cookie("cexamcd",tVO.getExam_cd());
			cookie1.setMaxAge(60*60);
			cookie2.setMaxAge(60*60);
			cookie3.setMaxAge(60*60);
			res.addCookie(cookie1);
			res.addCookie(cookie2);
			res.addCookie(cookie3);
			forward.setRedirect(true);
			forward.setPath("./testForm1.jsp");
		}
		else{//������ �����ߴ�?
			forward.setRedirect(true);
			forward.setPath("./testLoginFail.jsp");			
		}
		return forward;
	}

}
