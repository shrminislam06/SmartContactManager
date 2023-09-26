package com.SmartManager.SmartContactManager.Config;

import com.SmartManager.SmartContactManager.entity.Users;
import com.SmartManager.SmartContactManager.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDtlServiceIMPL implements UserDetailsService {
    @Autowired
    private UsersRepository usersRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

      Users  users=usersRepository.getUsersByEmail(username);
      if(users==null)
      {
          throw new UsernameNotFoundException("user not found.!");
      }
        return new CustomUserDetails(users);
    }
}
