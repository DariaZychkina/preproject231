package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import web.module.User;
import web.service.UserDaoService;
import web.service.UserDaoServiceImp;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {
    private final UserDaoService userService;
    @Autowired
    public UserController(UserDaoService userService) {
        this.userService = userService;
    }


    @GetMapping()
    public String getPartOfCarsList(ModelMap model) {
        model.addAttribute("users", userService.getUsersList());
        return "users";
    }
    @GetMapping(value = "/editUser/{id}")
    public String editUser(@PathVariable int id, ModelMap model) {
        model.addAttribute("user", userService.getById(id));
        return "editUser";
    }
    @GetMapping(value = "/addUser")
    public String addUser(ModelMap model) {
        model.addAttribute("user", new User());
        return "addUser";
    }
    @GetMapping(value="/deleteUser/{id}")
    public String deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return "redirect:/";
    }

    @RequestMapping(value="/editUser/{getId}", method = RequestMethod.POST)
    public String saveEditUser(@PathVariable int getId, @ModelAttribute("user") User user){
        user.setId(getId);
        userService.updateUser(user);
        return "redirect:/";
    }
    @RequestMapping(value="/addUser", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("user") User user){
        userService.addUser(user);
        return "redirect:/";
    }


}
