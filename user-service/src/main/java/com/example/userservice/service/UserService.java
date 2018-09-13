package com.example.userservice.service;

import com.example.userservice.entity.User;
import com.example.userservice.entity.UserLoginDTO;
import com.example.userservice.exception.UserLoginException;
import com.example.userservice.jwt.AuthServiceClient;
import com.example.userservice.jwt.JWT;
import com.example.userservice.repository.UserRepository;
import com.example.userservice.util.BPwdEncoderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    AuthServiceClient client;
    @Autowired
    private UserRepository userRepository;

    public User insertUser(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        return userRepository.save(user);
    }

    public UserLoginDTO login(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (null == user) {
            throw new UserLoginException("error username");
        }
        if (!BPwdEncoderUtil.matches(password, user.getPassword())) {
            throw new UserLoginException("error password");
        }
        JWT jwt = client.getToken("Basic U2FtcGxlQ2xpZW50SWQ6c2VjcmV0", "password", username, password);
        if (jwt == null) {
            throw new UserLoginException("error internal");
        }
        UserLoginDTO userLoginDTO = new UserLoginDTO();
        userLoginDTO.setJwt(jwt);
        userLoginDTO.setUser(user);
        return userLoginDTO;
    }
}
