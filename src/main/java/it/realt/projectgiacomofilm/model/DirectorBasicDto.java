package it.realt.projectgiacomofilm.model;

import it.realt.projectgiacomofilm.domain.Film;

import java.util.HashSet;
import java.util.Set;

public class DirectorBasicDto {

    private Long id;
    private String name;

    private Set<Film> films = new HashSet<>();
}
