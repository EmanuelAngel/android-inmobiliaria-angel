# Tech Stack & Guidelines

## Stack
- **Language:** Java 11 (Strict - Prohibido usar Kotlin)
- **Framework:** Android SDK (Min SDK 33, Target SDK 36)
- **Architecture:** MVVM (Model-View-ViewModel) estricto.
- **Networking:** Retrofit + GSON.
- **UI:** XML Layouts + ViewBinding.
- **Navigation:** Jetpack Navigation Component.
- **Images:** Glide.
- **Persistence:** SharedPreferences (Auth Token).

## Strict Constraints (Hard Rules)
- **No Dependency Injection Libraries:** Prohibido el uso de Dagger, Hilt, Koin, etc. La gestión de dependencias debe ser manual (ej. via ViewModelFactory).
- **ViewBinding Mandatory:** Prohibido el uso de `findViewById`. Todo acceso a vistas debe ser a través de ViewBinding.
- **Hybrid Naming Convention:** 
    - Dominio/Negocio en **Español** (ej. `Propietario`, `contrato`).
    - Técnica/Estructura en **Inglés** (ej. `ViewModel`, `Repository`).
    - Sufijos de LiveData: `Mutable` para LiveData mutable (ej. `propietarioMutable`) y nombre limpio para el expuesto.

## Conventions
- Nomenclatura camelCase para variables y métodos.
- Idioma del código y UI: **Español**.
- Mensajes de commit: Conventional Commits en **Inglés**.

## Features Note
- **Mapa (Inicio):** Implementación técnica pendiente de definición (SDK vs Intent).
