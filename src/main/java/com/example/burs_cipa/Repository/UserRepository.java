package com.example.burs_cipa.Repository;

import com.example.burs_cipa.Model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE CONCAT(u.firstName, u.lastName) LIKE %?1%")
    public List<User> search(String keyword);
}
