package ftn.uns.ac.rs.service;

import ftn.uns.ac.rs.domain.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User addUser(User user);

    User login(String username, String password);

    void logout();

    void delete(Long id);
}
