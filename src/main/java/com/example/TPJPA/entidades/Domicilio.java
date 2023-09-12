package com.example.TPJPA.entidades;

import com.fasterxml.jackson.databind.ser.Serializers;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Domicilio extends BaseEntidad {
    private String calle;
    private String numero;
    private String localidad;

}

