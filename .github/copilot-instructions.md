# Copilot Instructions for AUTO_API_PETSTORE_SCREENPLAY

## Overview
This project automates API testing for the PetStore Swagger API using the Screenplay pattern with Serenity BDD. The automation includes a complete CRUD flow (POST, GET, PUT, DELETE) and adheres to clean code principles and Gherkin syntax.

## Key Conventions

### General Rules
- **No Comments**: Code should not include comments.
- **Clean Code**: Maintain clean and readable code.
- **Gherkin Syntax**: Scenarios must use Gherkin syntax with keywords in English (`Feature`, `Scenario`, `Given`, `When`, `Then`, `And`, `But`).

### Project Structure
- **Dependencies**: Managed with Gradle. Ensure `serenity-screenplay-rest` is included in `build.gradle`.
- **Configuration**: Base URL for the API is set in `serenity.conf`.
- **Actor Setup**: Use `Actor` with `CallAnApi` ability for REST interactions.

### CRUD Flow Implementation
- **POST**: Create resources using `Post.to()`.
- **GET**: Retrieve resources using `Get.resource()`.
- **PUT**: Update resources using `Put.to()`.
- **DELETE**: Remove resources using `Delete.from()`.

### Best Practices
- Encapsulate REST interactions in custom tasks to improve readability.
- Validate response status codes and handle responses appropriately.
- Follow Gherkin rules strictly for scenario definitions.

## Example Prompts
- "Generate a Serenity Screenplay task for a POST request to create a pet."
- "Write a Gherkin scenario for updating a pet's details."
- "Validate the response status code for a DELETE operation."

## Potential Pitfalls
- Ensure the `serenity-screenplay-rest` dependency is correctly configured.
- Verify the base URL in `serenity.conf` matches the API endpoint.
- Adhere to the no-comments rule to maintain consistency.

## Build and Test Commands
- **Build**: `./gradlew build`
- **Test**: `./gradlew test`

## Additional Notes
- Use the examples in the `README.md` file as a reference for implementing tasks and scenarios.
- Maintain consistency with the outlined rules and best practices.