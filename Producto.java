/**
 * Clase Producto - Representa un nodo en el árbol binario de búsqueda
 * Almacena la información de una extensión (ID y nombre de oficina)
 */
public class Producto {
    // Identificador único de la extensión
    int id;
    
    // Nombre de la oficina asociada a la extensión
    String nombre;
    
    // Referencia al nodo hijo izquierdo (extensiones con ID menor)
    Producto izquierdo;
    
    // Referencia al nodo hijo derecho (extensiones con ID mayor)
    Producto derecho;
    
    /**
     * Constructor del nodo Producto
     * @param id - Identificador de la extensión
     * @param nombre - Nombre de la oficina
     */
    public Producto(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.izquierdo = null;      // Inicialmente sin hijo izquierdo
        this.derecho = null;        // Inicialmente sin hijo derecho
    }
}