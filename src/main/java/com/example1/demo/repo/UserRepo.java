package com.example1.demo.repo;

import com.example1.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<User,Integer> {

    @Query(value ="SELECT * FROM user WHERE ID = ?1", nativeQuery = true)
    User getUserByUserID (String userID);

    @Query(value = "SELECT * FROM user WHERE ID=?1 AND address=?2",nativeQuery = true)
    User getUserByUserIDAndAddress (String userID, String address);
}
