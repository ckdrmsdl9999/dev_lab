package com.ch7;

import com.vo.DeptVO;

public class DeptVOTest {

	public static void main(String[] args) {
		DeptVO dvo = new DeptVO();
		dvo.setDeptno(10);
		dvo.setDname("����");
		dvo.setLoc("�λ�");
		DeptVO dvo2 = new DeptVO(20,"�ѹ�","����");
		//insert here �μ���ȣ, �μ���, ������ ����Ͻÿ�.
		System.out.println(dvo.getDeptno()+", "+dvo.getDname()+", "+dvo.getLoc());
		System.out.println(dvo2.getDeptno()+", "+dvo2.getDname()+", "+dvo2.getLoc());
	}

}
