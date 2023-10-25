# API de Spring Boot: Documentación API

## Descripción General

Esta API ha sido diseñada para optimizar la gestión de una tienda virtual, facilitando la administración de usuarios, supervisores, productos y las complejas interacciones entre productos y cestas de compra.

## Clases Principales

### Usuario
La clase Usuario representa la entidad de usuario con un constructor para instancias y métodos eficientes, incluyendo identificador único (nameId), contraseña (contrasena), nombre (nombre), apellido (apellido), y correo electrónico (correo).

### Admin
La clase Administrador modela la entidad de administrador con un constructor y métodos eficientes, incluyendo identificador único (nameId), contraseña (contrasena), nombre (nombre), apellido (apellido), y correo electrónico (correo).

### Producto
La clase Producto representa un artículo con un constructor flexible para describir el producto, incluyendo nombre (nombre), descripción (descripcion), especificaciones (especificacion), precio (precio), disponibilidad (disponible), marca (marca), URL de la imagen principal (urlImagen), URL de la imagen de especificación (imagenEspecificacionUrl), estado destacado (destacado), cantidad en oferta (oferta), y categoría (categoria).

### ProductoCesta
La clase ProductoCesta modela la relación entre producto y cesta con un constructor para información esencial: URL de la imagen de especificación (imagenEspecificacionUrl), nombre del producto (nombre), precio del producto (precio), e identificador del usuario (idUsuario).

## Endpoints Disponibles
La API ofrece operaciones CRUD con ejemplos clave:

- Crear Producto: `POST /productos/`
- Obtener Producto por Nombre: `GET /productos/nombre/{nombre}`
- Actualizar Producto: `PUT /productos/{id}`
- Eliminar Producto: `DELETE /productos/{id}`
- Obtener Producto por ID: `GET /productos/{id}`
- Obtener Todos los Productos: `GET /productos`
- Obtener Productos en Oferta: `GET /productos/oferta`
- Obtener Productos por Precio: `GET /productos/precio`
- Obtener Productos Destacados: `GET /productos/destacado`
- Obtener Productos por Categoría: `GET /productos/categoria`

## Ejecución del Proyecto
1. Clonar el repositorio: `git clone https://github.com/tu-usuario/nombre-del-repo.git`
2. Navegar al directorio del proyecto: `cd nombre-del-repo`
3. Actualizar `application.properties`
4. Ejecutar la aplicación: `./mvnw spring-boot:run`
5. La aplicación estará en [http://localhost:8080](http://localhost:8080)

<br>
Esta API es un proyecto de aprendizaje explora las características y desarrolla la API.