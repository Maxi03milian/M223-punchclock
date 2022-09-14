package ch.ms.punchclock.service;

import ch.ms.punchclock.model.User;
import ch.ms.punchclock.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean checkUserCredentials(String username, String password) {
        return userRepository.existsByUsernameAndPassword(username, password);
    }

}
