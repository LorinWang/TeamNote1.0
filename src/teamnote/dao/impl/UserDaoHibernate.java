package teamnote.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import teamnote.dao.UserDao;
import teamnote.domain.Doc;
import teamnote.domain.Menu;
import teamnote.domain.User;
import teamnote.domain.UserGroup;

public class UserDaoHibernate extends HibernateDaoSupport implements UserDao
{

	@Override
	public User findById(long id)
	{
		return getHibernateTemplate().get(User.class, id);
	}

	@Override
	public User findByName(String name)
	{
		List<User> users = (List<User>) getHibernateTemplate().find("from User where userName = ?", name);
		if (users != null && users.size() >= 1)
		{
			return users.get(0);
		}
		return null;
	}

	@Override
	public User findByNameAndPass(User user)
	{
		List<User> users = (List<User>) getHibernateTemplate().find("from User u where u.userName = ? and u.userPassword=?", user.getUserName(), user.getUserPassword());
		if (users != null && users.size() >= 1)
		{
			return users.get(0);
		}
		return null;
	}

	@Override
	public User findByMenuOwner(Menu menu)
	{
		List<User> users = (List<User>) getHibernateTemplate().find("from User as u where " + "? in elements(u.userOwnedMenus)", menu);
		if (users != null && users.size() >= 1)
		{
			return users.get(0);
		}
		return null;
	}

	@Override
	public User findByDocOwner(Doc doc)
	{
		List<User> users = (List<User>) getHibernateTemplate().find("from User as u where " + "? in elements(u.userOwnedDocs)", doc);
		if (users != null && users.size() >= 1)
		{
			return users.get(0);
		}
		return null;
	}

	@Override
	public User findByGroupOwner(UserGroup userGroup)
	{
		List<User> users = (List<User>) getHibernateTemplate().find("from User as u where " + "? in elements(u.userOwnedGroups)", userGroup);
		if (users != null && users.size() >= 1)
		{
			return users.get(0);
		}
		return null;
	}

	@Override
	public User findByMenuModifier(Menu menu)
	{
		List<User> users = (List<User>) getHibernateTemplate().find("from User as u where " + "? in elements(u.userModifiedMenus)", menu);
		if (users != null && users.size() >= 1)
		{
			return users.get(0);
		}
		return null;
	}

	@Override
	public User findByDocWriter(Doc doc)
	{
		List<User> users = (List<User>) getHibernateTemplate().find("from User as u where " + "? in elements(u.userEditedDocs)", doc);
		if (users != null && users.size() >= 1)
		{
			return users.get(0);
		}
		return null;
	}

	@Override
	public User findByDocModifier(Doc doc)
	{
		List<User> users = (List<User>) getHibernateTemplate().find("from User as u where " + "? in elements(u.userModifiedDocs)", doc);
		if (users != null && users.size() >= 1)
		{
			return users.get(0);
		}
		return null;
	}

	@Override
	public long save(User user)
	{
		return (Long) getHibernateTemplate().save(user);
	}

	@Override
	public void update(User user)
	{
		getHibernateTemplate().update(user);
	}

	@Override
	public void delete(User user)
	{
		getHibernateTemplate().delete(user);
	}

	@Override
	public List<User> findAll()
	{
		return (List<User>) getHibernateTemplate().find("from User");
	}

	@Override
	public List<User> findByUnfoldMenu(Menu menu)
	{
		return (List<User>) getHibernateTemplate().find("from User as u where " + "? in elements(u.userUnfoldMenus)", menu);
	}

	@Override
	public List<User> findByDocReader(Doc doc)
	{
		return (List<User>) getHibernateTemplate().find("from User as u where " + "? in elements(u.userReadDocs)", doc);
	}

	@Override
	public List<User> findByUserGroup(UserGroup userGroup)
	{
		return (List<User>) getHibernateTemplate().find("from User as u where " + "? in elements(u.userGroup)", userGroup);
	}

}
