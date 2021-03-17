package it.realt.projectgiacomofilm.services;

import it.realt.projectgiacomofilm.domain.Director;
import it.realt.projectgiacomofilm.domain.FilmAction;
import it.realt.projectgiacomofilm.repositories.DirectorRepository;
import it.realt.projectgiacomofilm.test.ServicesAndRepositoriesConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;


@SpringBootTest(classes = {ServicesAndRepositoriesConfig.class})
@Slf4j
class DirectorServiceTest {

    @Autowired
    private DirectorService directorService;

    @Autowired
    private DirectorRepository directorRepository;

    @BeforeEach
    public void deleteAll() {
        directorRepository.deleteAll();
    }

    @Test
    public void testSave() {

        Director directora = new Director()
                .setName("Quentin Tarantino")
                .setBirthDate(LocalDate.of(1963, 3, 27))
                .setBirthPlace("Knoxville");
        directorService.save(directora);

        Director director = new Director()
                .setName("Clint Eastwood")
                .setBirthDate(LocalDate.of(1930, 5, 31))
                .setBirthPlace("San Francisco");

       // director.addFilm(new FilmAction()
       //         .setCodiceAction("A")
       //         .setDescrizione("aaa"));

        this.directorService.save(director);

        director.getFilms()
                .stream()
                .filter(f -> f.getGenre().equalsIgnoreCase("action"))
                .findFirst().ifPresent(film -> ((FilmAction)film)
                .setCodiceAction("T"));

        this.directorService.save(director);
    }
}