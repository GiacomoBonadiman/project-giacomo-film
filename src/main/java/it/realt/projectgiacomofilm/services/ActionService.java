package it.realt.projectgiacomofilm.services;

import it.realt.projectgiacomofilm.model.FilmActionDto;

import java.util.List;
import java.util.Optional;

public interface ActionService {
    Optional<FilmActionDto> getFilmActionById(Long directorId, Long filmId);
    List<FilmActionDto> getFilmAction(Long directorId);

    FilmActionDto addFilmAction(Long directorId, FilmActionDto filmActionDto);
    FilmActionDto updateFilmAction(Long directorId, FilmActionDto filmActionDto);
    void deleteFilmAction(Long directorId, Long filmId);
}
