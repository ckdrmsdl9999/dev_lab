package com.util;

import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;


public class HashMapBinder {
	Logger logger = Logger.getLogger(HashMapBinder.class);
	public HttpServletRequest request = null;
	public HashMapBinder(){}
	public HashMapBinder(HttpServletRequest request){
		this.request = request;//��ü ����
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
	}
}









