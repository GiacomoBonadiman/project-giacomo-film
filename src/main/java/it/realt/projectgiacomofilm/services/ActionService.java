package it.realt.projectgiacomofilm.services;

import it.realt.projectgiacomofilm.model.FilmActionDto;

import java.util.Optional;

public interface ActionService {
    Optional<FilmActionDto> getFilmActionById(Long directorId, Long filmId);
    FilmActionDto getFilmAction(Long directorId);

    FilmActionDto addFilmAction(Long directorId, FilmActionDto filmActionDto);
    FilmActionDto updateFilmAction(Long directorId, FilmActionDto filmActionDto);
    FilmActionDto deleteFilmAction(Long directorId, Long filmId);
}
