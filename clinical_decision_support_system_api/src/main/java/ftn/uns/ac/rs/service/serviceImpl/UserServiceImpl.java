package ftn.uns.ac.rs.service.serviceImpl;

import ftn.uns.ac.rs.domain.entity.User;
import ftn.uns.ac.rs.exeptions.MyAlreadyExistsException;
import ftn.uns.ac.rs.exeptions.MyInvalidRequestException;
import ftn.uns.ac.rs.exeptions.MyNotFoundExeption;
import ftn.uns.ac.rs.exeptions.MySavingInRepoException;
import ftn.uns.ac.rs.repository.UserRepository;
import ftn.uns.ac.rs.service.IllnessService;
import ftn.uns.ac.rs.service.UserService;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletContext;
import java.util.HashMap;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private KieContainer kieContainer;

    @Autowired
    private HashMap<String, KieSession> sessions;

    @Autowired
    private IllnessService illnessService;

    @Autowired
    private ServletContext servletContext;

    @Override
    public User addUser(User user) {
        if (user.getId() != null) {
            throw new MyInvalidRequestException("Bad request, id isn't null!");
        }

        if (userRepository.findByUsername(user.getUsername()) != null) {
            throw new MyAlreadyExistsException("There already exists a user with the username: " + user.getUsername());
        }

        return Optional.ofNullable(userRepository.save(user))
                .orElseThrow(() -> new MySavingInRepoException("Problem with saving user"));
    }

    @Override
    public User login(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }

    @Override
    public void logout() {
        //User user = Optional.ofNullable(userRepository.getOne(id))
        //  .orElseThrow(() -> new MyNotFoundExeption("User does not exist!"));
        String username = (String) servletContext.getAttribute("currentUser");
        sessions.get(username).dispose();
        sessions.remove(username);
    }

    @Override
    public void delete(Long id) {
        Optional.ofNullable(userRepository.getOne(id))
                .orElseThrow(() -> new MyNotFoundExeption("Can not delete user which does not exits."));

        userRepository.deleteById(id);
    }

}
