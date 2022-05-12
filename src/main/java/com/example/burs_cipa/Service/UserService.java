package com.example.burs_cipa.Service;

import com.example.burs_cipa.Model.User;
import com.example.burs_cipa.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;
import com.example.burs_cipa.Model.UserNotFoundException;

import java.util.List;
import java.util.Optional;

public class UserService implements UserS{

    @Autowired
    private UserRepository repo;

    public List<User> findAll(String keyword) {
        if (keyword != null) {
            return repo.search(keyword);
        }
        return (List<User>)repo.findAll();
    }

    @Override
    public List<User> findAll() {
        return (List<User>)repo.findAll();
    }

    @Override
    public boolean saveDataFromUploadFile(MultipartFile file) {
        return false;
    }
}
