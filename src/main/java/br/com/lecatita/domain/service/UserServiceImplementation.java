package br.com.lecatita.domain.service;

import br.com.lecatita.domain.model.User;
import br.com.lecatita.port.repository.UserRepository;
import br.com.lecatita.port.service.UserService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class UserServiceImplementation implements UserService {

    @Inject
    UserRepository userRepository;

    @Override
    @Transactional
    public List<User> getAll() {
        return userRepository.getAll();
    }

    @Override
    public User getbyId(Long userId) {
        return userRepository.getbyId(userId);
    }

    @Override
    public int edit(Long id, User user) {
        return userRepository.edit(id, user);
    }

    @Override
    @Transactional
    public User add(User user) {
        return userRepository.add(user);
    }

    @Override
    public Boolean delete(Long userId) {
        return userRepository.delete(userId);
    }

    @Override
    public User getByUserName(String username) {
        return userRepository.getByUserName(username);
    }
}
