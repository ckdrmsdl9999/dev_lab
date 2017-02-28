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
  //ê��â
  back = getToolkit().getImage("./0.jpg");
  taSay = new JTextArea(30,50) {   
   public void paint(Graphics g) {
    g.drawImage(back, 0, 0, this);
    paintComponent(g);
   }
  };
  taSay.setOpaque(false);
  
  taLogin = new JTextArea(30,10);
  //ê��â����
  taSay.setEditable(false);
  //������â ����
  taLogin.setEditable(false);
  taLogin.setText("       << ������ >>");
  //�ʵ�
  tfTing = new JTextField(40);
  tfTing.addActionListener(this);
  //��ư
  btnSave = new JButton("����");
  btnOpen = new JButton("����");
  btnExit = new JButton("������");
  btnSave.addActionListener(this);
  btnOpen.addActionListener(this);
  btnExit.addActionListener(this);
  //ê��â,������â,�ʵ�â
  pnlCenter = new JPanel();
  pnlField = new JPanel();
  //ê��â�� ��ũ�ѹ� ����
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
   //������ ȭ�� ����� �ٷ� ����
   System.exit(0);  }
  
  if(o == tfTing) {
   //JTextFieldâ�� ���ڸ� �Է������� JTextArea â�� ���
   taSay.append(tfTing.getText() + "\n");  
   //���� �Է��� �ʱ�ȭ
   tfTing.setText("");
  }else if(o == btnSave) {
   int val = ch.showSaveDialog(this);
   if(val == JFileChooser.APPROVE_OPTION) {
    //������ ������ �̸�
    File f = ch.getSelectedFile();
    //ê��â�� ������ ������ ��.
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
    //�ҷ��� ����
    File f = ch.getSelectedFile();
    FileReader reader = null;
    try {
     reader = new FileReader(f);
     char[] buf = new char[500];
     int c = 0;
     while(( c = reader.read(buf)) != -1) {
      //ê��â�� ���̱�
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