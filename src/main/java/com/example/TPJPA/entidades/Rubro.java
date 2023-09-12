package com.example.TPJPA.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "rubro")
public class Rubro extends BaseEntidad{
    private String denominacion;

    //Relacion con Producto
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
    @JoinColumn(name = "idRubro")     //Es PrimaryKey
    @Builder.Default

    private List<Producto> productos = new ArrayList<>();
    public void agregarProducto(Producto pro){
        productos.add(pro);
    }




    }

