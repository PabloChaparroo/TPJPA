package com.example.TPJPA;


import com.example.TPJPA.entidades.*;
import com.example.TPJPA.repositorios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;



@SpringBootApplication
public class TpjpaApplication {
	@Autowired
			ClienteRepository clienteRepository;
	@Autowired
			DomicilioRepository domicilioRepository;
	@Autowired
			FacturaRepository facturaRepository;
	@Autowired
			DetallePedidoRepository detallePedidoRepository;
	@Autowired
			ProductoRepository productoRepository;
	@Autowired
			PedidoRepository pedidoRepository;
	@Autowired
	RubroRepository rubroRepository;


	public static void main(String[] args) {
		SpringApplication.run(TpjpaApplication.class, args);
		System.out.println(" ");
		System.out.println("Este programa funcionó correctamente");
	}
	//ClienteRepository ClienteRepo
	@Bean
	CommandLineRunner init() {
		return args -> {

			System.out.println("\n...........Ejecutando..............");


			//Cliente
			Cliente cliente1 = Cliente.builder()
					.email("pablochaparro@gmail.com")
					.nombre("Pablo")
					.apellido("Chaparro")
					.telefono("23456789")
					.build();

			Cliente cliente2 = Cliente.builder()
					.email("lucas@gmail.com")
					.nombre("Lucas")
					.apellido("Gonzales")
					.telefono("9999999")
					.build();


			//Domicilios
			Domicilio domicilio1 = Domicilio.builder()
					.calle("Jose Ingenieros")
					.numero("234")
					.localidad("Guaymallén San Jose")
					.build();

			Domicilio domicilio2 = Domicilio.builder()
					.calle("Mitre")
					.numero("2342")
					.localidad("Ciudad")
					.build();

			Domicilio domicilio3 = Domicilio.builder()
					.calle("Sarmiento")
					.numero("5520")
					.localidad("Maipu")
					.build();

			//Pedidos:
			Pedido pedido1 = Pedido.builder()
					.total(1499.99)
					.fecha(null)
					.estado("iniciado")
					.tipoEnvio("delivery")
					.build();

			Pedido pedido2 = Pedido.builder()
					.total(2000)
					.fecha(null)
					.estado("preparacion")
					.tipoEnvio("retira")
					.build();

			Pedido pedido3 = Pedido.builder()
					.total(2000)
					.fecha(null)
					.estado("entregado")
					.tipoEnvio("retira")
					.build();

			//Facturas:
			Factura factura1 = Factura.builder()
					.fecha(null)
					.numero(123456)
					.descuento(300.55)
					.formaPago("Efectivo")
					.total(8000)
					.build();

			Factura factura2 = Factura.builder()
					.fecha(null)
					.numero(98426145)
					.descuento(555.85)
					.formaPago("Mercado Pago")
					.total(5000)
					.build();

			//DetallePedidos
			DetallePedido detallePedido1 = DetallePedido.builder()
					.cantidad(4)
					.subTotal(400)
					.build();
			DetallePedido detallePedido2 = DetallePedido.builder()
					.cantidad(10)
					.subTotal(589)
					.build();
			DetallePedido detallePedido3 = DetallePedido.builder()
					.cantidad(3)
					.subTotal(200)
					.build();

			//Productos
			Producto producto1 = Producto.builder()
					.tipo("manufacturado")
					.tiempo(2)
					.denominacion("Hamburguesa")
					.precioVenta(800.50)
					.precioCompra(1000.00)
					.stockActual(50)
					.stockMinimo(5)
					.unidadMedida("Kg")
					.receta("Queso chedal con pepinillo......")
					.build();

			Producto producto2 = Producto.builder()
					.tipo("insumo")
					.tiempo(30)
					.denominacion("pizza")
					.precioVenta(600.50)
					.precioCompra(800.00)
					.stockActual(20)
					.stockMinimo(5)
					.unidadMedida("Kg")
					.receta("Salsa de tomate con queso chedal......")
					.build();

			Rubro rubro1 = Rubro.builder()
					.denominacion("Delivery")
					.build();

			Rubro rubro2 = Rubro.builder()
					.denominacion("Empleado")
					.build();

			Rubro rubro3 = Rubro.builder()
					.denominacion("Administrador")
					.build();

			//Asociacion Detalle Pedido  a Producto
			detallePedido1.setProducto(producto1);
			detallePedido2.setProducto(producto1);
			detallePedido3.setProducto(producto2);


			//Asociacion Pedido a Detalle pedido
			pedido1.agregarDetallePedido(detallePedido1);
			pedido1.agregarDetallePedido(detallePedido2);
			pedido3.agregarDetallePedido(detallePedido3);



			pedido1.mostrarDetallePedido();
			pedido2.mostrarDetallePedido();
			pedido3.mostrarDetallePedido();

			//Asociación Pedido a Factura (puntero)
			pedido1.setFactura(factura1);
			pedido3.setFactura(factura2);




			//Asociación Cliente a Domicilio
			cliente1.agregarDomicilio(domicilio1);
			cliente1.agregarDomicilio(domicilio2);

			cliente2.agregarDomicilio(domicilio3);

			cliente1.mostrarDomicilios();
			cliente2.mostrarDomicilios();

			//Asociacion Cliente a Pedido
			cliente1.agregarPedido(pedido1);
			cliente1.agregarPedido(pedido2);
			cliente2.agregarPedido(pedido3);
			cliente1.mostrarPedidos();
			cliente2.mostrarPedidos();

			//Asociacion de Rubro con producto
			rubro1.agregarProducto(producto1);
			rubro2.agregarProducto(producto1);
			rubro3.agregarProducto(producto2);



			//Guardar cliente con la asociasión correspondientes de domicilios
			clienteRepository.save(cliente1);
			clienteRepository.save(cliente2);
			domicilioRepository.save(domicilio1);
			domicilioRepository.save(domicilio2);
			domicilioRepository.save(domicilio3);
			pedidoRepository.save(pedido1);
			pedidoRepository.save(pedido2);
			pedidoRepository.save(pedido3);
			facturaRepository.save(factura1);
			facturaRepository.save(factura2);
			detallePedidoRepository.save(detallePedido1);
			detallePedidoRepository.save(detallePedido2);
			detallePedidoRepository.save(detallePedido3);
			productoRepository.save(producto1);
			productoRepository.save(producto2);


			//Recuperar el objeto desde la base de datos
			Cliente clienteRecuperada = clienteRepository.findById(cliente1.getId()).orElse(null);
			if (clienteRecuperada != null) {
				System.out.println("\nNombre: " + clienteRecuperada.getNombre());
				System.out.println("Apellido " + clienteRecuperada.getApellido());
				System.out.println("Telefono: " + clienteRecuperada.getTelefono());
				System.out.println("Email: " + clienteRecuperada.getEmail());
			}


		};

	}


}

