package com.test;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class TestController {
	Logger logger = Logger.getLogger(TestController.class);
	@RequestMapping(value="/test/methodA.kosmo")
	public String methodA(){
		logger.info("methodA ȣ�� ����");
		//������ ��û URL -> /WEB-INF/jsp/test/testMethodA.jsp 
		return "test/testMethodA";
	}
}
