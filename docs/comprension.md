# Comprensión del diseño — Enunciado A
**Nombre:** Samuel Medina
**Fecha:** 19/10/26

Responde con tus palabras, basándote en `docs/UML-final.md`. Respuestas
concisas (2–4 líneas por pregunta). Este documento evidencia que entendiste el
contrato de diseño **antes** de programar.

---

### 1. Herencia y polimorfismo
¿Por qué `Sensor` es una clase abstracta y no una clase concreta? Menciona
qué método obliga a cada subclase a implementar y qué gana el sistema con eso.

> _Tu respuesta:_ Los tres tipos son sensores. Comparten id, unidad, historial de lecturas y promedio, pero difieren en el rango válido y en cómo generan una lectura. Se modela con clase abstracta Sensor y método abstracto generarLectura().

---

### 2. Composición vs. agregación
Explica con tus palabras la diferencia entre `NodoIoT ◆— Sensor` (composición)
y `CentroMonitoreo ◇— NodoIoT` (agregación). Da un ejemplo de qué pasaría con
los sensores si se elimina el nodo, y qué pasaría con los nodos si se elimina
el centro.

> _Tu respuesta:_ Basicamente Sensor Es parte de Nodo por lo que si eliminamos Nodo tambien se elimina Sensor por lo que compone Nodo mientras que los nodos no tienen esa "dependencia" a centro monitoreo ya que primero se crea el Nodo y luego se agrega a Centro Monitoreo 

---

### 3. Asociación
En `TecnicoMantenimiento — NodoIoT`, ¿quién es dueño de quién? ¿Por qué se
modela como N:M y no como composición?

> _Tu respuesta:_ No hay propiedad por parte de ninguno un tecnico revisa varios nodos y un nodo puede ser revisado por varios tecnicos.

---

### 4. Dependencia
¿Por qué `Lectura` **depende** de `ValidadorLectura` en lugar de **tenerlo**
como atributo? ¿Qué diferencia práctica hay entre pasar un `ValidadorLectura`
como parámetro versus guardarlo en un campo?

> _Tu respuesta:_ Lectura usa ValidadorLectura en un método puntual (esValida), pero no lo guarda como atributo. Se pasa como parámetro. Si ValidadorLectura cambia su API, Lectura podría verse afectada, pero no hay ciclo de vida compartido entonces lo que hace que sea un parametro y no un atributo es que solo es utilizado en un metodo puntual de validacion que no se almacena por lo que no es neseciario asociarlo a un ciclo de vida compartido.



---

### 5. Listas
En este proyecto se usan dos estructuras de datos distintas:
- `int[] ultimasLecturas` en `Sensor`
- `ArrayList<Sensor>` en `NodoIoT`

Explica por qué en cada caso se eligió esa estructura y no la otra. ¿Qué
ventaja tiene el `int[]` con buffer circular frente a un `ArrayList` para el
historial de lecturas?

> _Tu respuesta:_ El int[] se usa en el historial porque queremos guardar solo las últimas N lecturas, es decir, una capacidad fija y conocida. Con el buffer circular, sobrescribir la más antigua cuesta O(1), la memoria nunca crece y no hay que desplazar elementos. Un ArrayList crecería sin límite si el sensor genera lecturas durante meses, y borrar la primera (remove(0)) cuesta O(n). Para ArrayList<Sensor> en NodoIoT pasa lo contrario: la cantidad de sensores no está fija de antemano y hay que poder agregar dinámicamente con agregarSensor(), y un arreglo fijo obligaría a decidir el tamaño de antemano o redimensionarlo a mano