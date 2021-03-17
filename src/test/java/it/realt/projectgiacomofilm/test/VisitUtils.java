package it.realt.projectgiacomofilm.test;

import it.realt.projectgiacomofilm.model.FilmActionDto;

public class VisitUtils {
    public static FilmActionDto action(){
        return new FilmActionDto()
                .setTitle("007")
                .setDuration(143)
                .setCodiceAction("AZIONE")
                .setDescrizione("action film");
    }
}
