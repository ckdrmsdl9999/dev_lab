package com.mvc;

import java.util.List;
import java.util.Map;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.vo.BoardMasterVO;
import com.vo.BoardSubVO;
import com.vo.BoardVO;
/*******************************************************************************************
 * �н���ǥ
 * 1.Annotation�� ����ϱ� ���� �ʿ��� ������ �� �� �ִ�.
 * 2.Spring Container�� ���� �����Ǿ�� �ϴ� Bean�� �����ϱ� ���� ����� �� �ִ�
 *   Annotation�� ������ �˰� Ȱ���� �� �ִ�.
 * 3.Dependency Injection�� ���� ����� �� �ִ� Annotation�� ������ �˰� 
 *   Ȱ���� �� �ִ�.
 * 4.Bean�� Life Cycle�� �����ϴ� Annotation�� ������ �����ϰ� Ȱ���� �� �ִ�.
 * 
 * Spring Bean ���� �� AOP, Transaction ���� ����� ����ϰ��� �� ��
 * �ʿ��� �Ӽ����� XML�� �̿��Ͽ� ����
 * ��������
 * ����ϰ� ������ �Ӽ� ���� ���ϵ�� ���� �ý��� ���� �� ���� ������ ������ �ʷ��� ���ɼ���
 * ��������.
 * 
 * �ذ� ����� ����?
 * ��κ��� ���¼ҽ� �������� CoC(Convention Over Configuration)��� ����Ʈ���� ���� �з�������
 * �����Ͽ� �ִ��� ������ ���̰� �ּ����� ������ Annotation�� �̿��Ͽ� �� �� �ֵ��� �����ϰ� 
 * �ִ�.
 * 
 * Dependency Injection
 * @Autowired 
 * ���� �ٸ� Bean���� Dependency Injection ���Ǹ� ���� Annotation
 * Spring�� �������̱� ������ ������ �� �ִ� ��ġ�� @Resource���� �پ��ϰ�, 
 * ������ Dependency Injection�� �ʿ��� ��쿡 �����մϴ�.
 * 
 * @Autowired�� required�Ӽ�
 * �⺻������ @Autowired�� ����� �Ӽ��� �ʼ��̱� ������ �ݵ�� �ش� Bean�� �����ؾ� ������
 * required�Ӽ��� false�� �����ϴ� ��쿡�� �ش�Ǵ� Bean�� ã�� ���ϴ��� ������ �߻�����
 * �ʰ� ��.
 * 
 * @Autowired - @Qualifier
 * �⺻������ @Autowired�� type-driven injection ���·� �����Ͽ� @Autowired�� ���ǵǾ��� ���
 * Spring Container�� �ش� Bean�� ã�� �� Ŭ������ type�� �������� �˻��� �մϴ�.
 * �̶� Dependency Injection�� ������ ��� ���ؼ��� @Qualifier�� �ʿ��մϴ�.
 * 
 * Stereotype Annotation
 * Spring������ ���̾� ���� ������Ҹ� �����Ͽ� Annotation�� ����� ���� �����ϰ� �ֽ��ϴ�.
 * Spring���� ���̾�� ������Ҹ� �����Ͽ� ����ϴ� Annotation ���� @Service, @Repository
 * , @Controller�� �ֽ��ϴ�.
 * 1)@Service:����Ͻ� ������ ó���ϴ� Ŭ������ �����ϴµ� ����մϴ�.\
 * 2)@Repository:������ ���� ������ ó���ϴ� Ŭ������ �����ϴµ� ����մϴ�.
 * 3)@Controller:���������̼� ���̾ �����ϴ� ControllerŬ������ �����ϴµ� ����ϸ�
 *               Spring MVC����� ��쿡�� ���� Ȱ�밡����.
 ******************************************************************************************/
