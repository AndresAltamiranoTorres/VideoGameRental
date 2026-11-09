🎮 VideoGameRental

VideoGameRental es una aplicación de escritorio desarrollada en Java Swing para gestionar el alquiler de videojuegos. Permite administrar usuarios, videojuegos, plataformas, stock y devoluciones mediante una interfaz gráfica intuitiva.


🚀 Funcionalidades

👤 Gestión de usuarios

Registrar nuevos usuarios.

Consultar los usuarios registrados.

Eliminar usuarios.

Impedir la eliminación de usuarios con alquileres activos.

Generar automáticamente la fecha de registro.

🎮 Gestión de videojuegos

Registrar nuevos videojuegos.

Seleccionar el género del videojuego.

Asociar diferentes plataformas a cada videojuego.

Gestionar el stock independientemente para cada plataforma.

Consultar las unidades disponibles.

Evitar registrar plataformas sin stock.

Impedir la eliminación de videojuegos con alquileres activos.

📋 Gestión de alquileres

Registrar nuevos alquileres.

Seleccionar usuarios y videojuegos existentes.

Mostrar las plataformas disponibles según el videojuego seleccionado.

Comprobar automáticamente la disponibilidad de stock.

Generar automáticamente el número de registro.

Asignar automáticamente las fechas de inicio y devolución.

Registrar devoluciones.

Actualizar el stock después de cada alquiler o devolución.

Diferenciar visualmente los alquileres activos y devueltos mediante colores.

📊 Panel principal

Mostrar el número total de usuarios registrados.

Mostrar el número total de videojuegos.

Mostrar el número de alquileres activos.

🛠️ Tecnologías utilizadas

Java – Lenguaje de programación.

Java Swing – Desarrollo de la interfaz gráfica.

Apache Maven – Gestión y construcción del proyecto.

NetBeans IDE – Entorno de desarrollo.

Git y GitHub – Control de versiones y alojamiento del código.

🏗️ Arquitectura del proyecto

El proyecto utiliza una organización basada en el patrón MVC (Modelo-Vista-Controlador), separando las responsabilidades de la aplicación.

Paquete

Descripción

model

Clases que representan los usuarios, videojuegos, plataformas y alquileres.

view

Ventanas, formularios y paneles de la interfaz gráfica.

controller

Gestión de operaciones y reglas de negocio.

exception

Excepciones personalizadas para controlar errores y validaciones.

📁 Estructura del proyecto

VideoGameRental/
│
├── src/
│   └── main/
│       └── java/
│           └── com/altamirano/videogamerental/
│               │
│               ├── controller/
│               │   ├── UserController.java
│               │   ├── GameController.java
│               │   └── RentalController.java
│               │
│               ├── model/
│               │   ├── User.java
│               │   ├── Game.java
│               │   ├── Genre.java
│               │   ├── Platform.java
│               │   ├── PlatformStock.java
│               │   ├── Rental.java
│               │   └── RentalStatus.java
│               │
│               ├── view/
│               │   ├── MainView.java
│               │   ├── PanelInicio.java
│               │   ├── PanelUsers.java
│               │   ├── PanelGames.java
│               │   ├── PanelRentals.java
│               │   ├── DialogNewUser.java
│               │   ├── DialogNewGame.java
│               │   └── DialogNewRental.java
│               │
│               ├── exception/
│               │
│               └── VideoGameRental.java
│
├── pom.xml
└── README.md

⚙️ Requisitos

Para ejecutar el proyecto necesitas:

Java JDK.

Apache Maven.

NetBeans IDE (recomendado).

▶️ Instalación y ejecución

1. Clonar el repositorio

Abre una terminal y ejecuta:

git clone https://github.com/AndresAltamiranoTorres/VideoGameRental.git

2. Abrir el proyecto

Abre NetBeans IDE.

Selecciona File → Open Project.

Busca la carpeta VideoGameRental.

Abre el proyecto Maven.

3. Ejecutar la aplicación

Ejecuta el proyecto desde NetBeans utilizando la clase principal:

VideoGameRental.java

💾 Almacenamiento de datos

La aplicación utiliza colecciones en memoria (ArrayList) para gestionar los usuarios, videojuegos y alquileres.

No se utiliza una base de datos. Los datos iniciales se cargan al iniciar la aplicación y los cambios realizados durante la ejecución no se conservan al cerrar el programa.

🛡️ Validaciones y reglas de negocio

La aplicación incorpora diferentes validaciones para mantener la integridad de los datos:

No se pueden registrar alquileres sin stock disponible.

No se puede alquilar una plataforma que no pertenezca al videojuego seleccionado.

No se puede devolver un alquiler que ya ha sido devuelto.

No se pueden eliminar usuarios con alquileres activos.

No se pueden eliminar videojuegos con alquileres activos.

Cada alquiler dispone de un identificador único.

El stock se actualiza automáticamente al alquilar y devolver videojuegos.

👨‍💻 Autor

Andrés Altamirano Torres

Proyecto académico desarrollado como práctica de programación Java, programación orientada a objetos y diseño de interfaces gráficas con Swing.

⭐ Gracias por visitar este repositorio.
