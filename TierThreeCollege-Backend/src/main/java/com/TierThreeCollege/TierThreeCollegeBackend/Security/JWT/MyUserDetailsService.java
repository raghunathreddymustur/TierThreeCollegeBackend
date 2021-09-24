package com.TierThreeCollege.TierThreeCollegeBackend.Security.JWT;

import com.TierThreeCollege.TierThreeCollegeBackend.DAO.User;
import com.TierThreeCollege.TierThreeCollegeBackend.Repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(s);

//        try {
//            if (user == null) {
//                throw new UsernameNotFoundException(s);
//            }
//        } catch (UsernameNotFoundException e)
//        {
//            throw e;
//        }
        MyUserDetails myUserDetails= new MyUserDetails(user);
        System.out.println(myUserDetails.getAuthorities()+" "+myUserDetails.getEmail()+" "+myUserDetails.getPassword()+" "+myUserDetails.getCollegeName()+" "+myUserDetails.getFullName()+" "+myUserDetails.getYearOfPassOut());
        return myUserDetails;
    }
}
