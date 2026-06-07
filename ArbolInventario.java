/**
 * Clase ArbolInventario - Implementa un Árbol Binario de Búsqueda
 * Gestiona un inventario de extensiones ordenadas por ID
 */
public class ArbolInventario {
    // Referencia a la raíz del árbol
    Producto raiz;
    
    /**
     * Constructor - Inicializa un árbol vacío
     */
    public ArbolInventario() {
        this.raiz = null;  // El árbol comienza vacío
    }
    
    /**
     * Inserta una nueva extensión en el árbol
     * @param id - ID de la extensión
     * @param nombre - Nombre de la oficina
     */
    public void insertar(int id, String nombre) {
        raiz = insertarRecursivo(raiz, id, nombre);
    }
    
    /**
     * Método recursivo para insertar elementos manteniendo el orden BST
     * IDs menores van a la izquierda, mayores a la derecha
     * @param actual - Nodo actual en el recorrido
     * @param id - ID a insertar
     * @param nombre - Nombre asociado al ID
     * @return Retorna el nodo (nuevo o existente)
     */
    private Producto insertarRecursivo(Producto actual, int id, String nombre) {
        // Si el nodo está vacío, creamos uno nuevo
        if (actual == null) {
            return new Producto(id, nombre);
        }
        // Si el ID es menor, va al subárbol izquierdo
        if (id < actual.id) {
            actual.izquierdo = insertarRecursivo(actual.izquierdo, id, nombre);
        } else {
            // Si el ID es mayor o igual, va al subárbol derecho
            actual.derecho = insertarRecursivo(actual.derecho, id, nombre);
        }
        return actual;
    }
    
    /**
     * Muestra todas las extensiones en orden ascendente (recorrido inorden)
     */
    public void mostrar() {
        mostrarRecursivo(raiz);
    }
    
    /**
     * Recorrido inorden del árbol: izquierda -> raíz -> derecha
     * Esto produce las extensiones ordenadas por ID
     * @param actual - Nodo actual siendo procesado
     */
    private void mostrarRecursivo(Producto actual) {
        if (actual != null) {
            mostrarRecursivo(actual.izquierdo);  // Procesar subárbol izquierdo
            // Mostrar información del nodo actual
            System.out.println("ID: " + actual.id + " - Oficina: " + actual.nombre);
            mostrarRecursivo(actual.derecho);   // Procesar subárbol derecho
        }
    }
    
    /**
     * Busca una extensión por su ID
     * @param id - ID a buscar
     * @return Mensaje con el resultado de la búsqueda
     */
    public String buscar(int id) {
        Producto resultado = buscarRecursivo(raiz, id);
        if (resultado != null) {
            return "Encontrado: ID " + resultado.id + " - Oficina: " + resultado.nombre;
        }
        return "No se encontró el ID " + id + ".";
    }
    
    /**
     * Búsqueda recursiva en el árbol binario
     * Aprovecha la propiedad BST: izquierda < raíz < derecha
     * @param actual - Nodo actual en la búsqueda
     * @param id - ID buscado
     * @return El nodo si lo encuentra, null si no existe
     */
    private Producto buscarRecursivo(Producto actual, int id) {
        // Caso base: árbol vacío o nodo nulo
        if (actual == null) {
            return null;
        }
        // Si encontramos el ID, retornamos el nodo
        if (id == actual.id) {
            return actual;
        }
        // Si el ID buscado es menor, buscar en subárbol izquierdo
        // Si es mayor, buscar en subárbol derecho
        return id < actual.id
                ? buscarRecursivo(actual.izquierdo, id)
                : buscarRecursivo(actual.derecho, id);
    }
}