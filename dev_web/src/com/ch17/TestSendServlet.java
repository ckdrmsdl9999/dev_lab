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
	//����� ���� �޼ҵ�
	public void doService(HttpServletRequest req
	         ,HttpServletResponse res)
	throws ServletException, IOException
	{
		logger.info("doService ȣ�� ����");
		//ȭ�鿡�� �Է¹��� ���̵� ��������
		String mem_id = req.getParameter("mem_id");
		logger.info("���̵� : "+mem_id);
		//res.setContentType("text/html;charset=euc-kr");
		//PrintWriter out = res.getWriter();
/*
 * ������ �̵�ó��
 * doGet(HttpServletRequest req,HttpServletResponse res), doPost()
 * 1)res.sendRedirect(url); - �������� ó���� ��
 *   response.sendRedirect(url); - jsp���� ó���� ��
 *   -> URL�� �ٲ��.
 * 2)�������� forwardó���Ѵ�.
 *   forward(req,res);
 *   -> URL�� �ٲ��� �ʴ´�.(������ ������ �ٲ��)
 */
		Sonata myCar = new Sonata();
		req.setAttribute("myCar", myCar);
		//insert here
		req.setAttribute("r_name", "�̼���");
		//insert here
		MallardDuck myDuck = new MallardDuck();//������
		req.setAttribute("myDuck", myDuck);
		//insert here - �ڷᱸ��(List)
		List<DeptVO> deptList = new ArrayList<DeptVO>();
		DeptVO dvo = new DeptVO();
		dvo.setDeptno(10);
		dvo.setDname("����");
		dvo.setLoc("�λ�");
		deptList.add(dvo);
		dvo = new DeptVO();
		dvo.setDeptno(20);
		dvo.setDname("�ѹ�");
		dvo.setLoc("��õ");
		deptList.add(dvo);
		dvo = new DeptVO();
		dvo.setDeptno(30);
		dvo.setDname("�λ�");
		dvo.setLoc("����");
		deptList.add(dvo);
		req.setAttribute("deptList", deptList);
		res.sendRedirect("./getSendResult.jsp?mem_id="+mem_id);
/*		RequestDispatcher view = 
				req.getRequestDispatcher("./getSendResult.jsp");
		view.forward(req, res);*/
/*		out.print("<html>");
		out.print("<head>");
		out.print("<title>���� TestSendServlet</title>");
		out.print("</head>");
		out.print("<body>"+mem_id+"</body>");
		out.print("</html>");*/
	}
	@Override
	public void doGet(HttpServletRequest req
			         ,HttpServletResponse res)
	throws ServletException, IOException
	{
		logger.info("doGet ȣ�� ����");
		//insert here
		doService(req,res);
	}
	@Override
	public void doPost(HttpServletRequest req
	         		 ,HttpServletResponse res)
    throws ServletException, IOException
    {
		logger.info("doPost ȣ�� ����");
		//insert here
		doService(req,res);
    }
}
