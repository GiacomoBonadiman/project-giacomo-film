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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String birthPlace;
    private LocalDate birthDate;

    @ManyToMany(mappedBy = "directors")
    private Set<Film> films = new HashSet<>();

    public Director(String name) {
        this.name = name;
    }


}
