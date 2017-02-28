package com.ch11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.chatting.Room;
import com.vo.DeptVO;

public class ListSimulation {
	List<String> nameList = new ArrayList<String>();
	List<Integer> year = new ArrayList<Integer>();
	List<DeptVO> deptList = new ArrayList<DeptVO>();//VO패턴-DB연동-오라클의 타입과 자바의 타입
	//오라클에서 정렬을 해서 내보내므로 
	List<HashMap<String,Object>> roomList2 = 
			new ArrayList<HashMap<String,Object>>();//대용량솔루션-순서가 없다.
	//사용자 정의 클래스 타입을 제네릭으로 처리하는 경우
	List<Room> roomList = new ArrayList<Room>();
	public void methodA(){
		year.add(1990);
		year.add(1992);
		year.add(1997);
		for(Integer iyear:year){
			System.out.println(iyear);
		}
	}
	public void methodB(){//제네릭-HashMap
		HashMap<String,Object> hmTitle =
				new HashMap<String,Object>();
		hmTitle.put("rtitle", "스마트웹개발23기");
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
	//insert here - 사용자 정의 클래스 타입을 적용할 경우
	public void methodC(){
		Room room24 = new Room();
		room24.setTitle("스마트웹개발24기");
		room24.setMax(25);
		room24.setState("대기실");
		List<String> userList = new ArrayList<String>();
		userList.add("하하");
		userList.add("나신입");
		userList.add("돈키호테");
		room24.setUserList(userList);
		roomList.add(room24);
		
		Room room25 = new Room();
		room25.setTitle("스마트웹개발25기");
		room25.setMax(30);
		room25.setState("대기실");
		List<String> userList2 = new ArrayList<String>();
		userList2.add("하하2");
		userList2.add("나신입2");
		userList2.add("돈키호테2");
		room25.setUserList(userList2);		
		roomList.add(room25);
		
		for(Room room:roomList){
			System.out.println("대화방이름:"+room.getTitle());
			System.out.println("최대 인원수:"+room.getMax());
			System.out.println("상태 :"+room.getState());
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
