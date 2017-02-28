package com.ch5;

public class TwoArray {
	int values[] = new int[72];
	int dans[][] = new int[8][9];
	void test(int val, int cnt)
	{
		values[cnt] = val;
	}
	void test2(int val, int row, int cols){
		dans[row][cols] = val;
	}
	public static void main(String[] args) {
		TwoArray ta = new TwoArray();
		int jumsu[][] = new int[3][4];
/*		for(int i=0;i<jumsu.length;i++){
			for(int j=0;j<jumsu[i].length;j++){
				System.out.println("jumsu["+i+"]["+j+"] = "+jumsu[i][j]);
			}
		}*/
		//구구단의 계산값을 담을 배열을 선언하시오.
		int gugu[][] = new int[8][9];
		int cnt = 0;
		int row = 0;
		for(int i=2;i<10;i++,row++){
			int cols = 0;
			for(int j=1;j<10;j++,cols++){
				System.out.println(row+", "+cols);
				//ta.test(i*j, cnt);
				cnt++;
				//if(cnt==72) break;
				ta.test2(i*j,row,cols);
			}
		}
		for(int i=0;i<ta.values.length;i++){
			System.out.println("values["+i+"]="+ta.values[i]);
		}
		for(int x=0;x<ta.dans.length;x++){
			for(int y=0;y<ta.dans[x].length;y++){
				System.out.println("dans["+x+"]["+y+"]="+ta.dans[x][y]);
			}
		}
	}
}
