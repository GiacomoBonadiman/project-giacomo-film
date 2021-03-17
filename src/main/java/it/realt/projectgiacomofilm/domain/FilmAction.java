package it.realt.projectgiacomofilm.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "film_action")
@Inheritance(strategy = InheritanceType.JOINED)
public class FilmAction extends Film {
    public static final String TYPE = "ACTION";

    @Column(name = "cod_action")
    private String codiceAction;
    private String descrizione;

    public FilmAction() {
        this.setType(TYPE);
    }

    public FilmAction(Long id, LocalDate date, String type, Director director){
        super(id, date, TYPE, director);
    }


}
