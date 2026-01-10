public class OrdenamientosNoCuadraticos {

    public static void countingSort(Integer[] arreglo) {
        int max = obtenerMax(arreglo);
        int[] cont = new int[max + 1];
        for(int i: arreglo){
            cont[i]++;
        }
        int index = 0;
        for(int i: cont){
            if(i != 0){
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


    public static <T extends Comparable<T>> void mergeSort(ListaDoblementeLigada<T> lista) {
        /*Aquí va tu código*/
    }

    private static <T extends Comparable<T>> ListaDoblementeLigada<T> mezclar(ListaDoblementeLigada<T> li, ListaDoblementeLigada<T> ld) {
        /*Aquí va tu código*/
    }

    public static <T extends Comparable<T>> void quickSort(T[] arreglo) {
        /*Aquí va tu código*/
    }

    private static <T extends Comparable<T>> void quickSortAux(T[] arreglo, int inicio, int fin) {
        /*Aquí va tu código*/
    }

    private static <T extends Comparable<T>> int particionar(T[] arreglo, int inicio, int fin) {
        /*Aquí va tu código*/
    }

    private static <T> void intercambiar(T[] arreglo, int i, int j) {
        T support = arreglo[i];
        arreglo[i] = arreglo[j];
        arreglo[j] = arreglo[i];
        return support
    }
}
