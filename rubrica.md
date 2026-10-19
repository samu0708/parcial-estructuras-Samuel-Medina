# Rúbrica — Enunciado A: Red de Sensores IoT
*(Evalúa únicamente la Sesión 2 — la fase de modelado ya fue elaborada por el docente)*

| Criterio | Peso | Excelente (100%) | Aceptable (60%) | Insuficiente (0%) |
|---|---|---|---|---|
| **Comprensión del diseño** (`docs/comprension.md`) | 10% | Responde las 5 preguntas con criterio técnico | Responde parcialmente | No responde / copia |
| **Abstracción** (clase abstracta `Sensor`) | 10% | Implementa correctamente la clase abstracta y sus métodos abstractos | Uso parcial | No aplica |
| **Herencia y polimorfismo** | 20% | Jerarquía coherente, `@Override` correcto, uso polimórfico en `NodoIoT` | Jerarquía débil | No implementa |
| **Encapsulamiento** | 5% | Atributos privados, getters/setters correctos | Parcial | Todo público |
| **Relaciones** (composición, agregación, asociación, dependencia) | 20% | Las 4 correctas y con semántica adecuada | 2–3 correctas | ≤1 |
| **Manejo de listas** (`int[]` buffer + `ArrayList`) | 20% | Ambas usadas correctamente, buffer circular funcional | Solo una o con errores | Ninguna |
| **Tests JUnit pasando** | 10% | Todos los tests en verde | ≥70% en verde | <70% |
| **Git (rama + commits atómicos)** | 5% | Rama personal + commits descriptivos | Poco ordenado | Sin uso de Git |

**Penalizaciones:**
- Modificar `test/`: **anula el examen**.
- Proyecto no compila: **-30%**.
- Tests fallando: **-1% por test** (hasta -15%).