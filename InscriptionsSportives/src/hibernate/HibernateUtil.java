package hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
 
@SuppressWarnings("deprecation")
public class HibernateUtil {
 
    private static final SessionFactory sessionFactory;
 
    static{
        try{
            sessionFactory = new Configuration().configure().buildSessionFactory();
        }catch (Throwable ex) {
            System.err.println("Session Factory could not be created. " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
 
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
 
    public static void main(String args[])
    {
    	Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
    }
}