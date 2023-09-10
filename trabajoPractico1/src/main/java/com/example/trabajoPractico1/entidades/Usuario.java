package com.example.trabajoPractico1.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario extends BaseEntidad{
    private String Nombre;
    private String contrasenia;
    private String rol;

    @OneToMany(orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id")
    @Builder.Default
    private List<Pedido> pedidos = new ArrayList<>();
    public void agregarPedidos(Pedido pedi) {
        pedidos.add(pedi);
    }

    public void mostrarPedidos() {
        System.out.println("Pedidos del usuario " + Nombre + ":");
        for (Pedido pedido : pedidos) {
            System.out.println("Fecha: " + pedido.getFecha() +
                    ", Estado: " + pedido.getEstado() +
                    ", Hora estimada de entrega: " + pedido.getHoraEstimadaEntrega() +
                    ", Tipo de envío: " + pedido.getTipoEnvio() +
                    ", Total: " + pedido.getTotal());
        }
    }
}
