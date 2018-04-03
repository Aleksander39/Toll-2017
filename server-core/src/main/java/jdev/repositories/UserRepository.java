package jdev.repositories;

import jdev.dao.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User,String> {
    public User findByLogin(String login);
}
