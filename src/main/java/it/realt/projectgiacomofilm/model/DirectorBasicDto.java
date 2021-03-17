package it.realt.projectgiacomofilm.model;

import it.realt.projectgiacomofilm.domain.Film;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class DirectorBasicDto {

    private Long id;
    private String name;
    private String birthPlace;
    private LocalDate birthDate;
    private Set<Film> film = new HashSet<>();
}
