package com.util;

import java.io.File;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


public class HashMapBinder {
	Logger logger = Logger.getLogger(HashMapBinder.class);
	public HttpServletRequest request = null;
	//÷������ ���� �߰� ����
	MultipartRequest multi = null;//cos.jar���� �����ϴ� Ŭ����
	String realFolder = "";//÷�������� �ø� �������� ��ġ
	String saveFolder = "pds";//÷������ ���ε� ��ġ
	String encType = "euc-kr";//÷������ �ѱ�ó������
	int maxSize = 5*1024*1024;//÷������ ���ε� ũ�� ���� - 5MB
	
	public HashMapBinder(){}
	public HashMapBinder(HttpServletRequest request){
		this.request = request;//��ü ����
		realFolder = "E:\\dev_lab\\dev_ajax\\WebContent\\pds";
	}
	public void binder(Map<String,Object> pMap){
		pMap.clear();
		//Enumeration�ȿ��� String�ִ�.- name, address, pet
		//���� ����
		//Map�迭�� key�� �ߺ� �� �� �����ϴ�.
		String values[] = request.getParameterValues("pet");
		if(values !=null){
			for(String str:values){
				if("dog".equals(str)){
					pMap.put(str, str);//pMap.put("dog", "dog");
				}
				else if("cat".equals(str)){
					pMap.put(str, str);
				}
				else if("pig".equals(str)){
					pMap.put(str, str);
				}
			}
		}
		Enumeration<String> en = request.getParameterNames();
		while(en.hasMoreElements()){
			String key = en.nextElement();//name, address, pet
			if("pet".equals(key)){
				continue;//���ǽ��� �����ϸ� while�� ���ǽ����� �̵�
			}
			pMap.put(key, HangulConversion.toKor(request.getParameter(key)));//������, ����� ������, pig, dog, cat
		}
	}//////////////////////////// end of bind
	//���� ���ε� ó���� �� ����� �޼ҵ� �����ϱ�
	//@param BookInsertAction���� �����Ͽ� �Ķ���ͷ� �ѱ�ϴ�.
	public void multiBind(Map<String,Object> pMap){
		try {
			multi = new MultipartRequest(request
					,realFolder
					,maxSize
					,encType
					,new DefaultFileRenamePolicy());
			//<input type="text" id="iab_title" name="ab_title">
			Enumeration<String> en = multi.getParameterNames();//ab_title, ab_author, ab_img
			String name = "";
			while(en.hasMoreElements()){
				name = en.nextElement();
				pMap.put(name, multi.getParameter(name));
			} 
			//���۵� ���� ������ ��������
			Enumeration<String> files = multi.getFileNames();
			File file = null;
			while(files.hasMoreElements()){
				String fname = files.nextElement();
				String filename = multi.getFilesystemName(fname);
				pMap.put("ab_img", filename);
				file = multi.getFile(fname);
			}
			//÷�������� ũ�⸦ ���� ���� ����
			long size = 0;
			if(file !=null){
				size = file.length();//������ ũ�⸦ ����ؼ� size���
				pMap.put("ab_size", size);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}////////////////////end of try
	}////////////////////////end of multiBind
	
}









