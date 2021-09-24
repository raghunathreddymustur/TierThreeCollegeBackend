package com.TierThreeCollege.TierThreeCollegeBackend.Security.JWT;

import com.TierThreeCollege.TierThreeCollegeBackend.DAO.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MyUserDetails implements UserDetails {

    private String email;
    private String password;
    private String fullName;
    private String collegeName;
    private List<GrantedAuthority> authorities;
    private String yearOfPassOut;
    List<GrantedAuthority> al=new ArrayList<GrantedAuthority>();

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public void setAuthorities(List<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    public String getYearOfPassOut() {
        return yearOfPassOut;
    }

    public void setYearOfPassOut(String yearOfPassOut) {
        this.yearOfPassOut = yearOfPassOut;
    }

    public MyUserDetails()
    {

    }
    public MyUserDetails(User user)
    {
        this.email=user.getEmail();
        this.password=user.getPassword();
        this.fullName=user.getFullName();
        this.collegeName=user.getCollegeName();
        this.yearOfPassOut=user.getYearOfPassOut();
        this.authorities=al;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        GrantedAuthority auth=new SimpleGrantedAuthority("ROLE_USER");
        al.add(auth);
        authorities= al;
        return al;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
