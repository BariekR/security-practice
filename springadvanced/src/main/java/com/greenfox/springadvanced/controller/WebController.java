package com.greenfox.springadvanced.controller;

import com.greenfox.springadvanced.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;

@Controller
@AllArgsConstructor
public class WebController {
    private MovieService movieService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/saveMovie")
    public String saveMovie(Long idOfMovie) throws IOException {
        movieService.saveRequestedMovie(idOfMovie);
        return "redirect:/";
    }
}
