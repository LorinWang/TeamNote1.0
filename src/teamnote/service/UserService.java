package teamnote.service;

import teamnote.domain.User;

public interface UserService
{
	// ��¼ʧ��
	public static final int LOGIN_FAIL = 0;
	// ����ͨԱ����¼
	public static final int LOGIN_USR = 1;
	// �Ծ����¼
	public static final int LOGIN_ADM = 2;

	int validLogin(User user);
}
