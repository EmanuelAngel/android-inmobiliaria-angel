# Spec: Refinamiento de Configuración SDD

## ADDED Requirements

### Requirement: Shake to Call in Login
La pantalla de Login MUST implementar la funcionalidad de "agitar el teléfono" para realizar una llamada a la inmobiliaria.
(Previously: Not explicitly mentioned in product definition).

#### Scenario: Usuario agita el teléfono en Login
- GIVEN El usuario está en la `LoginActivity`.
- WHEN El usuario agita el dispositivo físicamente (o mediante emulación de sensor).
- THEN El sistema MUST iniciar un Intent de llamada al número de la inmobiliaria.

### Requirement: Restricciones Arquitectónicas Estrictas
El sistema SHALL prohibir el uso de librerías de Inyección de Dependencias (Dagger, Hilt, etc.) y obligar al uso de ViewBinding.

#### Scenario: Verificación de Dependencias
- GIVEN Un desarrollador o agente de IA intenta agregar una funcionalidad.
- WHEN Se revisa el `build.gradle` o los imports.
- THEN No deben existir referencias a `com.google.dagger` o `hilt`.
- AND Todas las referencias a vistas MUST ser mediante el objeto de binding generado.

## MODIFIED Requirements

### Requirement: Alcance de Producto - Vista Propietario
(Previously: Generic real estate management system).
El sistema MUST enfocarse exclusivamente en las funcionalidades para el Propietario en la App Móvil.

#### Scenario: Navegación de la App
- GIVEN El propietario ha iniciado sesión.
- WHEN Abre el menú de navegación (Drawer).
- THEN Debe ver las opciones: Inicio (Mapa), Perfil, Inmuebles, Inquilinos, Contratos, Logout.

### Requirement: Estándar de Nomenclatura Híbrida
(Previously: Standard camelCase).
El código MUST seguir un esquema híbrido: Español para lógica de negocio/dominio e Inglés para la estructura técnica.

#### Scenario: Creación de una variable de LiveData
- GIVEN Se está implementando un ViewModel para el perfil.
- WHEN Se declara un LiveData para el propietario.
- THEN El nombre de la variable MUST ser `propietarioMutable` (CamelCase, Español + Sufijo Inglés).
