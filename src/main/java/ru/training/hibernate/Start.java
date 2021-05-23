package ru.training.hibernate;

import org.hibernate.Session;
import ru.training.hibernate.Entity.Author;

public class Start {
    public static void main(String[] args) {
//        Session session = HibernateUtil.getSessionFactory().openSession();

        AuthorHelper ah = new AuthorHelper();

//        ah.persist(new Author("Pushkin"));
//        ah.update(new Author(6L,"Franclin"));
//        ah.delete(new Author(8L,"Pushkin"));

        for(Author a: ah.findAll()){
            System.out.println(a);
        }



// openSession() we can change to getCurrentSession()
    }
}
