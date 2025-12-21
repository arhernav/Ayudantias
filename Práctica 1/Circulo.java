public class Circulo implements Figura {
    
    public double radio;
    public double PI = 3.1416;

    public Circulo(double radio) {
        this.radio = radio;
    }

    /* Calcula y devulve el area del circulo 
    * @return double - Area del circulo
    */
    @Override
    public double calcularArea() {
        return this.PI * Math.pow(radio, 2);
    }

    /* Calcula y devulve el perimetro del circulo 
    * @return double - Perimetro del circulo
    */
    @Override
    public double calcularPerimetro() {
        return this.PI * radio * 2;
    }

    public String toString(){
        return "El tipo de figura es: Círculo" + 
        "\n Su área es: " + this.calcularArea() + 
        "\n Y su perímetro es: " + this.calcularPerimetro();
    }
}