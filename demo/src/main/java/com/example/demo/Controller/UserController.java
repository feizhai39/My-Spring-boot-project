package com.example.demo.Controller;

import com.example.demo.Model.UserModel;
import com.example.demo.Request.LoginRequest;
import com.example.demo.Request.UserRequest;
import com.example.demo.Service.UserService;
import com.example.demo.Response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("login")
    public String login(@RequestBody LoginRequest loginRequest){
        if(loginRequest.getEmail().equals("test@gmail.com") &&
                loginRequest.getPassword().equals("test")){
            return "ok";
        }else{
            return "error";
        }

    }

    //get the user list from the user table(database)
    @GetMapping("list")
    public ResponseEntity<List<UserModel>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());//success response
    }

    //create users
    @PostMapping("create")
    public ResponseEntity<?> createUser(@RequestBody UserRequest userRequest){
        userService.createUser(userRequest);
        UserResponse userResponse = new UserResponse();
        userResponse.setMessage("User is created..");
        return ResponseEntity.ok(userResponse);
    }
    //update user details
    @PostMapping("update")
    public ResponseEntity<?> updateUser(@RequestBody UserRequest userRequest){
        UserResponse userResponse = new UserResponse();
        try{
            userService.userUpdate(userRequest);
            userResponse.setMessage("User is updated..");
            return ResponseEntity.ok(userResponse);
        }catch(Exception e){
            userResponse.setMessage("Error "+ e.getMessage());
            return ResponseEntity.badRequest().body(userResponse);
        }
    }
    //delete user details
    @PostMapping("delete")
    public ResponseEntity<?> deleteUser(@RequestBody UserRequest userRequest){
        UserResponse userResponse = new UserResponse();
        try{
            userService.userDelete(userRequest);
            userResponse.setMessage("User is deleted..");
            return ResponseEntity.ok(userResponse);
        }catch(Exception e){
            userResponse.setMessage("Error "+ e.getMessage());
            return ResponseEntity.badRequest().body(userResponse);
        }
    }




}
