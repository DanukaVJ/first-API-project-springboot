package com.example1.demo.controller;

import com.example1.demo.dto.UserDTO;
import com.example1.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/user") //this is path
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

        @GetMapping("/getUser")
        public List<UserDTO> getUser() {
            return userService.getAllUsers();
        }

        @PostMapping("/saveUser")
        public UserDTO saveUser(@RequestBody UserDTO userDTO) {
            return userService.saveUser(userDTO);
        }

        @PutMapping("/updateUser")
        public UserDTO updateUser(@RequestBody UserDTO userDTO) {
            return userService.updateUser(userDTO);
        }

        @DeleteMapping("/deleteUser")
        public Boolean deleteUser(@RequestBody UserDTO userDTO) {
            return userService.deleteUser(userDTO);
        }

        @GetMapping("/getUserByUserID/{userID}")
        public UserDTO getUserByUserID(@PathVariable String userID) {
            return userService.getUserByUserID(userID);
        }

        @GetMapping("/getUserByUserIdAndAddress/{userID}/{address}")
        public UserDTO getUserByUserIdAndAddress(@PathVariable String userID,@PathVariable String address) {
            return userService.getUserByUserIdAndAddress(userID,address);
        }



}