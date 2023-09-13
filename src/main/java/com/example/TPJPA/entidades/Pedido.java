package com.example.TPJPA.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "pedido")
public class Pedido extends BaseEntidad {
    private Date fecha;
    private double total;
    private String estado;
    private String tipoEnvio;

    //Relacion con Factura (puntero)
    @OneToOne(cascade = CascadeType.ALL)        //cascada se persiste tanto factura como pedido
    @JoinColumn(name = "factura_id")            //Es la vinculación y cómo se va a llamar
    private Factura factura;



    //Relacion con Detalle Pedido
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
    @JoinColumn(name = "pedido_id")
    @Builder.Default

    private List<DetallePedido> detallesPedidos = new ArrayList<>();


    //metodos
    public void agregarDetallePedido(DetallePedido pedi){
        detallesPedidos.add(pedi);
    }
    public void mostrarDetallePedido(){
      ;
        for (DetallePedido detallePedido : detallesPedidos){
            System.out.println("Cantidad: "  + detallePedido.getCantidad() + ", sub Total: "+ detallePedido.getSubTotal());
        }
        System.out.println(" ");
    }



    }








