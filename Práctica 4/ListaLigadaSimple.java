import java.util.Iterator;

/**
 * Implementación de una lista enlazada simple genérica.
 *
 * @param <T> El tipo de elementos almacenados en la lista.
 */
public class ListaLigadaSimple<T> implements Lista<T> {

    private class Nodo{
        /**
         * Elemento almacenado en el nodo.
         */
        public T elemento;

        /**
         * Apuntador al siguiente nodo en la lista.
         */
        public Nodo siguiente;

        /**
         * Crea un nuevo nodo con el elemento proporcionado.
         *
         * @param elemento El elemento a almacenar en el nodo.
         */
        public Nodo(T elemento) {
            this.elemento = elemento;
        }
    }

    /**
    * Un iterador para recorrer la lista enlazada simple.
    */
    private class IteradorListaSimple implements Iterator<T> {

        /**
         * El nodo siguiente al que se moverá el iterador.
         */
        private Nodo iteradorLista;

        /**
         * Crea un nuevo iterador y lo inicializa en el primer nodo de la lista.
         */
        public IteradorListaSimple() {
            iteradorLista = new Nodo(null);
            iteradorLista.siguiente = cabeza;
        }

        /**
         * Verifica si hay un siguiente elemento en la lista.
         *
         * @return true si hay un siguiente elemento, false de lo contrario.
         */
        public boolean hasNext() {
            return iteradorLista.siguiente != null;
        }

        /**
         * Obtiene el siguiente elemento en la lista y mueve el iterador al siguiente nodo.
         *
         * @return El siguiente elemento en la lista.
         */
        public T next() {
            iteradorLista = iteradorLista.siguiente;
            return iteradorLista.elemento;
        }
    }

    private Nodo cabeza;

    private int longitud;

    public ListaLigadaSimple(){
      this.cabeza = null;
      this.longitud = 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterator<T> iterator() {
        return new IteradorListaSimple();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void insertar(T elemento) throws IllegalArgumentException {
        if(elemento == null){ throw new IllegalArgumentException("El elemento no puede ser null");}
        Nodo previousHead = this.cabeza;
        Nodo newNode = new Nodo(elemento);
        newNode.siguiente = previousHead;
        this.cabeza = newNode;
        this.longitud++;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean buscar(T elemento) {
        for(T element: this){
            if (element == elemento){
                return true;
            }
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T acceder(int i) throws IllegalArgumentException {
        if(i < 0 || i > this.longitud ){throw new IllegalArgumentException("Indice invalido");}
        int index = 0;
        for(T element: this){
            if(i == index){
                return element;
            }else{
                index++;
            }
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void eliminar(int i) {
        if(i == 0){
            this.cabeza = this.cabeza.siguiente;
            this.longitud--;
            return;
        }
        Nodo currentNode = this.cabeza;
        for (int index = 0; index < this.longitud; index++){
            if (index == i-1){
                if (currentNode.siguiente.siguiente == null){
                    currentNode.siguiente = null;
                }else{
                    currentNode.siguiente = currentNode.siguiente.siguiente;
                }
                this.longitud--;
            }else{
                currentNode = currentNode.siguiente;
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    public void eliminar(T elemento){
        int index = this.devolverIndiceElemento(elemento);
        this.eliminar(index);
    }

    /**
     * {@inheritDoc}
     */
    public int devolverIndiceElemento(T elemento) throws IllegalArgumentException{
        Nodo currentNode = this.cabeza;
        for (int i = 0; i < this.longitud; i++){
            if(currentNode.elemento.equals(elemento)){
                return i;
            }else{
                currentNode = currentNode.siguiente;
            }
        }
        throw new IllegalArgumentException("El elemento no se encuentra en la lista");
    }

    /**
     * Obtiene la longitud actual de la lista.
     *
     * @return La longitud de la lista.
     */
    public int darLongitud() {
        return this.longitud;
    }

    /**
     * Obtiene el primer nodo de la lista.
     *
     * @return El primer nodo de la lista.
     */
    public Nodo darCabeza() {
        return this.cabeza;
    }

    /**
     * Devuelve una representación en cadena de la lista ligada.
     * Los elementos se muestran en orden, separados por comas y encerrados entre corchetes.
     * 
     * @return una cadena con los elementos de la lista.
     */
    @Override
    public String toString() {
        String resultado = "[";
        boolean primero = true;
        for (T elemento : this) {
            if (!primero) {
                resultado += ", ";
            } else {
                primero = false;
            }
            resultado += elemento.toString();
        }

        resultado += "]";
        return resultado;
    }

}