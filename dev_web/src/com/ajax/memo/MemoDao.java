package com.ajax.memo;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import com.vo.MemberVO;
import com.vo.MemoVO;

public class MemoDao {
	Logger logger = Logger.getLogger(MemoDao.class);
	SqlSessionFactory sqlMapper = null;
	SqlSession sqlSes = null;		
	public int memoInsert(MemoVO moVO) {
		logger.info("memoInsert ȣ�� ����");
		int miResult = 0;
		try {
			String resource = "com/mybatis/MapperConfig.xml";
			Reader reader = null;
			reader = Resources.getResourceAsReader(resource);
			sqlMapper = 
			new SqlSessionFactoryBuilder().build(reader);
// booleanŸ���� �⺻ �� - false			
//openSession() : �ڵ�Ŀ���� �Ͼ�� �ʴ´�.
// �� �������� ���̺� �߰��� ������ �ݿ��ǵ��� �Ϸ���
// ���� sqlSes.commit() ȣ���ؾ� �ݿ��ȴ�.			
//openSession(boolean isFlag)	
//isFlag�� true�̸� ����Ŀ��
//isFlag�� false�̸� ����Ŀ�� ��尡 ���� �ִ�.			
			sqlSes = sqlMapper.openSession();
			reader.close();
			miResult = sqlSes.insert("memoInsert",moVO);
			if(miResult==1){//�Է¼���
				sqlSes.commit();
			}
		} catch (IOException ie) {
			logger.info("IOException:"+ie.getMessage());
			ie.printStackTrace();
		}		 
		return miResult;
	}
	public List<MemoVO> getReceiveMemoList(MemoVO pmoVO) {
		logger.info("getReceiveMemoList ȣ�� ����");
		List<MemoVO> memoList = null;
		try {
			String resource = "com/mybatis/MapperConfig.xml";
			Reader reader = null;
			reader = Resources.getResourceAsReader(resource);
			sqlMapper = 
			new SqlSessionFactoryBuilder().build(reader);
		
			sqlSes = sqlMapper.openSession();
			reader.close();
			memoList = sqlSes.selectList("getReceiveMemoList",pmoVO);
			
			logger.info(memoList.size());
			
		} catch (IOException ie) {
			logger.info("IOException:"+ie.getMessage());
			ie.printStackTrace();
		}		 
		return memoList;
	}
	public List<MemoVO> getSendMemoList(MemoVO pmoVO) {
		logger.info("getSendMemoList ȣ�� ����");
		List<MemoVO> memoList = null;
		try {
			String resource = "com/mybatis/MapperConfig.xml";
			Reader reader = null;
			reader = Resources.getResourceAsReader(resource);
			sqlMapper = 
			new SqlSessionFactoryBuilder().build(reader);
		
			sqlSes = sqlMapper.openSession();
			reader.close();
			memoList = sqlSes.selectList("getSendMemoList",pmoVO);
			logger.info(pmoVO.getFrom_id());
			logger.info(memoList.size());
			
		} catch (IOException ie) {
			logger.info("IOException:"+ie.getMessage());
			ie.printStackTrace();
		}		 
		return memoList;
	}
	public int memoDelete(MemoVO moVO) {
		logger.info("memoDelete ȣ�� ����");
		return 0;
	}
	public int memoUpdate(MemoVO moVO) {
		logger.info("memoUpdate ȣ�� ����");
		return 0;
	}

}
