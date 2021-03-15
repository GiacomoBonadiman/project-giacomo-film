package it.realt.projectgiacomofilm.controllers;

import it.realt.projectgiacomofilm.repositories.FilmRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

public class FilmController {
    private final FilmRepository filmRepository;

    public FilmController(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    @RequestMapping("/films")
    public String getFilms(Model model){
        model.addAttribute("films", filmRepository.findAll());

        return "films";
    }
}
