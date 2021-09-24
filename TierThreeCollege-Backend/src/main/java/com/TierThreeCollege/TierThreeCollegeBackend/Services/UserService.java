package com.TierThreeCollege.TierThreeCollegeBackend.Services;

import com.TierThreeCollege.TierThreeCollegeBackend.DAO.User;
import com.TierThreeCollege.TierThreeCollegeBackend.Repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    public User createUser(User  user)
    {
        User newUser=userRepository.save(user);
        return newUser;
    }
    public User userExists(String password)
    {
        return userRepository.findByEmail(password);
    }

}
