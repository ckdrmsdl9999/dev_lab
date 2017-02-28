package pro_03;

import java.io.Reader;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
//import com.vo.AddressVO;

public class ChatDao {
	String nickname = null;
	
	public int join(ChatmemberVO pVO) {
		SqlMapClient sqlMap = null;
		String resource = "pro_03/SqlMapConfig.xml";
		Reader reader = null;
		int result = 0;// 입력이 성공했을 때 1, 실패했을 때 0
		try {
			reader = Resources.getResourceAsReader(resource);
			sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);
			reader.close();
			result = sqlMap.update("join", pVO);// 쿼리문 호출
			if (result == 1) {
				System.out.println("입력 성공");
			} else {
				System.out.println("입력 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// result = pstmt.executeUpdate();
		return result;
	}
	public int id_check(ChatmemberVO pVO) {
		int result =0;
		List<ChatmemberVO> List = null;
		SqlMapClient sqlMap = null;
		String resource = "pro_03/SqlMapConfig.xml";
		Reader reader = null;
		try {
			reader = Resources.getResourceAsReader(resource);
			sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);
			reader.close();
			List = sqlMap.queryForList("id_check", pVO);
			result = List.size();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(result);
		if(1==result){
			
		}else{
			
		}
		return result;
	}
	public int nick_check(ChatmemberVO pVO) {
		int result =0;
		List<ChatmemberVO> List = null;
		SqlMapClient sqlMap = null;
		String resource = "pro_03/SqlMapConfig.xml";
		Reader reader = null;
		try {
			reader = Resources.getResourceAsReader(resource);
			sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);
			reader.close();
			List = sqlMap.queryForList("nick_check", pVO);
			result = List.size();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(result);
		if(1==result){
			
		}else{
			
		}
		return result;
	}
	public List<ChatmemberVO> login(ChatmemberVO pVO) {
		List<ChatmemberVO> result = null;
		List<ChatmemberVO> List = null;
		SqlMapClient sqlMap = null;
		String resource = "pro_03/SqlMapConfig.xml";
		Reader reader = null;
		try {
			reader = Resources.getResourceAsReader(resource);
			sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);
			reader.close();
			List = sqlMap.queryForList("loginConfig", pVO);
			System.out.println(List);
			result = List;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(result);
		
		return result;
	}

	// 업데이트
	public int change(ChatmemberVO pVO) {
		SqlMapClient sqlMap = null;
		String resource = "pro_03/SqlMapConfig.xml";
		Reader reader = null;
		int result = 0;// 입력이 성공했을 때 1, 실패했을 때 0
		try {
			reader = Resources.getResourceAsReader(resource);
			sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);
			System.out.println("=====" + sqlMap);
			reader.close();
			result = sqlMap.update("change", pVO);// 쿼리문 호출
			if (result == 1) {
				System.out.println("수정 성공");
			} else {
				System.out.println("수정 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// result = pstmt.executeUpdate();
		return result;
	}

	public int delete(ChatmemberVO pVO) {
		System.out.println("delete호출");
		SqlMapClient sqlMap = null;
		String resource = "pro_03/SqlMapConfig.xml";
		Reader reader = null;
		int result = 0;// 입력이 성공했을 때 1, 실패했을 때 0
		try {
			reader = Resources.getResourceAsReader(resource);
			sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);
			reader.close();
			result = sqlMap.delete("delete", pVO);// 쿼리문 호출
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
