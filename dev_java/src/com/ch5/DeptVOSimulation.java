package com.ch5;

import com.vo.DeptVO;
/*
 * DeptVO������ ���� �� ���ο츸 ���� �� �ִ�.
 * �ذ���
 * ��ü�迭�� ����ϸ� �������� �ο쵵 ���� �� �ִ�.
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
			System.out.println(dvos[i]);//3�� ��� - null
		}
		//DeptVO�迭�� �ȿ� ���� �� �ִ� Ÿ���� �����Դϱ�?
		dvos[0] = dvo;
		//dvos[1] = "������";//�迭�� Ÿ�԰� �ٸ� Ÿ���� ���� �� ����.
		//dvos[2] = 10;
	}

}







