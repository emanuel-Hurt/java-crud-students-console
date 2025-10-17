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
estudiantes.csv  

## Ejecución

1. Clonar el repositorio:
   ```bash
   git clone https://github.com/emanuel-hurt/java-crud-students-console.git
   ```
2. Entrar al directorio:
   ```bash
   cd java-crud-students-console
   ```
4. Compilar:
   ```bash
   javac -d bin src/**/*.java
   ```
5. Ejecutar:
   ```bash
   java -cp bin Main
   ```
También pudes ejecutarlo desde el IDE de tu preferencia (IntelliJ, Eclipse, VS Code, etc.).

## Tecnologías utilizadas
* Java 8+
* Programación Orientada a Objetos (POO).
* Stream API.
* Persistencia en archivo csv haciendo uso del paquete java.nio.file.Files

## Próximos pasos 
El siguiente paso será desarrollar una aplicación web con Spring Boot (Fase 2).  

#### Autor: Emanuel Hurtado  
[LinkedIn](https://www.linkedin.com/in/emanuel-hurtado)   
[email](mailto:emanuel.hurtado.cast@gmail.com) 

