package com.ch17;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ch7.Duck;
import com.ch7.MallardDuck;
import com.ch7.Sonata;
import com.vo.DeptVO;
  
public class TestSendServlet extends HttpServlet {
	Logger logger = Logger.getLogger(TestSendServlet.class);
	//사용자 정의 메소드
	public void doService(HttpServletRequest req
	         ,HttpServletResponse res)
	throws ServletException, IOException
	{
		logger.info("doService 호출 성공");
		//화면에서 입력받은 아이디 가져오기
		String mem_id = req.getParameter("mem_id");
		logger.info("아이디 : "+mem_id);
		//res.setContentType("text/html;charset=euc-kr");
		//PrintWriter out = res.getWriter();
/*
 * 페이지 이동처리
 * doGet(HttpServletRequest req,HttpServletResponse res), doPost()
 * 1)res.sendRedirect(url); - 서블릿에서 처리할 때
 *   response.sendRedirect(url); - jsp에서 처리할 때
 *   -> URL이 바뀐다.
 * 2)페이지를 forward처리한다.
 *   forward(req,res);
 *   -> URL이 바뀌지 않는다.(페이지 내용은 바뀐다)
 */
		Sonata myCar = new Sonata();
		req.setAttribute("myCar", myCar);
		//insert here
		req.setAttribute("r_name", "이순신");
		//insert here
		MallardDuck myDuck = new MallardDuck();//다형성
		req.setAttribute("myDuck", myDuck);
		//insert here - 자료구조(List)
		List<DeptVO> deptList = new ArrayList<DeptVO>();
		DeptVO dvo = new DeptVO();
		dvo.setDeptno(10);
		dvo.setDname("영업");
		dvo.setLoc("부산");
		deptList.add(dvo);
		dvo = new DeptVO();
		dvo.setDeptno(20);
		dvo.setDname("총무");
		dvo.setLoc("인천");
		deptList.add(dvo);
		dvo = new DeptVO();
		dvo.setDeptno(30);
		dvo.setDname("인사");
		dvo.setLoc("서울");
		deptList.add(dvo);
		req.setAttribute("deptList", deptList);
		res.sendRedirect("./getSendResult.jsp?mem_id="+mem_id);
/*		RequestDispatcher view = 
				req.getRequestDispatcher("./getSendResult.jsp");
		view.forward(req, res);*/
/*		out.print("<html>");
		out.print("<head>");
		out.print("<title>나는 TestSendServlet</title>");
		out.print("</head>");
		out.print("<body>"+mem_id+"</body>");
		out.print("</html>");*/
	}
	@Override
	public void doGet(HttpServletRequest req
			         ,HttpServletResponse res)
	throws ServletException, IOException
	{
		logger.info("doGet 호출 성공");
		//insert here
		doService(req,res);
	}
	@Override
	public void doPost(HttpServletRequest req
	         		 ,HttpServletResponse res)
    throws ServletException, IOException
    {
		logger.info("doPost 호출 성공");
		//insert here
		doService(req,res);
    }
}
