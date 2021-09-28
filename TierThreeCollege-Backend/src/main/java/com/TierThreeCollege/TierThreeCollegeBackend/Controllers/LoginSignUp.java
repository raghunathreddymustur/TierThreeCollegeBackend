package com.TierThreeCollege.TierThreeCollegeBackend.Controllers;


import com.TierThreeCollege.TierThreeCollegeBackend.DAO.User;
import com.TierThreeCollege.TierThreeCollegeBackend.Repo.UserRepository;
import com.TierThreeCollege.TierThreeCollegeBackend.RequstPOJO.UserPass;
import com.TierThreeCollege.TierThreeCollegeBackend.Security.JWT.JwtUtil;
import com.TierThreeCollege.TierThreeCollegeBackend.Security.JWT.MyUserDetailsService;
import com.TierThreeCollege.TierThreeCollegeBackend.Security.JWT.POJO.Request;
import com.TierThreeCollege.TierThreeCollegeBackend.Security.JWT.POJO.Response;
import com.TierThreeCollege.TierThreeCollegeBackend.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginSignUp {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    MyUserDetailsService myUserDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    JwtUtil jwtUtil;

    @GetMapping("/about")
    public String about()
    {
        return "This is about us";
    }
    @PostMapping("/authenticate")
    public ResponseEntity<?> getToken(@RequestBody Request request) throws Exception
    {
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(),request.getPassword()));
        }
        catch (BadCredentialsException e)
        {
            throw new Exception("Wrong Credentials",e);
        }
        final UserDetails userDetails=myUserDetailsService.loadUserByUsername(request.getEmail());
        final String jwt=jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new Response(jwt));
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
