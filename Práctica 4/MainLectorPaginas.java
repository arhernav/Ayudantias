import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MainLectorPaginas {
    
    public static void main(String[] args) {
        String nombreArchivo = "paginas.txt";
        ListaLigadaSimple<Pagina> lista = new ListaLigadaSimple<Pagina>();
        Historial hist = new Historial(lista);
        
        leerArchivo(nombreArchivo, hist);

        System.out.println(hist);
    }

    /**
     * Lee un archivo línea por línea con el formato "<cadenaPagina> : <fecha>"
     * y muestra su contenido. Se asume que el formato es correcto.
     *
     * @param nombreArchivo el nombre del archivo a leer
     */
    public static void leerArchivo(String nombreArchivo, Historial hist) {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(" : ");
                String pagina = partes[0].trim();
                String fecha = partes[1].trim();

                /*Aquí va tu código, puedes resolver el problema en este método o 
                usar otra forma que creas conveniente*/
            }

        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }

}
