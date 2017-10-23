package server.example.server.Controllers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import server.example.server.Models.Users;
import server.example.server.repositories.UsersRepository;

import java.util.List;

@Controller
@CrossOrigin(origins = {"http://localhost:4200","http://localhost:5200"}, maxAge = 3600)
public class UsersController {
  //@Autowired
  private UsersRepository repository;

  public UsersController(UsersRepository repository) {
    this.repository = repository;
  }

  //  public boolean ifUserExists(Users user)
//  {
//        return repository.ifExists(user.getUsername(),user.getPassword());
//  }

//  @RequestMapping(value= "/users/all", method = RequestMethod.GET)
//  public @ResponseBody List<Users> getAll()
//  {
//    return repository.findAll();
//
//  }
//
//  @RequestMapping(value= "/users/{username}", method = RequestMethod.GET)
//  public @ResponseBody Users getByUsername(@PathVariable("username") String username)
//  {
//    return repository.findUsersByUsername(username);
//
//  }
}
