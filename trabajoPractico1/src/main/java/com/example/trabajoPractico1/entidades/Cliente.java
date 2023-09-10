package com.example.trabajoPractico1.entidades;

import jakarta.persistence.*;
import lombok.*;
import com.example.trabajoPractico1.entidades.Pedido;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cliente extends BaseEntidad {


    private String nombre;
    private String apellido;
    private String telefono;
    private String email;

    @OneToMany(orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "cliente_id")
    @Builder.Default
    private List<Pedido> pedidos = new ArrayList<>();

    public void agregarPedidos(Pedido pedi) {
        pedidos.add(pedi);
    }
    public void mostrarPedidos() {
        System.out.println("Datos del cliente" + nombre + " " + apellido + ":" + "telefono: " + telefono
                + "email: "+ email);
        System.out.println("Pedidos del cliente");
        for (Pedido pedido : pedidos) {
            System.out.println("Fecha: " + pedido.getFecha()
                    + ",Número: " + pedido.getEstado()
                    + ",Hora estimada de entrega:  " + pedido.getHoraEstimadaEntrega()
                    + ",Tipo de envio: " + pedido.getTipoEnvio()
                    + ",Total: " + pedido.getTotal()
            );
        }

    }

}
