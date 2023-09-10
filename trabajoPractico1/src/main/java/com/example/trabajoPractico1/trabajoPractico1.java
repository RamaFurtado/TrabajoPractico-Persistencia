package com.example.trabajoPractico1;

import com.example.trabajoPractico1.entidades.*;
import com.example.trabajoPractico1.repositorios.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalTime;

@SpringBootApplication
public class trabajoPractico1 {
	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	DetallePedidoRepository detallePedidoRepository;
	@Autowired
	DomicilioRepository domicilioRepository;
	@Autowired
	FacturaRepository facturaRepository;
	@Autowired
	PedidoRepository pedidoRepository;
	@Autowired
	ProductoRepository productoRepository;
	@Autowired
	RubroRepository rubroRepository;
	@Autowired
	UsuarioRepository usuarioRepository;

	public static void main(String[] args) {
		SpringApplication.run(trabajoPractico1.class, args);
		System.out.println("Persistencia funcionando correctamente");
	}
	@Transactional
	@Bean
	CommandLineRunner init(ClienteRepository clienteRepository, DetallePedidoRepository detallePedidoRepository,
						   DomicilioRepository domicilioRepository, FacturaRepository facturaRepository,
						   PedidoRepository pedidoRepository, ProductoRepository productoRepository,
						   RubroRepository rubroRepository, UsuarioRepository usuarioRepository) {
		return args -> {
			System.out.println("Aplicación funcionando");

			// Creo instancias de todas las clases:
			Producto producto = Producto.builder()
					.foto("pizza.jpg")
					.Denominacion("Pizza")
					.tipo(Producto.Tipo.manufacturado)
					.receta("receta_pizza_link")
					.tiempoEstimadoCocina(30)
					.precioVenta(730.00)
					.precioCompra(500.00)
					.stockActual(200)
					.stockMinimo(50)
					.unidadMedida("por unidad")
					.build();
			productoRepository.save(producto);
			Rubro rubro = Rubro.builder()
					.denominacion("Gastronomía")
					.build();
			rubro.agregarProductos(producto);
			rubroRepository.save(rubro);

			DetallePedido detallePedido = DetallePedido.builder()
					.cantidad(2)
					.subtotal(1460.00)
					.build();
			detallePedido.setProducto(producto);
			detallePedidoRepository.save(detallePedido);
			Factura factura = Factura.builder()
					.fecha(LocalDate.of(2023,9,9))
					.numero(1)
					.descuento(0.0)
					.formaPago(Factura.FormaPago.mercadopago)
					.total(1560)
					.build();
			facturaRepository.save(factura);
			Pedido pedido = Pedido.builder()
					.Fecha("09/09/2023")
					.estado(Pedido.Estado.preparacion)
					.horaEstimadaEntrega(LocalTime.of(19,30))
					.tipoEnvio(Pedido.TipoEnvio.delivery)
					.total(1200.00)
					.build();
			pedido.agregarDetalles(detallePedido);
			pedido.setFactura(factura);
			pedidoRepository.save(pedido);

			Usuario usuario = Usuario.builder()
					.Nombre("Agustina")
					.rol("Gerente")
					.contrasenia("agus4352")
					.build();
			usuario.agregarPedidos(pedido);

			usuarioRepository.save(usuario);
			Cliente cliente = Cliente.builder()
					.nombre("Marcos")
					.apellido("Mautino")
					.email("marcosmautino@mail.com")
					.telefono("+54 121 5485678")
					.build();
			cliente.agregarPedidos(pedido);
			clienteRepository.save(cliente);

			Domicilio domicilio = Domicilio.builder()
					.calle("Urquiza ")
					.numero("2548")
					.localidad("Maipu")
					.build();
			domicilio.agregarPedidos(pedido);
			domicilio.setCliente(cliente);
			domicilioRepository.save(domicilio);

			//---------------------------------------------------------------------//

			/*Producto producto2 = Producto.builder()
					.foto("hamburguesa.jpg")
					.Denominacion("Hamburguesa")
					.tipo(Producto.Tipo.insumo)
					.receta("receta_hamburguesa_link")
					.tiempoEstimadoCocina(35)
					.precioVenta(780.00)
					.precioCompra(500.00)
					.stockActual(250)
					.stockMinimo(100)
					.unidadMedida("por unidad")
					.build();
			productoRepository.save(producto2);
			Rubro rubro2 = Rubro.builder()
					.denominacion("Comida rápida")
					.build();
			rubro.agregarProductos(producto2);
			rubroRepository.save(rubro2);
			DetallePedido detallePedido2 = DetallePedido.builder()
					.cantidad(1)
					.subtotal(1890.00)
					.build();
			detallePedido.setProducto(producto2);
			detallePedidoRepository.save(detallePedido2);
			Factura factura2 = Factura.builder()
					.fecha(LocalDate.of(2023,9,10))
					.numero(2)
					.descuento(0.0)
					.formaPago(Factura.FormaPago.mercadopago)
					.total(1890)
					.build();
			facturaRepository.save(factura2);
			Pedido pedido2 = Pedido.builder()
					.Fecha("10/09/2023")
					.estado(Pedido.Estado.entregado)
					.horaEstimadaEntrega(LocalTime.of(18,30))
					.tipoEnvio(Pedido.TipoEnvio.retira)
					.total(1890.00)
					.build();
			pedido.agregarDetalles(detallePedido2);
			pedido.setFactura(factura2);
			pedidoRepository.save(pedido2);

			Usuario usuario2 = Usuario.builder()
					.Nombre("Ramiro")
					.rol("empleado")
					.contrasenia("abcd234")
					.build();
			usuario.agregarPedidos(pedido2);
			usuarioRepository.save(usuario2);
			Cliente cliente2 = Cliente.builder()
					.nombre("Martin")
					.apellido("Rover")
					.email("martinrover@mail.com")
					.telefono("+54 121 4565678")
					.build();
			cliente.agregarPedidos(pedido2);
			clienteRepository.save(cliente2);
			Domicilio domicilio2 = Domicilio.builder()
					.calle("Cacheuta")
					.numero("848")
					.localidad("Godoy Cruz")
					.build();
			domicilio.agregarPedidos(pedido2);
			domicilio.setCliente(cliente2);
			domicilioRepository.save(domicilio2);*/


		};
	}

}

