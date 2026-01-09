import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListaDoblementeLigada<T> implements Lista<T> {

     private class Nodo{
          public T elemento;

          public Nodo siguiente;

          public Nodo anterior;

          public Nodo(T e) {
               this.elemento = e;
          }
     }

     private class IteradorDoubleLinkedList implements Iterator<T> {

          public Nodo anterior;

          public Nodo siguiente;

          public IteradorDoubleLinkedList() {
               siguiente = cabeza;
          }

          @Override

          public boolean hasNext() {
               return siguiente != null;
          }

          @Override
          public T next() {
               if (siguiente == null) {
                    throw new NoSuchElementException("El elemento es null");
               }
               anterior = siguiente;
               siguiente = siguiente.siguiente;
               return anterior.elemento;
          }
     }

     private Nodo cabeza;

     private Nodo rabo;

     private int longitud;

     public Iterator<T> iterator() {
          return new IteradorDoubleLinkedList();
     }

     public ListaDoblementeLigada(){
          this.cabeza = null;
          this.rabo = null;
          this.longitud = 0;
     }

     @Override
     public void insertar(T elemento) throws IllegalArgumentException {
          if(elemento == null){throw new IllegalArgumentException("No se puede insertar null");}
          Nodo newNode = new Nodo(elemento);
          if(this.cabeza == null){
               this.cabeza = this.rabo = newNode;
               this.longitud +=1;
          }else{
               this.cabeza.anterior = newNode;
               newNode.siguiente = this.cabeza;
               this.cabeza = newNode; 
               this.longitud +=1;
          }
     }

     public void eliminar(T elemento){

          if(this.cabeza == this.rabo){ 
               this.cabeza = this.rabo = null;
               this.longitud = 0; 
          } // only one element

          Nodo currentNode = this.cabeza;
          for(int i = 0; i < this.longitud; i ++){
               if(elemento.equals(currentNode.elemento)){
                    if( currentNode == this.cabeza){
                         this.eliminarCabeza();
                    }else if(currentNode == this.rabo){
                         this.eliminarRabo();
                    }else{
                         currentNode.anterior.siguiente = currentNode.siguiente;
                         currentNode.siguiente.anterior = currentNode.anterior;
                         this.longitud --;
                    } 
               }
               break;
          }
     }

     public void eliminarRabo(){
          if(this.cabeza == this.rabo){ 
               this.cabeza = this.rabo = null;
               this.longitud = 0; 
          } // only one element
          this.rabo = this.rabo.anterior;
          this.rabo.siguiente = null;
          this.longitud--;
     }

     public void eliminarCabeza(){
          if(this.cabeza == this.rabo){ 
               this.cabeza = this.rabo = null;
               this.longitud = 0; 
          } // only one element

          this.cabeza = this.cabeza.siguiente;
          this.cabeza.anterior = null;
          this.longitud--;
     }

     @Override
     public boolean buscar(T elemento) {
          for(T elem: this){
               if(elem.equals(elemento)){
                    return true;
               }
          }
          return false;
     }

     @Override
     public void eliminar(int i) {
          Nodo toDelete = this.accederNodo(i);
          toDelete.anterior.siguiente = toDelete.siguiente;
          toDelete.siguiente.anterior = toDelete.anterior;
          this.longitud--;
     }

     @Override
     public T acceder(int i) throws IllegalArgumentException {
          if(i < 0 || i>= this.longitud){throw new IllegalArgumentException("Este indice no se encuentra en la lista");}
          return this.accederNodo(i).elemento;   
     }

     public int devolverIndiceElemento(T elemento) throws IllegalArgumentException{
          Nodo supp = this.cabeza; 
          for(int i = 0; i < this.longitud; i ++){
               if(supp.elemento == elemento){
                    return i;
               }else{
                    supp = supp.siguiente;
               }
          }
          throw new IllegalArgumentException("El elemento no se encuentra en la lista");
     }

     public int darLongitud(){
          return this.longitud;
     }

     public void insertarFinal(T elemento) throws IllegalArgumentException {
          if(elemento == null){throw new IllegalArgumentException("No se puede insertar null");}
          Nodo newNode = new Nodo(elemento);
          if( this.cabeza == null){
               this.cabeza = this.rabo = newNode;
               this.longitud +=1;
          }else{
               this.rabo.siguiente = newNode;
               newNode.anterior = this.rabo; 
               this.rabo = newNode;
               this.longitud +=1;
          }
     }

     public ListaDoblementeLigada<T> reversa(){
          ListaDoblementeLigada<T> reversa = new ListaDoblementeLigada<>();
          if(this.cabeza == null){return reversa;}
          for(T suppElement: this){
               reversa.insertar(suppElement);
          }
          return reversa;
     }

     
     private Nodo accederNodo(int i) throws IllegalArgumentException {
          if(i < 0 || i >= this.longitud){throw new IllegalArgumentException("El indice no se encuentra en la lista");}
          int middle = (this.longitud-1)/ 2;
          Nodo currentNode = null;
          if(i < middle ){
               currentNode = this.cabeza; 
               for( int j = 0; j <= middle; j++){
                    if(j == i){
                         return currentNode;
                    }else{
                         currentNode = currentNode.siguiente;
                    }
               }
          }else{
               currentNode = this.rabo; 
               for( int j = this.longitud-1; j >= middle; j--){
                    if(j == i){
                         return currentNode;
                    }else{
                         currentNode = currentNode.anterior;
                    }
               }
          }
          return currentNode;
     }

     public String toString(){
          String s = "[";
          int cont = 0;
          for(T elem : this){
               if(cont == 0){
                    s = s + elem.toString();
                    cont++;
               }else{
                    s = s + "," +elem.toString();
               }
          }
          s = s + "]";
          return s;
     }
}