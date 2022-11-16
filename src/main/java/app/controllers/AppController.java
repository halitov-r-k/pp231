package app.controllers;

import app.dao.AppDao;
import app.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AppController {
    private final AppDao appDao;

    public AppController(AppDao appDao) {
        this.appDao = appDao;
    }

    @GetMapping()
    public String openUsers(Model model){
        List<User> userList = appDao.getListUsers();
        model.addAttribute("userList", userList);
        return "users";
    }
}
