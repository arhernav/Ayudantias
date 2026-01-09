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
          /*Aqui va tu código*/
     }

     public void eliminar(T elemento){
          /*Aqui va tu código*/
     }

     @Override
     public boolean buscar(T elemento) {
          /*Aqui va tu código*/
     }

     @Override
     public void eliminar(int i) {
          /*Aqui va tu código*/
     }

     @Override
     public T acceder(int i) throws IllegalArgumentException {
          /*Aqui va tu código*/     }

     public int devolverIndiceElemento(T elemento) throws IllegalArgumentException{
          /*Aqui va tu código*/
     }

     public int darLongitud(){
          /*Aqui va tu código*/
     }

     public void insertarFinal(T elemento) throws IllegalArgumentException {
          /*Aqui va tu código*/
     }

     public ListaDoblementeLigada<T> reversa(){
          /*Aqui va tu código*/
     }

     
     private Nodo accederNodo(int i) {
          /*Aqui va tu código*/
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