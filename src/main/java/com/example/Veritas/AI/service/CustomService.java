package com.example.Veritas.AI.service;

import com.example.Veritas.AI.Repository.AppInterfacerepo;
import com.example.Veritas.AI.user.AppUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomService implements UserDetailsService {
    AppInterfacerepo repo;
    PasswordEncoder encoder;
    CustomService(AppInterfacerepo repo,PasswordEncoder encoder){
        this.repo=repo;
        this.encoder=encoder;
    }


    public void register(AppUser user) {
        user.setPassword(encoder.encode(user.getPassword()));
        repo.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user=repo.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("username not found"));
        return org.springframework.security.core.userdetails.User.withUsername(user.getUsername())
                .password(user.getPassword()).build();
    }
}
