package com.sample.mapstruct.controller;

import com.sample.mapstruct.dto.custom.UserCustomDto;
import com.sample.mapstruct.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserCustomDto> findUserById(@PathVariable Long id) {
        return ResponseEntity
                .ok()
                .body(userService.findUser(id));
    }

}
