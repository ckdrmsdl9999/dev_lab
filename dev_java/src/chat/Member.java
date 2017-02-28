package chat;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import chat.KosmoCRUD;
import chat.MemberVO;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.JSplitPane;
import javax.swing.JButton;

public class Member extends JFrame implements ActionListener{

   private JPanel jp_member;
   private JTextField tf_id;
   private JTextField tf_pw;
   private JTextField tf_pw2;
   private JTextField tf_hint_a1;
   private JTextField tf_hint_a2;
   private JTextField tf_name;
   private JTextField tf_hp;
   private JTextField tf_address;
   private JLabel label_1;
   private JLabel label_2;
   private JLabel label_3;
   private JLabel label_4;
   private JLabel label_5;
   private JLabel label_7;
   private JTextField tf_nickname;
   private JButton jb_ok;
   private JButton jb_cancel;
   private ButtonGroup bg;
   private JComboBox comboBox;
   private JComboBox comboBox_1;
   private JTextField tf_birth;
   private JLabel lblYyyyd;
   

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               Member frame = new Member();
               frame.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }
   
   public String getSelectedButtonText(ButtonGroup buttonGroup) {
       for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
           AbstractButton button = buttons.nextElement();

           if (button.isSelected()) {
               return button.getText();
           }
       }

       return null;
   }

   /**
    * Create the frame.
    */
   public Member() {
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 420, 541);
      jp_member = new JPanel();
      jp_member.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(jp_member);
      jp_member.setLayout(null);
      
     
       
      
      JLabel lblNewLabel = new JLabel("\uC544\uC774\uB514");
      lblNewLabel.setBounds(12, 38, 99, 15);
      jp_member.add(lblNewLabel);
      
      JLabel lblNewLabel_1 = new JLabel("\uBE44\uBC00\uBC88\uD638");
      lblNewLabel_1.setBounds(12, 63, 99, 15);
      jp_member.add(lblNewLabel_1);
      
      tf_id = new JTextField();
      tf_id.setBounds(110, 35, 148, 21);
      jp_member.add(tf_id);
      tf_id.setColumns(10);
      
      tf_pw = new JTextField();
      tf_pw.setColumns(10);
      tf_pw.setBounds(110, 60, 148, 21);
      jp_member.add(tf_pw);
      
      JLabel label = new JLabel("\uBE44\uBC00\uBC88\uD638 \uD655\uC778");
      label.setBounds(12, 88, 96, 21);
      jp_member.add(label);
      
      tf_pw2 = new JTextField();
      tf_pw2.setColumns(10);
      tf_pw2.setBounds(110, 88, 148, 21);
      jp_member.add(tf_pw2);
      
      label_1 = new JLabel("\uC774\uB984");
      label_1.setBounds(12, 155, 99, 15);
      jp_member.add(label_1);
      
      label_2 = new JLabel("\uC131\uBCC4");
      label_2.setBounds(12, 183, 99, 15);
      jp_member.add(label_2);
      
      label_3 = new JLabel("\uD578\uB4DC\uD3F0");
      label_3.setBounds(12, 208, 99, 15);
      jp_member.add(label_3);
      
      label_4 = new JLabel("\uD78C\uD2B81");
      label_4.setBounds(12, 255, 99, 15);
      jp_member.add(label_4);
      
      label_5 = new JLabel("\uD78C\uD2B82");
      label_5.setBounds(12, 309, 99, 15);
      jp_member.add(label_5);
      
      comboBox = new JComboBox();
      comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "\uC5B4\uBA38\uB2C8\uC758 \uACE0\uD5A5\uC740?", "\uC88B\uC544\uD558\uB294 \uCE90\uB9AD\uD130\uB294?", "\uC5B4\uB838\uC744 \uB54C \uAC00\uC7A5 \uCE5C\uD588\uB358 \uCE5C\uAD6C\uC758 \uBCC4\uBA85\uC740?"}));
      comboBox.setBounds(110, 252, 225, 21);
      jp_member.add(comboBox);
      
      comboBox_1 = new JComboBox();
      comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"", "\uAC00\uC7A5 \uC88B\uC544\uD558\uB294 \uC74C\uC2DD\uC740?", "\uCC98\uC74C\uC73C\uB85C \uD63C\uC790 \uB5A0\uB098\uBCF8 \uC5EC\uD589\uC9C0?", "\uAC00\uC7A5 \uC88B\uC544\uD558\uB294 \uC560\uC644\uB3D9\uBB3C?", "\uAC00\uC7A5 \uAC10\uBA85 \uAE4A\uAC8C \uBCF8 \uC601\uD654\uB294?"}));
      comboBox_1.setBounds(110, 306, 225, 21);
      jp_member.add(comboBox_1);
      
      tf_hint_a1 = new JTextField();
      tf_hint_a1.setBounds(110, 278, 225, 21);
      jp_member.add(tf_hint_a1);
      tf_hint_a1.setColumns(10);
      
      tf_hint_a2 = new JTextField();
      tf_hint_a2.setColumns(10);
      tf_hint_a2.setBounds(110, 334, 225, 21);
      jp_member.add(tf_hint_a2);
      
      tf_name = new JTextField();
      tf_name.setColumns(10);
      tf_name.setBounds(110, 152, 148, 21);
      jp_member.add(tf_name);
      
      tf_hp = new JTextField();
      tf_hp.setColumns(10);
      tf_hp.setBounds(110, 205, 148, 21);
      jp_member.add(tf_hp);
      
      JRadioButton radioButton = new JRadioButton("\uB0A8");
      radioButton.setBounds(110, 179, 68, 23);
      jp_member.add(radioButton);
      
      JRadioButton radioButton_1 = new JRadioButton("\uC5EC");
      radioButton_1.setBounds(190, 179, 68, 23);
      jp_member.add(radioButton_1);
      
      bg = new ButtonGroup();
      bg.add(radioButton);
      bg.add(radioButton_1);
      
      
      
      jb_ok = new JButton("\uD655\uC778");
      jb_ok.setBounds(108, 365, 97, 23);
      jp_member.add(jb_ok);
      
      jb_cancel = new JButton("\uCDE8\uC18C");
      jb_cancel.setBounds(238, 365, 97, 23);
      jp_member.add(jb_cancel);
      
      JLabel address = new JLabel("\uC8FC\uC18C");
      address.setBounds(12, 230, 99, 15);
      jp_member.add(address);
      
      tf_address = new JTextField();
      tf_address.setBounds(110, 227, 225, 21);
      jp_member.add(tf_address);
      tf_address.setColumns(10);
      
      JLabel label_6 = new JLabel("\uB2C9\uB124\uC784");
      label_6.setBounds(12, 119, 99, 15);
      jp_member.add(label_6);
      
      tf_nickname = new JTextField();
      tf_nickname.setBounds(110, 116, 148, 21);
      jp_member.add(tf_nickname);
      tf_nickname.setColumns(10);
      
      label_7 = new JLabel("\uC0DD\uB144\uC6D4\uC77C");
      label_7.setBounds(12, 208, 57, 15);
      jp_member.add(label_7);
      
      tf_birth = new JTextField();
      tf_birth.setBounds(110, 205, 148, 21);
      jp_member.add(tf_birth);
      tf_birth.setColumns(10);
      
      lblYyyyd = new JLabel("ex)19871107");
      lblYyyyd.setBounds(266, 208, 99, 15);
      jp_member.add(lblYyyyd);
      
      jb_ok.addActionListener(this);
      jb_cancel.addActionListener(this);
   }

