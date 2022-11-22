package app.controllers;

import app.models.User;
import app.service.AppService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
public class AppController {
    static private final Logger LOGGER = Logger.getLogger("AppControllerLogger");
    private final AppService appService;

    public AppController(AppService appService) {
        this.appService = appService;
    }

    @GetMapping()
    public String openUsers(Model model){

        List<User> userList = appService.getUserList();
        LOGGER.log(Level.INFO, "openUsers(), parameter: userList.size()=" + userList.size() );
        model.addAttribute("userList", userList);
        return "users";
    }
    @RequestMapping("/addUser")
    public String addUser(Model model){
        LOGGER.log(Level.INFO, "addUsers()");
        User user = new User();
        model.addAttribute("user", user);
        return "user-new";
    }

    @RequestMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        LOGGER.log(Level.INFO, "saveUsers(): parameter: user=" + user.toString());
        appService.saveUser(user);
        return "redirect:/";
    }

    @RequestMapping("/getUser/{id}")
    public String getUser(@PathVariable("id") Integer id, Model model) {
        User user = appService.getUser(id);
        LOGGER.log(Level.INFO, "getUsers() parameter: id=" + id);
        model.addAttribute("user", user);
        return "user-update";
    }

    @PatchMapping("/updateUser")
     public String updateUser(@ModelAttribute("user") User user) {
        LOGGER.log(Level.INFO, "updateUsers() parameter: user=" + user.toString() );
        appService.updateUser(user);
        return "redirect:/";
    }

    @DeleteMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") Integer id) {
        LOGGER.log(Level.INFO, "deleteUsers(), parameter: id=" + id);
        appService.deleteUser(id);
        return "redirect:/";
    }

}
