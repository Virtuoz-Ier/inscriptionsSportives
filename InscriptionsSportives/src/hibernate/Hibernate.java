package hibernate;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class Hibernate
{
    private static Session session = null;
    private static SessionFactory sessionFactory = null;
    private static final String CONF_FILE = "config/hibernate.m2l.cfg.xml";
    private static Transaction transaction = null;
    
   

    static void initHibernate()
    {
    	
    	try
        {
        
            Configuration configuration = new Configuration().configure(CONF_FILE);
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings((Map)configuration.getProperties()).build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            
    }
        catch (HibernateException ex)
        {
            throw new RuntimeException("Probleme de config : " + ex.getMessage(), ex);
        }
        
    }

    public static void open() {
        if (sessionFactory == null){
            initHibernate();
        }
        if (!isOpened()){
				try {
					session = sessionFactory.openSession();
				} catch (HibernateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        }
    }

    public static boolean isOpened() {
        return session != null && session.isOpen();
    }

    public static void close() {
        if (isOpened())
            session.close();
    }

    public static void delete(Object o) {
        Transaction tx = session.beginTransaction();
        session.delete(o);
        tx.commit();
        session.flush();
    }

    public static void save(Object o) {
        Transaction tx = session.beginTransaction();
        session.save(o);
        tx.commit();
        session.flush();
    }

//    public static void save(SortedSet tab) {
//        for (Object o : tab ){
//            save(o);
//        }
//    }

    @SuppressWarnings("unchecked")
    public static <T> List<T> getData(String className) {
        Query query = session.createQuery("from " + className);
        return new ArrayList<T>((List<T>) query.list());
    }

    @SuppressWarnings("unchecked")
    public static <T> T getData(String className, int id) {
        Query query = session.createQuery("from " + className + " where id = " + id);
        return (T) (query.list().get(0));
    }
}