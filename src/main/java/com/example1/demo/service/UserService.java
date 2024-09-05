package com.example1.demo.service;

import com.example1.demo.dto.UserDTO;
import com.example1.demo.entity.User;
import com.example1.demo.repo.UserRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    public UserDTO saveUser(UserDTO userDTO){
        userRepo.save(modelMapper.map(userDTO, User.class));
        return userDTO;
    }

    public List<UserDTO> getAllUsers(){
        List<User>userList=userRepo.findAll();
        return modelMapper.map(userList,new TypeToken<List<UserDTO>>(){}.getType());
    }

    public UserDTO updateUser (UserDTO userDTO){
        userRepo.save(modelMapper.map(userDTO,User.class));
        return userDTO;
    }

    public Boolean deleteUser (UserDTO userDTO){
        userRepo.delete(modelMapper.map(userDTO,User.class));
        return true;
    }
    //user id >> user details
    //Query>> SELECT * FROM user where id = ?
    public UserDTO getUserByUserID(String userID){
        User user=userRepo.getUserByUserID(userID);
        return modelMapper.map(user, UserDTO.class);
    }

    //user id>> user Details
    //Query>> SELECT * FROM user WHERE id=? AND address = ?
    public UserDTO getUserByUserIdAndAddress(String userID, String address){
        User user=userRepo.getUserByUserIDAndAddress(userID,address);
        return modelMapper.map(user, UserDTO.class);
    }

}
