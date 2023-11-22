package com.example.ex001springsecurity.user;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // @GetMapping
    // public String testGet() {
    //     return "Controller funcionando";
    // }

    @GetMapping
    public ResponseEntity<List<UserModel>> getAll() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(userService.getAll());
        } catch(Exception exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        
    }
    
    @PostMapping
    public ResponseEntity<String> post(@RequestBody UserModel userModel) {
        try {
            userService.post(userModel);
            return ResponseEntity.status(HttpStatus.CREATED).body(null);
        } catch(Exception exception) {
            return ResponseEntity.status(
                HttpStatus.BAD_REQUEST).body(exception.getMessage()
            );
        }
    }
}
