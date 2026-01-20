public class ArbolBinarioOrdenado<T extends Comparable<T>> extends ArbolBinario<T>{

    public ArbolBinarioOrdenado(){
        super();
    }
    
    @Override
    public void insertar(T elemento) throws IllegalArgumentException{
        if(elemento == null){throw new IllegalArgumentException("No se puede insertar un elemento null");}
        if(this.raiz == null){
            Vertice v = new Vertice(elemento);
            this.raiz = v;
            this.tamanio +=1;
            return;
        }

        this.insertar(this.raiz, elemento);
    }
    
    private void insertar(Vertice v,T elemento){
        if(v.elemento.equals(elemento)){return;}
        if(v.elemento.compareTo(elemento) <= 0){
            if(v.derecho == null){
                Vertice vAux = new Vertice(elemento);
                this.tamanio +=1;
                v.derecho = vAux;
                vAux.padre = v;
                return;
            }else{
                this.insertar(v.derecho, elemento);
            }
        }
        if(v.izquierdo == null){
            Vertice vAux = new Vertice(elemento);
        }
        

        
    }
    
    @Override
    public void eliminar(T elemento) {
        if(elemento == null){return;}
        this.eliminar(this.raiz, elemento);
    }
    
    private void eliminar(Vertice v, T elemento) {
        if (v == null){return;}
        if(v.elemento.equals(elemento) && v == this.raiz && this.tamanio == 1){
            this.tamanio = 0;
            this.raiz = null;
        }
        if(v.elemento.equals(elemento) && v.izquierdo == null && v.derecho == null && v != this.raiz){  // Elemento es hoja
            this.tamanio -=1;
            if(v.esHijoIzquierdo()){
                v.padre.izquierdo = null;
            }else{
                v.padre.derecho = null;
            }
            return;
        }

        if(v.elemento.equals(elemento) && ((v.derecho != null &&  v.izquierdo == null) || (v.izquierdo != null &&  v.derecho == null) )){ //vertice solo tiene un hijo
            this.tamanio -=1;
            if(v.izquierdo != null){
                v.izquierdo.padre = v.padre;
                if(v.esHijoIzquierdo()){v.padre.izquierdo = v.izquierdo;}
                if(v.esHijoDerecho()){v.padre.derecho = v.izquierdo;}
            }
            if(v.derecho != null){
                v.derecho.padre = v.padre;
                if(v.esHijoIzquierdo()){v.padre.izquierdo = v.derecho;}
                if(v.esHijoDerecho()){v.padre.derecho = v.derecho;}
            }
            return;
        }

        if(v.elemento.equals(elemento) && v.derecho != null && v.izquierdo != null){
            Vertice support = v.izquierdo;
            while(support.derecho != null){
                support = support.derecho;
            }
            T e = v.elemento;
            v.elemento = support.elemento;
            support.elemento = e;
            this.eliminar(this.raiz, elemento);
        }
        this.eliminar(v.izquierdo, elemento);
        this.eliminar(v.derecho, elemento);
    }
    
    private Vertice devolverMinimo(Vertice v) {
        while(v.izquierdo != null){
            v = v.izquierdo;
        }
        return v;
    }
    
    @Override
    public boolean buscar(T elemento) {
        return this.buscar(elemento, this.raiz);
    }
    
    private boolean buscar(T elemento, Vertice v){
        if(v == null){return false;}
        if(v.elemento.equals(elemento)){
            return true;
        }
        if(v.elemento.compareTo(elemento) <= 0){
            return this.buscar(elemento, v.derecho);
        }
        return this.buscar(elemento, v.izquierdo);
    }

    public ListaDoblementeLigada<T> devolverRecorrido() {
        ListaDoblementeLigada<T> recorrido = new ListaDoblementeLigada<>();
        if(this.raiz == null){return recorrido;}
        Pila<Vertice> pila = new Pila<>();
        Vertice actual = this.raiz;
        while(actual != null || !pila.estaVacia()){
            while(actual != null){
                pila.meter(actual);
                actual = actual.izquierdo;
            }
            actual = pila.sacar();
            recorrido.insertarFinal(actual.elemento);
            actual = actual.derecho;
        }
        return recorrido;
    }





}
