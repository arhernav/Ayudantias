public class Circulo implements Figura {
    
    public double radio;
    public double PI = 3.1416;

    public Circulo(double radio) {
        this.radio = radio;
    }

    @Override
    public double calcularArea() {
        /*Aquí va tu código*/
    }

    @Override
    public double calcularPerimetro() {
        /*Aquí va tu código*/
    }

    public String toString(){
        return "El tipo de figura es: Círculo" + 
        "\n Su área es: " + this.calcularArea() + 
        "\n Y su perímetro es: " + this.calcularPerimetro();
    }
}