package numeroFlotante;

public class NumeroFlotanteCiprian {
  public static void main(String[] args) {
    // Almaceno el número en una variable del tipo float
    float floatNumber = 10.8f;

    // Extraigo la parte entera de la variable floatNumber
    int integerNumber = (int) floatNumber;

    // Extraigo la parte decimal de la variable floatNumber
    float decimalNumber = floatNumber - integerNumber;

    // Número almacenado.
    System.out.println("El número float es: " + floatNumber);

    // Parte entera del número almacenado.
    System.out.println("La parte entera del número float es: " + integerNumber);

    // Parte decimal del número almacenado.
    System.out.println("La parte decimal del número float es: " + decimalNumber);
  }

}