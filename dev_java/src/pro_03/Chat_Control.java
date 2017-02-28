package pro_03;


public class Chat_Control {
	private static final String LOGIN = "login";
	private static final String ID_CHECK = "id_check";
	private static final String NICK_CHECK = "nick_check";
	private static final String JOIN = "join";
	private static final String DELETE = "delete";

	public ChatmemberVO send(ChatmemberVO pVO) {
		ChatmemberVO rVO = null;
		ChatDao cd = new ChatDao();
		if (LOGIN.equals(pVO.getCommand())) {
			System.out.println("컨트롤 로그인 호출");
			cd.login(pVO);
		} else if (ID_CHECK.equals(pVO.getCommand())) {
			System.out.println("컨트롤 중복체크 호출");
			cd.id_check(pVO);
		} else if (NICK_CHECK.equals(pVO.getCommand())) {
			System.out.println("컨트롤 닉네임 체크 호출");
		} else if (JOIN.equals(pVO.getCommand())) {
			System.out.println("컨트롤 회원가입 호출");
			cd.join(pVO);
		}else if (DELETE.equals(pVO.getCommand())) {
			System.out.println("컨트롤 회원탈퇴 호출");
			cd.delete(pVO);
		}

		return rVO;

	}

}
