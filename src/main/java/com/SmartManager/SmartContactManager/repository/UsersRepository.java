package com.SmartManager.SmartContactManager.repository;

import com.SmartManager.SmartContactManager.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users,Long> {
    @Query("select u from Users u where u.email=:email")
    public Users getUsersByEmail(@Param("email") String email);

    Users findByEmail(String email);
}
