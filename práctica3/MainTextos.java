import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MainTextos {
    public static void main(String[] args) {
        String archivo1 = "rosa.txt";
        String archivo2 = "elDicho.txt";

        try {
        
            // Lectura archivo 1 y creación de set
            ConjuntoArreglo<String> set1 = new ConjuntoArreglo<String>();
            FileReader fileReader = new FileReader(archivo1);
            BufferedReader buffReader = new BufferedReader(fileReader);

            while (buffReader.ready()) {
                String line = buffReader.readLine();
                String[] words = split(line);
                for(String word: words){
                    set1.agregarElemento(word);
                }
            }


            // Lectura archivo 2 y creación de set
            ConjuntoArreglo<String> set2 = new ConjuntoArreglo<String>();
            FileReader fileReader2 = new FileReader(archivo2);
            BufferedReader buffReader2 = new BufferedReader(fileReader2);

            while (buffReader2.ready()) {
                String line = buffReader2.readLine();
                String[] words = split(line);
                for(String word: words){
                    set2.agregarElemento(word);
                }
            }
             

             // Ejercicio 1
            System.out.println("\n\nImprimimos las palabras del archivo 1: rosa.txt");
            for(String word: set1){
                System.out.print("  " + word + "  ");
            }

            System.out.println("\n\nImprimimos las palabras del archivo 2: elDicho.txt");
            for(String word: set2){
                System.out.print("  " + word + "  ");
            }

             // Ejercicio 2
            Conjunto<String> inter = set1.interseccion(set2);
            System.out.println("\n\nImprimimos las palabras que tienen en común ambos archivos");
            for(String word: inter){
                System.out.print("  " + word + "  ");
            }



        } catch (IOException e) {
            System.err.println("Error leyendo archivo: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Error creando conjuntos: " + e.getMessage());
        }
    }

    
    /**
     * Recibe un string, realiza split en base a espacios, comas y puntos. Devuelve un array de las palabras contenidas en el string
     * @param String string - String a separar
     * @return String[] - Array con las palabras del string inicial separadas
     */
    public static String[] split(String string){
        String regex = "[,\\.\\s\\(\\)\\:]+"; // Regex a usar para separar las palabras
        return string.split(regex); 
    }


}

