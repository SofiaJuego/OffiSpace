<h1 align="center">🏢OffiSpace - Plataforma de reservas de espacios de trabajo</h1>

OffiSpace es una aplicación web que permite a los usuarios buscar, visualizar y reservar distintos tipos de espacios, como oficinas privadas, salas de reuniones o lugares para eventos. Está orientada tanto a clientes que desean reservar espacios como a administradores que gestionan la oferta disponible.
<h4> 🚧 Este proyecto se encuentra en desarrollo.</h4>

### 🔍Funcionalidades principales

| Funcionalidad                                                             | Usuario no autenticado | Usuario autenticado (cliente) | Administrador |
|---------------------------------------------------------------------------|------------------------|-------------------------------|---------------|
| 🔍 Buscar espacios por filtros (ciudad, tipo, etc.)                        | ✅                      | ✅                             | ✅             |
| 👁️ Ver detalle de un espacio (precio, imágenes, ubicación, etc.)          | ✅                      | ✅                             | ✅             |
| 🏷️ Ver categorías y características disponibles                            | ✅                      | ✅                             | ✅             |
| 📚 Registrarse e iniciar sesión                                           | Necesita autenticación                      | ✅                             | ✅             |
| ⭐ Agregar/quitar espacios a favoritos                                    | ❌                      | ✅                             | ❌             |
| 📆 Realizar una reserva                                                   | ❌                      | ✅                             | ❌             |
| 📄 Ver historial de reservas                                              | ❌                      | ✅                             | ❌             |
| 🗣️ Crear, editar y eliminar reseñas (reviews)                             | ❌                      | ✅                             | ❌             |
| 🛠️ Espacios (crear, actualizar, eliminar)                   | ❌                      | ❌                            | ✅             |
| 🗂️ Categorías (crear, actualizar, eliminar)                                                      | ❌                      | ❌                             | ✅             |
| ⚙️ Características (crear, actualizar, eliminar)               | ❌                      | ❌                              | ✅             |
| 🧑‍💼 Asignar rol de administrador a otros usuarios                         | ❌                      | ❌                             | ✅             |
| 🧪 Acceder al panel de administración                                     | ❌                      | ❌                             | ✅             |

### 🛠️ Tecnologías utilizadas
##### Backend
- Java
- Spring Boot(Spring Web, Spring Security(JWT))
- JPA / Hibernate
- Base de datos en memoria H2
- Lombok
  
##### Frontend
- React native

##### Testing
- JUnit 5
- MockMvc

##### UX/UI
- Figma

### 📁 Estructura de carpetas
```
src
├── main
│   ├── java
│   │   └── com.offispace
│   │       ├── auth
│   │       ├── configuration
│   │       │   └── swaggerConfig
│   │       ├── controller
│   │       ├── dto
│   │       │   ├── request
│   │       │   └── response
│   │       ├── exception
│   │       ├── model
│   │       │   └── enum
│   │       ├── repository
│   │       └── service
│   │           └── impl
│   └── resources
│       └── application.properties
└── test
    └── java
        └── com.offispace
            └── controller
```
### 🔐 Seguridad y Clave Secreta
Este proyecto utiliza JWT (JSON Web Tokens) para la autenticación.
La clave secreta (jwt.secret) y otras configuraciones sensibles se almacenan en el archivo application.properties, el cual está ignorado en Git para evitar exponer información privada.
📁 Para facilitar las pruebas, se incluye el archivo application-example.properties con una configuración de ejemplo:

```
-Configuración de la base de datos en memoria H2
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.url=jdbc:h2:mem:offispace
spring.datasource.username=sa
spring.datasource.password=

-Configuración de JPA/Hibernate
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=create-drop

-Puerto del servidor
server.port=8081

-Configuración de JWT (reemplazar con una clave segura)
jwt.secret=my-secret-key-placeholder
jwt.expiration=86400000

```
### 🛑 Importante:

Para mayor seguridad, reemplazá my-secret-key-placeholder por una clave generada de forma segura.
Podés usar esta herramienta online para obtener una clave de 256 bits:
🔗 https://asecuritysite.com/encryption/plain
Luego, renombrá application-example.properties a application.properties o configurá tu entorno para que lo lea.

# 🙋‍♀️Contáctame [<img src="https://img.shields.io/badge/linkedin-%230077B5.svg?&style=for-the-badge&logo=linkedin&logoColor=white" />](https://www.linkedin.com/in/pratik-kumar04/)


