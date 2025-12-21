public class MainArreglos{
	
	public static void main(String[] args){

		/*
			Probando reversa
		*/
		int[] arreglo1 = {1,2,3,4,5,6,7};
		int[] revArreglo1 = PracticaArreglos.reversaArreglo(arreglo1);

		System.out.println("Este es el arreglo original: \n" + PracticaArreglos.imprimeArreglo(arreglo1));
		System.out.println("Y este es su arreglo reversa:");
		System.out.println(PracticaArreglos.imprimeArreglo(revArreglo1));
		System.out.println("\n"); 

		/*
			Probando arreglo de areas
		*/
		Figura triangulo = new TrianguloEquilatero(10.0);
		Figura cuadrado = new Cuadrado(10.0);
		Figura pentagono = new Pentagono(10.0);
		Figura circulo = new Circulo(10.0);

		Figura[] figuras = {triangulo,cuadrado,pentagono,circulo};
		double[] areas = PracticaArreglos.guardarAreas(figuras);
		System.out.println("Este es el arreglo original: \n" + PracticaArreglos.imprimeArreglo(figuras));
		System.out.println("Y este es su arreglo de areas");
		System.out.println(PracticaArreglos.imprimeArreglo(areas));
		System.out.println("\n");

		/*
			Probando Crear Personas
		*/
		int[] edades = {20,18,37,52,90};
		String[] nombres = {"Pepe", "Arturo", "Lupe", "Alejandra", "El compa Chuy"};
		Persona[] personas = PracticaArreglos.crearPersonas(nombres,edades);
		System.out.println("Estos son los arreglos originales: \n" + "Edades: " + PracticaArreglos.imprimeArreglo(edades));
		System.out.println("Personas: " + PracticaArreglos.imprimeArreglo(nombres));
		System.out.println("Y este es el arreglo de Personas");
		System.out.println(PracticaArreglos.imprimeArreglo(personas));
		System.out.println("\n");

		/*
			Probando combinar arreglos
		*/
		int[] numeros = {20,52,1,3,7,9,10,37};
		int[] fusion = PracticaArreglos.combinarArreglos(numeros,edades);
		System.out.println("Estos son los arreglos originales: \n" + "Edades: " + PracticaArreglos.imprimeArreglo(edades));
		System.out.println("numeros: " + PracticaArreglos.imprimeArreglo(numeros));
		System.out.println("Y este es el arreglo de Personas");
		System.out.println(PracticaArreglos.imprimeArreglo(fusion));
		System.out.println("\n");

	}
}