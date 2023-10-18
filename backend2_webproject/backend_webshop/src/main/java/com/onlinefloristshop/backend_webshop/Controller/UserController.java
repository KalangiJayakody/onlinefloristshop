package com.onlinefloristshop.backend_webshop.Controller;
import com.onlinefloristshop.backend_webshop.Entity.User;
import com.onlinefloristshop.backend_webshop.repository.UserRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EntityManager entityManager;

    @PostMapping("/registerNewUser")
    public void registerNewUser(@RequestBody User user){
        userRepository.save(user);
    }

    //wrong
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        if (userRepository.equals(user.getUserName()) && userRepository.equals(user.getUserPassword())) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed");
        }
    }


}
