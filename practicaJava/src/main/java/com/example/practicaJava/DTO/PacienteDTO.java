package com.example.practicaJava.DTO;





import com.example.practicaJava.modelo.Cita;
import com.example.practicaJava.modelo.Medico;
import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PacienteDTO extends UsuarioDTO{
        private String NSS;
        private String numTarjeta;
        private String telefono;
        private String direccion;
        private ArrayList<Medico> medicos =new ArrayList<>();
        private ArrayList<Cita> citas  = new ArrayList<>();

    }


