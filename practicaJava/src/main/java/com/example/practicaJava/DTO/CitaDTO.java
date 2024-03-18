package com.example.practicaJava.DTO;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CitaDTO {

    private Long id;
    private Date fechaHora;
    private String motivoCita;
    private int attribute11;
    private Long pacienteId;
    private Long medicoId;
    private Long diagnosticoId;
}


