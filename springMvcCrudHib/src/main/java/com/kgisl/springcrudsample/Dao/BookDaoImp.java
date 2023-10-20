package com.kgisl.springcrudsample.Dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kgisl.springcrudsample.Model.Book;

@Service
public class BookDaoImp implements BookDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveBook(Book book) {
        System.out.println(book);
        sessionFactory.getCurrentSession().save(book);
        System.out.println("***** Added Successfully! *****");

    }

    @Override
    public List<Book> listBooks() {
        TypedQuery<Book> query = sessionFactory.getCurrentSession().createQuery("from Book");
        return query.getResultList();
    }

    @Override
    public void updateBook(Book book) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(book);
        System.out.println("***** Updated Successfully! *****");
        // logger.info("Person updated successfully, Person Details="+book);
    }

    @Override
    public void deleteBook(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        Book book = session.get(Book.class, id);
        if (null != book) {
            session.delete(book);
            System.out.println("***** Deleted Successfully! *****");
        } else {
            System.out.println("***** Book with ID " + id + " not found! *****");
        }
    }

    @Override
    public Book getBookById(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        Book book = session.get(Book.class, id);
        return book;
    }

}
