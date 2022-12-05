package web.controller;

import web.module.User;
import web.service.UserDaoServiceImp;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {
    @GetMapping(value = "/users")
    public String getPartOfCarsList(ModelMap model) {
        List<User> users = new UserDaoServiceImp().getUsersList();
        model.addAttribute("users", users);
        return "users";
    }
}
