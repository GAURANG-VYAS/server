package server.example.server.Security;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import server.example.server.Models.Users;
import server.example.server.repositories.UsersRepository;


public class MongoUserDetailService  implements UserDetailsService{



  private UsersRepository repository;


  private User userdetails;

  public UserDetails loadUserByUsername(String username)
    throws UsernameNotFoundException {


    boolean enabled = true;
    boolean accountNonExpired = true;
    boolean credentialsNonExpired = true;
    boolean accountNonLocked = true;
    Users user = getUserDetail(username);
    System.out.println(username);
    System.out.println(user.getPassword());
    System.out.println(user.getUsername());
    System.out.println(user.getType());

    userdetails = new User(user.getUsername(),
      user.getPassword(),
      enabled,
      accountNonExpired,
      credentialsNonExpired,
      accountNonLocked,
      getAuthorities(user.getRole()));
    return userdetails;
  }

  public List<GrantedAuthority> getAuthorities(String role) {
    List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
    if (role.compareTo("User") == 0) {
      authList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));

    } else if (role.compareTo("Admin") == 0) {
      authList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }
    System.out.println(authList);
    return authList;
  }

  public Users getUserDetail(String username) {
    Users user = repository.findUsersByUsername(username);
    System.out.println(user.toString());
    return user;
  }
}
