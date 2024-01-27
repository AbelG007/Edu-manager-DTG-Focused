package com.nimit.edumanager.securitymanager.repository;

import com.nimit.edumanager.securitymanager.entity.User;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@EntityScan(basePackageClasses = User.class)
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName(String username);
}
