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
@Table(name = "cliente")            //Cómo se llama la tabla
public class Cliente extends BaseEntidad {
    @Column(name = "nombre")
    private String nombre;

    private String apellido;
    private String telefono;
    private String email;

    //Relacion a domicilio
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
    @JoinColumn(name = "idCliente")
    @Builder.Default

    private List<Domicilio> domicilios = new ArrayList<>();


    public void agregarDomicilio(Domicilio domi){
        domicilios.add(domi);
    }
    public void mostrarDomicilios(){
        System.out.println("Cliente: "+nombre+ " " + apellido+ ": ");

        System.out.println("Sus domicilios es:");

        for (Domicilio domicilio : domicilios){
            System.out.println("Calle: " + domicilio.getCalle() + ", Numero: "+ domicilio.getNumero()+", Localidad: " + domicilio.getLocalidad());
        }
        System.out.println(" ");
    }


    //Relacion con Pedido
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
    @JoinColumn(name = "idCliente")     //Es PrimaryKey
    @Builder.Default

    private List<Pedido> pedidos = new ArrayList<>();
    public void agregarPedido(Pedido pedi){
        pedidos.add(pedi);
    }
    public void mostrarPedidos(){
        System.out.println("Pedido:"+ nombre+ " " + apellido+ ": ");
        for (Pedido pedido: pedidos){
            System.out.println("Estado: " + pedido.getEstado() + ", Fecha: "+ pedido.getFecha()+", Tipo Envio: " + pedido.getTipoEnvio() + ", Total: " + pedido.getTotal() );
        }
        System.out.println(" ");
    }


    }


