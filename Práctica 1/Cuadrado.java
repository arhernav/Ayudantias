public class Cuadrado extends PoligonoRegular {
    private static final int LADOS = 4;
    private static final String TIPOFIGURA = "Cuadrado";

    public Cuadrado(double longitudLado) {
        super(LADOS, longitudLado, TIPOFIGURA);
    }

    /* Calcula y devulve el area del cuadrado 
    * @return double - Area del cuadrado
    */
    @Override
    public double calcularArea() {
        return Math.pow(super.longitudLado, 2);
    }
}