@Override
public void actionPerformed(ActionEvent e) {
	
	
	
   if(jb_ok.equals(e.getSource())){
		   MemberVO mv = new MemberVO();
		   mv.setID(tf_id.getText());
		   mv.setPW(tf_pw.getText());
		   mv.setNICKNAME(tf_nickname.getText());
		   mv.setNAME(tf_name.getText());
		   mv.setGENDER(getSelectedButtonText(bg));
		   mv.setHP(tf_hp.getText());
		   mv.setADDRESS(tf_address.getText());
		   mv.setHINT1_Q(comboBox.getSelectedItem().toString());
		   mv.setHINT1_A(tf_hint_a1.getText());
		   mv.setHINT2_Q(comboBox_1.getSelectedItem().toString());
		   mv.setHINT2_A(tf_hint_a2.getText());
		   
		   KosmoCRUD kc = new KosmoCRUD();
		   kc.memberInsert(mv);
		     
		   System.out.println("가입성공");
		   
		   this.dispose();
		   
		   //this.dispose();
		   
		   //System.out.println(mv.hashCode());
		   
		   
		   
		   
		   
	   }
	   else if(jb_cancel.equals(e.getSource())){
		   System.exit(0);
	   }
	
	
	
	
	
	
	
	
}
	
	
	
	
	
	
}
