package com.ajax.memo;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.util.Action;
import com.util.ActionForward;
import com.vo.MemoVO;

public class MemoReceiveAction implements Action {
	Logger logger = Logger.getLogger(MemoReceiveAction.class);
	@Override
	/*************************************************************************************
	 * ��������(���� ������ ��� ����)
	 * @param request, response
	 * @return ActionForward
	 * ���������� - getReceiveMemoList.jsp(���ΰ�ħ)
	 *************************************************************************************/
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		logger.info("execute ȣ�� ����");
		MemoLogic moLogic = new MemoLogic();
		MemoVO moVO = new MemoVO();
		HttpSession session = req.getSession();
		
		//moVO.setTo_id((String)session.getAttribute("sid"));
		logger.info(moVO.getTo_id());
		
		List<MemoVO> memoList = moLogic.getReceiveMemoList(moVO);
		//req.setAttribute("memoList", memoList);
		session.setAttribute("memoList", memoList); 
		ActionForward forward = new ActionForward();
		//��������:getReceiveMemoList.mem���� ��û������ �ٽ� ������ ��û�� �Ͼ�Ƿ�
		//         ���ѷ����� ������.
		forward.setRedirect(false);
		//��û�� ���� ������ ������ ������ �̸� Ȥ�� XXX.mem�̸�
		forward.setPath("./getReceiveMemoList.jsp");
		return forward;
	}

}
