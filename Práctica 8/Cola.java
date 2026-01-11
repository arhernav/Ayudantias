public class Cola<T> implements PiCoLa<T> {

    private class Nodo {
        public T elemento;
        public Nodo siguiente;

        public Nodo(T elemento) {
            this.elemento = elemento;
            this.siguiente = null;
        }
    }

    public Nodo tope;
    public Nodo rabo;
    private int tamanio;

    @Override
    public void meter(T elemento){
        Nodo newNode = new Nodo(elemento);
        if(this.rabo == null){
            this.tope = this.rabo = newNode;
        }else{
            rabo.siguiente = newNode;
            this.rabo = newNode;
        }
        this.tamanio++;
    } 
    
    @Override
    public T sacar() {
        if(this.tope == null){
            return null;
        }
        T elemento = this.tope.elemento;
        this.tope = this.tope.siguiente;
        this.tamanio --;
        return elemento;
    }

    @Override
    public T mira() {
        return this.tope.elemento;
    }

    @Override
    public boolean estaVacia() {
        return this.tope == null;
    }

    @Override
    public int devolverTamanio() {
        return this.tamanio;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        @SuppressWarnings("unchecked") Cola<T> m = (Cola<T>)o;
        Nodo n1 = this.tope;
        Nodo n2 = m.tope;
        while (n1 !=null && n2 != null){
            if (!n1.elemento.equals(n2.elemento))
                return false;
            n1 = n1.siguiente;
            n2 = n2.siguiente;
        }
        return (n1 == null && n2 == null);
    }

    @Override
    public String toString() {
        String resultado = "[";
        Nodo actual = tope;

        while (actual != null) {
            resultado += actual.elemento;
            if (actual.siguiente != null) {
                resultado += ", ";
            }
            actual = actual.siguiente;
        }

        resultado += "]";
        return resultado;
    }
}
