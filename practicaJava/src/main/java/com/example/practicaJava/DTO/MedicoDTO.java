package com.example.practicaJava.DTO;


import com.example.practicaJava.modelo.Cita;
import com.example.practicaJava.modelo.Paciente;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class MedicoDTO extends UsuarioDTO{


    private String numColegiado;
    //private ArrayList<Paciente> pacientesId = new ArrayList<>();
   // private ArrayList<Cita> citasId = new ArrayList<>();

}
