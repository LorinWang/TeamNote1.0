package teamnote.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import teamnote.dao.MenuDao;
import teamnote.domain.Doc;
import teamnote.domain.Menu;
import teamnote.domain.User;
import teamnote.domain.UserGroup;

public class MenuDaoHibernate extends HibernateDaoSupport implements MenuDao
{

	@Override
	public Menu findById(long id)
	{
		return getHibernateTemplate().get(Menu.class, id);
	}

	@Override
	public Menu findByName(String name)
	{
		List<Menu> menus = (List<Menu>) getHibernateTemplate().find("from Menu where menuName = ?", name);
		if (menus != null && menus.size() >= 1)
		{
			return menus.get(0);
		}
		return null;
	}

	@Override
	public Menu findByDoc(Doc doc)
	{
		List<Menu> menus = (List<Menu>) getHibernateTemplate().find("from Menu as m where " + "? in elements(m.menuDocs)", doc);
		if (menus != null && menus.size() >= 1)
		{
			return menus.get(0);
		}
		return null;
	}

	@Override
	public long save(Menu menu)
	{
		return (Long) getHibernateTemplate().save(menu);
	}

	@Override
	public void update(Menu menu)
	{
		getHibernateTemplate().update(menu);
	}

	@Override
	public void delete(Menu menu)
	{
		getHibernateTemplate().delete(menu);
	}

	@Override
	public List<Menu> findAll()
	{
		return (List<Menu>) getHibernateTemplate().find("from Menu");
	}

	@Override
	public List<Menu> findByUnfoldUser(User user)
	{
		return (List<Menu>) getHibernateTemplate().find("from Menu as m where " + "? in elements(m.menuUnfoldUsers)", user);
	}

	@Override
	public List<Menu> findByModifier(User modifier)
	{
		return (List<Menu>) getHibernateTemplate().find("from Menu as m where " + "m.menuModifier = ?", modifier);
	}

	@Override
	public List<Menu> findByOwner(User owner)
	{
		return (List<Menu>) getHibernateTemplate().find("from Menu as m where " + "m.menuOwner = ?", owner);
	}

	@Override
	public List<Menu> findByGroup(UserGroup userGroup)
	{
		return (List<Menu>) getHibernateTemplate().find("from Menu as m where " + "m.menuGroup = ?", userGroup);
	}

}
