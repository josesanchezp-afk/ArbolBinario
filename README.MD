# 📞 Sistema de Directorio de Extensiones

## 🎯 Objetivo

Desarrollar un **sistema de gestión de directorio de extensiones telefónicas** que permita a las organizaciones mantener un registro ordenado y eficiente de sus extensiones. El sistema utiliza un **Árbol Binario de Búsqueda (BST)** para garantizar que:

- Las extensiones se mantengan automáticamente ordenadas por ID
- Las búsquedas sean rápidas y eficientes (O(log n) en promedio)
- La inserción de nuevas extensiones sea ordenada sin intervención manual
- El listado completo se muestre siempre en orden ascendente

## Descripción General

Sistema de gestión de inventario de extensiones telefónicas implementado mediante un **Árbol Binario de Búsqueda (BST)** en Java. Permite registrar, buscar y listar extensiones de oficinas de manera ordenada y eficiente.

---

## 📋 Clases Principales

### 1. **Clase `Producto`**

Representa un nodo en el árbol binario de búsqueda.

#### Atributos:
- `int id` - Identificador único de la extensión
- `String nombre` - Nombre de la oficina asociada
- `Producto izquierdo` - Referencia al nodo hijo izquierdo (extensiones con ID menor)
- `Producto derecho` - Referencia al nodo hijo derecho (extensiones con ID mayor)

#### Constructor:
```java
public Producto(int id, String nombre)
```
Inicializa un nodo con la extensión y nombre especificados, sin referencias iniciales a nodos hijos.

---

### 2. **Clase `ArbolInventario`**

Implementa la estructura de Árbol Binario de Búsqueda para gestionar las extensiones.

#### Atributos:
- `Producto raiz` - Referencia a la raíz del árbol

#### Métodos Principales:

##### **Constructor**
```java
public ArbolInventario()
```
Inicializa un árbol vacío.

##### **insertar(int id, String nombre)**
- **Descripción**: Inserta una nueva extensión en el árbol manteniendo el orden BST
- **Parámetros**: 
  - `id` - Número de extensión
  - `nombre` - Nombre de la oficina
- **Funcionamiento**: IDs menores van a la izquierda, mayores a la derecha

##### **mostrar()**
- **Descripción**: Muestra todas las extensiones ordenadas ascendentemente por ID
- **Recorrido**: Inorden (izquierda → raíz → derecha)

##### **buscar(int id)**
- **Descripción**: Busca una extensión por su ID
- **Parámetro**: `id` - Número de extensión a buscar
- **Retorno**: Mensaje con resultado de la búsqueda

##### **Métodos Recursivos Privados**
- `insertarRecursivo()` - Implementa la inserción recursiva
- `mostrarRecursivo()` - Implementa el recorrido inorden recursivo
- `buscarRecursivo()` - Implementa la búsqueda recursiva aprovechando la propiedad BST

---

### 3. **Clase `Main`**

Punto de entrada del programa. Proporciona una interfaz interactiva con menú para el usuario.

#### Funcionalidad:
Menú interactivo con las siguientes opciones:

| Opción | Descripción |
|--------|-------------|
| **1** | Registrar Extensión - Añade una nueva extensión al sistema |
| **2** | Ver Directorio - Muestra todas las extensiones ordenadas por ID |
| **3** | Buscar Extensión - Busca una extensión específica por ID |
| **0** | Salir - Cierra el programa |

#### Flujo del Programa:
1. Se crea una instancia del árbol binario
2. Se presenta el menú en un bucle continuo
3. El usuario selecciona una opción
4. Se procesa la solicitud según la opción elegida
5. Se repite hasta que el usuario selecciona "Salir"

---

## 🚀 Instrucciones de Ejecución

### Prerequisitos
- ✅ **Java Development Kit (JDK)** versión 8 o superior instalado
- ✅ **Compilador de Java** disponible en la ruta del sistema
- ✅ **Terminal o Línea de Comandos** accesible

### Paso 1: Compilación
Compila todos los archivos Java en archivos .class ejecutables:

```bash
javac Main.java ArbolInventario.java Producto.java
```

