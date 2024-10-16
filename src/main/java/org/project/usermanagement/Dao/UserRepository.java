package org.project.usermanagement.Dao;

import org.project.usermanagement.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {


}
