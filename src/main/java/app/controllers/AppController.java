package app.controllers;

import app.models.User;
import app.service.AppService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class AppController {
    private final AppService appService;

    public AppController(AppService appService) {
        this.appService = appService;
    }

    @GetMapping()
    public String openUsers(Model model){
        List<User> userList = appService.getUserList();
        model.addAttribute("userList", userList);
        return "users";
    }
    @RequestMapping("/addUser")
    public String addUser(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "user";
    }

    @RequestMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        appService.saveUser(user);
        return "redirect:/";
    }

    @RequestMapping("/updateUser/{id}")
    public String updateUser(@PathVariable("id") Integer id, Model model) {
        User user = appService.getUser(id);
        model.addAttribute("user", user);
        return "user";
    }
    @RequestMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") Integer id) {
        appService.deleteUser(id);
        return "redirect:/";
    }
}
