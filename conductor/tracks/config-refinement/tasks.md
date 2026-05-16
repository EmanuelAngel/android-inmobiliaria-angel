# Tasks: Refinamiento de Configuración SDD

## Review Workload Forecast

| Field | Value |
|-------|-------|
| Estimated changed lines | 50-100 |
| 400-line budget risk | Low |
| Chained PRs recommended | No |
| Suggested split | Single PR |
| Delivery strategy | single-pr |
| Chain strategy | size-exception |

Decision needed before apply: No
Chained PRs recommended: No
Chain strategy: size-exception
400-line budget risk: Low

## Phase 1: Core Documentation Updates

- [x] 1.1 Actualizar `conductor/product.md` con el alcance exclusivo de la App del Propietario.
- [x] 1.2 Añadir la funcionalidad "Shake to Call" en `conductor/product.md`.
- [x] 1.3 Insertar la sección `## Strict Constraints (Hard Rules)` en `conductor/tech-stack.md`.
- [x] 1.4 Añadir nota sobre el Mapa de Google en `conductor/tech-stack.md`.
- [x] 1.5 Sincronizar reglas de naming y prohibición de DI en `conductor/tech-stack.md`.

## Phase 2: Verification

- [x] 2.1 Verificar que `conductor/index.md` y `conductor/tracks.md` mantengan coherencia con los cambios.
- [x] 2.2 Validar que las Hard Rules no contradigan `AGENTS.md`.
