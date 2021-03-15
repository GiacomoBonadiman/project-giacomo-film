package it.realt.projectgiacomofilm.repositories;


import it.realt.projectgiacomofilm.domain.Film;
import org.springframework.data.repository.CrudRepository;

public interface FilmRepository  extends CrudRepository<Film, Long> {
}
