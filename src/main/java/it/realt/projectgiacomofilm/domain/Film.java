package it.realt.projectgiacomofilm.domain;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)

@Entity
@Table(name="film")
@Inheritance(strategy = InheritanceType.JOINED)
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private int duration;

    @Column(name="film_genre")
    private String genre;

    @ManyToOne(optional = false)
    @JoinColumn(name = "productor_id", nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Productor productor;

    @ManyToMany
    @JoinTable(name = "director_film", joinColumns = @JoinColumn(name="film_id"),
            inverseJoinColumns = @JoinColumn(name="director_id"))
    private Set<Director> directors = new HashSet<>();



    public Film(String title, int duration, Set<Director> directors) {
        this.title = title;
        this.duration = duration;
        this.directors = directors;
    }

    public Film(String title, int duration) {
        this.title = title;
        this.duration = duration;
    }

}

