package it.realt.projectgiacomofilm.services;


import it.realt.projectgiacomofilm.model.DirectorBasicDto;
import it.realt.projectgiacomofilm.model.DirectorDto;

import java.util.Optional;

public interface DirectorService extends ActionService{

    Optional<DirectorDto> getDirectorById(Long id);
    DirectorDto addDirector(DirectorBasicDto directorDto);
    DirectorDto updateDirector(DirectorBasicDto directorDto);
    void deleteDirector(Long id);
}
