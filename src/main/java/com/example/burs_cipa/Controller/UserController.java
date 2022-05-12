package com.example.burs_cipa.Controller;

import com.example.burs_cipa.Model.User;
import com.example.burs_cipa.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@Controller
public class UserController {

    @Autowired private UserService service;

    @GetMapping(value="")
    public String home(Model model, @Param("keyword") String keyword){
        model.addAttribute("user", new User());
        List<User> users = service.findAll(keyword);
        model.addAttribute("users", users);
        model.addAttribute("keyword", keyword);

        return "view/users";
    }
    @PostMapping(value = "/fileupload")
    public String uploadFile(@Valid @ModelAttribute User user, RedirectAttributes redirectAttributes) {
        boolean isFlag = service.saveDataFromUploadFile(user.getFile());
        if(isFlag){
            redirectAttributes.addFlashAttribute("successmessage", "File has been uploaded Successfully!!");
        }else {
            redirectAttributes.addFlashAttribute("errormessage", "File has not been uploaded !!");
        }
        return "redirect:/";
    }


}

