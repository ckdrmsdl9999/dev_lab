package com.cookie;

import org.apache.log4j.Logger;

import com.vo.ExamineeVO;
import com.vo.RightAnswerVO;
import com.vo.TakeVO;

public class OnLineTestLogic {
	Logger logger = Logger.getLogger(OnLineTestLogic.class);
	/***********************************************************************************
	 * ���� ���� ó�� �� ä�� �ϱ� ����
	 * @param  ����� ��ȣ 
	 * @return ���� ��� �� ���� 
	 **********************************************************************************/
	public ExamineeVO marking(ExamineeVO peVO, TakeVO ptVO) {
		ExamineeVO reVO = null;
		OnLineTestDao testDao = new OnLineTestDao();
		//����� ó�� ����� ���� ���� ����
		int tiResult = 0;
		//���� ���� ���� ���� ��� ���� ���� ����
		//1�̸� ä�� ���� �Ϸ�
		//0�̸� ä�� ����  
		int euResult = 0;
		//insert here - INSERT�� �ۼ��� ����
		/*INSERT INTO take(exam_cd, test_no, take1, take2, take3, take4, take5)
        VALUES(t_20170111,2017010001,1,1,2,2,2)*/
		tiResult = testDao.takeInsert(ptVO);//����� INSERTó��
		//insert here - SELECT�� �ۼ��� ����(�����ڵ忡 ���� ���ǰ˻�)
		//���� ���� SELECTó��
		RightAnswerVO rraVO = testDao.getRightAnswer(ptVO.getExam_cd());
		/************************ �������� *************************
		 ä���ϴ� ������ �ڹ��ڵ尡 �ƴ� SQL������ �� �� ���� ������?
		************************************************************/
		//insert here - SELECT�� �ۼ��� ����(�����ڵ�� �������ȣ ���ǰ˻�)
/*		SELECT exam_cd, test_no, take1, take2, take3
             , take4, take5
		  FROM take 
		 WHERE exam_cd = 't_20170111'
		   AND test_no = '2017010001'*/ 
		//�ۼ��� ������� ���� ���������� insert�� �Ǹ� ����� ���̺� ������ �ʿ����
		//�Ķ���ͷ� �Ѿ�� ptVO�� ����մϴ�.
		//ä���ϱ� ����
		int daps[] = new int[5];//���� ��� �迭 ����
		int takes[] = new int[5];//����� ��� �迭 ����
		if(rraVO != null){//������ ���� �迭�� ���� �ʱ�ȭ
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
			logger.info("����["+i+"] = "+daps[i]);
			logger.info("���["+i+"] = "+takes[i]);
		}
		TakeVO rtVO = testDao.getTake(ptVO);//����� ���� SELECTó��
		//insert here - ä������(�������μ���) - �߰�
		//���� �������� : 60��
		//���� ����     : 20��
		//�������� : Ȥ�� SQL�������� ó���� �� ������?
		int cnt = 0;//���� ����
		int bscore = 20;//��������
		int score = 0;//���û��� ������ ��� ����
		int pscore = 60;
		String decision = "���հ�";
		for(int i=0;i<daps.length;i++){
			for(int j=0;j<takes.length;j++){
				if(i==j){//�迭�� �ε����� ����? - ���� �����Դϴ�.
					if(daps[i]==takes[j]){//����
						++cnt;//cnt = cnt+1
					}
				}
			}
		}
		logger.info("score:"+score+", cnt:"+cnt);
		//���û� ���� ����ϱ�
		score = bscore*cnt;
		//�հ� ���� ���
		if(score >= pscore){
			decision = "�հ�";
		}
		else{
			decision = "���հ�";
		}
		//insert here 
		peVO.setDecision(decision);//�հ� or ���հ��� ���
		peVO.setScore(score);
		peVO.setTake_yn("1");//���� : 1�̸� ���� 0�̸� ������
		//insert here - UPDATE�� �ۼ��� ����(�ش� ������� ���� ���� ����)
/*		UPDATE examinee
	       SET decision = '�հ�' -- or ���հ�
	          ,score = 80
	          ,take_yn = 1 
	     WHERE test_no = '2017010001' */		
		euResult = testDao.examineeUpdate(peVO);//���� ���� ���� ���� ���� UPDATEó��
		//����� �������� ó�� ���� SELECTó��
		//���� ���� ��� ������ ��ȸ�ϱ�
		//�Ʒ� �޼ҵ�� ����ó�� �ϴ� testLogin SQL���� ���� �غ��ô�.
		reVO = testDao.testLogin(peVO);
		logger.info("�����ȣ:"+reVO.getTest_no());
		logger.info("����:"+reVO.getT_name());
		logger.info("�������:"+reVO.getDecision());
		logger.info("����:"+reVO.getScore());
		logger.info("���ÿ���:"+reVO.getTake_yn());
		return reVO;
	}

	public ExamineeVO testLogin(ExamineeVO peVO) {
		logger.info("testLogin ȣ�� ����");
		ExamineeVO reVO = null;
		OnLineTestDao testDao = new OnLineTestDao();
		reVO = testDao.testLogin(peVO);
		return reVO;
	}

}






