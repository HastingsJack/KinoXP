package org.example.kinoxp.repositories;


import org.example.kinoxp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Optional;

@CrossOrigin
public interface UserRepository extends JpaRepository<User,Integer> {

    Optional<User> findUserByEmail(String email);
}
