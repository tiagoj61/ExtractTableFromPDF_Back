package br.com.lecatita.port.service;

import br.com.lecatita.domain.model.User;

import java.util.List;

public interface UserService {
    List<User> getAll();

    User getbyId(Long userId);

    User add(User user);

    Boolean delete(Long userId);

    int edit(Long id, User user);

    User getByUserName(String username);
}
