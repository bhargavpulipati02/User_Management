package org.project.usermanagement.Service;

import org.project.usermanagement.Entity.User;

import java.util.List;

public interface UserService {
    User createuser(User user);
    User getUserById(Long uid);

    List<User> getAllUsers();
    User updateUser(User user);
    void deleteUser(Long uid);

}
