public class Pentagono extends PoligonoRegular {
    
    private static final int LADOS = 5;
    private static final String TIPOFIGURA = "Pentagono";

    public double PI = 3.1416;

    public Pentagono(double longitudLado) {
        super(LADOS, longitudLado, TIPOFIGURA);
    }

    /* Calcula y devulve el area del pentagono 
    * @return double - Area del pentagono
    */
    @Override
    public double calcularArea() {
        double apotema = this.calcularApotema();
        return (5 * this.longitudLado * apotema) / 2;
    }


    /* Calcula y devulve el area del pentagono 
    * Ya que es pentagno regular tenemos que el apotema siempre es LongitudLado / 1.45
    * @return double - Area del pentagono
    */
    public double calcularApotema(){
        return this.longitudLado / 1.45; 
    }

}