# AUTO_API_PETSTORE_SCREENPLAY

## Automatizacion de Automatización de API: Ciclo completo (CRUD) con Screenplay (REST)

- **IDE** VSCode + Git Hub Copilot
- **Patron** Screenplay (REST)
- **Framework de automatización** Serenity BDD
- **Gestion de dependencias** Gradle
- **Escenario** Crear un único flujo de prueba que incluya los 4 verbos: POST (crear),
GET (consultar), PUT (actualizar) y DELETE (eliminar)
- Test runner para cucumber

## Objetivo

Implementar un flujo end to end de automatización de pruebas con Screenplay (REST) sobre 
[PetStore Swagger](https://petstore.swagger.io/#/pet/getPetById)

## Reglas generales

- Están prohibidos los comentarios en el código

- se debe generar código limpio

- Se debe usar Gherkin para la generación de escenario, el escenario se escribir en lenguaje Gherkin usando las palabras claves en Inglés: Feature', 'Scenario', 'Given', 'When', 'Then', 'And', 'But'.

## Metodología para el flujo de prueba CRUD

### Configuración inicial

1. **Dependencias**: Asegúrate de incluir la dependencia `serenity-screenplay-rest` en tu archivo `build.gradle`:
   ```gradle
   testCompile "net.serenity-bdd:serenity-screenplay-rest:${serenityVersion}"
   ```

2. **Base URL**: Configura la URL base de la API en el archivo `serenity.conf`:
   ```properties
   restapi.baseurl = "https://petstore.swagger.io/v2"
   ```

3. **Actor**: Define un actor con la habilidad `CallAnApi` para interactuar con la API REST:
   ```java
   Actor sam = Actor.named("Sam the tester").whoCan(CallAnApi.at(theRestApiBaseUrl));
   ```

### Implementación del flujo CRUD

1. **POST (Crear)**:
   - Crea una tarea para enviar una solicitud POST con los datos necesarios.
   - Ejemplo:
     ```java
     sam.attemptsTo(
         Post.to("/pet").with(request -> request
             .header("Content-Type", "application/json")
             .body(new Pet("Dog", 123)))
     );
     ```

2. **GET (Consultar)**:
   - Recupera los datos del recurso creado utilizando su ID.
   - Ejemplo:
     ```java
     sam.attemptsTo(
         Get.resource("/pet/123")
     );
     sam.should(
         seeThatResponse("El recurso debe existir",
             response -> response.statusCode(200))
     );
     ```

3. **PUT (Actualizar)**:
   - Actualiza los datos del recurso existente.
   - Ejemplo:
     ```java
     sam.attemptsTo(
         Put.to("/pet").with(request -> request
             .header("Content-Type", "application/json")
             .body(new Pet("Cat", 123)))
     );
     ```

4. **DELETE (Eliminar)**:
   - Elimina el recurso utilizando su ID.
   - Ejemplo:
     ```java
     sam.attemptsTo(
         Delete.from("/pet/123")
     );
     sam.should(
         seeThatResponse("El recurso debe ser eliminado",
             response -> response.statusCode(200))
     );
     ```

### Buenas prácticas

- Utiliza tareas personalizadas para encapsular las interacciones REST y mejorar la legibilidad.
- Asegúrate de manejar las respuestas y validar los códigos de estado esperados.
- Mantén el código limpio y sigue las reglas de Gherkin para los escenarios.

