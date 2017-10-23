package server.example.server.Controllers;


import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.SpringVersion;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.userdetails.User;
import server.example.server.Models.Users;
import server.example.server.repositories.UsersRepository;

@Controller
//@CrossOrigin(origins = {"http://localhost:4200","http://localhost:5200"}, maxAge = 3600)
public class MainController {

  @Autowired
  UsersRepository repository;
  @RequestMapping(value = "/", method = RequestMethod.GET)
//  @CrossOrigin(origins = {"http://localhost:4200","http://localhost:5200"}, maxAge = 3600)
  public String defaultPage(ModelMap map) {
    System.out.println("Version " + SpringVersion.getVersion());
//    User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//    String name = user.getUsername();
//    System.out.println("Username  : "+name);
    return "redirect:http://localhost:4200";
  }

  @RequestMapping(value = "/login", method = RequestMethod.GET)
  public String login(ModelMap model) {
    return "redirect:http://localhost:5200";
  }

  @RequestMapping(value = "/logout", method = RequestMethod.GET)
  public String logout(ModelMap model) {
    return "redirect:http://localhost:4200";
  }



//  @RequestMapping(value= "/users/all", method = RequestMethod.GET)
//  public @ResponseBody void  getAll(ModelMap model)
//  {
//
//    Iterable<Users> users= repository.findAll();
//    model.addAttribute("users", users);
//    System.out.println("Listed All");
//
//  }
//
  @RequestMapping(value= "/users/{username}", method = RequestMethod.GET)
  public @ResponseBody void getByUsername(ModelMap model, @PathVariable("username") String username)
  {

    model.addAttribute("user", repository.findUsersByUsername(username));
    System.out.println("Listed One");
  }

  @RequestMapping(value = "/accessdenied")
  public String loginerror(ModelMap model) {
    model.addAttribute("error", "true");
    return "redirect:https://www.drupal.org/node/20397";
  }


}
