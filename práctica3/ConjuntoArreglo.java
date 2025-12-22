import java.util.Iterator;
import java.util.NoSuchElementException;

public class ConjuntoArreglo<T> extends Conjunto<T>{

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int indice = 0;

            @Override
            public boolean hasNext() {
                return indice < elementos.length;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return elementos[indice++];
            }
        };
    }

    public T[] elementos;

    public ConjuntoArreglo() {
        this.elementos = (T[]) new Object[0];
    }

    public ConjuntoArreglo(T[] elementos) {
        if (elementos == null) {
            this.elementos = (T[]) new Object[0];
        } else if (UtilArreglos.tieneDuplicados(elementos)) {
            throw new IllegalArgumentException("El arreglo contiene elementos duplicados.");
        } else if (UtilArreglos.contieneNull(elementos)) {
            throw new IllegalArgumentException("El arreglo contiene elementos nulos.");
        } else {
            this.elementos = UtilArreglos.copiaArregloGenerico(elementos);
        }
    }

    /* Determina si el elemento se encuenra en el conjunto
    * @return boolean - True si el elemento se encuentra en el conjuno. False en otro caso
    */
    public boolean pertenece(T elemento) {
        for(T element: this.elementos){
            if(elemento.equals(element)){
                return true;
            }
        }
        return false;
    }

    /** Método que agrega un elemento a un conjunto
     * @param T Elemento - Elemento a agregar al conjunto
     */
    public void agregarElemento(T elemento) {
        T[] newarray = (T[]) new Object[this.elementos.length + 1];
        for (int i = 0; i < this.elementos.length; i ++){
            if (this.elementos[i].equals(elemento)){
                return;
            }
            newarray[i] = this.elementos[i];
        }
        newarray[this.elementos.length] = elemento;
        this.elementos = newarray;
    }

    /** Método que recibe un conjunto y verifica si es subconjunto de otro
     * @param Conjunto<T> C - Conjunto a verificar
     * @return boolean - True en caso de que c sea subconjunto. False en otro caso
     */
    public boolean contieneConjunto(Conjunto<T> c) {
        for (T element: c){
            if(!this.pertenece(element)){
                return false;
            }
        }
        return true;
    }

    /**
     * Devuelve la unión de ambos conjuntos
     * @param Conjunto<T> c - Conjunto a unir
     * @return Conjunto<T> Unión de ambos conjuntos
     */
    public Conjunto<T> union(Conjunto<T> c) {
        Conjunto<T> uni = new ConjuntoArreglo<T>();
        for (T element: this.elementos){
            uni.agregarElemento(element);
        }
        for (T element: c){
            uni.agregarElemento(element);
        }
        return uni;
    }

    /**
     * Devuelve la intersección de ambos conjuntos
     * @param Conjunto<T> c - Conjunto que se usara para obtener la intersección
     * @return Conjunto<T> - Conjuno conteniendo la intersección de ambos.
     */
    public Conjunto<T> interseccion(Conjunto<T> c) {
        Conjunto<T> inter = new ConjuntoArreglo<T>();
        for(T element: c){
            if (this.pertenece(element)){
                inter.agregarElemento(element);
            }
        }
        return inter;
    }

    /**
     * Determina si dos conjuntos son iguales
     * @param Conjunto<T> c - Conjunto a comparar
     * @return boolean - True si ambos conjuntos son iguales. False en otro caso
     */
    public boolean iguales(Conjunto<T> c) {
        if (this.elementos.length != c.obtenerCardinalidad()){
            return false;
        }
        for (T element: c){
            if (!this.pertenece(element)){
                return false;
            }
        }
        return true;
    }

    /**
     * Devuelve la cardinalidad del conjunto
     * @return int - Cardinalidad del conjunto
     */
    public int obtenerCardinalidad(){
        return this.elementos.length;
    }

}
