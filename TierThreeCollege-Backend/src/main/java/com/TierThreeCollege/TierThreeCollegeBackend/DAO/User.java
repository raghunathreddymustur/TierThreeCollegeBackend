package com.TierThreeCollege.TierThreeCollegeBackend.DAO;



import javax.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(nullable = false,unique = true)
    String email;
    String password;
    String fullName;
    String collegeName;
    String yearOfPassOut;

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
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

    public String getYearOfPassOut() {
        return yearOfPassOut;
    }

    public void setYearOfPassOut(String yearOfPassOut) {
        this.yearOfPassOut = yearOfPassOut;
    }

    public User(String email, String password, String fullName, String collegeName, String yearOfPassOut) {
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.collegeName = collegeName;
        this.yearOfPassOut = yearOfPassOut;
    }
}
