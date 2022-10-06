package edu.epidata.empresa.jpa;

import edu.epidata.empresa.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJPA extends JpaRepository<User, Integer> {
    User findByName(String name);

}