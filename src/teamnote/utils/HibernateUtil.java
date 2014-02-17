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
			// ����SessionFactory
			sessionFactory = new Configuration().configure().buildSessionFactory();
		}
		catch (HibernateException e)
		{
			throw new HibernateException("Build SessionFactory:", e);
		}
	}

	public static Session currentSession()
	{
		// ȡ��Session����
		Session s = (Session) thread_var.get();
		// �������߳�Ϊ��,��һ���µ�Session
		if (s == null)
		{
			s = sessionFactory.openSession();
			// ��Hibernate��Session����thread_var�����б���
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
