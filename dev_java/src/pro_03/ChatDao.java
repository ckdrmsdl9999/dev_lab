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
		int result = 0;// �Է��� �������� �� 1, �������� �� 0
		try {
			reader = Resources.getResourceAsReader(resource);
			sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);
			reader.close();
			result = sqlMap.update("join", pVO);// ������ ȣ��
			if (result == 1) {
				System.out.println("�Է� ����");
			} else {
				System.out.println("�Է� ����");
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

	// ������Ʈ
	public int change(ChatmemberVO pVO) {
		SqlMapClient sqlMap = null;
		String resource = "pro_03/SqlMapConfig.xml";
		Reader reader = null;
		int result = 0;// �Է��� �������� �� 1, �������� �� 0
		try {
			reader = Resources.getResourceAsReader(resource);
			sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);
			System.out.println("=====" + sqlMap);
			reader.close();
			result = sqlMap.update("change", pVO);// ������ ȣ��
			if (result == 1) {
				System.out.println("���� ����");
			} else {
				System.out.println("���� ����");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// result = pstmt.executeUpdate();
		return result;
	}

	public int delete(ChatmemberVO pVO) {
		System.out.println("deleteȣ��");
		SqlMapClient sqlMap = null;
		String resource = "pro_03/SqlMapConfig.xml";
		Reader reader = null;
		int result = 0;// �Է��� �������� �� 1, �������� �� 0
		try {
			reader = Resources.getResourceAsReader(resource);
			sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);
			reader.close();
			result = sqlMap.delete("delete", pVO);// ������ ȣ��
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
