# TPJPA
**Desarrollo de Software**

## Trabajo Práctico N°1 - JPA
**Email Profesores:** pablobautic15@gmail.com

El proyecto se desarrolló con IntelliJ y con un Framework Object Relational Mapping (ORM) llamado Spring.

### Dependencias utilizadas:
- Spring Boot DevTools
- Lombok
- Spring Web
- H2 Database
- Spring Data JPA

### Contenidos
- JAVA

### Desarrollo del código
- **Importaciones:** Al principio, importe las clases necesarias para el proyecto, incluyendo las entidades y repositorios que se usarán para interactuar con la base de datos.

- **Anotaciones:** Utilice anotaciones de Spring, como `@SpringBootApplication` para configurar la aplicación y `@Autowired` para inyectar las dependencias de los repositorios.

- **Método main:** El método main inicia la aplicación Spring Boot y muestra un mensaje de confirmación en la consola.

- **Inicialización de datos:** Utilice un método `init` anotado con `@Bean` y `CommandLineRunner` para inicializar datos de ejemplo en la base de datos. Para poder compilar y demostrar la base de datos, cree las entidades clientes, domicilios, pedidos, facturas, detalles de pedidos, productos y rubros, y establezca relaciones entre ellos. Créelos con el método `builder()` para poder desplazarlos de manera desordenada. Además, cree una entidad `BaseEntidad` de la cual hereden los ID de cada entidad.

- **Creación de Clientes:** Cree dos objetos Cliente llamados `cliente1` y `cliente2` con detalles como nombre, apellido, email y teléfono.

- **Creación de Domicilios:** Cree tres objetos Domicilio con detalles de dirección, calle, número y localidad.

- **Creación de Pedidos:** Cree tres objetos Pedido con información como total, estado y tipo de envío.

- **Creación de Facturas:** Cree dos objetos Factura con detalles como fecha, número, descuento, forma de pago y total.

- **Creación de Detalles de Pedidos:** Cree tres objetos DetallePedido con información sobre la cantidad y el subtotal.

- **Creación de Productos:** Cree dos objetos Producto con detalles como tipo, tiempo de preparación, denominación, precios, stock y receta.

- **Creación de Rubros:** Cree tres objetos Rubro con detalles de denominación.

- **Asociaciones de Objetos:**
  - Los detalles de pedidos se asocian con productos mediante el método `setProducto`.
  - Los pedidos agregan detalles de pedido mediante el método `agregarDetallePedido`.
  - Los pedidos se asocian con facturas mediante el método `setFactura`.
  - Los clientes agregan domicilios mediante el método `agregarDomicilio`.
  - Los clientes agregan pedidos mediante el método `agregarPedido`.
  - Los rubros agregan productos mediante el método `agregarProducto`.

- **Almacenamiento en la Base de Datos:** Se guardan los objetos en la base de datos utilizando los repositorios correspondientes como `clienteRepository`, `domicilioRepository`, etc.

- **Recuperación de Datos:** Se recupera un cliente de la base de datos por su ID utilizando el método `findById` y se muestra su información en la consola.

### Uso
- Una vez compilado el proyecto, muestra en consola algunas notaciones de características de las entidades.
- Para ejecutarlo, abre http://localhost:8080/h2-console/ en tu navegador para hacer consultas en la base de datos H2 y verificar las relaciones del diagrama.


