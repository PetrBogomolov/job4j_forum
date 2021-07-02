package ru.job4j.forum.repository;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.forum.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findByUsername(String username);
}
