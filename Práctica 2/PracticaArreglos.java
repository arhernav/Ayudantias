import java.util.HashMap;
public class PracticaArreglos{
	
	public static String imprimeArreglo(Object[] arreglo){
		String representacion = "";
		for (int i = 0; i < arreglo.length; i++){
			representacion = representacion + arreglo[i].toString() + ", ";
		}
		return String.format("[ %s]", representacion);
	}

	public static String imprimeArreglo(int[] arreglo){
		String representacion = "";
		for (int i = 0; i < arreglo.length; i++){
			representacion = representacion + arreglo[i] + ", ";
		}
		return String.format("[ %s]", representacion);
	}

	public static String imprimeArreglo(double[] arreglo){
		String representacion = "";
		for (int i = 0; i < arreglo.length; i++){
			representacion = representacion + arreglo[i] + ", ";
		}
		return String.format("[ %s]", representacion);
	}

	public static int[] reversaArreglo(int[] arreglo){
		int[] newArray = new int[arreglo.length];
		int index = arreglo.length -1;
		for (int i = 0; i < arreglo.length; i++){
			newArray[i] = arreglo[index - i];
		}
		return newArray;
	} 

	public static double[] guardarAreas(Figura[] figuras){
		double[] areas = new double[figuras.length];
		for (int i = 0; i < figuras.length; i ++){
			areas[i] = figuras[i].calcularArea();
		}
		return areas;
	}

	public static Persona[] crearPersonas(String[] nombres, int[] edades){
		Persona[] personas = new Persona[nombres.length];
		for (int i = 0; i < nombres.length; i ++){
			personas[i] = new Persona(nombres[i], edades[i]);
		}
		return personas;
	}

	public static int[] combinarArreglos(int[] arreglo1, int[] arreglo2){
		int newLength = arreglo1.length + arreglo2.length;
		int[] newArray = new int[newLength];
		for (int i = 0; i < arreglo1.length;  i++) {
			newArray[i] = arreglo1[i];
		}
		for (int i = 0; i < arreglo2.length;  i++) {
			newArray[i + arreglo1.length] = arreglo2[i];
		}
		return newArray;
	}

	/*Punto extra*/
	public static Object[] eliminarDuplicados(Object[] arreglo) {
		HashMap<Object, Object> hashMap = new HashMap<>();
		Object[] newArray = new Object[arreglo.length];
		for(int i = 0; i < arreglo.length; i ++){
			hashMap.put(arreglo[i], arreglo[i]);
		}
		return hashMap.keySet().toArray();
	}
}
