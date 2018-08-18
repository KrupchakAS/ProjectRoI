package app.net.dao;

import app.net.entity.Book;
import app.net.entity.Genre;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class BookDAOImpl implements BookDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public void createBook(Book book) {
        sessionFactory.getCurrentSession().save(book);
    }


    public void delete(Book book) {
        sessionFactory.getCurrentSession().delete(book);
    }


    public Book getBookById(Integer id) {
        return sessionFactory.getCurrentSession().find(Book.class, id);
    }


    public Book getBookByName(String bookName) {
        List<Book> list = sessionFactory.getCurrentSession().createCriteria(Book.class)
                .add(Restrictions.eq("bookName", bookName)).list();
        if (list.size() > 0) {
            return list.get(0);
        } else {
            return null;
        }
    }



    @Override
    public void update(Book book) {
        sessionFactory.getCurrentSession().update(book);
    }

    @Override
    public Set<Book> findBooks(String name, String genre) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Book.class, "books");
        criteria.createAlias("books.genres", "genres", Criteria.INNER_JOIN);
        if (name != null) {
            criteria.add(Restrictions.like("bookName", "%" + name + "%"));
        }
        if (genre != null) {
            criteria.add(Restrictions.eq("genres.genreName", genre));
        }
        return new HashSet<Book>(criteria.list());
    }


}
