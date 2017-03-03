package com.mvc;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.util.DayTime;
import com.util.HangulConversion;
import com.vo.BoardMasterVO;
import com.vo.BoardSubVO;
import com.vo.BoardVO;

@Controller
@RequestMapping(value="/board")
public class BoardController {
	Logger logger = Logger.getLogger(BoardController.class);
	@Autowired
	public BoardLogic boardLogic = null;
	//�۾��� ȭ�� ���� - window.openȣ�� - ���ο� �������� ���� ��û�� �ѹ� �� �߻�
	@RequestMapping(value="writeForm.kosmo")
	public String writeForm(){
		return "redirect:writeForm.jsp";
	}
	//�ۻ� ó�� ����
	@RequestMapping(value="getBoardDetail.kosmo")
	public String getBoardDetail(ModelMap mMap, @ModelAttribute BoardMasterVO pbmVO)
	{
		List<Map<String,Object>> boardList = null;
		boardList = boardLogic.getBoardList(pbmVO);
		logger.info("boardList.size():"+boardList.size());
		mMap.put("boardList", boardList);
		return "forward:Read.jsp";
	}
	//�۾��� ó�� ����
	/*
	 * ������������ ����ڰ� �Է��� ����(�ݺ��ڵ�:request.getParameter())�� �ޱ� ���� �ڵ带 �ٿ��ֱ����ؼ�
	 * @ModelAttribute�� @RequestParam API�� �����ϰ� �ֽ��ϴ�.
	 *
	 */
	@RequestMapping(value="boardInsert.kosmo")
	public String boardInsert(@RequestParam("bfile") MultipartFile bfile,@ModelAttribute BoardMasterVO pbmVO, @ModelAttribute BoardSubVO pbsVO)
	{
		String fileName = HangulConversion.toKor
				(bfile.getOriginalFilename());
		logger.info("fileName:"+fileName);
		String path = "E:\\dev_lab\\dev_spring4\\WebContent\\pds\\";
		//÷������ �ߺ�ó���ϱ� - ���� history����
		//test.zip -> test_20170210161910.zip	
		//1)�����̸��� �����(test)
		String onlyFileName = 
			fileName.substring(0, fileName.indexOf("."));
		logger.info("onlyFileName : "+onlyFileName);
		//2)Ȯ���ڸ� �����(.zip)
		String extension = fileName.substring(fileName.indexOf("."));
		//3)�����̸� �������ϱ�
		String rename = onlyFileName+"_"+DayTime.getCurrentDayTime()+extension;
		pbsVO.setB_file(rename);
		if(bfile !=null){//÷������ �߰��ߴ�?
		//���� �����ϴ� �����̸��� ��ü�� �������ִ� Ŭ����
		//���Ͽ� ����ִ� ������� �����Ǵ� ���� �ƴϴ�.
		File file = new File(path+rename);
		try {
			//������ ���Ͼȿ� ����� ����Ʈ�� ��� �迭
			byte[] bytes = bfile.getBytes();//123
			//������ ũ��
			BufferedOutputStream bos
			=new BufferedOutputStream(
				new FileOutputStream(file));
			bos.write(bytes);//123���
			bos.close();
			long size = file.length();
			pbsVO.setB_size((double)size);//byte
		} catch (Exception e) {
			logger.info(e.toString());
		}
		}		
//post����� ����� ��� toKor�Լ��� �¿��� �Ѵ�.		
		pbmVO.setB_title(HangulConversion.toKor(pbmVO.getB_title()));
		pbmVO.setB_name(HangulConversion.toKor(pbmVO.getB_name()));
		pbmVO.setB_content(HangulConversion.toKor(pbmVO.getB_content()));
		int results[] = null;
		results = boardLogic.boardInsert(pbmVO,pbsVO);
		return "redirect:getBoardList.kosmo";
	}
	//�ۼ��� ȭ�� ȣ��(DB����:select)
	@RequestMapping(value="updateForm.kosmo")
	public String updateForm(ModelMap mMap,@ModelAttribute BoardMasterVO pbmVO)
	{
		List<Map<String,Object>> boardList 
			= boardLogic.getBoardList(pbmVO);
		//boardList.size()�� �󸶴�? - 1
		Map<String,Object> rMap = null;
		if(boardList !=null){
			//insert here
			rMap = boardList.get(0);
		}
		mMap.addAttribute("rMap", rMap);
		return "forward:updateForm.jsp";
	}
	//����ȸ �����ϱ�
	/*************************************************************************************
	 * ��ȸ ����� List�� ��� �ְ� �� �ּҹ����� ȭ�鿡 �Ѱܼ� �ͽ��������� ����ϸ�
	 * ȭ�鿡 ����ϱ�
	 * <%=pMap.get("B_TITLE")%> - �������� �ؽ�Ʈ�� �״�� ��µȴ�.
	 * @param mMap
	 * @param pbmVO
	 * @return List<Map<String,Object>>
	 * ��� ������ �̸� : List.jsp
	 *************************************************************************************/
	@RequestMapping(value="getBoardList.kosmo")
	public String getBoardList(ModelMap mMap,@ModelAttribute BoardMasterVO pbmVO)
	{
		
		List<Map<String,Object>> boardList = null;
		//insert here - ȭ�鿡 ��ȸ����� ����ϰ� �;��
		boardList = boardLogic.getBoardList(pbmVO);
		mMap.addAttribute("boardList", boardList);
		return "forward:List.jsp";
	}	
	//�� ��ȸ �����ϱ� - �ι�° �̼�(JSON�������� ��������)
	/*************************************************************************************
	 * List�� ��� �ִ� ������ JSON�������� ��������
	 * <%=pMap.get("B_TITLE")%> - �������� �ؽ�Ʈ�� �״�� ��µȴ�.
	 * @param mMap
	 * @param pbmVO
	 * @return List<Map<String,Object>>
	 * ��� ������ �̸� : jsonGetBoardList.jsp
	 *************************************************************************************/
	@RequestMapping(value="jSonGetBoardList.kosmo")
	public String jSonGetBoardList(ModelMap mMap,@ModelAttribute BoardMasterVO pbmVO)
	{
		List<Map<String,Object>> boardList = null;
		//insert here - ȭ�鿡 ��ȸ����� ����ϰ� �;��
		boardList = boardLogic.getBoardList(pbmVO);
		mMap.addAttribute("boardList", boardList);
		return "forward:jsonGetBoardList.jsp";
	}	
	//�ۼ��� �����ϱ�(DB����:update)
	@RequestMapping(value="boardUpdate.kosmo")
	public String boardUpdate(@ModelAttribute BoardMasterVO pbmVO
			                 ,@ModelAttribute BoardSubVO pbsVO)
	{
		int results[] = null;//1�̸� ���� ���� 0�̸� ��������
		results = boardLogic.boardUpdate(pbmVO,pbsVO);
		return "redirect:getBoardList.kosmo";
	}	
	//�ۻ��� ȭ������
	//��й�ȣ üũȭ��
	@RequestMapping(value="deleteForm.kosmo")
	public String deleteForm()
	{
		return "redirect:deleteForm.jsp";
	}
	//�ۻ��� �����ϱ�
	@RequestMapping(value="boardDelete.kosmo")
	public String boardDelete(@ModelAttribute BoardMasterVO pbmVO
			                , @ModelAttribute BoardSubVO pbsVO)
	{
		int results[] = null;
		results =boardLogic.boardDelete(pbmVO, pbsVO);
		return "redirect:getBoardList.kosmo";
	}
}










