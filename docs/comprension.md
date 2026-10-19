# Comprensión del diseño — Enunciado A
**Nombre:** _________________________
**Fecha:** __________________________

Responde con tus palabras, basándote en `docs/UML-final.md`. Respuestas
concisas (2–4 líneas por pregunta). Este documento evidencia que entendiste el
contrato de diseño **antes** de programar.

---

### 1. Herencia y polimorfismo
¿Por qué `Sensor` es una clase abstracta y no una clase concreta? Menciona
qué método obliga a cada subclase a implementar y qué gana el sistema con eso.

> _Tu respuesta:_

---

### 2. Composición vs. agregación
Explica con tus palabras la diferencia entre `NodoIoT ◆— Sensor` (composición)
y `CentroMonitoreo ◇— NodoIoT` (agregación). Da un ejemplo de qué pasaría con
los sensores si se elimina el nodo, y qué pasaría con los nodos si se elimina
el centro.

> _Tu respuesta:_

---

### 3. Asociación
En `TecnicoMantenimiento — NodoIoT`, ¿quién es dueño de quién? ¿Por qué se
modela como N:M y no como composición?

> _Tu respuesta:_

---

### 4. Dependencia
¿Por qué `Lectura` **depende** de `ValidadorLectura` en lugar de **tenerlo**
como atributo? ¿Qué diferencia práctica hay entre pasar un `ValidadorLectura`
como parámetro versus guardarlo en un campo?

> _Tu respuesta:_

---

### 5. Listas
En este proyecto se usan dos estructuras de datos distintas:
- `int[] ultimasLecturas` en `Sensor`
- `ArrayList<Sensor>` en `NodoIoT`

Explica por qué en cada caso se eligió esa estructura y no la otra. ¿Qué
ventaja tiene el `int[]` con buffer circular frente a un `ArrayList` para el
historial de lecturas?

> _Tu respuesta:_