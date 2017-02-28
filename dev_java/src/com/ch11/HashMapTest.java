package com.ch11;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
public class HashMapTest {
	public List<HashMap<String,Object>> setDeptList()
	{
		List<HashMap<String,Object>> deptList = 
				new ArrayList<HashMap<String,Object>>();
		HashMap<String,Object> map = 
				new HashMap<String,Object>();
		map.put("deptno", 10);
		map.put("dname", "영업");
		map.put("loc", "부산");
		deptList.add(map);
		map = new HashMap<String,Object>();
		map.put("deptno", 20);
		map.put("dname", "총무");
		map.put("loc", "인천");
		deptList.add(map);
		map = new HashMap<String,Object>();
		map.put("deptno", 30);
		map.put("dname", "인사");
		map.put("loc", "서울");
		deptList.add(map);	
		map = new HashMap<String,Object>();
		map.put("deptno", 40);
		map.put("dname", "개발");
		map.put("loc", "서울");
		deptList.add(map);		
		//deptListPrint(deptList);
		return deptList;
	}
	public void deptListPrint
	(List<HashMap<String,Object>> deptList){
		for(int i=0;i<deptList.size();i++){
			HashMap rMap = deptList.get(i);
			System.out.println(rMap.get("deptno")
					     +", "+rMap.get("dname")
					     +", "+rMap.get("loc"));
		}
	}
	public Map<String, Object> setHashMap()
	{
		Map<String, Object> map
			=new HashMap<String,Object>();
		map.put("one", "이순신");
		map.put("two", "강감찬");
		map.put("three", "김유신");
		return map;
	}
	public void mapPrint(){
		Map<String, Object> map = setHashMap();
		Iterator it = map.keySet().iterator();
		//Set set = map.keySet();
		//Iterator iter = set.iterator();
		while(it.hasNext()){
			Object obj = it.next();//키가 저장됨.
			String value = (String)map.get(obj);
			System.out.println("key:"+obj+", value:"+value);
		}	
	}
	public void mapPrint2(){
		Map<String, Object> map = setHashMap();
		Object keys[] = map.keySet().toArray();//키값
		for(int i=0;i<keys.length;i++){
			String key = (String)keys[i];//키가 저장됨.
			String value = (String)map.get(key);
			System.out.println("key:"+key+", value:"+value);
		}	
	}	
	/***********************************************************
	 * Object배열을 String배열로 형전환은 가능하다.(컴파일에러무)
	 * 값을 꺼내 올때 ClassCastingException발생한다(런타임에러)
	 * 대입연산자 오른쪽에는 항상 자식타입이오는것이 안전하다.
	 **********************************************************/
	public void mapPrint3(){
		Map<String, Object> map = setHashMap();
		//String keys2[] = (String[])(map.keySet().toArray());//키값
		String keys2[] = null;
		for(int i=0;i<map.keySet().toArray().length;i++){
			keys2[i] = (String)(map.keySet().toArray()[i]);
		}
		for(int i=0;i<keys2.length;i++){
			String key = (String)keys2[i];//키가 저장됨.
			String value = (String)map.get(key);
			System.out.println("key:"+key+", value:"+value);
		}	
	}	
	public static void main(String[] args) {
		//insert here
		HashMapTest hmt = new HashMapTest();
		//hmt.mapPrint2();
		hmt.setDeptList();
	}

}
