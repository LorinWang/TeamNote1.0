package teamnote.utils;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil
{

	private static final SessionFactory sessionFactory;
	private static final ThreadLocal thread_var = new ThreadLocal();

	static
	{
		try
		{
			// 创建SessionFactory
			sessionFactory = new Configuration().configure().buildSessionFactory();
		}
		catch (HibernateException e)
		{
			throw new HibernateException("Build SessionFactory:", e);
		}
	}

	public static Session currentSession()
	{
		// 取得Session对象
		Session s = (Session) thread_var.get();
		// 如果这个线程为空,打开一个新的Session
		if (s == null)
		{
			s = sessionFactory.openSession();
			// 把Hibernate的Session放入thread_var变量中保存
			thread_var.set(s);
		}
		return s;
	}

	public static void closeSession()
	{
		Session s = (Session) thread_var.get();
		if (s != null)
		{
			s.close();
		}
		thread_var.set(null);
	}
}
