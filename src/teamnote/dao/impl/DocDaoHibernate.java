package teamnote.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import teamnote.dao.DocDao;
import teamnote.domain.Doc;
import teamnote.domain.Menu;
import teamnote.domain.User;
import teamnote.domain.UserGroup;

public class DocDaoHibernate extends HibernateDaoSupport implements DocDao
{
	@Override
	public Doc findById(long id)
	{

		return getHibernateTemplate().get(Doc.class, id);
	}

	@Override
	public Doc findByName(String name)
	{
		List<Doc> docs = (List<Doc>) getHibernateTemplate().find("from Doc where docName = ?", name);
		if (docs != null && docs.size() >= 1)
		{
			return docs.get(0);
		}
		return null;
	}

	@Override
	public long save(Doc doc)
	{
		return (Long) getHibernateTemplate().save(doc);
	}

	@Override
	public void update(Doc doc)
	{
		getHibernateTemplate().update(doc);
	}

	@Override
	public void delete(Doc doc)
	{
		getHibernateTemplate().delete(doc);
	}

	@Override
	public List<Doc> findAll()
	{
		return (List<Doc>) getHibernateTemplate().find("from Doc");
	}

	@Override
	public List<Doc> findByMenu(Menu menu)
	{
		return (List<Doc>) getHibernateTemplate().find("from Doc as d where " + "d.docMenu = ?", menu);
	}

	@Override
	public List<Doc> findByOwner(User owner)
	{
		return (List<Doc>) getHibernateTemplate().find("from Doc as d where " + "d.docOwner = ?", owner);
	}

	@Override
	public List<Doc> findByGroup(UserGroup userGroup)
	{
		return (List<Doc>) getHibernateTemplate().find("from Doc as d where " + "d.docGroup = ?", userGroup);
	}

	@Override
	public List<Doc> findByReader(User reader)
	{
		return (List<Doc>) getHibernateTemplate().find("from Doc as d where " + "? in elements(d.docReadUsers)", reader);
	}

	@Override
	public List<Doc> findByWriter(User writer)
	{
		return (List<Doc>) getHibernateTemplate().find("from Doc as d where " + "d.docEditor = ?", writer);
	}

	@Override
	public List<Doc> findByModifier(User modifier)
	{
		return (List<Doc>) getHibernateTemplate().find("from Doc as d where " + "d.docModifier = ?", modifier);
	}

}
