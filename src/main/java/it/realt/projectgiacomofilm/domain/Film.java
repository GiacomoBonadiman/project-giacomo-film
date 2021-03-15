package it.realt.projectgiacomofilm.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private int duration;

    @ManyToOne
    private Productor productor;

    public Productor getProductor() {
        return productor;
    }

    public void setProductor(Productor productor) {
        this.productor = productor;
    }

    @ManyToMany
    @JoinTable(name = "director_film", joinColumns = @JoinColumn(name="film_id"),
            inverseJoinColumns = @JoinColumn(name="director_id"))
    private Set<Director> directors = new HashSet<>();

    public Film() {
    }

    public Film(String title, int duration, Set<Director> directors) {
        this.title = title;
        this.duration = duration;
        this.directors = directors;
    }

    public Film(String title, int duration) {
        this.title = title;
        this.duration = duration;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Set<Director> getDirectors() {
        return directors;
    }

    public void setDirectors(Set<Director> directors) {
        this.directors = directors;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", duration=" + duration +
                ", productor=" + productor +
                ", directors=" + directors +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Film film = (Film) o;

        return id != null ? id.equals(film.id) : film.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

}

