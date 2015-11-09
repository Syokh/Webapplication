package education.spring.java.lesson.services;

import education.spring.java.lesson.model.User;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class ServiceUser implements UserDetailsService {

    @Inject
    private SessionFactory sessionFactory;

    public ServiceUser() {

    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username1) throws UsernameNotFoundException {

        Query query = sessionFactory.getCurrentSession().createQuery("from User u where u.username=:username");
        query.setParameter("username", username1);
        User result = (User) query.uniqueResult();

        if (result == null) {
            throw new UsernameNotFoundException("username: " + username1 + " ");
        }

        return result;
    }
    @Transactional
    public void save(User user){
        sessionFactory.getCurrentSession().save(user);
    }

}
