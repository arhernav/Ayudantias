import java.util.Scanner;

public class MainPiCola {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Qué estructura deseas probar?");
        System.out.println("1. Pila");
        System.out.println("2. Cola");
        System.out.print("Elige una opción (1 o 2): ");

        int opcion = sc.nextInt();

        switch (opcion) {
            case 1:
                System.out.println("\nPROBANDO PILA");
                Pila<Integer> pila = new Pila<>();
                Pila<Integer> pila2 = new Pila<>();
                probarEstructura(pila,pila2);
                break;

            case 2:
                System.out.println("\nPROBANDO COLA");
                Cola<Integer> cola = new Cola<>();
                Cola<Integer> cola2 = new Cola<>();
                probarEstructura(cola,cola2);
                break;

            default:
                System.out.println("Opción no válida");
        }

        sc.close();
    }

    public static void probarEstructura(PiCoLa<Integer> estructura, PiCoLa<Integer> estructura2) {

        System.out.println("¿Está vacía?: " + estructura.estaVacia());
        System.out.println("Tamanio: " + estructura.devolverTamanio());

        System.out.println("\nAgregando elementos");
        estructura.meter(10);
        estructura.meter(20);
        estructura.meter(30);

        System.out.println("¿Está vacía?: " + estructura.estaVacia());
        System.out.println("Tamanioo: " + estructura.devolverTamanio());

        System.out.println("\nConsultando el primer elemento");
        System.out.println("Elemento: " + estructura.mira());

        System.out.println("\nsacando elementos");
        System.out.println("Elemento sacado: " + estructura.sacar());
        System.out.println("Tamaio: " + estructura.devolverTamanio());

        System.out.println("\nComparando con otra PiCoLa");

        estructura2.meter(20);
        estructura2.meter(30);
        System.out.println(estructura2);
        System.out.println("¿Son iguales?: " + estructura.equals(estructura2));

        System.out.println("\nagregando un elemento diferente a la segunda PiCoLa");
        estructura2.meter(40);
        System.out.println("¿Son iguales ahora?: " + estructura.equals(estructura2));
    }
}
