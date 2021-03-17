package it.realt.projectgiacomofilm.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class FilmItemDto {
    private Long id;
    private String title;
    private int duration;
    private String genre;
}
