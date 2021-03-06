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
 * 학습목표
 * 1.Annotation을 사용하기 위한 필요한 설정을 할 수 있다.
 * 2.Spring Container에 의해 관리되어야 하는 Bean을 정의하기 위해 사용할 수 있는
 *   Annotation의 종류를 알고 활용할 수 있다.
 * 3.Dependency Injection을 위해 사용할 수 있는 Annotation의 종류를 알고 
 *   활용할 수 있다.
 * 4.Bean의 Life Cycle에 관여하는 Annotation의 종류를 이해하고 활용할 수 있다.
 * 
 * Spring Bean 정의 및 AOP, Transaction 등의 기능을 사용하고자 할 때
 * 필요한 속성들을 XML을 이용하여 설정
 * 문제제기
 * 방대하고 복잡한 속성 정의 파일들로 인해 시스템 개발 및 유지 보수의 지연을 초래할 가능성이
 * 높아졌다.
 * 
 * 해결 방법은 머지?
 * 대부분의 오픈소스 진영에서 CoC(Convention Over Configuration)라는 소프트웨어 개발 패러다임을
 * 도입하여 최대한 설정을 줄이고 최소한의 설정도 Annotation을 이용하여 할 수 있도록 지원하고 
 * 있다.
 * 
 * Dependency Injection
 * @Autowired 
 * 서로 다른 Bean간의 Dependency Injection 정의를 위한 Annotation
 * Spring에 종속적이긴 하지만 적용할 수 있는 위치가 @Resource보다 다양하고, 
 * 정밀한 Dependency Injection이 필요한 경우에 유용합니다.
 * 
 * @Autowired의 required속성
 * 기본적으로 @Autowired가 적용된 속성은 필수이기 때문에 반드시 해당 Bean이 존재해야 하지만
 * required속성을 false로 설정하는 경우에는 해당되는 Bean을 찾지 못하더라도 에러가 발생하지
 * 않게 함.
 * 
 * @Autowired - @Qualifier
 * 기본적으로 @Autowired는 type-driven injection 형태로 동작하여 @Autowired가 정의되었을 경우
 * Spring Container가 해당 Bean을 찾을 때 클래스의 type을 기준으로 검색을 합니다.
 * 이때 Dependency Injection의 세밀한 제어를 위해서는 @Qualifier가 필요합니다.
 * 
 * Stereotype Annotation
 * Spring에서는 레이어 별로 구성요소를 구분하여 Annotation을 사용할 것을 권장하고 있습니다.
 * Spring에서 레이어별로 구성요소를 구분하여 사용하는 Annotation 에는 @Service, @Repository
 * , @Controller가 있습니다.
 * 1)@Service:비즈니스 로직을 처리하는 클래스를 정의하는데 사용합니다.\
 * 2)@Repository:데이터 접근 로직을 처리하는 클래스를 정의하는데 사용합니다.
 * 3)@Controller:프리젠테이션 레이어를 구성하는 Controller클래스를 정의하는데 사용하며
 *               Spring MVC기반인 경우에만 한해 활용가능함.
 ******************************************************************************************/
@Service
public class BoardLogic {
	@Autowired(required=false)
	public BoardDao boardDao = null;
	/****************************************************************************************
	 * 게시판 글쓰기 구현
	 * 새글을 등록할 때는 리스트 화면에서 글쓰기 버튼을 통해서 이벤트가 처리되고
	 * 답글을 등록할 때는 상세페이지에서 답변 버튼을 클릭했을 때 처리한다.
	 * 새글일때는 글번호는 시퀀스를 통해 채번하고 b_group값은 MAX에서 1 더한 값으로 등록해야
	 * 한다.
	 * 답글일 경우에는 b_no는 채번하고 b_group값은 상세페이지에서 넘겨받은 값으로 등록한다.
	 * 답글일 경우 화면으로 부터 b_step값을 받아서 같은 글의 그룹에 더 큰값이 존재하면
	 * 삽입되는 글 아래에 있는 답글들의 b_step값은 각각 1을 더한 값으로 update해야 한다.
	 * update문 작성해 보기 - 새글일 경우 해당없고 답글인 경우만 적용
	 * UPDATE board_master
	 *    SET b_step = b_step + 1
	 *  WHERE b_group = ?(상세보기에서 hidden으로 받아온 값)
	 *    AND b_step > ? (상세보기에서 hidden으로 받아온 값)
	 * @param pbmVO
	 * @param pbsVO
	 * @return
	 ***************************************************************************************/
	//트랜잭션처리 문제
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor={DataAccessException.class})
	@Pointcut(value="execution(* com.mvc.*Logic.*(..)")
	public int[] boardInsert(BoardMasterVO pbmVO, BoardSubVO pbsVO) {
		int mresult = 0;
		int sresult = 0;
		int results[] = new int[2];
		try {
			//답글이니?(read.jsp 호출)
			if(pbmVO.getB_no() > 0){
				boardDao.bStepUpdate(pbmVO);
				pbmVO.setB_pos(pbmVO.getB_pos()+1);
				pbmVO.setB_step(pbmVO.getB_step()+1);
			}
			//새글이구나(List.jsp 호출) - 글번호를 새로 채번
			else{ 
				int b_group = boardDao.getBgroup(pbmVO);
				pbmVO.setB_group(b_group);
				pbmVO.setB_pos(0);
				pbmVO.setB_step(0);
			}
			mresult = boardDao.boardMasterInsert(pbmVO);
			//첨부파일이 존재하니?
			if(pbsVO.getB_file().length()>0){
				sresult = boardDao.boardSubInsert(pbsVO);
			}
		} catch (DataAccessException de) {
		//boardMasterInsert, boardSubInsert, bStepUpdate
		//DataAccessException에 해당될 때 롤백처리하기 위한 코드(관여)	
			throw de;//스프링컨테이너에게 던진다.
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







