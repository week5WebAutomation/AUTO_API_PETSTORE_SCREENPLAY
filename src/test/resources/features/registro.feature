Feature: Validar la integridad de los servicios REST de la PetStore Swagger

  Scenario: Flujo completo de validacion de servicios REST
    Given el usuario accede al sistema de gestion de mascotas
      And el usuario configura la URL base del sistema como "https://petstore.swagger.io"
      And el usuario se registra en el sistema con los detalles proporcionados
      And el usuario autentica su sesion con la API key especial
      And el usuario registra una nueva mascota con nombre "Max" y tipo "Perro"
    When el usuario consulta la informacion de la mascota registrada
      And actualiza el tipo de la mascota a "Gato"
      And elimina la mascota del sistema
    Then el sistema confirma que los servicios REST han funcionado correctamente
      And el sistema valida que las respuestas incluyan los codigos de estado esperados
      And el usuario cierra la sesion del sistema

| Operación | Endpoint       | Método | Datos Enviados                          | Código de Estado Esperado |
|-----------|----------------|--------|-----------------------------------------|---------------------------|
| Crear     | /pet           | POST   | {"name": "Max", "id": 123, "type": "Dog"} | 200                       |
| Consultar | /pet/123       | GET    | petId                                   | 200                       |
| Actualizar| /pet           | PUT    | {"name": "Max", "id": 123, "type": "Cat"} | 200                       |
| Eliminar  | /pet/123       | DELETE | petId                                   | 200                       |
