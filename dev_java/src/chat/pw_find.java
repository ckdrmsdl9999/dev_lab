package chat;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class pw_find extends JFrame implements ActionListener{

   JPanel jp_pw_find;
   JTextField tf_id;
   JTextField tf_hint1_A;
   JTextField tf_hint2_A;
   JLabel jlb_hint1_A;
   JLabel jlb_hint2_Q;
   JLabel jlb_hint2_A;
   JComboBox comboBox;
   JComboBox comboBox_1;
   JButton jb_pw_find_ok = new JButton("확인");
   JButton jb_pw_find_cancel = new JButton("취소");
   JButton jb_id_find = new JButton("조회");
   
   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               pw_find frame = new pw_find();
               frame.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }

   /**
    * Create the frame.
    */
   public pw_find() {
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 386, 285);
      jp_pw_find = new JPanel();
      jp_pw_find.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(jp_pw_find);
      jp_pw_find.setLayout(null);
      
      JLabel lblNewLabel = new JLabel("ID");
      lblNewLabel.setBounds(25, 36, 57, 15);
      jp_pw_find.add(lblNewLabel);
      
      tf_id = new JTextField();
      tf_id.setBounds(105, 33, 142, 21);
      jp_pw_find.add(tf_id);
      tf_id.setColumns(10);
      
      comboBox = new JComboBox();
      comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "\uC5B4\uBA38\uB2C8\uC758 \uACE0\uD5A5\uC740?", "\uC88B\uC544\uD558\uB294 \uCE90\uB9AD\uD130\uB294?", "\uC5B4\uB838\uC744 \uB54C \uAC00\uC7A5 \uCE5C\uD588\uB358 \uCE5C\uAD6C\uC758 \uBCC4\uBA85\uC740?"}));
      comboBox.setBounds(105, 78, 224, 21);
     
      jp_pw_find.add(comboBox);
      
      comboBox_1 = new JComboBox();
      comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"", "\uAC00\uC7A5 \uC88B\uC544\uD558\uB294 \uC74C\uC2DD\uC740?", "\uCC98\uC74C\uC73C\uB85C \uD63C\uC790 \uB5A0\uB098\uBCF8 \uC5EC\uD589\uC9C0?", "\uAC00\uC7A5 \uC88B\uC544\uD558\uB294 \uC560\uC644\uB3D9\uBB3C?", "\uAC00\uC7A5 \uAC10\uBA85 \uAE4A\uAC8C \uBCF8 \uC601\uD654\uB294?"}));
      comboBox_1.setBounds(105, 137, 224, 21);
      jp_pw_find.add(comboBox_1);
      
      tf_hint1_A = new JTextField();
      tf_hint1_A.setBounds(105, 109, 172, 21);
      jp_pw_find.add(tf_hint1_A);
      tf_hint1_A.setColumns(10);
      
      tf_hint2_A = new JTextField();
      tf_hint2_A.setBounds(105, 168, 172, 21);
      jp_pw_find.add(tf_hint2_A);
      tf_hint2_A.setColumns(10);
      
      JLabel jlb_hint1_Q = new JLabel("힌트1");
      jlb_hint1_Q.setBounds(25, 81, 57, 15);
      jp_pw_find.add(jlb_hint1_Q);
      
      jlb_hint1_A = new JLabel("힌트1 정답");
      jlb_hint1_A.setBounds(25, 112, 74, 15);
      jp_pw_find.add(jlb_hint1_A);
      
      jlb_hint2_Q = new JLabel("힌트2");
      jlb_hint2_Q.setBounds(25, 140, 57, 15);
      jp_pw_find.add(jlb_hint2_Q);
      
      jlb_hint2_A = new JLabel("힌트2 정답");
      jlb_hint2_A.setBounds(25, 171, 74, 15);
      jp_pw_find.add(jlb_hint2_A);
      
      jb_pw_find_ok.addActionListener(this);
      jb_pw_find_ok.setBounds(60, 214, 97, 23);
      jp_pw_find.add(jb_pw_find_ok);
      
      jb_pw_find_cancel.addActionListener(this);
      jb_pw_find_cancel.setBounds(210, 214, 97, 23);
      jp_pw_find.add(jb_pw_find_cancel);
      
      jb_id_find.setBounds(261, 32, 68, 23);
      jp_pw_find.add(jb_id_find);
      jb_id_find.addActionListener(this);
   }

@Override
public void actionPerformed(ActionEvent ae) {
	
	    KosmoCRUD KC = new KosmoCRUD();
	    Object obj = ae.getSource();
	    if(obj==jb_pw_find_ok){
		String ID=       tf_id.getText();
		String HINT1_Q = comboBox.getSelectedItem().toString();
		String HINT1_A = tf_hint1_A.getText();
		String HINT2_Q = comboBox_1.getSelectedItem().toString();
		String HINT2_A = tf_hint2_A.getText();
		String PW = null;
		
		System.out.println(ID);
		System.out.println(HINT1_Q);
		System.out.println(HINT2_Q);
		System.out.println(HINT1_A);
		System.out.println(HINT2_A);
	
		PW = KC.memberfind(ID, HINT1_Q, HINT2_Q, HINT1_A, HINT2_A);
		if(PW!=null){
		JOptionPane.showMessageDialog(this
                , "당신 아이디의 암호는 "+PW+"입니다.", "Error"
                , JOptionPane.ERROR_MESSAGE); 
		
		}
	}else if(obj == jb_pw_find_cancel){
		System.exit(0);
		
	}else if(obj == jb_id_find){
		String ID = tf_id.getText();
		System.out.println(ID);
		if(KC.memberLogin(ID)==null)
		{
			JOptionPane.showMessageDialog(this
                    , "아이디 존재하지 않음", "Error"
                    , JOptionPane.ERROR_MESSAGE); 
		}
		else{
			JOptionPane.showMessageDialog(this
                    , "아이디 존재함", "INFO"
                    , JOptionPane.INFORMATION_MESSAGE); 
			}
		}
	}
}