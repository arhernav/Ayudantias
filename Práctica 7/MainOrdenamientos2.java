import java.util.Random;

/**
 * Clase para probar ordenamientos sobre listas y arreglos.
 */
public class MainOrdenamientos2 {

    public static void main(String[] args) {

        // Generar arreglo aleatorio con 10 elementos (valores entre 0 y 99)
        Integer[] arreglo = generarArregloAleatorio(10, 100);
        System.out.println("\nArreglo original: " + arregloToString(arreglo));

        // Ordenar arreglo con bucketSort
        OrdenamientosNoCuadraticos.countingSort(arreglo);
        System.out.println("Arreglo ordenado (bucketSort): " + arregloToString(arreglo));

        // Generar lista aleatoria con 10 elementos (valores entre 0 y 99)
        ListaDoblementeLigada<Integer> lista = generarListaAleatoria(10, 100);
        System.out.println("\nLista original: " + lista);

        // Ordenar la lista con mergeSort
        OrdenamientosNoCuadraticos.mergeSort(lista);
        System.out.println("Lista ordenada (mergeSort): " + lista);

        // Generar arreglo aleatorio con 10 elementos (valores entre 0 y 99)
        Integer[] arreglo2 = generarArregloAleatorio(10, 100);
        System.out.println("\nArreglo original: " + arregloToString(arreglo2));

        // Ordenar arreglo con quickSort
        OrdenamientosNoCuadraticos.quickSort(arreglo2);
        System.out.println("Arreglo ordenado (quickSort): " + arregloToString(arreglo2));
    }

    /**
     * Genera una lista doblemente ligada de enteros aleatorios.
     * @param tamaño número de elementos a generar.
     * @param maxValor valor máximo (exclusivo) para los números aleatorios.
     * @return lista doblemente ligada con números aleatorios.
     */
    private static ListaDoblementeLigada<Integer> generarListaAleatoria(int tamaño, int maxValor) {
        ListaDoblementeLigada<Integer> lista = new ListaDoblementeLigada<>();
        Random rand = new Random();

        for (int i = 0; i < tamaño; i++) {
            lista.insertar(rand.nextInt(maxValor));
        }
        return lista;
    }

    /**
     * Genera un arreglo de Integer con valores aleatorios.
     * @param tamaño número de elementos a generar.
     * @param maxValor valor máximo (exclusivo) para los números aleatorios.
     * @return arreglo con números aleatorios.
     */
    private static Integer[] generarArregloAleatorio(int tamaño, int maxValor) {
        Integer[] arreglo = new Integer[tamaño];
        Random rand = new Random();

        for (int i = 0; i < tamaño; i++) {
            arreglo[i] = rand.nextInt(maxValor);
        }
        return arreglo;
    }

    /**
     * Convierte un arreglo genérico a una cadena legible similar a Arrays.toString.
     * @param arreglo arreglo genérico a convertir.
     * @param <T> tipo de los elementos del arreglo.
     * @return representación en cadena del arreglo.
     */
    private static <T> String arregloToString(T[] arreglo) {
        if (arreglo == null || arreglo.length == 0) {
            return "[]";
        }
        String resultado = "[";
        for (int i = 0; i < arreglo.length; i++) {
            resultado += arreglo[i];
            if (i < arreglo.length - 1) {
                resultado += ", ";
            }
        }
        resultado += "]";
        return resultado;
    }
}
