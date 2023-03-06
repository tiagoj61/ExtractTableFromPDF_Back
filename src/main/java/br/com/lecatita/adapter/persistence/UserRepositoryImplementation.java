package br.com.lecatita.adapter.persistence;

import br.com.lecatita.domain.model.User;
import br.com.lecatita.port.repository.UserRepository;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class UserRepositoryImplementation implements PanacheRepository<User>, UserRepository {

    @Override
    @Transactional
    public List<User> getAll() {
        return listAll();
    }

    @Override
    public User getbyId(Long userId) {
        return findById(userId);
    }

    @Override
    public int edit(Long id, User user) {
        return update("username = ?1, password =?2 where id = ?3", user.getUsername(), user.getPassword(), id);
    }

    @Override
    @Transactional
    public User add(User user) {
        persistAndFlush(user);
        return user;
    }

    @Override
    public Boolean delete(Long userId) {
        return deleteById(userId);
    }

    @Override
    public User getByUserName(String username) {
        return find("username = ?1", username).firstResult();
    }
}
