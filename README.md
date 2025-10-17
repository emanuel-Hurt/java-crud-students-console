# Gestor de Estudiantes en Consola (Java 8)

Este es un proyecto simple desarrollado en **Java 8**, que implementa un sistema CRUD (Crear, Leer, Actualizar y Eliminar) de estudiantes desde la **línea de comandos**.  

El proyecto forma parte de mi plan de práctica personal para fortalecer fundamentos de Java, programación orientada a objetos, programación funcional y uso de la Stream API de Java. 

---

## Características 

- Interfaz de texto (menú en consola). 
- Registro, listado, búsqueda, actualización y eliminación de estudiantes. 
- Persistencia de datos en archivo de csv (`estudiantes.csv`). 
- Organización del código en capas: `model`, `service`, `util`. 
- Uso de colecciones (`ArrayList`) y expresiones **lambda / Stream API**. 
- Código modular y orientado a objetos. 

## Estructura del proyecto 

src/  
|---- model/Student.java  
|---- service/StudentService.java  
|---- myUtils/FileHandler.java  
|---- Main.java  

