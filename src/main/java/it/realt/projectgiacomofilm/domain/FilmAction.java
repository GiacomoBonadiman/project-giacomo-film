package it.realt.projectgiacomofilm.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Set;

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "film_action")
@Inheritance(strategy = InheritanceType.JOINED)
public class FilmAction extends Film {
    public static final String GENRE = "ACTION";

    @Column(name = "cod_action")
    private String codiceAction;
    private String descrizione;

    public FilmAction() {
        this.setGenre(GENRE);
    }

    public FilmAction(Long id, String title, int duration, String genre, Productor productor, Set<Director> director){
        super(id, title, duration, GENRE, productor, director);
    }


}
