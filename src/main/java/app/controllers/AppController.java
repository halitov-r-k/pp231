package app.controllers;

import app.models.User;
import app.service.AppService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AppController {
    /*private final AppDao appDao;
    public AppController(AppDao appDao) {
        this.appDao = appDao;
    }*/

    private final AppService appService;

    public AppController(AppService appService) {
        this.appService = appService;
    }

    @GetMapping()
    public String openUsers(Model model){
      //  List<User> userList = appDao.getUserList();
        List<User> userList = appService.getUserList();
        model.addAttribute("userList", userList);
        return "users";
    }
}
