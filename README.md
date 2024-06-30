
# Conversor de monedas

## Descripción

Este proyecto es una bibliteca desarrollado en Java 17 con el uso de Maven, Spring Boot con JPA, Loombook, Jackson y como base de datos se usó PosgreSQL. Permite guardar información de libros y autores, usando la API de Gutendex.

La interfaz gráfica del programa se realiza a través de la consola, ofreciendo una experiencia simple e intuitiva para el usuario.

## Características

- Registro de libros y autores en una base de datos.
- Obtención de información de libros usando la API de Guntendex.
- Interfaz de usuario en consola.
- Se usó Docker en conjunto con PosgreSQL por motivos educativos.

## Requisitos

- Java 17
- Maven
- Spring boot Framework
- PosgreSQL
- Docker

## Instalación

1. **Clonar el repositorio:**
   ```bash
   git clone https://github.com/ejsantamaria/Literalura.git
   cd ConversorMoneda
   docker-compose up -d
   ```

## Uso


1. **Interacción con el programa:**

   El programa mostrará un menú de opciones para poder interactuar.

   Capturas de pantalla de la interfaz en consola:
   
   Pantalla inicial: 

   ![Captura 1](https://github.com/ejsantamaria/Literalura/blob/main/Literalura/assets/Screenshot%202024-06-30%20012140.png)

   Opcion 1:

   ![Captura 2](https://github.com/ejsantamaria/Literalura/blob/main/Literalura/assets/Screenshot%202024-06-30%20012330.png)

   Opcion 2:
   
   ![Captura 3](https://github.com/ejsantamaria/Literalura/blob/main/Literalura/assets/Screenshot%202024-06-30%20012428.png)

   Opcion 3:
   
   ![Captura 3](https://github.com/ejsantamaria/Literalura/blob/main/Literalura/assets/Screenshot%202024-06-30%20012456.png)
  
   Opcion 4:
   
   ![Captura 4](https://github.com/ejsantamaria/Literalura/blob/main/Literalura/assets/Screenshot%202024-06-30%20012540.png)

   Opcion 5:

   ![Captura 5](https://github.com/ejsantamaria/Literalura/blob/main/Literalura/assets/Screenshot%202024-06-30%20012628.png)
   
## Estructura del Proyecto

```plaintext
ConversorMoneda/
├── .idea/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── edu/
│   │   │       └── alura/
│   │   │           └── alura/
│   │   │               ├── main/
│   │   │               │   └── Menu.java
│   │   │               ├── model/
│   │   │               │   ├── AuthorAPI.java
│   │   │               │   ├── AuthorEntity.java
│   │   │               │   ├── BookAPI.java
│   │   │               │   ├── AuthorEntity.java
│   │   │               │   └── ResponseAPI.java
│   │   │               ├── repository/
│   │   │               │   ├── AuthorRepository.java
│   │   │               │   └── BookRepository.java
│   │   │               ├── Service/
│   │   │               │   ├── APIConsumption.java
│   │   │               │   ├── AuthorService.java
│   │   │               │   ├── BookService.java
│   │   │               │   ├── DataConverter.java
│   │   │               │   └── IDataConverter.java
│   │   │               └── LiteraluraApplication.java
│   │   └── resources/
│   │       ├── static/
│   │       ├── templates/
│   │       └── application.properties
│   └── test/
│       └── java/
├── target/
├── .gitignore
├── docker-compose.yml
└── pom.xml
```

## Contribuciones

Las contribuciones son bienvenidas. Por favor, haga un fork del repositorio y envíe un pull request con sus cambios.


## Contacto

Para preguntas o soporte, por favor contacte a [ejsantamaria.cu@gmail.com].
