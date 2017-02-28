package com.mvc;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vo.BoardMasterVO;
import com.vo.BoardSubVO;
/********************************************************************
 * !�н���ǥ
 * 1.Annotation�� ����ϱ� ���� ������ �� �� �ִ�.
 * 2.Spring Container�� ���� �����Ǿ���ϴ� Bean�� �����ϱ� ���� ����� ��
 * �ִ� Annotation�� ������ �˰� Ȱ���� �� �ִ�.
 * 3.Dependency Injection(������ ����)�� ���� ����� �� �ִ� Annotation��
 * ������ �˰� Ȱ���� �� �ִ�. 
 * 4.Bean�� Life Cycle�� �����ϴ� Annotation�� ������ �̿��ϰ� Ȱ���� �� �ִ�.
 * 
 * Spring Bean ���� �� AOP, Transaction ���� ����� ����ϰ��� �� ��
 * �ʿ��� �Ӽ����� XML�� �̿��Ͽ� ����
 * ��������
 * ����ϰ� ������ �Ӽ� ���� ���ϵ�� ���� �ý��� ���� �� ���������� ������ �ʷ��� ���ɼ���
 * ��������.
 * 
 * �ذ����� ����?
 * ��κ��� ���¼ҽ� �������� CoC(Convention Over Configuration)��� ����Ʈ����
 * �����з������� �����Ͽ� �ִ��� ������ ���̰� �ּ����� ������ Annotation�� �̿��Ͽ� ��
 * �� �ֵ��� �����ϰ� �ִ�.
 * 
 * Dependency Injection
 * @Autowired
 * ���� �ٸ� Bean���� Dependency Injection ���Ǹ� ���� Annotation
 * Spring�� �������̱������� ������ �� �ִ� ��ġ�� @Resource���� �پ��ϰ�,
 * ������ Dependency Injection�� �ʿ��� ��쿡 �����մϴ�.
 * 
 * @Autowired�� required�Ӽ�
 * �⺻������ @Autowired�� ����� �Ӽ��� �ʼ��̱� ������ �ݵ�� �ش� Bean�� �����ؾ�������
 * required�Ӽ��� false�� �����ϴ� ��쿡�� �ش�Ǵ� Bean�� ã�� ���ϴ��� ������ �߻�����
 * �ʰ� �Ѵ�.
 * 
 * @Autowired - @Qualifier
 * �⺻������ @Autowired�� type-driven injection ���·� �����Ͽ� @Autowired
 * �� ���ǵǾ��� ��� Spring Container�� �ش� Bean�� ã�� �� Ŭ������ type�� ��������
 * �˻��� �մϴ�. �̶� Dependency Injection�� ������ ��� ���ؼ��� @Qualifier��
 * �ʿ��մϴ�.
 *
 * Stereotype Annotation
 * Spring������ ���̾� ���� ������Ҹ� �����Ͽ� Annotaion�� ����� ���� �����ϰ� �ֽ��ϴ�.
 * Spring���� ���̾�� ������Ҹ� �����Ͽ� ����ϴ� Annotaion ���� @Service, @Repository
 * ,@Controller ���� �ֽ��ϴ�.
 * @Service: ����Ͻ� ������ ó���ϴ� Ŭ������ �����ϴµ� ����մϴ�.
 * @Repository: ������ ���� ������ ó���ϴ� Ŭ������ �����ϴµ� ���
 * @Controller: ���������̼� ���̾ �����ϴ� ��Ʈ�ѷ� Ŭ������ �����ϴµ� ����ϸ�
 *              Spring MVC����� ��쿡�� ���ؼ� Ȱ�밡��.
 ********************************************************************/


@Service
public class BoardLogic {
@Autowired(required=false) //����Ʈ Ʈ��
   public BoardDao boardDao = null;
   Logger logger = Logger.getLogger(BoardLogic.class);
   
   //Ʈ����� ó�� ����!
   /********************************************************
    * ������������ ����ڰ� �Է��� ����(�ݺ��ڵ�:request.getParameter())
    * �� �ޱ� ���� �ڵ带 �ٿ��ֱ����ؼ�
    * @ModelAttribute�� @RequestParam API�� �����ϰ� �ֽ��ϴ�.
    * Map�� Ÿ���� �� ������ �ִ�, vo�� Ÿ���� ��Ȯ
    * vo�� ĳ���� Ŭ���� �μ��� �� �� �� �ִ�.
    ********************************************************/
   public int[] boardInsert(BoardMasterVO pbmVO, BoardSubVO pbsVO) {
      logger.info("boardInsert");
      int mresult = 0;
      int sresult = 0;
      int results[] =  new int[2];
      mresult = boardDao.boardMasterInsert(pbmVO, pbsVO);
      //÷�� ������ �����Ҷ�
      if(pbsVO != null)sresult = boardDao.boardSubInsert(pbmVO, pbsVO);
      
      results[0] = mresult;
      results[1] = sresult;
      return results;
   }

   public int[] boardUpdate(BoardMasterVO pbmVO, BoardSubVO pbsVO) {
      logger.info("boardUpdate");
      int mresult = 0;
      int sresult = 0;
      int results[] =  new int[2];
      mresult = boardDao.boardMasterUpdate(pbmVO, pbsVO);
      //÷�� ������ �����Ҷ�
     
      
      results[0] = mresult;
      results[1] = sresult;
      return results;
   }

   public int[] boardDelete(BoardMasterVO pbmVO,BoardSubVO pbsVO) {
      logger.info("boardDelete");
      int mresult = 0;
      int sresult = 0;
      int results[] =  new int[2];
      mresult = boardDao.boardMasterDelete(pbmVO, pbsVO);
      //÷�� ������ �����Ҷ�
     
      
      results[0] = mresult;
      results[1] = sresult;
      return results;
   }

   public List<Map<String,Object>> getBoardList(BoardMasterVO pbmVO) {
      // TODO Auto-generated method stub
      logger.info("getBoardList");
      List<Map<String,Object>> boardList = null;
      boardList = boardDao.getBoardList(pbmVO);
      return boardList;
   }
   
}