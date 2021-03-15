package it.realt.projectgiacomofilm.bootstrap;


import it.realt.projectgiacomofilm.domain.Director;
import it.realt.projectgiacomofilm.domain.Film;
import it.realt.projectgiacomofilm.domain.Productor;
import it.realt.projectgiacomofilm.repositories.DirectorRepository;
import it.realt.projectgiacomofilm.repositories.FilmRepository;
import it.realt.projectgiacomofilm.repositories.ProductorRepository;
import org.springframework.boot.CommandLineRunner;

public class BootStrapData implements CommandLineRunner {

    private final DirectorRepository directorRepository;
    private final FilmRepository filmRepository;
    private final ProductorRepository productorRepository;

    public BootStrapData(DirectorRepository directorRepository, FilmRepository filmRepository, ProductorRepository productorRepository) {
        this.directorRepository = directorRepository;
        this.filmRepository = filmRepository;
        this.productorRepository = productorRepository;

    }

    @Override
    public void run(String... args) throws Exception {
        Productor productor = new Productor();
        productor.setName("Sony");
        productor.setCity("Culver City");
        productor.setState("California");
        productor.setNation("USA");
        productorRepository.save(productor);

        Director dir = new Director("Russo Brothers");
        Film cap = new Film("Captain America: Civil War", 147);
        dir.getFilms().add(cap);
        cap.getDirectors().add(dir);

        cap.setProductor(productor);
        productor.getFilms().add(cap);

        directorRepository.save(dir);
        filmRepository.save(cap);
        productorRepository.save(productor);

        Productor productor2 = new Productor();
        productor2.setName("EON Productions");
        productor2.setCity("Londra");
        productor2.setState("England");
        productor2.setNation("UK");
        productorRepository.save(productor2);

        Director sam = new Director("Sam Mendes");
        Film bond = new Film("007: Skyfall", 143);
        sam.getFilms().add(bond);
        bond.getDirectors().add(sam);

        bond.setProductor(productor2);
        productor2.getFilms().add(bond);

        directorRepository.save(sam);
        filmRepository.save(bond);
        productorRepository.save(productor2);



    }
}

