package com.example.trabajoPractico1.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Factura extends BaseEntidad{

    private LocalDate fecha;
    private int numero;
    private double descuento;
    private int total;
    @Enumerated(EnumType.STRING)
    private FormaPago formaPago;
    public enum FormaPago{efectivo, credito, debito, mercadopago,}





}
