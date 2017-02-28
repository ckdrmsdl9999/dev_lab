package com.ajax.memo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.util.Action;
import com.util.ActionForward;
import com.vo.MemoVO;

public class MemoUpdateAction implements Action {
	Logger logger = Logger.getLogger(MemoSendAction.class);
	@Override
	/*************************************************************************************
	 * ��������(�������� �����ϱ� ����)
	 * @param request, response
	 * @return ActionForward
	 * ���������� - getSendMemoList.mem
	 *************************************************************************************/
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		logger.info("execute ȣ�� ����");
		MemoLogic moLogic = new MemoLogic();
		int muResult = 0;
		MemoVO moVO = new MemoVO();
		muResult = moLogic.memoUpdate(moVO);		
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		//��û�� ���� ������ ������ ������ �̸� Ȥ�� XXX.mem�̸�
		if(muResult == 1) forward.setPath("./memoUpdateSuccess.jsp");
		else forward.setPath("./memoUpdateFail.jsp");
		return forward;
	}
}
