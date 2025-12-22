package com.library.library_api.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.library.library_api.models.User;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public interface UserRepositoryImpl extends UserRepository{
    @Override
    default User isEmailAlreadyInUse(String email) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session openSession = sessionFactory.openSession();
        openSession.beginTransaction();

        CriteriaBuilder cb = openSession.getCriteriaBuilder();

        CriteriaQuery<User> cr = cb.createQuery(User.class);
        Root<User> root = cr.from(User.class);
        cr.select(root).where(cb.equal(root.get("email"), email));  //here you pass a class field, not a table column (in this example they are called the same)

        Query<User> query = openSession.createQuery(cr);
        query.setMaxResults(1);
        List<User> resultList = query.getResultList();
        openSession.close();

        return resultList.get(0);
    }
}
