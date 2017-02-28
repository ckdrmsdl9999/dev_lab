package com.ch5;

import com.vo.DeptVO;
/*
 * DeptVO패턴은 오직 한 개로우만 담을 수 있다.
 * 해결방법
 * 객체배열을 사용하면 여러개의 로우도 담을 수 있다.
 * DeptVO[]
 */
public class DeptVOSimulation {

	public static void main(String[] args) {
		DeptVO dvo = new DeptVO();
		dvo.deptno = 10;
		System.out.println(dvo.deptno);//10
		dvo.deptno = 20;
		System.out.println(dvo.deptno);//10
		DeptVO dvo2 = null;
		System.out.println(dvo2);
		//System.out.println(dvo2.deptno);
		DeptVO dvos[] = new DeptVO[3];
		for(int i=0;i<dvos.length;i++){
			System.out.println(dvos[i]);//3번 출력 - null
		}
		//DeptVO배열의 안에 담을 수 있는 타입이 무엇입니까?
		dvos[0] = dvo;
		//dvos[1] = "쓰레기";//배열의 타입과 다른 타입은 담을 수 없다.
		//dvos[2] = 10;
	}

}







