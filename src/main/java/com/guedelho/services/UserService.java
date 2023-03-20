package com.guedelho.services;

import com.guedelho.models.User;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class UserService {
    public List<User> listAll(){
        return User.listAll();
    }

    public List<User> list(){
        Query query = User.getEntityManager().createQuery("select u from User u where u.status = 'ATIVO'");
        return query.getResultList();
    }

    public User listById(Long id) {
        return User.findById(id);
    }
    @Transactional
    public User save(User user) {
        User.persist(user);
        return user;
    }

    @Transactional
    public User update(Long id, User user) {
        user.id = id;
        User.getEntityManager().merge(user);
        User.flush();
        return user;
    }
}
