import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Persona {
    // Creamos las variables de clase Nombre y Apellido como private
    private String nombre;
    private String apellido;

    // Constructor con argumentos
    public Persona(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }


    // Método que ordena la lista por nombre manera ascendente
    public static void ordenarPorNombre(List<Persona> personasDeLaLista) {

        //  Con un sort ordenamos la lista pasada como argumento
        Collections.sort(personasDeLaLista, new Comparator<Persona>() {
            @Override
            public int compare(Persona p1, Persona p2) {
                return p1.getNombre().compareTo(p2.getNombre());
            }
        });

        // Por consola vamos a motrar los resultados ordenados
        System.out.println("\nOrdenado por Nombre: ");
        for(Persona persona : personasDeLaLista){
            System.out.println("• " + persona.getNombre() + ", " + persona.getApellido());
        }
    };

    // Método que ordena la lista por apellido
    public static void ordenarPorApellido(List<Persona> personasDeLaLista) {

        // Con un sort ordenamos la lista pasada como argumento
        Collections.sort(personasDeLaLista, new Comparator<Persona>() {
            @Override
            public int compare(Persona p1, Persona p2) {
                return p1.getApellido().compareTo(p2.getApellido());
            }
        });

        // Por consola vamos a motrar los resultados ordenados
        System.out.println("\nOrdenado por Apellido: ");
        for(Persona persona : personasDeLaLista){
            System.out.println("• " + persona.getApellido() + ", " + persona.getNombre());
        }
    };

    // Método que ordena la lista por Apellido inversamente
    public static void ordenarPorApellidoInversamente(List<Persona> personasDeLaLista) {

        // Con un sort ordenamos la lista pasada como argumento
        Collections.sort(personasDeLaLista, new Comparator<Persona>() {
            @Override
            public int compare(Persona p1, Persona p2) {
                return p2.getApellido().compareTo(p1.getApellido());
            }
        });

        // Por consola vamos a motrar los resultados ordenados
        System.out.println("\nOrdenado por Apellido inversamente: ");
        for(Persona persona : personasDeLaLista){
            System.out.println("• " + persona.getApellido() + ", " + persona.getNombre());
        }
    };
}
