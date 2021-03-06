package com.bang.controller;

import com.bang.model.User;
import com.bang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public ResponseEntity login(@RequestBody User user) {
        boolean validation = userService.validateUser(user);
        if (validation) {
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity register(@RequestBody User user) {
        boolean isCreated = userService.createUser(user);
        if (isCreated) {
            return new ResponseEntity(HttpStatus.CREATED);
        }
        return new ResponseEntity(HttpStatus.CONFLICT);
    }
}
