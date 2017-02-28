package com.projectTest;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Chat extends JFrame implements ActionListener {
 JTextArea taSay;
 JTextArea taLogin;
 JTextField tfTing;
 JButton btnSave;
 JButton btnOpen;
 JButton btnExit;
 
 JPanel pnlField;
 JPanel pnlCenter;
 
 Image back;
 
 Chat(String title) {
  super(title);
  this.init();
  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 }
 
 private void init() {
  //챗팅창
  back = getToolkit().getImage("./0.jpg");
  taSay = new JTextArea(30,50) {   
   public void paint(Graphics g) {
    g.drawImage(back, 0, 0, this);
    paintComponent(g);
   }
  };
  taSay.setOpaque(false);
  
  taLogin = new JTextArea(30,10);
  //챗팅창고정
  taSay.setEditable(false);
  //접속자창 고정
  taLogin.setEditable(false);
  taLogin.setText("       << 접속자 >>");
  //필드
  tfTing = new JTextField(40);
  tfTing.addActionListener(this);
  //버튼
  btnSave = new JButton("저장");
  btnOpen = new JButton("열기");
  btnExit = new JButton("나가기");
  btnSave.addActionListener(this);
  btnOpen.addActionListener(this);
  btnExit.addActionListener(this);
  //챗팅창,접속자창,필드창
  pnlCenter = new JPanel();
  pnlField = new JPanel();
  //챗팅창에 스크롤바 생성
//  JScrollPane jp = new JScrollPane(taSay);
//  jp.setOpaque(false);
  
  pnlCenter.add(new JScrollPane(taSay));
  pnlCenter.add(taLogin);
  pnlCenter.setOpaque(false);
  pnlField.add(tfTing);
  pnlField.add(btnSave);
  pnlField.add(btnOpen);
  pnlField.add(btnExit);
 
  this.setBounds(150,100,700,650);
  this.getContentPane().add(pnlCenter,BorderLayout.CENTER);
  this.getContentPane().add(pnlField,BorderLayout.SOUTH);
  this.getContentPane().add(new JScrollPane(pnlCenter));
  
  taLogin.setBackground(Color.LIGHT_GRAY);
  btnSave.setBackground(Color.CYAN);
  btnOpen.setBackground(Color.PINK);
  btnExit.setBackground(Color.ORANGE);
  
  this.setVisible(true);
  back = back.getScaledInstance(taSay.getWidth(), taSay.getHeight(), Image.SCALE_DEFAULT);
 }
 public void actionPerformed(ActionEvent ae) {
  Object o = ae.getSource();
  JFileChooser ch = new JFileChooser();
  
  if(o==btnExit) {
   //나가기 화면 종료시 바로 종료
   System.exit(0);  }
  
  if(o == tfTing) {
   //JTextField창에 글자를 입력했을시 JTextArea 창에 출력
   taSay.append(tfTing.getText() + "\n");  
   //글자 입력을 초기화
   tfTing.setText("");
  }else if(o == btnSave) {
   int val = ch.showSaveDialog(this);
   if(val == JFileChooser.APPROVE_OPTION) {
    //저장할 파일의 이름
    File f = ch.getSelectedFile();
    //챗팅창의 내용을 가지고 옴.
    String str = taSay.getText();
    FileWriter writer = null;
    try {
     writer = new FileWriter(f);
     writer.write(str);
     writer.flush();
    }catch(Exception e) {
     e.printStackTrace();
    }finally {
     try {
      writer.close();
     }catch(Exception e) {}
    }
   }
  }else if(o == btnOpen) {
   
   taSay.setText("");
   int val = ch.showOpenDialog(this);
   
   if(val == JFileChooser.APPROVE_OPTION) {
    //불러올 파일
    File f = ch.getSelectedFile();
    FileReader reader = null;
    try {
     reader = new FileReader(f);
     char[] buf = new char[500];
     int c = 0;
     while(( c = reader.read(buf)) != -1) {
      //챗팅창에 붙이기
      taSay.append(new String(buf,0,c));
     
     }
    }catch(Exception e) {
    }
   }
  }
 }
 public static void main(String[] args) {
  new Chat("CHATTING");
  
 }
}