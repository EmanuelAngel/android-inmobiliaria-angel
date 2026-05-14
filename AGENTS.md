# Inmobiliaria Angel

Este archivo establece las normas y procedimientos fundamentales para cualquier agente de IA que trabaje en este repositorio. Estas instrucciones tienen precedencia absoluta sobre los comportamientos por defecto.

## Project Overview
Sistema de gestión inmobiliaria para el proyecto integrador de la asignatura "Desarrollo en entorno Android". La aplicación permite a los propietarios gestionar sus inmuebles, visualizar inquilinos, contratos y pagos a través de una API REST.

### Tech Stack & Architecture
- **Language:** 100% Java (Prohibido usar Kotlin).
- **Architecture:** MVVM (Model-View-ViewModel) estricto.
- **Components:** LiveData, Navigation Component, ViewBinding (Obligatorio en todos los layouts).
- **Networking:** Retrofit para consumo de API REST.
- **Images:** Glide para carga y caché de imágenes.
- **Dependency Injection:** No utilizar librerías de DI (Hilt/Dagger). Gestión manual de dependencias.

## Code Style Guidelines
- **Nomenclatura:** camelCase estándar para variables y métodos.
- **Documentación:** Código autodocumentado por defecto. Solo usar Javadoc para explicar lógica de negocio compleja o algoritmos no triviales.
- **Formateo:**
    - Seguir el estándar de Android Studio.
    - **Límite de línea:** Máximo 100 caracteres. Aplicar saltos de línea manuales si se excede este límite.
- **ViewBinding:** Nunca usar `findViewById`. Siempre acceder a las vistas mediante el objeto de binding generado.

## Security Considerations
- **Auth:** El token JWT se almacena en `SharedPreferences`.
- **Session Management:** Ante errores de red críticos o sesión expirada (HTTP 401), la aplicación debe invalidar el token local y redirigir inmediatamente al `LoginActivity`.

## Workflow & Conventions
- **Commits:** Seguir estrictamente **Conventional Commits** (ej: `feat:`, `fix:`, `docs:`, `chore:`, `refactor:`). **Los mensajes de commit deben ser siempre en inglés.**
- **Status Tracking:** Mantener actualizado el archivo `STATUS.md` en la raíz del proyecto tras completar cada hito o funcionalidad de una entrega.
- **Idioma:** Todo el código (comentarios, logs, strings de la UI) debe estar en **Español**. No es necesaria la internacionalización.
- **Testing:** No se requieren pruebas unitarias ni instrumentales por el momento.

## Instrucciones Específicas del Curso
- Priorizar la simplicidad y la legibilidad académica.
- Tener en cuenta que el modelo relacional y de API definido en la carpeta `docs/` es un ejemplo, no el modelo final y real.

## Skills del Proyecto
- **naming-convention:** Aplica las reglas de nomenclatura híbrida (Español negocio/Inglés técnico) y sufijos de LiveData. Ubicación: `.gemini/skills/naming-convention/SKILL.md`.
