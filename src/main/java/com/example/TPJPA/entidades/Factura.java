package com.example.TPJPA.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "factura")
public class Factura extends BaseEntidad {
    private int numero;
    private Date fecha;
    private double descuento;
    private String formaPago;
    private int total;



}



