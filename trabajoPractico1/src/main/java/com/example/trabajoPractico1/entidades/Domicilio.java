package com.example.trabajoPractico1.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.trabajoPractico1.entidades.Cliente;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Domicilio extends BaseEntidad {


    private String calle;
    private String numero;
    private String localidad;

    @OneToMany(orphanRemoval = true, fetch = FetchType.EAGER)
    @Builder.Default
    private List<Pedido> pedidos = new ArrayList<>();
    @ManyToOne()
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    // Métodos para los pedidos

    public void agregarPedidos(Pedido pedi) {
        pedidos.add(pedi);
    }
    public void mostrarPedidos() {
        System.out.println("Pedidos de " + calle + " " + numero + ", " + localidad + ": ");
        for (Pedido pedido : pedidos) {
            System.out.println("Fecha: " + pedido.getFecha() +
                    ", Estado: " + pedido.getEstado() +
                    ", Hora estimada de entrega: " + pedido.getHoraEstimadaEntrega() +
                    ", Tipo de envío: " + pedido.getTipoEnvio() +
                    ", Total: " + pedido.getTotal());
        }
    }
}
