package com.example.trabajoPractico1.entidades;

import jakarta.persistence.*;
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
public class DetallePedido extends BaseEntidad {

    private int cantidad;
    private double subtotal;

    @ManyToOne()          //si es ManyToOne no lleva parentesis, va solo la anotacion
    @JoinColumn(name = "producto_id")
    private Producto producto;

}
