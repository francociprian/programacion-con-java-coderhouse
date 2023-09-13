import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Creamos las 5 personas
        Persona persona1 = new Persona("Luis","Ciprian");
        Persona persona2 = new Persona("María","Rodríguez");
        Persona persona3 = new Persona("Carlos","González");
        Persona persona4 = new Persona("Ana","Morales");
        Persona persona5 = new Persona("Luis","Fernández");

        // Guardamos las 5 personas en el ArrayList
        ArrayList<Persona> listaDePersonas = new ArrayList<>();

        // Agregamos las 5 personas al ArrayList "listaDePersonas"
        listaDePersonas.add(persona1);
        listaDePersonas.add(persona2);
        listaDePersonas.add(persona3);
        listaDePersonas.add(persona4);
        listaDePersonas.add(persona5);

        // Llamando a la función para ordenar por Nombre
        Persona.ordenarPorNombre(listaDePersonas);

        // Llamando a la función para ordenar por Apellido
        Persona.ordenarPorApellido(listaDePersonas);

        // Llamando a la función para ordenar por Apellido inversamente
        Persona.ordenarPorApellidoInversamente(listaDePersonas);
    }
}