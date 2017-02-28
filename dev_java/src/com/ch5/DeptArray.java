package com.ch5;

import com.vo.DeptVO;

public class DeptArray {
	void getDeptList(DeptVO dvos[]){
		for(int i=0;i<dvos.length;i++){
			DeptVO dvo = dvos[i];
			System.out.println(dvo.deptno+" , "+dvo.dname+" , "+dvo.loc);
		}
	}
	void getDeptList(int deptnos[], String dnames[], String locs[]){
		for(int i=0;i<deptnos.length;i++){
			System.out.println(deptnos[i]+" , "+dnames[i]+" , "+locs[i]);
		}
	}
	public static void main(String[] args) {
/*		int 	deptnos[] 	= {10,20,30,40};
		String 	dnames[] 	= {"ACCOUNTING","RESEARCH","SALES","OPERATIONS"};
		String 	locs[] 		= {"NEW YORK","DALLAS","CHICAGO","BOSTON"};
		for(int i=0;i<deptnos.length;i++){
			System.out.println(deptnos[i]+" , "+dnames[i]+" , "+locs[i]);
		}*/
		DeptVO dvos[] = new DeptVO[4];
		DeptVO dvo = new DeptVO();
		dvo.deptno = 10;
		dvo.dname = "ACCOUNTING";
		dvo.loc = "NEW YORK";
		dvos[0] = dvo;
		dvo = new DeptVO();
		dvo.deptno = 20;
		dvo.dname = "RESEARCH";
		dvo.loc = "DALLAS";
		dvos[1] = dvo;
		dvo = new DeptVO();
		dvo.deptno = 30;
		dvo.dname = "SALES";
		dvo.loc = "CHICAGO";
		dvos[2] = dvo;
		dvo = new DeptVO();
		dvo.deptno = 40;
		dvo.dname = "OPERATIONS";
		dvo.loc = "BOSTON";
		dvos[3] = dvo;
		DeptArray da = new DeptArray();
		da.getDeptList(dvos);
	}//////////////// end of main

}







