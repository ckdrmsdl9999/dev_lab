package com.ch5;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class BaseBallGameArray implements ActionListener {
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
	JButton jbtns[] = new JButton[4];
	String btn_label[] = {"새게임","정답","지우기","종료"};
	Font f = new Font("Thoma",Font.BOLD,14);
	int count = 0;//전역변수
	//화면처리 하기
	public void initDisplay(){
		java.lang.System.out.println("initDisplay 호출 성공");
		//메뉴아이템, 메뉴, 메뉴바 추가하기
		jm_file.add(jmi_new);
		jm_file.add(jmi_dap);
		jm_file.add(jmi_exit);
		jmb.add(jm_file);
		jf_game.setJMenuBar(jmb);
		jp_east.setLayout(new GridLayout(4,1,2,2));
		for(int i=0;i<jbtns.length;i++){
			jbtns[i] = new JButton(btn_label[i]);
			//버튼에 폰트 지정하기
			jbtns[i].setFont(f);
			//jp_east속지에 버튼 4개 붙이기
			jp_east.add(jbtns[i]);		
		}
		//이벤트 소스와 이벤트 처리를 담당하는 핸들러 클래스의 연결
		jbtns[2].addActionListener(this);//this=>BaseBallGame=>actionPerformed메소드가 내안에 있을 때
		jtf_input.addActionListener(this);
		jbtns[3].addActionListener(this);
		jp_center.setLayout(new BorderLayout(0,20));
		//jp_center.setBackground(Color.BLUE);
		//jp_east.setBackground(Color.GREEN);
		//jp_center속지에 jta_display를 중앙에 배치하고
		//jp_center속지에 jtf_input을 배치하자.
		jp_center.add("Center",jsp_display);
		jp_center.add("South",jtf_input);

		//버튼에 색깔 입히기
		jbtns[0].setBackground(new Color(158,9,9));
		jbtns[0].setForeground(new Color(212,212,212));
		jbtns[1].setBackground(new Color(19,99,57));
		jbtns[1].setForeground(new Color(212,212,212));
		jbtns[2].setBackground(new Color(7,84,170));
		jbtns[2].setForeground(new Color(212,212,212));
		jbtns[3].setBackground(new Color(54,54,54));
		jbtns[3].setForeground(new Color(212,212,212));

		jf_game.setBackground(new Color(214,211,206));
		//속지 두 장을 JFrame에 붙이기
		jf_game.add("Center",jp_center);
		jf_game.add("East",jp_east);
		String title = "야구숫자게임-배열";
		jf_game.setTitle(title);
		jf_game.setSize(300,350);
		jf_game.setVisible(true);
	}
	//볼 판정 하기
	
	//이벤트 처리 하기
	
	//메인메소드
	//20-21-22-11-12
	public static void main(String[] args) {
		BaseBallGameArray bGame = new BaseBallGameArray();
		bGame.initDisplay();//메소드 호출
	}
	//actionPerformed메소드는 콜백메소드
	@Override 
	public void actionPerformed(ActionEvent ae) {
		//이벤트가 발생한 컴포넌트에 주소번지 가져오기 - 어떤 버튼을 눌렀니?
		Object obj = ae.getSource();//지우기버튼의 주소번지 가져오기
		//System.out.println(jbtns[2]+" , "+ae.getSource());
		//지우기 버튼을 클릭했을 때 호출
		if(obj==jbtns[2]){
			jta_display.setText("");
		}
		//사용자가 값을 입력하고 엔터 쳤을 때 호출
		else if(obj==jtf_input){
			String user = jtf_input.getText();
			jta_display.append(++count+"."+user+" : "+"0스 0볼"+"\n");
			jtf_input.setText("");
		}
		//종료 버튼을 클릭했을 때 호출
		else if(obj==jbtns[3]){
			System.exit(0);//자바가상머신과 연결고리가 끊긴다.
		}
	}
}
