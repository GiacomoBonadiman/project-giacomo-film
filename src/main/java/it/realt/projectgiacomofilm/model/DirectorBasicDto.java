package it.realt.projectgiacomofilm.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class DirectorBasicDto {

    private Long id;
    private String name;
    private String birthPlace;
    private LocalDate birthDate;
}
