package ru.training.hibernate;

import org.hibernate.*;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.*;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    static {
        final StandardServiceRegistry registry =  new StandardServiceRegistryBuilder().configure().build();
        // configure()  Прочтите информацию о настройках из cfg.XML-файла, используя стандартное расположение ресурса.
        // build()      Создайте StandardServiceRegistry.

        try {

//                MetadataSources sources = new MetadataSources( registry );
//                MetadataBuilder metadataBuilder = sources.getMetadataBuilder();
//                Metadata metadata = metadataBuilder.build();

            //Metadata metadata = new MetadataSources(registry).buildMetadata();
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();


        } catch (Exception e) {
            System.out.println("Сработал Catch");
            e.printStackTrace();
            //StandardServiceRegistryBuilder.destroy(registry);

        }



    }
    public static final SessionFactory getSessionFactory() {
        return sessionFactory;
    }


}
