package com.mvc;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vo.BoardMasterVO;
import com.vo.BoardSubVO;
/********************************************************************
 * !학습목표
 * 1.Annotation을 사용하기 위한 설정을 할 수 있다.
 * 2.Spring Container에 의해 관리되어야하는 Bean을 정의하기 위해 사용할 수
 * 있는 Annotation의 종류를 알고 활용할 수 있다.
 * 3.Dependency Injection(의존성 주입)을 위해 사용할 수 있는 Annotation의
 * 종류를 알고 활용할 수 있다. 
 * 4.Bean의 Life Cycle에 관여하는 Annotation의 종류를 이용하고 활용할 수 있다.
 * 
 * Spring Bean 정의 및 AOP, Transaction 등의 기능을 사용하고자 할 때
 * 필요한 속성들을 XML을 이용하여 설정
 * 문제제기
 * 방대하고 복잡한 속성 정의 파일들로 인해 시스템 개발 및 유지보수의 지연을 초래할 가능성이
 * 높아졌다.
 * 
 * 해결방법은 뭐지?
 * 대부분의 오픈소스 진영에서 CoC(Convention Over Configuration)라는 소프트웨어
 * 개발패러다임을 도입하여 최대한 설정을 줄이고 최소한의 설정도 Annotation을 이용하여 할
 * 수 있도록 지운하고 있다.
 * 
 * Dependency Injection
 * @Autowired
 * 서로 다른 Bean간의 Dependency Injection 정의를 위한 Annotation
 * Spring에 종속적이긴하지만 적용할 수 있는 위치가 @Resource보다 다양하고,
 * 정밀한 Dependency Injection이 필요한 경우에 유용합니다.
 * 
 * @Autowired의 required속성
 * 기본적으로 @Autowired가 적용된 속성은 필수이기 때문에 반드시 해당 Bean이 존재해야하지만
 * required속성을 false로 설정하는 경우에는 해당되는 Bean을 찾지 못하더라도 에러가 발생하지
 * 않게 한다.
 * 
 * @Autowired - @Qualifier
 * 기본적으로 @Autowired는 type-driven injection 형태로 동작하여 @Autowired
 * 가 정의되었을 경우 Spring Container가 해당 Bean을 찾을 떄 클래스의 type을 기준으로
 * 검색을 합니다. 이때 Dependency Injection의 세밀한 제어를 위해서는 @Qualifier가
 * 필요합니다.
 *
 * Stereotype Annotation
 * Spring에서는 레이어 별로 구성요소를 구분하여 Annotaion을 사용할 것을 권장하고 있습니다.
 * Spring에서 레이어별로 구성요소를 구분하여 사용하는 Annotaion 에는 @Service, @Repository
 * ,@Controller 등이 있습니다.
 * @Service: 비즈니스 로직을 처리하는 클래스를 정의하는데 사용합니다.
 * @Repository: 데이터 접근 로직을 처리하는 클래스를 정의하는데 사용
 * @Controller: 프리젠테이션 레이어를 구성하는 컨트롤러 클래스를 정의하는데 사용하며
 *              Spring MVC기반인 경우에만 한해서 활용가능.
 ********************************************************************/


@Service
public class BoardLogic {
@Autowired(required=false) //디폴트 트루
   public BoardDao boardDao = null;
   Logger logger = Logger.getLogger(BoardLogic.class);
   
   //트랜잭션 처리 문제!
   /********************************************************
    * 스프링에서는 사용자가 입력한 정보(반복코드:request.getParameter())
    * 를 받기 위한 코드를 줄여주기위해서
    * @ModelAttribute와 @RequestParam API를 지원하고 있습니다.
    * Map은 타입을 다 담을수 있다, vo는 타입이 명확
    * vo는 캐스팅 클래스 인셉션 안 뜰 수 있다.
    ********************************************************/
   public int[] boardInsert(BoardMasterVO pbmVO, BoardSubVO pbsVO) {
      logger.info("boardInsert");
      int mresult = 0;
      int sresult = 0;
      int results[] =  new int[2];
      mresult = boardDao.boardMasterInsert(pbmVO, pbsVO);
      //첨부 파일이 존재할때
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
      //첨부 파일이 존재할때
     
      
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
      //첨부 파일이 존재할때
     
      
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