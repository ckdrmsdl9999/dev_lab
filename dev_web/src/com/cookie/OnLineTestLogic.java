package com.cookie;

import org.apache.log4j.Logger;

import com.vo.ExamineeVO;
import com.vo.RightAnswerVO;
import com.vo.TakeVO;

public class OnLineTestLogic {
	Logger logger = Logger.getLogger(OnLineTestLogic.class);
	/***********************************************************************************
	 * 시험 응시 처리 및 채점 하기 구현
	 * @param  수험생 번호 
	 * @return 판정 결과 및 점수 
	 **********************************************************************************/
	public ExamineeVO marking(ExamineeVO peVO, TakeVO ptVO) {
		ExamineeVO reVO = null;
		OnLineTestDao testDao = new OnLineTestDao();
		//답안지 처리 결과를 담을 변수 선언
		int tiResult = 0;
		//시험 판정 정보 수정 결과 담을 변수 선언
		//1이면 채점 정상 완료
		//0이면 채점 실패  
		int euResult = 0;
		//insert here - INSERT문 작성해 보기
		/*INSERT INTO take(exam_cd, test_no, take1, take2, take3, take4, take5)
        VALUES(t_20170111,2017010001,1,1,2,2,2)*/
		tiResult = testDao.takeInsert(ptVO);//답안지 INSERT처리
		//insert here - SELECT문 작성해 보기(문제코드에 대한 조건검색)
		//정답 정보 SELECT처리
		RightAnswerVO rraVO = testDao.getRightAnswer(ptVO.getExam_cd());
		/************************ 도전과제 *************************
		 채점하는 로직을 자바코드가 아닌 SQL문으로 할 수 있지 않을까?
		************************************************************/
		//insert here - SELECT문 작성해 보기(문제코드와 수험생번호 조건검색)
/*		SELECT exam_cd, test_no, take1, take2, take3
             , take4, take5
		  FROM take 
		 WHERE exam_cd = 't_20170111'
		   AND test_no = '2017010001'*/ 
		//작성한 답안지에 대해 정상적으로 insert가 되면 답안지 테이블 가져올 필요없이
		//파라미터로 넘어온 ptVO를 사용합니다.
		//채점하기 구현
		int daps[] = new int[5];//정답 담는 배열 선언
		int takes[] = new int[5];//답안지 담는 배열 선언
		if(rraVO != null){//정답을 담을 배열에 대한 초기화
			daps[0] = rraVO.getAnswer1();
			daps[1] = rraVO.getAnswer2();
			daps[2] = rraVO.getAnswer3();
			daps[3] = rraVO.getAnswer4();
			daps[4] = rraVO.getAnswer5();
		}
		logger.info("tiResult:"+tiResult);
		if(tiResult==1){ 
			takes[0] = ptVO.getTake1();
			takes[1] = ptVO.getTake2();
			takes[2] = ptVO.getTake3();
			takes[3] = ptVO.getTake4();
			takes[4] = ptVO.getTake5();
		}
		for(int i=0;i<daps.length;i++){
			logger.info("정답["+i+"] = "+daps[i]);
			logger.info("답안["+i+"] = "+takes[i]);
		}
		TakeVO rtVO = testDao.getTake(ptVO);//답안지 정보 SELECT처리
		//insert here - 채점로직(업무프로세스) - 추가
		//판정 기준점수 : 60점
		//문항 점수     : 20점
		//개선사항 : 혹시 SQL문만으로 처리할 수 없을까?
		int cnt = 0;//맞힌 갯수
		int bscore = 20;//문항점수
		int score = 0;//응시생의 점수를 담는 변수
		int pscore = 60;
		String decision = "불합격";
		for(int i=0;i<daps.length;i++){
			for(int j=0;j<takes.length;j++){
				if(i==j){//배열의 인덱스가 같니? - 같은 문항입니다.
					if(daps[i]==takes[j]){//정답
						++cnt;//cnt = cnt+1
					}
				}
			}
		}
		logger.info("score:"+score+", cnt:"+cnt);
		//응시생 점수 계산하기
		score = bscore*cnt;
		//합격 여부 담기
		if(score >= pscore){
			decision = "합격";
		}
		else{
			decision = "불합격";
		}
		//insert here 
		peVO.setDecision(decision);//합격 or 불합격을 담기
		peVO.setScore(score);
		peVO.setTake_yn("1");//색인 : 1이면 응시 0이면 미응시
		//insert here - UPDATE문 작성해 보기(해당 수험생에 대해 정보 수정)
/*		UPDATE examinee
	       SET decision = '합격' -- or 불합격
	          ,score = 80
	          ,take_yn = 1 
	     WHERE test_no = '2017010001' */		
		euResult = testDao.examineeUpdate(peVO);//시험 응시 판정 정보 수정 UPDATE처리
		//수험생 시험응시 처리 정보 SELECT처리
		//시험 응시 결과 정보를 조회하기
		//아래 메소드는 인증처리 하는 testLogin SQL문을 재사용 해봅시다.
		reVO = testDao.testLogin(peVO);
		logger.info("수험번호:"+reVO.getTest_no());
		logger.info("성명:"+reVO.getT_name());
		logger.info("판정결과:"+reVO.getDecision());
		logger.info("점수:"+reVO.getScore());
		logger.info("응시여부:"+reVO.getTake_yn());
		return reVO;
	}

	public ExamineeVO testLogin(ExamineeVO peVO) {
		logger.info("testLogin 호출 성공");
		ExamineeVO reVO = null;
		OnLineTestDao testDao = new OnLineTestDao();
		reVO = testDao.testLogin(peVO);
		return reVO;
	}

}






