package com.example.demo.Service;

import com.example.demo.Model.UserModel;
import com.example.demo.Repository.UserRepo;
import com.example.demo.Request.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;
    public List<UserModel> getAllUsers(){
        return userRepo.findAll();
    }//Get all users

    public void createUser(UserRequest userRequest){
        UserModel userModel = new UserModel();
        userModel.setEmail(userRequest.getEmail());
        userModel.setName(userRequest.getName());
        userRepo.save(userModel);//will insert the data in the table
    }
    public void userUpdate(UserRequest userRequest) throws Exception{
        UserModel userModel = userRepo.findById(userRequest.getId()).orElseThrow(()->new Exception("No user found"));
        if(Objects.nonNull(userRequest.getName())){
            userModel.setName(userRequest.getName());
        } else if(Objects.nonNull(userRequest.getEmail())){
            userModel.setName(userRequest.getEmail());
        }
        userRepo.save(userModel);//will update the data in the table
    }
    public void userDelete(UserRequest userRequest) throws Exception{
        UserModel userModel = userRepo.findById(userRequest.getId()).orElseThrow(()->new Exception("No user found"));
        if(Objects.nonNull(userRequest.getName())){
            userModel.setName(userRequest.getName());
        } else if(Objects.nonNull(userRequest.getEmail())){
            userModel.setName(userRequest.getEmail());
        }
        userRepo.delete(userModel);//will delete the userRow in the table
    }
}
