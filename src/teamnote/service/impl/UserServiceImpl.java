package teamnote.service.impl;

import teamnote.dao.DocDao;
import teamnote.dao.MenuDao;
import teamnote.dao.UserDao;
import teamnote.dao.UserGroupDao;
import teamnote.domain.User;
import teamnote.service.UserService;

public class UserServiceImpl implements UserService
{

	private DocDao docDao;
	private MenuDao menuDao;
	private UserDao userDao;	
	private UserGroupDao userGroupDao;
	
	@Override
	public int validLogin(User user)
	{
		if (userDao.findByNameAndPass(user) != null)
		{
			return LOGIN_USR;
		}

		else
		{
			return LOGIN_FAIL;
		}
	}

	public UserDao getUserDao()
	{
		return userDao;
	}

	public void setUserDao(UserDao userDao)
	{
		this.userDao = userDao;
	}

	public DocDao getDocDao()
	{
		return docDao;
	}

	public void setDocDao(DocDao docDao)
	{
		this.docDao = docDao;
	}

	public MenuDao getMenuDao()
	{
		return menuDao;
	}

	public void setMenuDao(MenuDao menuDao)
	{
		this.menuDao = menuDao;
	}

	public UserGroupDao getUserGroupDao()
	{
		return userGroupDao;
	}

	public void setUserGroupDao(UserGroupDao userGroupDao)
	{
		this.userGroupDao = userGroupDao;
	}

}
