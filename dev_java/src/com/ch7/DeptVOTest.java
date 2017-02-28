package com.ch7;

import com.vo.DeptVO;

public class DeptVOTest {

	public static void main(String[] args) {
		DeptVO dvo = new DeptVO();
		dvo.setDeptno(10);
		dvo.setDname("영업");
		dvo.setLoc("부산");
		DeptVO dvo2 = new DeptVO(20,"총무","포항");
		//insert here 부서번호, 부서명, 지역을 출력하시오.
		System.out.println(dvo.getDeptno()+", "+dvo.getDname()+", "+dvo.getLoc());
		System.out.println(dvo2.getDeptno()+", "+dvo2.getDname()+", "+dvo2.getLoc());
	}

}
