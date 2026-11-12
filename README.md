# CaffeNet – Backend

API REST para la gestión de una cafetería: productos, carrito de compras, pedidos, mesas y reservas, pagos y comprobantes.

Proyecto académico de la **Corporación Universitaria del Huila (CORHUILA)** – Ingeniería de Sistemas, desarrollado en equipo.
Backend desarrollado por **Oscar Guillermo Sierra Lozano**. El frontend (Angular + Ionic) está en [CaffeNet](https://github.com/Yefersom10/CaffeNet).

## Tecnologías

- Java 17 · Spring Boot 3.3
- Spring Web · Spring Data JPA (Hibernate)
- MySQL 8
- Spring Mail (recuperación de contraseña)
- Springdoc OpenAPI / Swagger UI
- HTTPS con certificado local (PKCS12)
- Docker y Docker Compose · Jenkins (pipeline de compilación e imagen)
- Maven (wrapper incluido)

## Funcionalidades

| Módulo | Ruta base | Qué hace |
|---|---|---|
| Usuarios y administradores | `/api` | Registro, inicio de sesión, validación de email, recuperación de contraseña por correo |
| Productos | `/api/v1/producto` | Catálogo del menú |
| Carrito de compras | `/api/v1/carbuys` | Agregar, consultar y vaciar el carrito |
| Detalle de pedido | `/api/v1/detalle_pedido` | Productos de cada pedido |
| Pagos | `/api/v1/pago` | Pago de pedidos |
| Comprobantes | `/api/v1/comprobante` | Generación y consulta de comprobantes de pago |
| Mesas | `/api/v1/mesas` | Disponibilidad, ocupar, liberar y finalizar mesas |
| Reservas | `/api/v1/reserva` | Reservas de mesas |
| Pagos y comprobantes de reserva | `/api/v1/pago/reserva`, `/api/v1/comprobante_reserva` | Pago y comprobante de cada reserva |

## Estructura

```
Backend-CaffeNet/
└── src/main/java/com/corhuila/Backend_CaffeNet/
    ├── common/               # Controlador, servicio y entidad base genéricos (CRUD común)
    ├── configuration/        # Configuración CORS
    └── modules/              # Un paquete por dominio
        └── <módulo>/
            ├── Controller/
            ├── Service/ · IService/
            ├── IRepository/
            └── Entity/
```

## Cómo ejecutarlo

### Con Docker Compose

```bash
cd Backend-CaffeNet
docker compose up --build
```

Levanta la API y una base de datos MySQL 8. La API queda expuesta en el puerto `9000` del host.

### En local

**Requisitos:** JDK 17 y MySQL 8.

1. Crea la base de datos `CaffeNet`.
2. Ajusta `src/main/resources/application.properties` con **tus propios** datos:
   - conexión a MySQL (`spring.datasource.*`)
   - cuenta SMTP (`spring.mail.username`, `spring.mail.password`)
   - certificado HTTPS (`server.ssl.*`), o desactívalo con `server.ssl.enabled=false`
3. Ejecuta:

```bash
cd Backend-CaffeNet
./mvnw spring-boot:run
```

La API queda en `https://localhost:8082` y la documentación interactiva en
`https://localhost:8082/swagger-ui.html`. Al arrancar se cargan datos iniciales desde `data.sql`.

## Ejemplos de endpoints

| Método | Ruta | Descripción |
|---|---|---|
| POST | `/api/addUser` | Registrar usuario |
| POST | `/api/loginUser` | Iniciar sesión |
| GET | `/api/v1/producto` | Listar productos |
| POST | `/api/v1/carbuys` | Agregar producto al carrito |
| DELETE | `/api/v1/carbuys/deleteAll` | Vaciar el carrito |
| GET | `/api/v1/mesas/{id}/disponible` | Consultar si una mesa está libre |
| POST | `/api/v1/reserva/addReservation` | Reservar una mesa |
| POST | `/api/v1/comprobante/generar_comprobante` | Generar comprobante de pago |

La lista completa está en Swagger UI.
