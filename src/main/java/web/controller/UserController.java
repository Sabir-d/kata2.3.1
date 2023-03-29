package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.Service;
import web.service.ServiceUser;


@Controller
@RequestMapping("/users")
public class UserController {

    private final Service serviceUser;

    @Autowired
    public UserController(Service serviceUser) {
        this.serviceUser = serviceUser;
    }

    @GetMapping()
    public String users(Model model) {
        model.addAttribute("user", serviceUser.findAll());
        return "users";
    }

    @GetMapping("/{id}")
    public String user(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", serviceUser.findOne(id));
        return "user";
    }

    @GetMapping("new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") User user) {
        serviceUser.save(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", serviceUser.findOne(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user, Model model, @PathVariable("id") Long id) {
        serviceUser.update(id, user);
        return "redirect:/users";
    }

    @DeleteMapping({"/{id}"})
    public String delete(@PathVariable("id") Long id) {
        serviceUser.delete(id);
        return "redirect:/users";
    }

}