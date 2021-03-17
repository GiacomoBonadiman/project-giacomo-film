package it.realt.projectgiacomofilm.domain;


import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Accessors(chain = true)
@Table(name = "director")
public class Director {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    private String birthPlace;

    private LocalDate birthDate;

    //@ManyToMany(mappedBy = "directors")
    @OneToMany( mappedBy = "director", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Film> films = new HashSet<>();

//    public Director addFilm(Film film) {
//        film.setDirectors(this);
//        this.films.add(film);
//        return this;
//    }
}
