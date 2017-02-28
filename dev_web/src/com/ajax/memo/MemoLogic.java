package com.ajax.memo;

import java.util.List;

import org.apache.log4j.Logger;

import com.vo.MemoVO;

public class MemoLogic {
	Logger logger = Logger.getLogger(MemoLogic.class);
	/***********************************************************************************
	 * 쪽지 쓰기
	 * @param moVO - 사용자가 입력한 정보
	 * @return miResult - 1:입력성공, 0:입력실패
	 ***********************************************************************************/
	public int memoInsert(MemoVO moVO) {
		logger.info("memoInsert 호출 성공");
		int miResult = 0;
		MemoDao moDao = new MemoDao();
		miResult = moDao.memoInsert(moVO);
		return miResult;
	}
	/************************************************************************************
	 * 받은 쪽지함 목록 구현
	 * @param moVO - 세션에 담긴 아이디 저장
	 * @return List<MemoVO>
	 ************************************************************************************/
	public List<MemoVO> getReceiveMemoList(MemoVO moVO) {
		logger.info("getReceiveMemoList 호출 성공");
		logger.info(moVO.getTo_id());
		List<MemoVO> memoList = null;
		MemoDao moDao = new MemoDao();
		memoList = moDao.getReceiveMemoList(moVO);
		return memoList;
	}
	public List<MemoVO> getSendMemoList(MemoVO moVO) {
		logger.info("getSendMemoList 호출 성공");
		List<MemoVO> memoList = null;
		MemoDao moDao = new MemoDao();
		memoList = moDao.getSendMemoList(moVO);
		return memoList;
	}
	public int memoDelete(MemoVO moVO) {
		logger.info("memoDelete 호출 성공");
		int mdResult = 0;
		MemoDao moDao = new MemoDao();
		mdResult = moDao.memoDelete(moVO);
		return mdResult;
	}
	public int memoUpdate(MemoVO moVO) {
		logger.info("memoUpdate 호출 성공");
		int muResult = 0;
		MemoDao moDao = new MemoDao();
		muResult = moDao.memoUpdate(moVO);
		return muResult;
	}
	
}




