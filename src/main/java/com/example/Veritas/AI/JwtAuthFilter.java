package com.example.Veritas.AI;

import com.example.Veritas.AI.security.JwtService;
import com.example.Veritas.AI.service.CustomService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
@Service
public class JwtAuthFilter  extends OncePerRequestFilter {

    @Autowired
     JwtService service;
    @Autowired
    ApplicationContext context;

    protected void doFilterInternal(HttpServletRequest request,HttpServletResponse response,
                            FilterChain filterChain )throws ServletException,IOException{
        String header = request.getHeader("Authorization");
        if (header != null && header.startsWith("Bearer ")) {


            String token = header.substring(7);
            String username = service.extractUsername(token);

            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                UserDetails userDetails = context.getBean(CustomService.class).loadUserByUsername(username);
                if (service.validateToken(token, userDetails)) {
                    UsernamePasswordAuthenticationToken authtoken =
                            new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    authtoken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authtoken);
                }
            }
        }
        filterChain.doFilter(request, response);
    }
}
