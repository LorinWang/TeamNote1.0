package teamnote.test;

import teamnote.dao.impl.DocDaoHibernate;

public class TestDao
{
	public static void main(String[] args)
	{
		DocDaoHibernate doc= new DocDaoHibernate();
		doc.findAll();
	}
}
