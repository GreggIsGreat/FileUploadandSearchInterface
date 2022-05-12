package com.example.burs_cipa.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.burs_cipa.Model.User;
import com.example.burs_cipa.Repository.UserRepository;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public interface UserS {
    List<User> findAll();

    boolean saveDataFromUploadFile(MultipartFile file);

}
