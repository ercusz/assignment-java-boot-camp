package works.wachirawitch.week1.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import works.wachirawitch.week1.user.entity.User;
import works.wachirawitch.week1.user.repository.UserRepository;

@RestController
@RequestMapping("/api")
public class UserController {
    
    @Autowired
    UserRepository userRepository;

    @GetMapping("users")
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = (List<User>) userRepository.findAll();
        return ResponseEntity.ok().body(users);
    }
}
