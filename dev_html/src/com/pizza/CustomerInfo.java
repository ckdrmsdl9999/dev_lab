package com.pizza;

import com.vo.CustomerVO;

public class CustomerInfo {
	public CustomerVO cVOs[] = new CustomerVO[3];
	public void init(){
		CustomerVO cVO = 
				new CustomerVO("�̼���"
						      ,"02-245-3698"
						      ,"����� ������ ������");
		cVOs[0] = cVO;
		cVO = 
				new CustomerVO("������"
						      ,"02-365-1234"
						      ,"����� ���빮�� ����");
		cVOs[1] = cVO;
		cVO = 
				new CustomerVO("������"
						      ,"02-785-2560"
						      ,"����� ���α� ������");
		cVOs[2] = cVO;		
		
		
	}
}
