package br.com.lecatita.port.repository;

import br.com.lecatita.domain.model.User;
import io.smallrye.mutiny.Uni;

import java.util.List;

public interface UserRepository {
    List<User> getAll();

    User getbyId(Long userId);

    User add(User user);

    Boolean delete(Long userId);

    int edit(Long id, User user);

    User getByUserName(String username);
}
