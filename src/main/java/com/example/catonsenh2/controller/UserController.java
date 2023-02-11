package com.example.catonsenh2.controller;

import com.example.catonsenh2.models.UserModel;
import com.example.catonsenh2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public @ResponseBody ResponseEntity<List<UserModel>> getAllUser(){
        return new ResponseEntity<>(this.userService.findAllUser(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public @ResponseBody ResponseEntity<Optional<UserModel>> getOneUser(@PathVariable Long id){
        return new ResponseEntity<>(this.userService.findUserByID(id),HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public @ResponseBody ResponseEntity<List<UserModel>> getUserByName(@PathVariable String name){
        return new ResponseEntity<>(this.userService.findUserByName(name),HttpStatus.OK);
    }

    @GetMapping("/tel/{tel}")
    public @ResponseBody ResponseEntity<List<UserModel>> getUserByTel(@PathVariable String tel){
        return new ResponseEntity<>(this.userService.findUserByTel(tel),HttpStatus.OK);
    }

    @GetMapping("/email/{email}")
    public @ResponseBody ResponseEntity<List<UserModel>> getUserByEmail(@PathVariable String email){
        return new ResponseEntity<>(this.userService.findUserByEmail(email),HttpStatus.OK);
    }

    @PostMapping("")
    public @ResponseBody ResponseEntity<UserModel> postUser(@RequestBody UserModel user){
        return new ResponseEntity<>(this.userService.saveUser(user),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public @ResponseBody ResponseEntity<Optional<UserModel>> putUser(@PathVariable Long id,@RequestBody UserModel user){
        return new ResponseEntity<>(this.userService.updateUser(id,user),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public @ResponseBody ResponseEntity<String> deleteUser(@PathVariable Long id){
        this.userService.deleteByID(id);
        return new ResponseEntity<>(String.format("%d has deleted.",id),HttpStatus.OK);
    }
}
