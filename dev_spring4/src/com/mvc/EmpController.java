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
import com.vo.EmpVO;

@Controller
@RequestMapping(value="/emp")
public class EmpController {
   Logger logger = Logger.getLogger(EmpController.class);
   @Autowired
   EmpLogic empLogic = null;
   
   
   @RequestMapping(value="uploadFile.kosmo")
   public String uploadFile(ModelMap pMap, @RequestParam("imgFile") MultipartFile imgFile){
      logger.info("uploadFile");
      String fileName = HangulConversion.toKor(imgFile.getOriginalFilename());
     
      logger.info("fileName:"+fileName);
      String path="C:\\Users\\H\\Desktop\\dev_lab\\dev_spring4\\WebContent\\pds\\";
      
      //÷������ �ߺ�ó���ϱ�
      String onlyFileName = fileName.substring(0, fileName.indexOf("."));
      logger.info("onlyFileName:"+onlyFileName);
      
      String extension = fileName.substring(fileName.indexOf("."));
      
      String rename = onlyFileName+"_"+DayTime.getCurrentDayTime();
      
      pMap.addAttribute("fileName",rename);
      
      
      if(imgFile != null){//÷������ �߰��ߴ�
         //���� �����ϴ� �����̸�!!�� ��ü�� �������ִ� Ŭ������ �ִ�(���� �����)
         File file = new File(path+rename);
         byte[] bytes;
         try {
            bytes = imgFile.getBytes();
            BufferedOutputStream bos = new BufferedOutputStream(
               new FileOutputStream(file));
            bos.write(bytes);
            bos.close();
         } catch (Exception e) {
            // TODO Auto-generated catch block
            logger.info(e.toString());
         } //��������
         
      }
      return "forward:fileDownload.jsp";
   }
   
   @RequestMapping(value="getEmpList.kosmo") //������� ����Ʈ
   public String getEmpList(ModelMap rMap, @RequestParam Map<String,Object> pMap){
      logger.info("EmpController : getEmpList");
      
      List<EmpVO> empList = empLogic.getEmpList(pMap);
      rMap.addAttribute("empList", empList);
      return "forward:jgetEmpList.jsp";
   }
   @RequestMapping(value="getEmpList2.kosmo") //������� ����Ʈ
   public String getEmpList2(ModelMap rMap, @RequestParam Map<String,Object> pMap){
      logger.info("EmpController : getEmpList");
      
      List<EmpVO> empList = empLogic.getEmpList2(pMap);
      rMap.addAttribute("empList", empList);
      return "forward:jgetEmpList.jsp";
   }
   
   @RequestMapping(value="empDelete.kosmo") //������� �����ϱ�
   public String empDelete(@RequestParam Map<String,Object> pMap){
	   
     
	   logger.info("EmpController : empDelete");
     
	   int result = 0 ;
	   
      result = empLogic.empDelete(pMap);
      
      return "redirect:getEmpList.jsp";
   }
   //./empInsert.kosmo
   @RequestMapping(value="empInsert.kosmo") //������� ����Ʈ
   public String empInsert(ModelMap rMap, @ModelAttribute EmpVO eVO){
      logger.info("EmpController : empInsert");
      
      int result = 0;
      
      logger.info(eVO.getDeptno());
      
      
      result = empLogic.empInsert(eVO);
      
      rMap.addAttribute("result", result);
      
      
      
      return "redirect:getEmpList.jsp?result="+result;
   } 
   
   
   @RequestMapping(value="empUpdate.kosmo") //������� ����Ʈ
   public String empUpdate(ModelMap rMap, @ModelAttribute EmpVO eVO){
      logger.info("EmpController : empInsert");
      
      int result = 0;
      
      logger.info(eVO.getDeptno());
      
      
      result = empLogic.empUpdate(eVO);
      
      rMap.addAttribute("result", result);
      
      
      
      return "redirect:getEmpList.jsp?result="+result;
   } 
   
   @RequestMapping(value="proc_salupdate.kosmo") //������� ����Ʈ
   public String proc_salupdate(ModelMap rMap, @ModelAttribute EmpVO eVO){
      logger.info("proc_salupdate : proc_salupdate");
      
      int result = 0;
      
      logger.info(eVO.getDeptno());
      
      
      empLogic.proc_salupdate(eVO);
      
      
      
      return "redirect:getEmpList.jsp?msg="+eVO.getMsg();
   } 
   
   
   
   
   
   
}