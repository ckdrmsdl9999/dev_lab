package pro_03;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordTest {
	 public String SHA256(String str){
	  String SHA = ""; 
	  try{
	   MessageDigest sh = MessageDigest.getInstance("SHA-256"); 
	   sh.update(str.getBytes()); 
	   byte byteData[] = sh.digest();
	   StringBuffer sb = new StringBuffer(); 
	   for(int i = 0 ; i < byteData.length ; i++){
	    sb.append(Integer.toString((byteData[i]&0xff) + 0x100, 16).substring(1));
	   }
	   SHA = sb.toString();
	   System.out.println(SHA);
	  }catch(NoSuchAlgorithmException e){
	   e.printStackTrace(); 
	   SHA = null; 
	  }
	  return SHA;
	 }

	}