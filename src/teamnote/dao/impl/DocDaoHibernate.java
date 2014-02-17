package teamnote.dao.impl;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import teamnote.dao.DocDao;
import teamnote.domain.Doc;
import teamnote.domain.Menu;
import teamnote.domain.User;
import teamnote.domain.UserGroup;
import teamnote.utils.HibernateUtil;

public class DocDaoHibernate extends HibernateDaoSupport implements DocDao
{
	@Override
	public Doc findById(long id)
	{
		
		return null;
	}

	@Override
	public Doc findByName(String name)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long save(Doc doc)
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void update(Doc doc)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Doc doc)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Doc> findAll()
	{
		Session sess=HibernateUtil.currentSession();
		Transaction tx=sess.beginTransaction();
		List docs=sess.createQuery("from Doc").list();
		for (Iterator pit=docs.iterator();pit.hasNext();)
		{
			Doc doc=(Doc)pit.next();
			System.out.println(doc.getDocName());
		}
		tx.commit();
		HibernateUtil.closeSession();
		return docs;
	}

	@Override
	public List<Doc> findByMenu(Menu menu)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Doc> findByOwner(User owner)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Doc> findByGroup(UserGroup userGroup)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Doc> findByReader(User reader)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Doc> findByWriter(User writer)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Doc> findByModifier(User modifier)
	{
		// TODO Auto-generated method stub
		return null;
	}

}
