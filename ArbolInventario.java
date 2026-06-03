public class ArbolInventario {
Producto raiz;
public ArbolInventario() {
    this.raiz = null;
}
public void insertar(int id, String nombre) {
    
    raiz = insertarRecursivo(raiz, id,nombre);
}
private Producto insertarRecursivo(Producto actual, int id, String nombre) {
    if (actual == null) {
        return new Producto(id, nombre);
    }
    if (id < actual.id) {
        actual.izquierdo = insertarRecursivo(actual.izquierdo, id, nombre);
    } else {
        actual.derecho = insertarRecursivo(actual.derecho, id, nombre);
    }
    return actual;
}
public void mostrar() {
    mostrarRecursivo(raiz);
}

private void mostrarRecursivo(Producto actual) {
    if (actual != null) {
        mostrarRecursivo(actual.izquierdo);
        System.out.println("ID: " + actual.id + " - Oficina: " + actual.nombre);
        mostrarRecursivo(actual.derecho);
    }
}

public String buscar(int id) {
    Producto resultado = buscarRecursivo(raiz, id);
    if (resultado != null) {
        return "Encontrado: ID " + resultado.id + " - Oficina: " + resultado.nombre;
    }
    return "No se encontró el ID " + id + ".";
}

private Producto buscarRecursivo(Producto actual, int id) {
    if (actual == null) {
        return null;
    }
    if (id == actual.id) {
        return actual;
    }
    return id < actual.id
            ? buscarRecursivo(actual.izquierdo, id)
            : buscarRecursivo(actual.derecho, id);
}
}