# Design: Refinamiento de Configuración SDD

## Technical Approach
Actualización directa de los archivos de documentación central (`conductor/product.md` y `conductor/tech-stack.md`) mediante el uso de la herramienta `replace`. Se inyectarán los requerimientos definidos en el `spec.md` del track, asegurando que las "Hard Rules" de `AGENTS.md` queden explícitamente codificadas para futuros agentes.

## Architecture Decisions

### Decision: Inyección de Restricciones en Tech Stack
**Choice**: Crear una sección dedicada `## Strict Constraints (Hard Rules)` en `tech-stack.md`.
**Alternatives considered**: Dejar las reglas solo en `AGENTS.md`.
**Rationale**: Centralizar las reglas en `tech-stack.md` asegura que cualquier track de SDD que lea el stack técnico herede estas restricciones, minimizando errores de arquitectura.

### Decision: Alcance del Producto
**Choice**: Redefinir `product.md` para que sea exclusivo de la App del Propietario.
**Alternatives considered**: Mantener una definición híbrida (Agencia + Propietario).
**Rationale**: El proyecto académico se centra en la aplicación móvil para el propietario. Mantener alcance administrativo solo genera confusión.

## File Changes

| File | Action | Description |
|------|--------|-------------|
| `conductor/product.md` | Modify | Reescritura para enfocar en el Propietario y añadir "Shake to Call". |
| `conductor/tech-stack.md` | Modify | Adición de sección de restricciones estrictas y nota del Mapa. |

## Testing Strategy

| Layer | What to Test | Approach |
|-------|-------------|----------|
| Documentation | Coherencia | Lectura manual de los archivos finales para verificar cumplimiento de specs. |
| SDD Integrity | Enlaces | Verificar que el index y el tracks registry sigan funcionando. |

## Migration / Rollout
No migration required. Los cambios son puramente documentales y entran en vigor inmediatamente para futuros tracks.
