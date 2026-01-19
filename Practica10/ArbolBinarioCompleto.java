public class ArbolBinarioCompleto<T> extends ArbolBinario<T> {
    
    private Vertice ultimoAgregado;

    public ArbolBinarioCompleto() {
        super();
        ultimoAgregado = null;
    }

    @Override
    public void insertar(T elemento) {
        if( elemento ==  null){ return;}
        Vertice newVertice = new Vertice(elemento);
        if(this.raiz == null){
            this.raiz = newVertice;
            this.ultimoAgregado = newVertice;
            this.tamanio+=1;
            return;
        }
        Cola<Vertice> cola = new Cola<Vertice>();
        cola.meter(this.raiz);
        while(!cola.estaVacia()){
            Vertice v = cola.sacar();
            if(v.izquierdo != null){
                cola.meter(v.izquierdo);
            }else{
                v.izquierdo = newVertice;
                newVertice.padre = v;
                break;
            }
            if(v.derecho != null){
                cola.meter(v.derecho);
            }else{
                v.derecho = newVertice;
                newVertice.padre = v;
                break;
            }
        }
        this.tamanio +=1;
    }

    @Override
    public void eliminar(T elemento) {
        if(elemento == null || this.raiz == null){ return;}
        Vertice verticeAEliminar = new Vertice(null);
        Vertice ultimoVertice = new Vertice(null);
        Cola<Vertice> cola = new Cola<Vertice>();
        cola.meter(this.raiz);
        while(!cola.estaVacia()){
            Vertice actual = cola.sacar();
            ultimoVertice = actual;
            if(actual.elemento.equals(elemento)){verticeAEliminar = actual;}
            if(actual.izquierdo != null){cola.meter(actual.izquierdo);}
            if(actual.derecho != null){cola.meter(actual.derecho);}
        }

        if(verticeAEliminar == null){return;}
        verticeAEliminar.elemento = ultimoVertice.elemento;
        if(ultimoVertice == this.raiz){
            this.raiz = null;
        }else{
            Vertice p = ultimoVertice.padre;
            if(p.izquierdo == ultimoVertice){
                p.izquierdo = null;
            }else{
                p.derecho = null;
            }
        }
        this.tamanio -= 1;
        this.actualizarUltimoAgregado();
    }

    private void actualizarUltimoAgregado() {
        if(this.raiz == null){this.ultimoAgregado = null;}
        Cola<Vertice> cola = new Cola<Vertice>();
        cola.meter(this.raiz);
        while(!cola.estaVacia()){
            Vertice ultimo = cola.sacar();
            if(ultimo.izquierdo != null){cola.meter(ultimo.izquierdo);}
            if(ultimo.derecho != null){cola.meter(ultimo.derecho);}
            this.ultimoAgregado = ultimo;
        }

    }


    @Override
    public boolean buscar(T elemento) {
        return this.buscar(elemento, this.raiz);
    }

    private boolean buscar(T elemento, Vertice v){
        if(v == null){ return false;}
        if(v.elemento.equals(elemento)){return true;}
        return this.buscar(elemento, v.izquierdo) || this.buscar(elemento, v.derecho);  
    }

    @Override
    public ListaDoblementeLigada<T> devolverRecorrido() {
        ListaDoblementeLigada<T> recorrido = new ListaDoblementeLigada<>();
        if(this.raiz == null){return recorrido;}
        Cola<Vertice> cola = new Cola<Vertice>();
        cola.meter(this.raiz);
        while(!cola.estaVacia()){
            Vertice actual = cola.sacar();
            recorrido.insertarFinal(actual.elemento);
            if(actual.izquierdo != null){cola.meter(actual.izquierdo);}
            if(actual.derecho != null){cola.meter(actual.derecho);}
        }
        return recorrido;
    }

    private void agregaEnPrimerEspacioIzquierdo(Vertice desde, Vertice nuevo) {
        while(desde.izquierdo != null){
            desde = desde.izquierdo;
        }
        desde.izquierdo = nuevo; 
        this.ultimoAgregado = nuevo;
        this.tamanio+=1;
    }

}
