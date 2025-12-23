public class MainListaSimple {
    public static void main(String[] args) {
        ListaLigadaSimple<Integer> lista = new ListaLigadaSimple<>();

        // Insertar elementos en la lista
        lista.insertar(1);
        lista.insertar(2);
        lista.insertar(3);

        // Imprimir los elementos de la lista
        System.out.println("Elementos de la lista:");
        System.out.println(lista);
        System.out.println();

        System.out.println("El índice del elemento 2 es: " + lista.devolverIndiceElemento(2));
        System.out.println();
        
        System.out.println("Está 3 en la lista : "+ lista.buscar(3));
        System.out.println("El accedido es: "+ lista.acceder(1));
        System.out.println();

        System.out.println("La longitud es: "+ lista.darLongitud());
        lista.eliminar(2);

        System.out.println("Elementos de la lista:");
        
        System.out.println(lista);
        
        System.out.println();

        System.out.println("La longitud es: "+ lista.darLongitud());
        System.out.println("El accedido es: "+ lista.acceder(1));
        System.out.println();

        Integer x = 3;
        lista.eliminar(x);
        System.out.println(lista);
    }
}