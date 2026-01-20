public class MainArbolOrdenado {
    public static void main(String[] args) {
        ArbolBinarioOrdenado<Integer> arbol = new ArbolBinarioOrdenado<>();

        //insertar elementos
        System.out.println("Insertamos los primeros 10 números al arbol");
        for (int i = 1; i <= 10; i++) {
            arbol.insertar(i);
        }
        System.out.println(arbol.devolverRecorrido());
        System.out.println(arbol.tamanio);
        System.out.println();

        System.out.println("Eliminamos el número 5");
        arbol.eliminar(Integer.valueOf(5));
        System.out.println(arbol.devolverRecorrido());
        System.out.println(arbol.tamanio);

        System.out.println("Eliminamos el número 7");
        arbol.eliminar(Integer.valueOf(7));
        System.out.println(arbol.devolverRecorrido());
        System.out.println(arbol.tamanio);
        System.out.println();

        System.out.println("Comprobamos si contiene el número 3");
        System.out.println(arbol.buscar(Integer.valueOf(3)));
        System.out.println();

        System.out.println("Comprobamos si contiene el número 7");
        System.out.println(arbol.buscar(Integer.valueOf(7)));
        System.out.println();

        System.out.println("Pasamos el arbol a lista");
        System.out.println("Lista" + arbol.devolverRecorrido());
        System.out.println(arbol.tamanio);
        System.out.println();
       
    }

}
