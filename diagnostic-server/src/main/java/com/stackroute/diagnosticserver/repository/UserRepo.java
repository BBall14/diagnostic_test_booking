package com.stackroute.diagnosticserver.repository;

import com.stackroute.diagnosticserver.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// annotate with Repository
// extend JpaRepository
@Repository
public interface UserRepo extends JpaRepository<User, String> {

    public User findByUserName(String userName);
}