**Resultado esperado**: Se crean los archivos:
- `Main.class`
- `ArbolInventario.class`
- `Producto.class`

### Paso 2: Ejecución
Ejecuta el programa desde la línea de comandos:

```bash
java Main
```

### Paso 3: Interacción con el Sistema

Una vez ejecutado el programa, verás el siguiente menú:

```
--- DIRECTORIO DE EXTENSIONES ---
1. Registrar Extensión
2. Ver Directorio (Ordenado)
3. Buscar Extensión
0. Salir
Seleccione una opción: 
```

### Ejemplo Completo de Uso:

#### 1️⃣ Registrar extensiones:
```
Seleccione una opción: 1
Ingrese número de extensión: 105
Nombre de la oficina: Recepción
Registrado con éxito.

Seleccione una opción: 1
Ingrese número de extensión: 50
Nombre de la oficina: Recursos Humanos
Registrado con éxito.

Seleccione una opción: 1
Ingrese número de extensión: 200
Nombre de la oficina: Contabilidad
Registrado con éxito.
```

#### 2️⃣ Ver directorio ordenado:
```
Seleccione una opción: 2

LISTADO ACTUAL:
ID: 50 - Oficina: Recursos Humanos
ID: 105 - Oficina: Recepción
ID: 200 - Oficina: Contabilidad
```

#### 3️⃣ Buscar una extensión:
```
Seleccione una opción: 3
ID a buscar: 105
Encontrado: ID 105 - Oficina: Recepción

Seleccione una opción: 3
ID a buscar: 999
No se encontró el ID 999.
```

#### 4️⃣ Salir del programa:
```
Seleccione una opción: 0
Saliendo del sistema...
```

### Alternativa: Ejecución en un Solo Paso

Si deseas compilar y ejecutar en un solo comando:

```bash
javac Main.java ArbolInventario.java Producto.java && java Main
```

---

## 🏗️ Estructura de Datos

### Árbol Binario de Búsqueda (BST)

El sistema utiliza un **Árbol Binario de Búsqueda** para mantener las extensiones ordenadas:

- **Propiedad BST**: Para cada nodo, todos los IDs en el subárbol izquierdo son menores, y todos en el subárbol derecho son mayores
- **Ventajas**:
  - ✅ Búsqueda eficiente: O(log n) en promedio
  - ✅ Inserción ordenada automática: O(log n) en promedio
  - ✅ Listado ordenado mediante recorrido inorden: O(n)
  - ✅ Operaciones intuitivas basadas en relaciones padre-hijo

### Representación Gráfica

```
           Extensión 100 (Oficina A)
          /                        \
    Extensión 50                Extensión 150
    (Oficina B)                 (Oficina C)
     /        \                 /         \
   30        75               120        200
```

---

## 📊 Complejidad de Operaciones

| Operación | Mejor Caso | Caso Promedio | Peor Caso |
|-----------|-----------|---------------|----------|
| Insertar | O(1) | O(log n) | O(n) |
| Buscar | O(1) | O(log n) | O(n) |
| Listar (Inorden) | O(n) | O(n) | O(n) |

---

## 💡 Características

- ✅ **Gestión automática de orden** - Las extensiones se mantienen ordenadas sin intervención manual
- ✅ **Búsqueda eficiente** - Localiza extensiones rápidamente aprovechando la estructura BST
- ✅ **Interfaz amigable** - Menú intuitivo en consola
- ✅ **Escalabilidad** - Puede manejar un gran número de extensiones
- ✅ **Código bien documentado** - Comentarios explicativos en todas las clases

---

## 🔧 Requisitos

- Java 8 o superior
- No requiere librerías externas

---

## 📝 Notas Importantes

- Cada extensión (ID) debe ser única en el sistema
- Los IDs se utilizan como claves de ordenamiento
- El programa mantiene un registro durante la ejecución, pero los datos se pierden al cerrar (sin persistencia a archivos)
- Las búsquedas son case-sensitive para el nombre de la oficina

---

**Proyecto**: Sistema de Directorio de Extensiones  
**Estructura**: Árbol Binario de Búsqueda  
**Lenguaje**: Java
