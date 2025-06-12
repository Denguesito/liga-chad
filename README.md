# LIGA CHAD - Sistema de Gestión de Liga de Fútbol ⚽

## 📌 Descripción General
**LIGA CHAD** es una aplicación de consola escrita en **Java**, orientada a la gestión de una liga de fútbol local. Permite registrar equipos, jugadores titulares y suplentes, simular partidos, gestionar estadísticas, generar reportes detallados y exportar los datos de equipos a archivos CSV.

## ⚠️ Aviso importante sobre datos precargados

- Al iniciar la aplicación, la liga ya cuenta con equipos precargados (Unión, For Ever, Sarmiento y Sacachispas), cada uno con 5 jugadores titulares y 3 suplentes, listos para usar y probar todas las funcionalidades.

---

## 🛠️ Funcionalidades Principales

| Funcionalidad | Descripción |
|---------------|-------------|
| ➕ Crear equipos | Registrar nuevos equipos en la liga. |
| 👥 Agregar jugadores | Cargar jugadores titulares y suplentes en un equipo, con opción para hacerlo de forma múltiple. |
| ⚽ Registrar partidos | Registrar partidos manualmente o simular resultados de manera automática. |
| 🎯 Asignar goles | Asociar goles a jugadores durante el partido. |
| 🔁 Transferencias | Mover un jugador transferible de un equipo a otro. |
| 📈 Reportes de Liga | Mostrar total de goles, promedio de goles por partido, jugador más eficiente, equipo más goleador. |
| 📊 Reportes por Equipo | Promedio de goles de jugadores, jugadores sin goles, titular más activo, suplente más utilizado. |
| 🧠 Estadísticas | Eficiencia de jugadores, goleador de la liga, suplentes que nunca ingresaron. |
| 📂 Exportar CSV | Generar un archivo CSV con los datos de los jugadores (titulares y suplentes) de un equipo específico. |
| 📋 Ranking | Mostrar el ranking de equipos ordenados por goles anotados. |
| 👀 Listado de jugadores | Mostrar todos los jugadores de todos los equipos clasificados por tipo. |

---

## 🚀 ¿Cómo funciona?

1. Al iniciar el programa, se muestra un **menú interactivo** donde el usuario puede navegar por todas las opciones.
2. Cada operación está delegada a un **servicio específico**, según la capa de responsabilidad (gestión, estadísticas, reportes, utilidades).
3. El sistema solicita la información desde consola utilizando una clase `LectorConsola` que valida las entradas.
4. Toda la lógica de negocio está encapsulada en servicios, manteniendo las entidades limpias y enfocadas solo en su estado.
5. Los datos exportados (CSV) se guardan automáticamente en la carpeta `/csv`, que se crea si no existe.


- 🔍 **Diseño guiado por funcionalidades**: Se identificaron las entidades y servicios directamente del enunciado antes de programar.
- 🧩 **Modularización temprana**: Desde el principio se propuso separar claramente los servicios de gestión, estadísticas y presentación.
- 🧪 **Uso de clases simuladoras**: Se agregó una opción para simular automáticamente resultados de partidos para facilitar el testeo y generación de estadísticas.


## 📥 Requisitos técnicos
- Java 17+
- Maven (compilación y gestión de dependencias)
- Librería OpenCSV (incluida en el `pom.xml`)

---

## 📌 Cómo ejecutar

1. Clonar el repositorio o descargar el proyecto
2. Abrir con un IDE compatible con Maven (VSCode, IntelliJ, etc.)
3. Ejecutar `App.java`
4. Seguir las instrucciones del menú por consola

Gracias por visitar la LIGA CHAD. ¡El proyecto está listo para brillar como campeón! 🏆⚽
