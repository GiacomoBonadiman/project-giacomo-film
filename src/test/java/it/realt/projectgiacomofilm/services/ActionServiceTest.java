package it.realt.projectgiacomofilm.services;

import it.realt.projectgiacomofilm.domain.FilmAction;
import it.realt.projectgiacomofilm.model.FilmActionDto;
import it.realt.projectgiacomofilm.repositories.DirectorRepository;
import it.realt.projectgiacomofilm.test.ServicesAndRepositoriesConfig;
import it.realt.projectgiacomofilm.test.VisitUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(classes = {ServicesAndRepositoriesConfig.class})
@Slf4j
class ActionServiceTest {

    @Autowired
    private DirectorService directorService;

    @Autowired
    private DirectorRepository directorRepository;

    @Test
    public void test_getFilmActionById() {
        Long directorId = -125L;
        assertAll("",
                () -> assertTrue(directorService.getFilmActionById(directorId, -8L).isPresent()),
                () -> assertFalse(directorService.getFilmActionById(directorId, -9L).isPresent()));
    }

    @Test
    public void test_getFilmAction() {
        Long directorId = -125L;
        assertAll("",
                () -> assertThat(directorService.getFilmAction(directorId), hasSize(2)));
    }

    @Test
    public void test_add_update_delete_Film() {
        Long directorId = -125L;
        try {
            FilmActionDto filmActionDto = directorService.addFilmAction(directorId, VisitUtils.action());
            assertAll("",
                    () -> assertThat(directorService.getFilmAction(directorId), hasSize(3)),
                    () -> assertThat(filmActionDto.getDirectorId(), is(directorId)),
                    () -> assertThat(filmActionDto.getCodiceAction(), is("ACTION")));

            filmActionDto.setCodiceAction("THRILLER");
            FilmActionDto filmActionDtoUpdate = directorService.updateFilmAction(directorId, filmActionDto);
            assertAll("",
                    () -> assertThat(directorService.getFilmAction(directorId), hasSize(3)),
                    () -> assertThat(filmActionDtoUpdate.getDirectorId(), is(directorId)),
                    () -> assertThat(filmActionDtoUpdate.getCodiceAction(), is("THRILLER")));

            directorService.deleteFilmAction(directorId, filmActionDto.getId());
            assertAll("",
                    () -> assertThat(directorService.getFilmAction(directorId), hasSize(2)));
        } finally {
            directorService.getDirectorById(directorId).ifPresent(d -> d
                    .getFilms()
                    .stream()
                    .filter(f -> f.getGenre().equalsIgnoreCase(FilmAction.GENRE))
                    .filter(f -> f.getId() > 0L)
                    .forEach(f -> directorService.deleteFilmAction(directorId, f.getId()))
                    );
        }

    }
}