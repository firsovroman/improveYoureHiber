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

    public List<Author> getAuthorList() {

        // открыть сессию для манипуляции персист объектами
        Session session = sessionFactory.openSession();

        session.get(Author.class, 1L); // получение объекта по ID



        //    ******** Получение всех объектов *********

        // *** Этап подготовки
        // Объект конструктор запросов для Criteria API
        CriteriaBuilder cb = session.getCriteriaBuilder();

        CriteriaQuery cq = cb.createQuery(Author.class);

        Root<Author> root = cq.from(Author.class); // определяем какая таблица будет вставляться после from в запросе

        cq.select(root); // необязательный оператор, используется если просто нужно получить все значение


        // *** Выполнение запроса
        Query query = session.createQuery(cq);

        List<Author> authorList = query.getResultList();

        session.close();

        return authorList;

    }


    public Author getAuthor(String name) {
        return null;
    }

}
