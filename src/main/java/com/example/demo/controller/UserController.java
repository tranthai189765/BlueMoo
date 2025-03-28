package com.example.demo.controller;

import com.example.demo.entity.Resident;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.service.ResidentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/user") 
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private ResidentService residentService;

    @GetMapping("/home")
    public Map<String, Object> home(Principal principal) {
        String username = principal.getName();
        User user = userService.findByName(username);
        Resident resident = residentService.findById(user.getResidentId());

        Map<String, Object> response = new HashMap<>();
        response.put("username", user.getName());
        response.put("resident", resident);

        return response;
    }

    @PostMapping("/change-password")
    public Map<String, String> changePassword(@RequestParam Long userId,
                                              @RequestParam String oldPassword,
                                              @RequestParam String newPassword) {
        String result = userService.changePassword(userId, oldPassword, newPassword);
        Map<String, String> response = new HashMap<>();
        response.put("message", result);
        return response;
    }
}
