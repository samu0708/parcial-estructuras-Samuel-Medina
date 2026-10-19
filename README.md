# Parcial — Estructuras de Datos (2° semestre)
## Enunciado A: Red de Sensores IoT para Agricultura Inteligente

**Espacio académico:** Estructuras de Datos
**Programa:** Ingeniería en Datos e Inteligencia Artificial
**Duración:** Sesión 1 (3 h) + Sesión 2 (2 h)
**Modalidad:** Individual
**Evaluación:** Según `RUBRICA.md`

---

## 🎯 Contexto del problema

Una empresa agrícola despliega una red de sensores para monitorear cultivos.
Cada **nodo** contiene varios **sensores** de distinto tipo (temperatura,
humedad, luminosidad). Los sensores generan **lecturas** periódicas que se
almacenan para análisis posterior.

El centro de monitoreo debe poder consultar:
- Promedio de temperatura por nodo.
- Sensores con lecturas fuera de rango.
- Técnicos asignados a cada nodo.

---

## 📚 Material que ya viene resuelto (NO lo modifiques)

El docente ya realizó **la fase de modelado** (Sesión 1). En `docs/UML-final.md`
encontrarás el diagrama completo con clases, atributos, métodos y las cinco
relaciones UML. Ese documento es tu **contrato**: el código que escribas debe
respetarlo tal cual.

**También encontrarás `docs/comprension.md`**: respóndelo antes de empezar a
programar.

---

## 📋 Lo que TÚ debes hacer

### Sesión 1 (3 h)
1. Clonar el repositorio y crear tu rama personal (ver instrucciones Git).
2. Configurar el proyecto en IntelliJ IDEA (ver sección "Configuración en IntelliJ").
3. Leer `docs/UML-final.md` y responder `docs/comprension.md`.
4. Empezar a implementar los `TODO` de las clases más sencillas:
   `Sensor.registrarLectura`, `Sensor.promedioUltimasLecturas`, getters/setters.
5. Primer commit: `comprension: respondo preguntas del UML + primeros TODOs`.

### Sesión 2 (2 h)
6. Implementar el resto de `TODO`:
   - Jerarquía de sensores (`generarLectura()` polimórfico en las 3 subclases).
   - `NodoIoT` con composición real (crea sensores internamente).
   - `CentroMonitoreo` con `ArrayList<NodoIoT>` (agregación).
   - `TecnicoMantenimiento` asociado a nodos.
   - `Lectura` que usa `ValidadorLectura` (dependencia).
7. Ejecutar los tests JUnit desde IntelliJ (clic en triángulo verde).
8. Iterar hasta que **todos** los tests pasen.
9. Commit final: `impl: TODOs completados y tests pasando`.
10. Push de tu rama.

⚠️ **NO modifiques la carpeta `test/`.** Si lo haces, se anula el examen.

---

## 🛠️ Configuración en IntelliJ IDEA (paso a paso)

1. **Abrir el proyecto:**
   `File → Open…` y selecciona la carpeta raíz del repo clonado.

2. **Marcar `src` como Sources Root:**
   Clic derecho sobre `src` → `Mark Directory as → Sources Root`.
   (La carpeta se pone azul.)

3. **Marcar `test` como Test Sources Root:**
   Clic derecho sobre `test` → `Mark Directory as → Test Sources Root`.
   (La carpeta se pone verde.)

4. **Agregar JUnit como librería:**
   - Descarga `junit-platform-console-standalone-1.10.2.jar` de:
     https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/1.10.2/
   - Guárdalo en `lib/`.
   - `File → Project Structure → Libraries → + → Java` y selecciona el JAR.
   - Verifica en `Modules → Dependencies` que la librería esté asociada.

5. **Ejecutar un test:**
   Clic derecho sobre cualquier clase en `test/` → `Run 'XxxTest'`.
   O sobre la carpeta `test` → `Run 'All Tests'`.

6. **Si algo no compila:** `Build → Rebuild Project`.

---

## 🚀 Configuración del proyecto en Git

### 1. Clonar el repositorio base
```bash
git clone <URL-del-repo-base> parcial-estructuras
cd parcial-estructuras