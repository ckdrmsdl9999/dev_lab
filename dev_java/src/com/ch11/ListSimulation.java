package com.ch11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.chatting.Room;
import com.vo.DeptVO;

public class ListSimulation {
	List<String> nameList = new ArrayList<String>();
	List<Integer> year = new ArrayList<Integer>();
	List<DeptVO> deptList = new ArrayList<DeptVO>();//VO����-DB����-����Ŭ�� Ÿ�԰� �ڹ��� Ÿ��
	//����Ŭ���� ������ �ؼ� �������Ƿ� 
	List<HashMap<String,Object>> roomList2 = 
			new ArrayList<HashMap<String,Object>>();//��뷮�ַ��-������ ����.
	//����� ���� Ŭ���� Ÿ���� ���׸����� ó���ϴ� ���
	List<Room> roomList = new ArrayList<Room>();
	public void methodA(){
		year.add(1990);
		year.add(1992);
		year.add(1997);
		for(Integer iyear:year){
			System.out.println(iyear);
		}
	}
	public void methodB(){//���׸�-HashMap
		HashMap<String,Object> hmTitle =
				new HashMap<String,Object>();
		hmTitle.put("rtitle", "����Ʈ������23��");
		roomList2.add(hmTitle);
		HashMap<String,Object> hmPw =
				new HashMap<String,Object>();
		hmPw.put("rpw", "smart123");
		roomList2.add(hmPw);
		HashMap<String,Object> hmInwon =
				new HashMap<String,Object>();
		hmInwon.put("rInwon", 20);
		roomList2.add(hmInwon);	
		for(HashMap pMap:roomList2){
			Object[] keys = pMap.keySet().toArray();
			System.out.println(keys[0]+":"+pMap.get(keys[0]));
		}
	}
	//insert here - ����� ���� Ŭ���� Ÿ���� ������ ���
	public void methodC(){
		Room room24 = new Room();
		room24.setTitle("����Ʈ������24��");
		room24.setMax(25);
		room24.setState("����");
		List<String> userList = new ArrayList<String>();
		userList.add("����");
		userList.add("������");
		userList.add("��Űȣ��");
		room24.setUserList(userList);
		roomList.add(room24);
		
		Room room25 = new Room();
		room25.setTitle("����Ʈ������25��");
		room25.setMax(30);
		room25.setState("����");
		List<String> userList2 = new ArrayList<String>();
		userList2.add("����2");
		userList2.add("������2");
		userList2.add("��Űȣ��2");
		room25.setUserList(userList2);		
		roomList.add(room25);
		
		for(Room room:roomList){
			System.out.println("��ȭ���̸�:"+room.getTitle());
			System.out.println("�ִ� �ο���:"+room.getMax());
			System.out.println("���� :"+room.getState());
			for(int i=0;i<room.getUserList().size();i++){
				System.out.print(room.getUserList().get(i));
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		ListSimulation ls = new ListSimulation();
		ls.methodA();
		System.out.println("===============================");
		ls.methodB();
		System.out.println("===============================");
		ls.methodC();
	}

}
