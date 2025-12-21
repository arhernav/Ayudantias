public class TrianguloEquilatero extends PoligonoRegular {
    private static final int LADOS = 3;
    private static final String TIPOFIGURA = "Triángulo equilátero";

    public TrianguloEquilatero (double longitudLado) {
        super(LADOS, longitudLado, TIPOFIGURA);
    }

    /* Calulca el area de un traingulo en base a sus lados. 
    * Usa A = (sqr(3) / 4) *  longitudLado 
    * @return double - Area del triangulo
    */
    @Override
    public double calcularArea() {
        return Math.pow(longitudLado, 2) *  (Math.sqrt(3) / 4);
    }
}