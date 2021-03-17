package it.realt.projectgiacomofilm.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class FilmActionDto{

    private Long id;
    private Long directorId;
    private String title;
    private int duration;
    private DirectorBasicDto director;

    private String codiceAction;
    private String descrizione;
}
