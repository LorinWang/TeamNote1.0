package teamnote.action;

import teamnote.service.UserService;

import com.opensymphony.xwork2.ActionSupport;

public class UserBaseAction extends ActionSupport
{
	protected UserService userService;

	public void setUserService(UserService userService)
	{
		this.userService = userService;
	}
	

}
