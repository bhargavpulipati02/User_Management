package org.project.usermanagement.Controller;
import org.project.usermanagement.Entity.User;
import org.project.usermanagement.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {
    @Autowired
//    no need autowired because only one parameter constructor
    private UserService userservice;
    @PostMapping("createuser")
    public ResponseEntity<User> createuser(@RequestBody User user){
        User saveduser = userservice.createuser(user);
        return new ResponseEntity<>(saveduser, HttpStatus.CREATED);

    }

    @GetMapping("getuser/{id}")
    public ResponseEntity<User> getuser(@PathVariable("id") Long uid){
        User user= userservice.getUserById(uid);
        return new ResponseEntity<>(user, HttpStatus.OK);

    }

    @GetMapping("allusers")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users= userservice.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PutMapping("update")
    public ResponseEntity<User> updateUser(@ RequestBody User user){
        User updateduser =userservice.updateUser(user);
        return new ResponseEntity<>(updateduser, HttpStatus.OK);

    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long uid){
        userservice.deleteUser(uid);
        return new ResponseEntity<>("User deleted", HttpStatus.OK);
    }






}
