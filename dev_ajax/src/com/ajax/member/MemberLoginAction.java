package com.ajax.member;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.util.Action;
import com.util.ActionForward;
import com.vo.MemberVO;

public class MemberLoginAction implements Action {
	Logger logger = Logger.getLogger(MemberLoginAction.class);
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		logger.info("execute 호출 성공");
		MemberDao mDao = new MemberDao();
		MemberVO mvo = new MemberVO();
		mvo.setMem_id(req.getParameter("mem_id"));
		mvo.setMem_pw(req.getParameter("mem_pw"));
		//name에 담긴 이름이 있다는 것은 로그인에 성공했다는 의미입니다.
		String name = mDao.login(mvo);
		logger.info("name:"+name);
		HttpSession session = req.getSession();
		//기존에 쿠키에 담았던 정보를 세션객체에 담기
		session.setAttribute("sname", name);
		Cookie cookie =   
				new Cookie("cname"
						  ,URLEncoder.encode(name,"utf-8"));
		cookie.setMaxAge(60*30);//쿠키 유지시간 30분으로 설정
		//쿠키를 사용할 디렉토리 경로를 설정
		//setPath()사용하여 쿠키의 경로를 지정하면 브라우저는
		//지정한 경로 또는 하위 경로에 대해서만 쿠키를 전송한다.
		//아래에서 도메인 아래 member를 정의하였으므로
		//브라우저는 cname쿠키를 /member나 그 하위 경로에만 전송
		//할 수 있다.
		cookie.setPath("/");
		res.addCookie(cookie);
		ActionForward forward = new ActionForward();
		forward.setPath("./logout.jsp");//index.jsp페이지는 새로고침 일어난다.
		//ajax 기술을 적용할 땐 -> 부분페이지(logout.jsp) 이름을 작성합니다.
		forward.setRedirect(true);
		logger.info(forward.getPath());//null, "./index.jsp"
		return forward;
	}

}
