# Literalura - Catalogo de Libros y Autores

Aplicacion de consola construida con Spring Boot que consulta la API publica de Gutendex para buscar libros y guarda la informacion en una base de datos MySQL.

## Descripcion

Este proyecto permite:

- Buscar libros por titulo usando Gutendex.
- Persistir autores y libros en MySQL evitando duplicados.
- Listar libros registrados.
- Listar autores registrados.
- Listar autores vivos en un anio determinado.
- Filtrar libros por idioma.

El flujo principal esta implementado como una aplicacion CLI (menu por consola) en `src/main/java/com/literalura/rias/RiasApplication.java`.

## Tecnologias

- Java 21
- Spring Boot 4.0.3
- Spring Data JPA
- MySQL
- Maven Wrapper (`mvnw` / `mvnw.cmd`)
- Gson
- API Gutendex (`https://gutendex.com/books/`)

## Requisitos

- JDK 21 instalado
- MySQL disponible (la configuracion actual usa `127.0.0.1:3307`)
- Git (opcional)

## Configuracion

La configuracion actual se encuentra en `src/main/resources/application.yaml`.

`application.yaml` usa variables de entorno:

- URL: `${DB_URL}`
- Usuario: `${DB_USER}`
- Password: `${DB_PASSWORD}`
- Puerto de la app: `${SERVER_PORT}`
- `ddl-auto`: `update`

### Archivo .env

La aplicacion carga automaticamente el archivo `.env` en este orden:

1. `src/main/resources/.env`
2. `.env` en la raiz del proyecto (fallback)

Ejemplo recomendado:

```env
DB_URL=jdbc:mysql://127.0.0.1:3307/literalura?createDatabaseIfNotExist=true&useSSL=false&serverTimezone=UTC
DB_USER=root
DB_PASSWORD=literaluraLatam
SERVER_PORT=8086
```

Si tu entorno usa otro puerto, usuario o password, ajusta estos valores antes de iniciar.

## Ejecucion

### Windows (PowerShell)

```powershell
.\mvnw.cmd spring-boot:run -DskipTests
```

### Linux / macOS

```bash
./mvnw spring-boot:run -DskipTests
```

Tambien puedes compilar primero:

```bash
./mvnw clean package
```

En Windows:

```powershell
.\mvnw.cmd clean package
```

## Menu de la aplicacion

Al iniciar, veras un menu en consola con estas opciones:

1. Buscar libros por titulo
2. Listar libros registrados
3. Lista autores registrados
4. Lista autores vivos en un determinado anio
5. Lista libro por idioma
6. Salir

## Flujo funcional (resumen)

1. El usuario ingresa un titulo.
2. La app consulta Gutendex (`HttpController`).
3. Se mapean datos a entidades `Libro` y `Autor` (`LibroMapper`).
4. Se persisten autor y libro (`CRUDController`, `AutorServices`, `LibroServices`).
5. Luego se puede consultar el catalogo local por diferentes criterios.

## Estructura principal

- `src/main/java/com/literalura/rias/RiasApplication.java`: entrada y loop del menu.
- `src/main/java/com/literalura/rias/controllers/HttpController.java`: consumo HTTP de Gutendex.
- `src/main/java/com/literalura/rias/controllers/CRUDController.java`: capa de orquestacion para operaciones CRUD.
- `src/main/java/com/literalura/rias/controllers/printControllers/PrintController.java`: interaccion con usuario por consola.
- `src/main/java/com/literalura/rias/entities/`: entidades JPA (`Autor`, `Libro`) y DTOs.
- `src/main/java/com/literalura/rias/repository/`: repositorios JPA y consultas personalizadas.
- `src/main/java/com/literalura/rias/services/`: logica de negocio.

## Notas

- El proyecto usa consultas con `JOIN FETCH` para evitar problemas de carga perezosa al imprimir autores y libros.
- Se manejan posibles valores nulos en datos de autor de la API externa.
- La persistencia intenta evitar duplicados por autor y por combinacion libro+autor.

## Autor

Proyecto desarrollado en el contexto del challenge Literalura de Oracle + Alura Latam.
