package net.learningproj.journalApp.service;

import lombok.extern.slf4j.Slf4j;
import net.learningproj.journalApp.entity.User;
import net.learningproj.journalApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username);
        if (user != null) {
           // log.debug("User found: {}", username);  // Add logging here
            return org.springframework.security.core.userdetails.User.builder()
                    .username(user.getUserName())
                    .password(user.getPassword())  // Make sure to get password correctly
                    .roles(user.getRoles().toArray(new String[0]))  // Make sure roles are correctly set
                    .build();
        } else {
           // log.error("User not found: {}", username);  // Log error if user not found
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}
