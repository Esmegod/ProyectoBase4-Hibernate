package util;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 *
 * @author darkdestiny
 */
public class HibernateUtil {

    private static StandardServiceRegistry registry;
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if(sessionFactory == null){
            try{
              registry = new StandardServiceRegistryBuilder().
                      configure("hibernate.cfg.xml").build();
                MetadataSources ms = new MetadataSources(registry);
                Metadata m  = ms.getMetadataBuilder().build();
                sessionFactory = m.getSessionFactoryBuilder().build();
                
            }catch(Exception e){
                e.printStackTrace();
                if(registry != null){
                    StandardServiceRegistryBuilder.destroy(registry);
                }
            }
        }
        return sessionFactory;
    }

    public static void shutdown() {
        if (registry != null) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}