@Service
public class BoardLogic {
	@Autowired(required=false)
	public BoardDao boardDao = null;
	/****************************************************************************************
	 * �Խ��� �۾��� ����
	 * ������ ����� ���� ����Ʈ ȭ�鿡�� �۾��� ��ư�� ���ؼ� �̺�Ʈ�� ó���ǰ�
	 * ����� ����� ���� ������������ �亯 ��ư�� Ŭ������ �� ó���Ѵ�.
	 * �����϶��� �۹�ȣ�� �������� ���� ä���ϰ� b_group���� MAX���� 1 ���� ������ ����ؾ�
	 * �Ѵ�.
	 * ����� ��쿡�� b_no�� ä���ϰ� b_group���� ������������ �Ѱܹ��� ������ ����Ѵ�.
	 * ����� ��� ȭ������ ���� b_step���� �޾Ƽ� ���� ���� �׷쿡 �� ū���� �����ϸ�
	 * ���ԵǴ� �� �Ʒ��� �ִ� ��۵��� b_step���� ���� 1�� ���� ������ update�ؾ� �Ѵ�.
	 * update�� �ۼ��� ���� - ������ ��� �ش���� ����� ��츸 ����
	 * UPDATE board_master
	 *    SET b_step = b_step + 1
	 *  WHERE b_group = ?(�󼼺��⿡�� hidden���� �޾ƿ� ��)
	 *    AND b_step > ? (�󼼺��⿡�� hidden���� �޾ƿ� ��)
	 * @param pbmVO
	 * @param pbsVO
	 * @return
	 ***************************************************************************************/
	//Ʈ�����ó�� ����
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor={DataAccessException.class})
	@Pointcut(value="execution(* com.mvc.*Logic.*(..)")
	public int[] boardInsert(BoardMasterVO pbmVO, BoardSubVO pbsVO) {
		int mresult = 0;
		int sresult = 0;
		int results[] = new int[2];
		try {
			//����̴�?(read.jsp ȣ��)
			if(pbmVO.getB_no() > 0){
				boardDao.bStepUpdate(pbmVO);
				pbmVO.setB_pos(pbmVO.getB_pos()+1);
				pbmVO.setB_step(pbmVO.getB_step()+1);
			}
			//�����̱���(List.jsp ȣ��) - �۹�ȣ�� ���� ä��
			else{ 
				int b_group = boardDao.getBgroup(pbmVO);
				pbmVO.setB_group(b_group);
				pbmVO.setB_pos(0);
				pbmVO.setB_step(0);
			}
			mresult = boardDao.boardMasterInsert(pbmVO);
			//÷�������� �����ϴ�?
			if(pbsVO.getB_file().length()>0){
				sresult = boardDao.boardSubInsert(pbsVO);
			}
		} catch (DataAccessException de) {
		//boardMasterInsert, boardSubInsert, bStepUpdate
		//DataAccessException�� �ش�� �� �ѹ�ó���ϱ� ���� �ڵ�(����)	
			throw de;//�����������̳ʿ��� ������.
		}
		
		results[0] = mresult;
		results[1] = sresult;
		return results; 
	}

	public List<Map<String, Object>> getBoardList(BoardMasterVO pbmVO) {
		List<Map<String, Object>> boardList = null;
		boardList = boardDao.getBoardList(pbmVO);
		return boardList;
	}

	public int[] boardUpdate(BoardMasterVO pbmVO, BoardSubVO pbsVO) {
		int mresult = 0;
		int sresult = 0;
		int results[] = new int[2];
		mresult = boardDao.boardMasterUpdate(pbmVO);
		sresult = boardDao.boardSubUpdate(pbsVO);
		results[0] = mresult;
		results[1] = sresult;
		return results;
	}

	public int[] boardDelete(BoardMasterVO pbmVO
			             , BoardSubVO pbsVO) {
		int mresult = 0;
		int sresult = 0;
		int results[] = new int[2];
		mresult = boardDao.boardMasterDelete(pbmVO);
		sresult = boardDao.boardSubDelete(pbsVO);
		results[0] = mresult;
		results[1] = sresult;
		return results;
	}

}







