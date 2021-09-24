package com.TierThreeCollege.TierThreeCollegeBackend.Controllers;


import com.TierThreeCollege.TierThreeCollegeBackend.DAO.User;
import com.TierThreeCollege.TierThreeCollegeBackend.Repo.UserRepository;
import com.TierThreeCollege.TierThreeCollegeBackend.RequstPOJO.UserPass;
import com.TierThreeCollege.TierThreeCollegeBackend.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginSignUp {
    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;

    @GetMapping("/authenticate")
    public User getUser()
    {
        return userRepository.findByEmail("raghu52@gmail.com");
    }
    @PostMapping("/signup")
    public  Boolean addUser(@RequestBody User user)
    {

        User existingUser=userService.userExists(user.getEmail());
        if(existingUser!=null)
        {
            return false;
        }
        else
        {
            User newUser=userService.createUser(user);
            if(newUser!=null)
            {
                return true;
            }
            return false;
        }
    }



}
