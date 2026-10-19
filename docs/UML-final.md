---

## 📄 `docs/UML-final.md` (ELABORADO POR EL DOCENTE — contrato)

```markdown
# UML Final — Enunciado B: Plataforma de Entrenamiento de Modelos ML
### Documento de diseño — Elaborado por el docente

Este documento es **el contrato de diseño** del parcial. El código que
implementes debe respetar exactamente estas clases, atributos, métodos y
relaciones. No se permite agregar ni eliminar clases.

---

# UML Final — Enunciado A: Red de Sensores IoT
### Documento de diseño — Elaborado por el docente

Este documento es **el contrato de diseño** del parcial. El código que
implementes debe respetar exactamente estas clases, atributos, métodos y
relaciones. No se permite agregar ni eliminar clases.

---

## 1. Diagrama de clases

```
                    +----------------------+
                    |   <<abstract>>       |
                    |       Sensor         |
                    +----------------------+
                    | - id: String         |
                    | - unidad: String     |
                    | - ultimasLecturas:int[]|
                    | - indiceActual: int  |
                    | - cantidadLecturas:int|
                    +----------------------+
                    | + Sensor(id, unidad, capacidad) |
                    | + generarLectura():int {abstract} |
                    | + registrarLectura(v:int):void |
                    | + promedioUltimasLecturas():double |
                    | + fueraDeRango(v:int):boolean {abstract} |
                    | + getId():String |
                    | + getUnidad():String |
                    | + getUltimasLecturas():int[] |
                    | + getCantidadLecturas():int |
                    | + getIndiceActual():int |
                    +----------△-----------+
                               │
          ┌────────────────────┼────────────────────┐
          │                    │                    │
+-----------------+  +-----------------+  +---------------------+
|SensorTemperatura|  |  SensorHumedad  |  | SensorLuminosidad   |
+-----------------+  +-----------------+  +---------------------+
| MIN=-10 MAX=50  |  | MIN=0 MAX=100   |  | MIN=0 MAX=2000      |
+-----------------+  +-----------------+  +---------------------+
| + generarLectura() | | + generarLectura() | | + generarLectura() |
| + fueraDeRango(v)  | | + fueraDeRango(v)  | | + fueraDeRango(v)  |
+-----------------+  +-----------------+  +---------------------+

+----------------------+        ◆ (composición)       +-----------------+
|      NodoIoT         |◆───────────────────────────>|     Sensor      |
+----------------------+  1..*                        +-----------------+
| - id: String         |
| - sensores:ArrayList<Sensor> |
+----------------------+
| + NodoIoT(id:String) |
| + agregarSensor(tipo,id,cap):Sensor |
| + promedioTemperatura():double |
| + sensoresFueraDeRango():List<Sensor> |
| + getId():String |
| + getSensores():ArrayList<Sensor> |
+----------------------+
          △
          │ ◇ (agregación) 1..*
          │
+--------------------------+
|    CentroMonitoreo       |
+--------------------------+
| - nombre: String         |
| - nodos: ArrayList<NodoIoT> |
+--------------------------+
| + CentroMonitoreo(nombre:String) |
| + agregarNodo(n:NodoIoT):void |
| + reporteTemperaturas():List<String> |
| + getNombre():String |
| + getNodos():ArrayList<NodoIoT> |
+--------------------------+

+------------------------+     ——— (asociación N:M)    +-----------------+
| TecnicoMantenimiento   |────────────────────────────>|     NodoIoT     |
+------------------------+                             +-----------------+
| - nombre: String       |
| - nodosAsignados:ArrayList<NodoIoT> |
+------------------------+
| + TecnicoMantenimiento(nombre:String) |
| + asignarNodo(n:NodoIoT):void |
| + getNombre():String |
| + getNodosAsignados():ArrayList<NodoIoT> |
+------------------------+

