package com.jibnawa;

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
import com.vo.JibnawaDao;
import com.vo.JibnawaMemberVO;

public class JibnawaSiginAction implements Action {
	Logger logger = Logger.getLogger(JibnawaSiginAction.class);
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//HttpSession session = req.getSession();
		//session.setAttribute("sname", name);
		JibnawaDao jDao = new JibnawaDao();
		JibnawaMemberVO jvo = new JibnawaMemberVO();
		jvo.setMem_email(req.getParameter("mem_email"));
		jvo.setMem_pw(req.getParameter("mem_pw"));
		jvo.setMem_name(req.getParameter("mem_name"));
		jvo.setMem_nickname(req.getParameter("mem_nickname"));
		jvo.setMem_div(req.getParameter("mem_div"));
		jvo.setMem_phone_f(req.getParameter("mem_phone_f"));
		jvo.setMem_phone_m(req.getParameter("mem_phone_m"));
		jvo.setMem_phone_e(req.getParameter("mem_phone_e"));
		//name에 담긴 이름이 있다는 것은 로그인에 성공했다는 의미입니다.
		if(req.getParameter("mem_pw")==null||req.getParameter("mem_pw")==""){
			int resunt = jDao.mailChk(jvo);
			String mailChk=null;
			if(resunt==0){
				mailChk="true";
			}else{
				mailChk="false";
			}
			Cookie cookie1 =   
					new Cookie("cname"
							  ,URLEncoder.encode(req.getParameter("mem_email"),"utf-8"));
			Cookie cookie2 =   
					new Cookie("mailChk"
							  ,URLEncoder.encode(mailChk,"utf-8"));
			cookie1.setMaxAge(60*30);//쿠키 유지시간 30분으로 설정
			cookie1.setPath("/");
			res.addCookie(cookie1);
			res.addCookie(cookie2);
		}else{
			int resunt = jDao.sigin(jvo);
			String sigin=null;
			if(resunt==1){
				sigin="true";
			}else{
				sigin="false";
			}
			Cookie cookie =   
					new Cookie("sigin"
							  ,URLEncoder.encode(sigin,"utf-8"));
			cookie.setPath("/");
			res.addCookie(cookie);
			cookie.setMaxAge(60*30);//쿠키 유지시간 30분으로 설정
		}
		

		//기존에 쿠키에 담았던 정보를 세션객체에 담기
		//쿠키를 사용할 디렉토리 경로를 설정
		//setPath()사용하여 쿠키의 경로를 지정하면 브라우저는
		//지정한 경로 또는 하위 경로에 대해서만 쿠키를 전송한다.
		//아래에서 도메인 아래 member를 정의하였으므로
		//브라우저는 cname쿠키를 /member나 그 하위 경로에만 전송
		//할 수 있다.
		ActionForward forward = new ActionForward();
		forward.setPath("./sigin.jsp");//index.jsp페이지는 새로고침 일어난다.
		//ajax 기술을 적용할 땐 -> 부분페이지(logout.jsp) 이름을 작성합니다.
		forward.setRedirect(true);
		logger.info(forward.getPath());//null, "./index.jsp"
		return forward;
	}

}
