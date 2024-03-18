package com.example.practicaJava.DTO;



import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DiagnosticoDTO {
    private Long id;
    private String valoracionEspecialista;
    private String enfermedad;
    private Long citaId;

}
