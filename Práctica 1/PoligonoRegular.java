public abstract class PoligonoRegular implements Figura{
    protected int numeroLados;
    protected double longitudLado;
    protected String tipoFigura;

    public PoligonoRegular(int numeroLados, double longitudLado, String tipoFigura) {
        this.numeroLados = numeroLados;
        this.longitudLado = longitudLado;
        this.tipoFigura = tipoFigura;
    }

    /* Calcula y devulve el perimetro del poligono 
    * @return double - Area del poligono
    */
    public double calcularPerimetro() {
        return numeroLados * longitudLado;
    }

    public abstract double calcularArea();


    public String toString(){
        return "El tipo de figura es: " + this.tipoFigura + 
        "\n Su área es: " + this.calcularArea() + 
        "\n Y su perímetro es: " + this.calcularPerimetro();
    }
}