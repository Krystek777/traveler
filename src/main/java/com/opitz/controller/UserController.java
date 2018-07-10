package com.opitz.controller;


import com.opitz.model.Claim;
import com.opitz.model.User;
import com.opitz.service.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users", consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @Autowired
    private ClaimService claimService;


    @GetMapping("/all")
    public @ResponseBody
    ResponseEntity<List<User>> getUsers() {
        try{
            return new ResponseEntity<>(claimService.getUsers(), HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
        }
    }

    @PostMapping("/save")
    public @ResponseStatus
    HttpStatus saveUser(@RequestBody User user) {
        try {
            claimService.saveUser(user);
            return HttpStatus.OK;
        } catch(Exception ex) {
            ex.printStackTrace();
            return HttpStatus.NOT_ACCEPTABLE;
        }
    }

    @GetMapping("find/id/{id}")
    public @ResponseBody ResponseEntity<User> findUser(@PathVariable long id) {
        try {
            return new ResponseEntity<>(claimService.findUser(id), HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("find/username/{username}")
    public @ResponseBody  ResponseEntity<User>  findUser(@PathVariable String username) {
        try {
            return new ResponseEntity<>(claimService.findUser(username), HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }




}
