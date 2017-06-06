package cs544.hap2;

/**
 * Created by Adonai on 6/5/2017.
 */

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class HibernateUtil {
    private static final SessionFactory sessionFactory;
    static{
        final StandardServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder()
                .configure().build();
        try{
            sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();

        }catch (Throwable ex){
            System.out.println("Initial SessionFactory creation failed: "+ex);
            StandardServiceRegistryBuilder.destroy(serviceRegistry);
            throw new ExceptionInInitializerError(ex);
        }
    }
    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}