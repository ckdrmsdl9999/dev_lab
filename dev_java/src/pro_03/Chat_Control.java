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
			System.out.println("��Ʈ�� �α��� ȣ��");
			cd.login(pVO);
		} else if (ID_CHECK.equals(pVO.getCommand())) {
			System.out.println("��Ʈ�� �ߺ�üũ ȣ��");
			cd.id_check(pVO);
		} else if (NICK_CHECK.equals(pVO.getCommand())) {
			System.out.println("��Ʈ�� �г��� üũ ȣ��");
		} else if (JOIN.equals(pVO.getCommand())) {
			System.out.println("��Ʈ�� ȸ������ ȣ��");
			cd.join(pVO);
		}else if (DELETE.equals(pVO.getCommand())) {
			System.out.println("��Ʈ�� ȸ��Ż�� ȣ��");
			cd.delete(pVO);
		}

		return rVO;

	}

}
