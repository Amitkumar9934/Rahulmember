package com.rahulmember.service;

import com.rahulmember.entity.UserDetail;
import com.rahulmember.repository.UserDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserDetailService {

    @Autowired
    private UserDetailRepository userDetailRepository;

    public boolean userExists(String username) {
        Optional<UserDetail> user = userDetailRepository.findByUsername(username);
        return user.isPresent();
    }

    public UserDetail createUser(UserDetail userDetail) {
        if (userExists(userDetail.getUsername())) {
            throw new IllegalArgumentException("User already exists with this username.");
        }
        return userDetailRepository.save(userDetail);
    }
}
