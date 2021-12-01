package com.chambea.security;


import com.chambea.security.services.UserDetailsServiceImpl;
import com.chambea.security.util.JwtTokenUtil;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    private final JwtTokenUtil jwtTokenUtil;
    private final UserDetailsServiceImpl userDetailsService;

    JwtRequestFilter(JwtTokenUtil jwtTokenUtil, UserDetailsServiceImpl userDetailsService){
        this.jwtTokenUtil = jwtTokenUtil;
        this.userDetailsService = userDetailsService;
    }


    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {

        //Get auth header from request and validate.
        final String header = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (null == header){
            filterChain.doFilter(request, response);
            return;
        }

        if (!header.startsWith("Bearer ")){
            filterChain.doFilter(request, response);
            return;
        }

        //Get and validate jwt
        final String token = header.split(" ")[1].trim();
        if (!jwtTokenUtil.validateToken(token)){
            filterChain.doFilter(request, response);
            return;
        }

        //Get username from token
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(
                jwtTokenUtil.getUsername(token));

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null
                );
        authenticationToken.setDetails(
                new WebAuthenticationDetailsSource().buildDetails(request)
        );

        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        filterChain.doFilter(request, response);

    }
}
