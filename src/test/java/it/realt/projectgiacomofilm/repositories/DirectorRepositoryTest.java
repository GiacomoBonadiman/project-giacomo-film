package it.realt.projectgiacomofilm.repositories;

import it.realt.projectgiacomofilm.domain.Director;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.notNullValue;
@Tag("repository")
@Tag("director")
@ExtendWith(SpringExtension.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest

class DirectorRepositoryTest {

    @Autowired
    private DirectorRepository directorRepository;

    @Test
    public void testVoid(){
        List<Director> directorList = directorRepository.findAll();
        assertThat(directorList, hasSize(2));
    }
    @Test
    public void should_add_director(){
        Director director = new Director()
                .setName("James Cameron")
                .setBirthDate(LocalDate.of(1954, 8, 16 ))
                .setBirthPlace("Canada")
                ;

        Director dbDirector = directorRepository.save(director);
        assertThat(dbDirector.getId(), notNullValue());
        assertThat(dbDirector.getFilms(), hasSize(3));
    }

}