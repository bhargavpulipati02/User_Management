package org.project.usermanagement.Service.Implementation;

import lombok.AllArgsConstructor;
import org.project.usermanagement.Dao.UserRepository;
import org.project.usermanagement.Entity.User;
import org.project.usermanagement.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository userrepository;


    public User createuser(User user) {
        return userrepository.save(user);

    }

    public User getUserById(Long uid){
        Optional<User> optionalUser = userrepository.findById(uid);
        return optionalUser.get();

    }

    @Override
    public List<User> getAllUsers() {
        return userrepository.findAll();
    }

    public User updateUser(User user) {
        User updateUser = userrepository.findById(user.getId()).get();
        updateUser.setFirstName(user.getFirstName());
        updateUser.setLastName(user.getLastName());
        updateUser.setEmail(user.getEmail());
        return userrepository.save(updateUser);

    }

    @Override
    public void deleteUser(Long uid) {
        userrepository.deleteById(uid);
    }


}
