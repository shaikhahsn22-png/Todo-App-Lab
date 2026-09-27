package com.ga.todoapp.Repository;

import com.ga.todoapp.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    //to register
    boolean existsByEmailAddress(String emailAddress);

    //to login
    User findUserByEmailAddress(String emailAddress);
}
