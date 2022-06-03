package práctica9ej3;
import java.util.Scanner;
//creamos la clase AppAnimal que contiene el main
public class AppAnimal {
public static void main(String[] args){
        //solicitamos por scanner el nombre del mamífero
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Qué animal es?");
        String animal = sc.nextLine();
        //solicitamos la alimentación que tiene el mamífero
        System.out.println("Indica que come el tigre: [carne, vegetales, ambos]");
        String respuesta = sc.nextLine();
        //creamos el objeto Mamífero m
        Mamífero m = new Mamífero(animal);
        //salida del método comer
        System.out.println(m.comer(respuesta));
        //salida del método segúnAlimento
        System.out.println(m.segúnAlimento(respuesta));
        //salida del método nacer
        System.out.println(m.nacer());
    }
}
//creamos la clase abstracta Animal
abstract class Animal {
    //atributo protegido
    protected String nombre;
    //método abstracto
    public abstract String comer(String alimento);
    //método abstracto
    public abstract String nacer();
}
//creamos la interface Alimentable
interface Alimentable {    
    String segúnAlimento(String alimento);
}
// creamos la clase Mamífero,hereda de Animal y implementa la interface Alimentable
class Mamífero extends Animal implements Alimentable {
    Mamífero(String nombre) {
        this.nombre = nombre;
    }
    @Override
    //método comer
    public String comer(String alimento) {
        return "El " + nombre + " come " + alimento + ".";
    }
    @Override
    //método nacer
    public String nacer() {
        return "Los mamíferos son vivíparos.";
    }
    @Override
    //método segúnAlimento al que se le pasa el string alimento
    public String segúnAlimento(String alimento) {
        String dieta;
        switch (alimento) {
            //En el caso de que introducir el caso uno nos devolverá "Es carnívoro"
            case "carne":
                dieta = "Es carnívoro.";
                break;
            //En el caso de que introducir el caso dos nos devolverá "Es herbívoro."
            case "vegetales":
                dieta = "Es herbívoro.";
                break;
            //En el caso de que introducir el caso tres nos devolverá "Es omnívoro."
            case "ambos":
                dieta = "Es omnívoro.";
                break;
            //Si la entrada no coincide con ningún caso mostrará que no se ha especificado
            default:
                dieta = "Alimento no especificado.";
                break;
        }
        //devuelve dieta
        return dieta;
    }
}
