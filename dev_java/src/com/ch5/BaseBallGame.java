package com.ch5;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class BaseBallGame implements ActionListener {
	//선언부
	//메뉴바 추가하기
	JMenuBar 	jmb 	= new JMenuBar();
	JMenu 		jm_file = new JMenu("파일");
	JMenuItem	jmi_new = new JMenuItem("새게임");
	JMenuItem	jmi_dap = new JMenuItem("정답");
	JMenuItem	jmi_exit = new JMenuItem("종료");
	//JFrame은 자바에서 제공하는 클래스 입니다.
//	javax.swing.JFrame jf_game = new javax.swing.JFrame();
	JFrame jf_game = new JFrame();
	//JFrame에 붙일 속지 두 개 선언하고 생성하기
	JPanel jp_center = new JPanel();
	//배치-jp_center속지에 중앙에 배치하자
	JTextArea jta_display = new JTextArea();
	//JTextArea에 스크롤 바 추가하기
	JScrollPane jsp_display = new JScrollPane(jta_display);
	//배치-jp_center속지에 남쪽에 배치하자
	JTextField jtf_input = new JTextField();
	JPanel jp_east = new JPanel();
	//새게임버튼, 정답버튼, 지우기버튼, 종료버튼-> jp_east속지에 배치해 보자.
	JButton jbt_new = new JButton("새게임");
	JButton jbt_dap = new JButton("정답");
	JButton jbt_clear = new JButton("지우기");
	JButton jbt_exit = new JButton("종료");
	Font f = new Font("Thoma",Font.BOLD,14);
	int cnt = 0;//전역변수
	int com[] = new int[3];//컴터가 채번한 숫자 담기
	int my[] = new int[3];//사용자가 입력한 값 담기
	public BaseBallGame(){
		nanSu();
	}
	//사용자가 입력한 숫자를 받아서 배열에 담기 구현
	/*********************************************************************************/
	//유저숫자 입력
	void userInput(String input){
		if(input.length()!=3){
			JOptionPane.showMessageDialog(jf_game, "세자리 숫자만 입력하세요."
					                    , "INFO", JOptionPane.INFORMATION_MESSAGE);
			return;//userInput메소드 탈출
		}		
		int temp = 0;
		temp = Integer.parseInt(input);
		my[0] = temp/100;//1
		my[1] = (temp%100)/10;//2
		my[2] = temp%10;//3		
	}//////////////// end of userInput /////////////////	 
	/*********************************************************************************/
	//세자리 숫자 체번하는 메소드 구현
	/**********************************************************************************/
	//숫자 3개 랜덤생성
	public void nanSu()
	{
		com[0] = (int)(Math.random()*10);
		do{
			com[1] = (int)(Math.random()*10);
		}while(com[0]==com[1]);
		do{
			com[2] = (int)(Math.random()*10);
		}while(com[0]==com[2] || com[1]==com[2]);
	}
	/**********************************************************************************/
	//화면처리 하기
	public void initDisplay(){
		java.lang.System.out.println("initDisplay 호출 성공");
		//메뉴아이템, 메뉴, 메뉴바 추가하기
		jm_file.add(jmi_new);
		jm_file.add(jmi_dap);
		jm_file.add(jmi_exit);
		jmb.add(jm_file);
		jf_game.setJMenuBar(jmb);
		//이벤트 소스와 이벤트 처리를 담당하는 핸들러 클래스의 연결
		jbt_new.addActionListener(this);
		jbt_dap.addActionListener(this);
		jbt_clear.addActionListener(this);//this=>BaseBallGame=>actionPerformed메소드가 내안에 있을 때
		jtf_input.addActionListener(this);
		jbt_exit.addActionListener(this);
		jp_center.setLayout(new BorderLayout(0,20));
		jp_east.setLayout(new GridLayout(4,1,2,2));
		//jp_center.setBackground(Color.BLUE);
		//jp_east.setBackground(Color.GREEN);
		//jp_center속지에 jta_display를 중앙에 배치하고
		//jp_center속지에 jtf_input을 배치하자.
		jp_center.add("Center",jsp_display);
		jp_center.add("South",jtf_input);
		//버튼에 폰트 지정하기
		jbt_new.setFont(f);
		jbt_dap.setFont(f);
		jbt_clear.setFont(f);
		jbt_exit.setFont(f);
		//버튼에 색깔 입히기
		jbt_new.setBackground(new Color(158,9,9));
		jbt_new.setForeground(new Color(212,212,212));
		jbt_dap.setBackground(new Color(19,99,57));
		jbt_dap.setForeground(new Color(212,212,212));
		jbt_clear.setBackground(new Color(7,84,170));
		jbt_clear.setForeground(new Color(212,212,212));
		jbt_exit.setBackground(new Color(54,54,54));
		jbt_exit.setForeground(new Color(212,212,212));
		//jp_east속지에 버튼 4개 붙이기
		jp_east.add(jbt_new);
		jp_east.add(jbt_dap);
		jp_east.add(jbt_clear);
		jp_east.add(jbt_exit);
		jf_game.setBackground(new Color(214,211,206));
		//속지 두 장을 JFrame에 붙이기
		jf_game.add("Center",jp_center);
		jf_game.add("East",jp_east);
		String title = "야구숫자게임";
		jf_game.setTitle(title);
		jf_game.setSize(300,350);
		jf_game.setVisible(true);
	}
	//볼 판정 하기
	String Ya9Run()
	{
		int ball=0;
		int strike=0;	
		//////////// 볼 판정 시작 ////////////////
		for(int i=0; i<com.length; i++)
		{
			for(int j=0; j<my.length; j++)
			{
				//숫자가 존재하니? - true:볼 확보
				if(com[i]==my[j]){
				//자리도 일치하니? - true:스트라이크 확보
					if(i==j){
						strike++;
					}
					else{
						ball++;
					}
				}
			}///////////out of end inner for
		}///////////////out of end outter for
		//////////// 볼 판정 끝 /////////////////
	   if(strike==3)
	   {
		   return "정답입니다.";
	   }
	   return strike+"스"+ball+"볼 아직 멀었네요";
	}/////////////// end of ya9Run /////////////////	
	//이벤트 처리 하기
	
	//메인메소드
	//20-21-22-11-12
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		BaseBallGame bGame = new BaseBallGame();
		bGame.initDisplay();//메소드 호출
	}
	//actionPerformed메소드는 콜백메소드
	@Override 
	public void actionPerformed(ActionEvent ae) {
		//이벤트가 발생한 컴포넌트에 주소번지 가져오기 - 어떤 버튼을 눌렀니?
		Object obj = ae.getSource();//지우기버튼의 주소번지 가져오기
		//System.out.println(jbt_clear+" , "+ae.getSource());
		//지우기 버튼을 클릭했을 때 호출
		if(obj==jbt_clear){
			jta_display.setText("");
		}
		//새게임버튼을 클릭했니?
		else if(obj == jbt_new){
			cnt = 0;
			nanSu();
			jta_display.setText("");
			jtf_input.setText("");
			jtf_input.requestFocus();
		}
		//정답버튼을 클릭했니?
		//이벤트소스의 주소번지와 정답버튼의 주소번지가 같니?
		else if(obj==jbt_dap){
			System.out.println("==========정답버튼 클릭 테스트==========");
			jta_display.append("정답은 "+com[0]
					                    +com[1]
					                    +com[2]+"\n");
		}
		//사용자가 값을 입력하고 엔터 쳤을 때 호출
		else if(obj==jtf_input){
			String user = jtf_input.getText();//사용자가 입력한 세자리 숫자 저장된다.
			userInput(user);	
			jta_display.append(++cnt+"."+user+" : "+Ya9Run()+"\n");
			jtf_input.setText("");
		}
		//종료 버튼을 클릭했을 때 호출
		else if(obj==jbt_exit){
			System.exit(0);//자바가상머신과 연결고리가 끊긴다.
		}
	}///////////////////// end of actionPerformed ///////////////////////
}
