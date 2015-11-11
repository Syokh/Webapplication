package education.spring.java.lesson.services;

import education.spring.java.lesson.model.Book;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named("serviseBook")
public class ServiceBook {

    @Inject
    private SessionFactory sessionFactory;

    public ServiceBook() {
    }

    @SuppressWarnings("unchecked")
    @Transactional
    public List<Book> getAll(){
        Query query = sessionFactory.getCurrentSession().createQuery("from Book");
        return query.list();

    }

    @Transactional
    public void save(Book book){
        sessionFactory.getCurrentSession().save(book);
    }

}
