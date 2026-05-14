---
name: naming-convention
description: "Trigger: naming, estándar, consistencia, refactorización. Aplica las reglas de nomenclatura de Inmobiliaria Angel."
license: Apache-2.0
metadata:
  author: gentleman-programming
  version: "1.0"
---

## Activation Contract
Activar cuando se creen nuevos componentes (ViewModels, Fragments, Activities), se realice una refactorización o se detecten inconsistencias en el nombrado de variables y métodos.

## Hard Rules
- **Variables de Clase:** 
  - Usar `camelCase`.
  - Prohibido el uso de prefijos como `m` o `_`.
  - **MutableLiveData/LiveData:** Obligatorio el sufijo `Mutable` tanto en la variable como en su getter (ej: variable `errorMutable`, getter `getErrorMutable()`).
- **Idioma Híbrido:**
  - **Dominio/Negocio:** Siempre en **Español** (`propietario`, `contrato`, `inmueble`).
  - **Términos Técnicos:** En **Inglés** (`loading`, `token`, `error`, `setup`, `observers`).
  - **Métodos de Acción:** Siempre en **Español** (`autenticar()`, `cargarPerfil()`).
- **Constantes:** Usar `SCREAMING_SNAKE_CASE` (ej: `BASE_URL`).
- **UI (Activity/Fragment):**
  - Métodos de estructura en inglés: `setupObservers()`, `setupListeners()`, `initViews()`.

## Decision Gates
| Tipo de Variable | Regla | Ejemplo |
|------------------|-------|---------|
| MutableLiveData de Error | [nombre]Mutable | `errorMutable` |
| Variable de Dominio | Español | `propietario` |
| Estado de Carga | Inglés técnico | `loading` |
| Método que guarda datos | Español | `guardarCambios()` |

## Execution Steps
1. Identificar el tipo de variable o método a crear/modificar.
2. Aplicar la regla de idioma según si es negocio o técnico.
3. Si es un LiveData, asegurar el sufijo `Mutable`.
4. Eliminar cualquier prefijo de miembro (`m`, `_`).

## Output Contract
- Código coherente con el estándar híbrido.
- Nombres de variables autodescriptivos sin redundancia de tipo (excepto LiveData).
- Documentación mínima necesaria en JavaDoc si la lógica es compleja.