+----------------+      ⇢ (dependencia)      +---------------------+
|    Lectura     |──────────────────────────>|  ValidadorLectura   |
+----------------+   usa en esValida()       +---------------------+
| - valor:int    |                           | + esValida(tipo,valor):boolean |
| - unidad:String|                           +---------------------+
| - timestamp:long |
+----------------+
| + Lectura(valor,unidad,timestamp) |
| + esValida(tipo:String, validador:ValidadorLectura):boolean |
| + getValor():int |
| + getUnidad():String |
| + getTimestamp():long |
+----------------+
```

---

## 2. Las cinco relaciones — justificación

### 2.1 Herencia — `Sensor` → `SensorTemperatura` / `SensorHumedad` / `SensorLuminosidad`
Los tres tipos **son** sensores. Comparten id, unidad, historial de lecturas
y promedio, pero difieren en el rango válido y en cómo generan una lectura.
Se modela con clase abstracta `Sensor` y método abstracto `generarLectura()`.

### 2.2 Composición — `NodoIoT ◆— Sensor`
Los sensores **pertenecen** al nodo: se crean dentro del método
`agregarSensor(...)` del nodo y no tienen vida útil propia fuera de él. Si el
nodo se destruye, sus sensores también. Se implementa creando los sensores
**dentro** de `NodoIoT.agregarSensor(...)`, no recibiéndolos ya instanciados
desde afuera.

### 2.3 Agregación — `CentroMonitoreo ◇— NodoIoT`
Los nodos **pueden existir** sin el centro de monitoreo. Un nodo se crea
independientemente y luego se registra en el centro con `agregarNodo()`.
El centro solo mantiene referencias en su `ArrayList<NodoIoT>`.

### 2.4 Asociación — `TecnicoMantenimiento — NodoIoT` (N:M)
Un técnico revisa varios nodos y un nodo puede ser revisado por varios
técnicos. No hay propiedad; solo referencia mutua por atributo
(`ArrayList<NodoIoT>`).

### 2.5 Dependencia — `Lectura ⇢ ValidadorLectura`
`Lectura` **usa** `ValidadorLectura` en un método puntual (`esValida`), pero
no lo guarda como atributo. Se pasa como parámetro. Si `ValidadorLectura`
cambia su API, `Lectura` podría verse afectada, pero no hay ciclo de vida
compartido.

---

## 3. Reglas de negocio implícitas

Estas reglas no se derivan del UML, pero los tests JUnit las validan:

1. `NodoIoT.agregarSensor(tipo, id, capacidad)` debe devolver `null` si el
   tipo no es `"TEMPERATURA"`, `"HUMEDAD"` o `"LUMINOSIDAD"`, y **no debe
   agregar nada** a la lista de sensores en ese caso.
2. `Sensor.registrarLectura(int)` implementa un **buffer circular**: cuando
   el arreglo `ultimasLecturas` se llena, sobrescribe la lectura más antigua
   sin lanzar excepción.
3. `Sensor.generarLectura()` debe llamar a `registrarLectura(...)` antes de
   retornar el valor.
4. `NodoIoT.promedioTemperatura()` solo considera sensores de tipo
   `SensorTemperatura` (filtra con `instanceof`).
5. `NodoIoT.sensoresFueraDeRango()` devuelve solo sensores cuya **última**
   lectura registrada esté fuera de su rango.
6. `CentroMonitoreo.reporteTemperaturas()` genera una línea por nodo con su
   id y su promedio de temperatura.
7. `TecnicoMantenimiento.asignarNodo(...)` no debe agregar el mismo nodo dos
   veces.

---

## 4. Firmas exactas de los métodos

Las firmas están dadas en el código base de `src/`. Tu tarea es implementar
sus cuerpos, **no cambiar sus firmas**.

| Clase | Método | Retorno esperado |
|---|---|---|
| `Sensor` | `registrarLectura(int)` | `void` |
| `Sensor` | `promedioUltimasLecturas()` | `double` |
| `SensorTemperatura` | `generarLectura()` | `int` |
| `SensorTemperatura` | `fueraDeRango(int)` | `boolean` |
| `SensorHumedad` | `generarLectura()` | `int` |
| `SensorHumedad` | `fueraDeRango(int)` | `boolean` |
| `SensorLuminosidad` | `generarLectura()` | `int` |
| `SensorLuminosidad` | `fueraDeRango(int)` | `boolean` |
| `NodoIoT` | `agregarSensor(String, String, int)` | `Sensor` |
| `NodoIoT` | `promedioTemperatura()` | `double` |
| `NodoIoT` | `sensoresFueraDeRango()` | `List<Sensor>` |
| `CentroMonitoreo` | `agregarNodo(NodoIoT)` | `void` |
| `CentroMonitoreo` | `reporteTemperaturas()` | `List<String>` |
| `TecnicoMantenimiento` | `asignarNodo(NodoIoT)` | `void` |
| `ValidadorLectura` | `esValida(String, int)` | `boolean` |
| `Lectura` | `esValida(String, ValidadorLectura)` | `boolean` |

---

## 5. Lo que NO debes hacer

- No agregar clases nuevas.
- No cambiar firmas de métodos existentes.
- No modificar la carpeta `test/`.
- No convertir atributos privados en públicos.
- No duplicar lógica entre subclases cuando pueda heredarse de `Sensor`.