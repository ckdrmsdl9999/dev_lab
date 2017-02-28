package com.mvc;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vo.BoardMasterVO;
import com.vo.BoardSubVO;

@Controller
@RequestMapping(value="/board")
public class BoardController {
   Logger logger = Logger.getLogger(BoardController.class);
   
   //글쓰기 화면 제공 - 메소드이름으로 매핑하자
   //웹서비스는 브라우저에서 부르니까 url패턴으로 해야한다
   //결과페이지 필요하다 리턴값 String, 필요없다 void
   @Autowired
   public BoardLogic boardLogic = null;
   //글조회
   @RequestMapping(value="getBoardList.kosmo")
   public String getBoardList(ModelMap pMap, @ModelAttribute BoardMasterVO pbmVO){
      //모델맵도 스프링지원, 정보를 화면에 보내야 하므로 모델맵 필요하다   
      List<Map<String,Object>> boardList = null;
      //화면에 조회결과를 출력하고 싶어요
      
      logger.info("getBoardList 호출성공");
      
      boardList=boardLogic.getBoardList(pbmVO);
      pMap.addAttribute("boardList", boardList);
      
      return "forward:List.jsp"; //webcontent/board/List.jsp~
   }
   @RequestMapping(value="jSonGetBoardList.kosmo")
   public String jSonGetBoardList(ModelMap pMap, @ModelAttribute BoardMasterVO pbmVO){
      //모델맵도 스프링지원, 정보를 화면에 보내야 하므로 모델맵 필요하다   
      List<Map<String,Object>> boardList = null;
      //화면에 조회결과를 출력하고 싶어요
      
      logger.info("getBoardList 호출성공");
      
      boardList=boardLogic.getBoardList(pbmVO);
      pMap.addAttribute("boardList", boardList);
      
      return "forward:jsonGetBoardList.jsp"; //webcontent/board/List.jsp~
   }
   @RequestMapping(value="writeForm.kosmo")
   public String writeForm(){
      return "redirect:writeForm.jsp"; //webcontent/board/writeForm.jsp~
   }
   //글쓰기 처리 구현
   @RequestMapping(value="boardInsert.kosmo")
   public String boardInsert(@ModelAttribute BoardMasterVO pbmVO,
      @ModelAttribute BoardSubVO pbsVO){
      
      int results[] = null;
      results = boardLogic.boardInsert(pbmVO, pbsVO);
      return "redirect:getBoardList.kosmo";
      //forward는 셀렉트할때 쓰자
   }
   //글 수정 화면 호출(DB연동:select)
   @RequestMapping(value="updateForm.kosmo")
   public String updateForm(ModelMap pMap, @ModelAttribute BoardMasterVO pbmVO){
      //1건의 검색결과를 담고있다(VO) 그러므로 포워드 사용
      
      List<Map<String,Object>> boardList 
                  = boardLogic.getBoardList(pbmVO);
      //boardList.size()는 얼마니? 1
      Map<String,Object> rMap = null;
      if(boardList != null){
         rMap = boardList.get(0);
      }
      pMap.addAttribute("rMap",rMap);
      return "forward:updateForm.jsp";
   }
   //글 수정 구현하기(DB연동:update)
   @RequestMapping(value="boardUpdate.kosmo")
   public String boardUpdate(@ModelAttribute BoardMasterVO pbmVO, @ModelAttribute BoardSubVO pbsVO){
      int results[] = null;
      results = boardLogic.boardUpdate(pbmVO,pbsVO);
      return "redirect:getBoardList.kosmo";
   }
   //글삭제 화면제공
   //비밀번호 확인하고 삭제해야됨 - read.jsp에서 삭제가능하므로 db안타도된다.
   @RequestMapping(value="deleteForm.kosmo")
   public String deleteForm(){
      return "redirect:deleteForm.jsp";
   }
   //글 삭제 구현(DB연동:delete)
   //글삭제시 첨부파일은 모두 삭제되므로 마스터VO만 보내자
   @RequestMapping(value="boardDelete.kosmo")
   public String boardDelete(@ModelAttribute BoardMasterVO pbmVO,
         @ModelAttribute BoardSubVO pbsVO){
      int results[] = null;
      results = boardLogic.boardDelete(pbmVO,pbsVO);
      return "redirect:getBoardList.kosmo";
   }
   
}