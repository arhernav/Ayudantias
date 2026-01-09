public class OrdenamientosCuadraticos {

    private static <T> void intercambio(T[] arreglo, int i, int j) {
        /*Aquí va tu código*/
    }

    private static <T extends Comparable<T>> int encontrarIndiceMenor(T[] arreglo, int i, int j){
        /*Aquí va tu código*/
    }  

    public static <T extends Comparable<T>> void selectionSort(T[] arreglo) {
        /*Aquí va tu código*/
    }

    public static <T extends Comparable<T>> void bubbleSort(T[] arreglo) {
        /*Aquí va tu código*/
    }

    public static <T extends Comparable<T>> void insertionSort(T[] arreglo) {
        /*Aquí va tu código*/
    }

    public static <T extends Comparable<T>> void ordenar(int algoritmo, T[] arreglo) {
        switch (algoritmo) {
            case 1:
                selectionSort(arreglo);
                break;
            case 2:
                bubbleSort(arreglo);
                break;
            case 3:
                insertionSort(arreglo);
                break;
            default:
                System.out.println("Opción de ordenamiento no válida.");
        }
    }

    public static <T> String imprimeArreglo(T[] arreglo) {
        String s = "{";
        for (int i = 0; i < arreglo.length; i++) {
            if (i == arreglo.length - 1) {
                s = s + arreglo[i];
            } else {
                s = s + arreglo[i] + ",";
            }
        }
        s = s + "}";
        return s;
    }
}
