package com.TierThreeCollege.TierThreeCollegeBackend.Repo;

import com.TierThreeCollege.TierThreeCollegeBackend.DAO.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    public User findByEmail(String password);
}
