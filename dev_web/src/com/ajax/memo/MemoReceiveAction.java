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
	 * 쪽지관리(받은 쪽지함 목록 구현)
	 * @param request, response
	 * @return ActionForward
	 * 응답페이지 - getReceiveMemoList.jsp(새로고침)
	 *************************************************************************************/
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		logger.info("execute 호출 성공");
		MemoLogic moLogic = new MemoLogic();
		MemoVO moVO = new MemoVO();
		HttpSession session = req.getSession();
		
		//moVO.setTo_id((String)session.getAttribute("sid"));
		logger.info(moVO.getTo_id());
		
		List<MemoVO> memoList = moLogic.getReceiveMemoList(moVO);
		//req.setAttribute("memoList", memoList);
		session.setAttribute("memoList", memoList); 
		ActionForward forward = new ActionForward();
		//문제제기:getReceiveMemoList.mem으로 요청했을때 다시 포워드 요청이 일어나므로
		//         무한루프에 빠진다.
		forward.setRedirect(false);
		//요청에 대한 응답이 나가는 페이지 이름 혹은 XXX.mem이름
		forward.setPath("./getReceiveMemoList.jsp");
		return forward;
	}

}
