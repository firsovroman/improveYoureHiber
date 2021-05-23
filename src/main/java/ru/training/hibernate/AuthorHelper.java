package ru.training.hibernate;

import javax.persistence.*;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.*;
import ru.training.hibernate.Entity.Author;

import java.util.List;

public class AuthorHelper {

    private SessionFactory sessionFactory;

    public AuthorHelper() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public Author findById(long id) {
        return sessionFactory.openSession().get(Author.class, id);
    }



    public List<Author> findAll() {
        List<Author> author = (List<Author>)  sessionFactory.openSession().createQuery("From Author").list();
        return author;
    }

    public void update(Author author) {
        Session session = sessionFactory.openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(author);
        tx1.commit();
        session.close();
    }

    public void delete(Author author) {
        Session session = sessionFactory.openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(author);
        tx1.commit();
        session.close();
    }

    public void persist(Author author) {
        Session session = sessionFactory.openSession();
        Transaction tx1 = session.beginTransaction();
        session.persist(author);
        tx1.commit();
        session.close();
    }

}
