import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Clase principal para ejecutar la simulación de un evento con usuarios registrados.
 * Lee usuarios desde un archivo, los ordena, los agrega al evento y muestra rechazados.
 */
public class MainFilaVirtual {

    // Constante que define la capacidad del evento
    public static final int CAPACIDAD_EVENTO = 5;

    /**
     * Cuenta cuántas líneas tiene el archivo de entrada.
     * Sirve para dimensionar el arreglo de usuarios.
     *
     * @param rutaArchivo ruta del archivo .txt
     * @return número de líneas en el archivo
     */
    public static int contarUsuarios(String rutaArchivo) {
        int contador = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            while (br.readLine() != null) {
                contador++;
            }
        } catch (IOException e) {
            System.out.println("Error leyendo archivo: " + e.getMessage());
        }
        return contador;
    }

    /**
     * Carga usuarios desde un archivo con formato nombre_nivel_numeroLlegada.
     *
     * @param rutaArchivo  ruta al archivo de entrada
     * @param maxUsuarios  número máximo de usuarios a cargar
     * @return arreglo de usuarios cargados
     */
    public static Usuario[] cargarUsuariosDesdeArchivo(String rutaArchivo, int maxUsuarios) {
        Usuario[] usuariosArreglo = new Usuario[maxUsuarios];
        int contador = 0;
        String line = null;
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            line = null;
            while ( (line = br.readLine()) != null && contador < maxUsuarios) {
                String[] splitString = line.split("[_]+");
                usuariosArreglo[contador] = new Usuario(splitString[0], getNivel(splitString[1]), Integer.parseInt(splitString[2]));
                contador++;
            }
        } catch (IOException e) {
            System.out.println("Error leyendo archivo: " + e.getMessage());
        }
        return usuariosArreglo;
    }

    public static Usuario.Nivel getNivel(String nivelString){
        switch(nivelString){
            case "REGULAR":
                return Usuario.Nivel.REGULAR;
                
            case "PREMIUM":
                return Usuario.Nivel.PREMIUM;
                
            case "VIP":
                return Usuario.Nivel.VIP;
                
            default:
                return Usuario.Nivel.REGULAR;
                
        }
    }

    public static Usuario[] copyOfRange(Usuario[] ogArray, int from, int to){
        Usuario[] newArray = new Usuario[to - from];
        int newIndex = 0;
        for (int i = from; i < to; i ++){
            newArray[newIndex] = ogArray[i];
            newIndex++;
        }
        return newArray;
    }

    public static void main(String[] args) {
        String rutaArchivo = "usuarios.txt"; // Ruta al archivo
        int totalUsuarios = contarUsuarios(rutaArchivo);
        
        // 1. Crear evento con cupo limitado

        Evento event = new Evento(CAPACIDAD_EVENTO);

        // 2. Cargar usuarios
        Usuario[] usuariosArray = cargarUsuariosDesdeArchivo(rutaArchivo, totalUsuarios); //Cargamos todos los usuarios al arreglo
        System.out.println("Todos los usuarios en orden de llegada: ");
        for(Usuario usuario: usuariosArray){
            System.out.println(usuario);
        }

        // 3. RESUELVE
        int algoritmo = 2;
        OrdenamientosCuadraticos.ordenar(algoritmo, usuariosArray);
        System.out.println("\nTodos los usuarios tras ordenar por prioridad: ");
        for(Usuario usuario: usuariosArray){
            System.out.println("\t" + usuario);
        }


        Usuario[] aceptados = copyOfRange(usuariosArray, 0, event.getLugaresDisponibles());
        Usuario[] noAceptados = copyOfRange(usuariosArray, event.getLugaresDisponibles(), usuariosArray.length);
        if (aceptados.length + noAceptados.length != usuariosArray.length){System.out.println("Total no coincide");}

        event.setUsuariosAceptados(aceptados);
        
        System.out.println("\nTodos los usuarios en el evento");
        for(Usuario usuario: event.getUsuariosAceptados()){
            System.out.println("\t" + usuario);
        }

        System.out.println("\nTodos los usuarios no aceptados: ");
        for(Usuario usuario: noAceptados){
            System.out.println("\t" + usuario);
        }

    }
}
