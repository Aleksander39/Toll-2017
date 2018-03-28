package jdev.services;

import jdev.dao.User;
import jdev.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class  UserService {

    @Autowired
    UserRepository userRepository;

    public User create(User user){
        return userRepository.save(user);
    }

    public User update(User user){
        return userRepository.save(user);
    }

    public void delete(User user){
        userRepository.delete(user);
    }

    public List<User> findAll(){
        return (List<User>) userRepository.findAll();
    }

    public User findByLogin(String login){
        return userRepository.findByLogin(login);
    }
}
