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
public class Producto extends BaseEntidad {
    @Enumerated(EnumType.STRING)
    private Tipo tipo;
    public enum Tipo{ manufacturado, insumo}

    private int tiempoEstimadoCocina;
    private String Denominacion;
    private double  precioVenta;
    private double precioCompra;
    private int stockActual;
    private int stockMinimo;
    private String unidadMedida;
    private String foto;
    private String receta;

}
