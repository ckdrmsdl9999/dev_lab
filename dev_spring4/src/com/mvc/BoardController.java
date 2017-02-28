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
   
   //�۾��� ȭ�� ���� - �޼ҵ��̸����� ��������
   //�����񽺴� ���������� �θ��ϱ� url�������� �ؾ��Ѵ�
   //��������� �ʿ��ϴ� ���ϰ� String, �ʿ���� void
   @Autowired
   public BoardLogic boardLogic = null;
   //����ȸ
   @RequestMapping(value="getBoardList.kosmo")
   public String getBoardList(ModelMap pMap, @ModelAttribute BoardMasterVO pbmVO){
      //�𵨸ʵ� ����������, ������ ȭ�鿡 ������ �ϹǷ� �𵨸� �ʿ��ϴ�   
      List<Map<String,Object>> boardList = null;
      //ȭ�鿡 ��ȸ����� ����ϰ� �;��
      
      logger.info("getBoardList ȣ�⼺��");
      
      boardList=boardLogic.getBoardList(pbmVO);
      pMap.addAttribute("boardList", boardList);
      
      return "forward:List.jsp"; //webcontent/board/List.jsp~
   }
   @RequestMapping(value="jSonGetBoardList.kosmo")
   public String jSonGetBoardList(ModelMap pMap, @ModelAttribute BoardMasterVO pbmVO){
      //�𵨸ʵ� ����������, ������ ȭ�鿡 ������ �ϹǷ� �𵨸� �ʿ��ϴ�   
      List<Map<String,Object>> boardList = null;
      //ȭ�鿡 ��ȸ����� ����ϰ� �;��
      
      logger.info("getBoardList ȣ�⼺��");
      
      boardList=boardLogic.getBoardList(pbmVO);
      pMap.addAttribute("boardList", boardList);
      
      return "forward:jsonGetBoardList.jsp"; //webcontent/board/List.jsp~
   }
   @RequestMapping(value="writeForm.kosmo")
   public String writeForm(){
      return "redirect:writeForm.jsp"; //webcontent/board/writeForm.jsp~
   }
   //�۾��� ó�� ����
   @RequestMapping(value="boardInsert.kosmo")
   public String boardInsert(@ModelAttribute BoardMasterVO pbmVO,
      @ModelAttribute BoardSubVO pbsVO){
      
      int results[] = null;
      results = boardLogic.boardInsert(pbmVO, pbsVO);
      return "redirect:getBoardList.kosmo";
      //forward�� ����Ʈ�Ҷ� ����
   }
   //�� ���� ȭ�� ȣ��(DB����:select)
   @RequestMapping(value="updateForm.kosmo")
   public String updateForm(ModelMap pMap, @ModelAttribute BoardMasterVO pbmVO){
      //1���� �˻������ ����ִ�(VO) �׷��Ƿ� ������ ���
      
      List<Map<String,Object>> boardList 
                  = boardLogic.getBoardList(pbmVO);
      //boardList.size()�� �󸶴�? 1
      Map<String,Object> rMap = null;
      if(boardList != null){
         rMap = boardList.get(0);
      }
      pMap.addAttribute("rMap",rMap);
      return "forward:updateForm.jsp";
   }
   //�� ���� �����ϱ�(DB����:update)
   @RequestMapping(value="boardUpdate.kosmo")
   public String boardUpdate(@ModelAttribute BoardMasterVO pbmVO, @ModelAttribute BoardSubVO pbsVO){
      int results[] = null;
      results = boardLogic.boardUpdate(pbmVO,pbsVO);
      return "redirect:getBoardList.kosmo";
   }
   //�ۻ��� ȭ������
   //��й�ȣ Ȯ���ϰ� �����ؾߵ� - read.jsp���� ���������ϹǷ� db��Ÿ���ȴ�.
   @RequestMapping(value="deleteForm.kosmo")
   public String deleteForm(){
      return "redirect:deleteForm.jsp";
   }
   //�� ���� ����(DB����:delete)
   //�ۻ����� ÷�������� ��� �����ǹǷ� ������VO�� ������
   @RequestMapping(value="boardDelete.kosmo")
   public String boardDelete(@ModelAttribute BoardMasterVO pbmVO,
         @ModelAttribute BoardSubVO pbsVO){
      int results[] = null;
      results = boardLogic.boardDelete(pbmVO,pbsVO);
      return "redirect:getBoardList.kosmo";
   }
   
}