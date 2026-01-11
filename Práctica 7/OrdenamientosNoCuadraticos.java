import java.util.Iterator;
public class OrdenamientosNoCuadraticos {

    public static void countingSort(Integer[] arreglo) {
        int max = obtenerMax(arreglo);
        int[] cont = new int[max + 1];
        for(int i: arreglo){
            cont[i]++;
        }
        int index = 0;
        for(int i = 0; i< cont.length; i ++){
            while(cont[i] > 0){
                arreglo[index] = i;
                index ++;
                cont[i] = cont[i]-1;
            }
            
        }
    }

    private static int obtenerMax(Integer[] arreglo) {
        int max = arreglo[0];
        for(int elemento: arreglo){
            if (elemento > max){
                max = elemento;
            }
        }
        return max;
    }


    public static <T extends Comparable<T>> ListaDoblementeLigada<T> mergeSortSupport(ListaDoblementeLigada<T> lista) {
        if(lista.longitud < 2){
            return lista;
        }
        ListaDoblementeLigada<T> listaIzquirda = new ListaDoblementeLigada<T>();
        ListaDoblementeLigada<T> listaDerecha = new ListaDoblementeLigada<T>();
        int mitad = lista.longitud / 2;
        for(int i = 0; i < lista.longitud; i ++){
            if(i < mitad){
                listaIzquirda.insertar(lista.acceder(i));
            }else{
                listaDerecha.insertar(lista.acceder(i));
            }
        }
        listaIzquirda = mergeSortSupport(listaIzquirda);
        listaDerecha = mergeSortSupport(listaDerecha);

        return mezclar(listaIzquirda, listaDerecha);
    }

    public static <T extends Comparable<T>> void mergeSort(ListaDoblementeLigada<T> lista) {
        ListaDoblementeLigada<T> newLista = mergeSortSupport(lista);
        lista.cabeza = newLista.cabeza;
        lista.rabo = newLista.rabo;
        lista.longitud = newLista.longitud;
    }


    private static <T extends Comparable<T>> ListaDoblementeLigada<T> mezclar(ListaDoblementeLigada<T> li, ListaDoblementeLigada<T> ld) {
        ListaDoblementeLigada<T>.Nodo ni = li.cabeza;
        ListaDoblementeLigada<T>.Nodo nd = ld.cabeza;
        ListaDoblementeLigada<T> result = new ListaDoblementeLigada<T>();
        
        while(ni != null && nd != null){
            if(ni.elemento.compareTo(nd.elemento) < 0 ){
                result.insertar(ni.elemento);
                ni = ni.siguiente;
            }else{
                result.insertar(nd.elemento);
                nd = nd.siguiente;
            }
        }
        
        ListaDoblementeLigada<T>.Nodo sobrante = null;
        if(ni != null){ sobrante = ni;}else{sobrante = nd;}

        while(sobrante != null){
            result.insertar(sobrante.elemento);
            sobrante = sobrante.siguiente;
        }

        return result;
        
    }

    public static <T extends Comparable<T>> void quickSort(T[] arreglo) {
        quickSortAux(arreglo, 0, arreglo.length -1);
    }

    private static <T extends Comparable<T>> void quickSortAux(T[] arreglo, int inicio, int fin) {
        if(inicio >= fin ){return;}
        int indicePivote = particionar(arreglo, inicio, fin);
        quickSortAux(arreglo, inicio, indicePivote - 1);
        quickSortAux(arreglo, indicePivote + 1, fin);
    }

    private static <T extends Comparable<T>> int particionar(T[] arreglo, int inicio, int fin) {
        
        T pivote = arreglo[fin];
        int i = inicio;
        for(int j = inicio; j < fin ; j++){
            if(arreglo[j].compareTo(pivote) <= 0){
                intercambiar(arreglo, i, j);
                i = i + 1;
            }
        }
        intercambiar(arreglo, i , fin);
        return i;
    }

    private static <T> void intercambiar(T[] arreglo, int i, int j) {
        T support = arreglo[i];
        arreglo[i] = arreglo[j];
        arreglo[j] = support;
    }
}
