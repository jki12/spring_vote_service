package com.example.vote.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.Collection;
import java.util.UUID;

// @Repository
public class JpaUserRepo implements UserRepo {
    @Autowired
    private final EntityManagerFactory emf;
    private final EntityManager em;

    public JpaUserRepo(EntityManagerFactory emf) {
        this.emf = emf;

        this.em = emf.createEntityManager();
    }

    @Transactional
    @Override
    public boolean save(User user) {
        if (findByEmail(user.getEmail()) != null) return false;

        em.persist(user);

        return true;
    }

    @Override
    public User findById(UUID id) {
        return em.find(User.class, id);
    }

    @Override
    public User findByEmail(String email) {
        return em.find(User.class, email);
    }

    @Override
    public Collection<User> getUsers() {
        return em.createQuery("select user from Users user", User.class).getResultList();
    }
}
