package teamnote.service;

import teamnote.domain.User;

public interface UserService
{
	// 登录失败
	public static final int LOGIN_FAIL = 0;
	// 以普通员工登录
	public static final int LOGIN_USR = 1;
	// 以经理登录
	public static final int LOGIN_ADM = 2;

	int validLogin(User user);
}
