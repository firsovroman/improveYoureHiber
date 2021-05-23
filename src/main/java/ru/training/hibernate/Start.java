package ru.training.hibernate;

import org.hibernate.Session;
import ru.training.hibernate.Entity.Author;

public class Start {
    public static void main(String[] args) {
//        Session session = HibernateUtil.getSessionFactory().openSession();



        for(Author a: new AuthorHelper().getAuthorList()){
            System.out.println(a);
        }

// openSession() we can change to getCurrentSession()
    }
}
