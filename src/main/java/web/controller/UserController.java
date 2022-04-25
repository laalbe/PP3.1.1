package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String getUsers(Model model) {
        model.addAttribute("allUsers", userService.getAllUsers());
        return "users";
    }

    @GetMapping("/new")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "newUser";
    }

    @GetMapping("{id}")
    public String updateUser(Model model, @PathVariable("id") long id) {
        model.addAttribute("user", userService.getUser(id));
        return "updateUser";
    }

    @PostMapping
    public String newPerson(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/";
    }

    @PatchMapping("{id}")
    public String userUpdate(@PathVariable("id") Long id,@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/";
    }
    @DeleteMapping("delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }
}