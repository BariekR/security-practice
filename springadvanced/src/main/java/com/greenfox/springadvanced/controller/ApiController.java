package com.greenfox.springadvanced.controller;

import com.greenfox.springadvanced.dto.AuthenticationRequest;
import com.greenfox.springadvanced.dto.AuthenticationResponse;
import com.greenfox.springadvanced.service.MovieService;
import com.greenfox.springadvanced.service.MyUserDetailsService;
import com.greenfox.springadvanced.util.JwtUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class ApiController {
    private MovieService movieService;
    private AuthenticationManager authenticationManager;
    private MyUserDetailsService myUserDetailsService;
    private JwtUtil jwtTokenUtil;

    @GetMapping("/movies")
    public ResponseEntity<?> listMovies() {
        return ResponseEntity.ok(movieService.listMovies());
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),authenticationRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }

        final UserDetails userDetails = myUserDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());
        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

    @GetMapping("/vault")
    public ResponseEntity<?> vault() {
        return ResponseEntity.ok("vault content");
    }
}
