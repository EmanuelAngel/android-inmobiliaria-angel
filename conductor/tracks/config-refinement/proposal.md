# Proposal: Refinamiento de Configuración SDD

## Intent
Alinear la documentación base de SDD (`product.md` y `tech-stack.md`) con los requerimientos reales de la consigna académica (`docs/task.md`) y las restricciones técnicas obligatorias del repositorio (`AGENTS.md`). La configuración actual es demasiado genérica y omite reglas críticas de estilo y arquitectura.

## Scope

### In Scope
- Actualizar el alcance del producto en `product.md` para centrarse solo en la App del Propietario.
- Incluir la funcionalidad "Shake to Call" en el Login.
- Refinar `tech-stack.md` con prohibiciones explícitas (No DI) y obligaciones (ViewBinding, Naming Híbrido).
- Documentar el estado pendiente del Mapa de Google.

### Out of Scope
- Implementación de código en este track.
- Creación de nuevos fragments o layouts.
- Gestión de la API (fuera del alcance del cliente móvil).

## Capabilities

### New Capabilities
- None (Este track refina documentos base, no introduce comportamiento de software).

### Modified Capabilities
- `product-definition`: Ajuste de funcionalidades del propietario.
- `technical-standards`: Endurecimiento de reglas de arquitectura y estilo.

## Approach
Revisión quirúrgica de `conductor/product.md` y `conductor/tech-stack.md` para inyectar las directrices de `AGENTS.md` y `task.md`.

## Affected Areas

| Area | Impact | Description |
|------|--------|-------------|
| `conductor/product.md` | Modified | Sincronización con requerimientos de la App del Propietario. |
| `conductor/tech-stack.md` | Modified | Adición de restricciones de arquitectura y estilo. |

## Risks

| Risk | Likelihood | Mitigation |
|------|------------|------------|
| Inconsistencia con tracks futuros | Low | Mantener el index centralizado y actualizado. |

## Rollback Plan
Revertir cambios en `product.md` y `tech-stack.md` usando Git.

## Dependencies
- `docs/task.md` (Consigna)
- `AGENTS.md` (Reglas del proyecto)

## Success Criteria
- [x] `product.md` refleja exactamente las funciones de la App del Propietario.
- [x] `tech-stack.md` prohíbe explícitamente librerías de DI.
- [x] `tech-stack.md` obliga al uso de ViewBinding y Naming Híbrido.
