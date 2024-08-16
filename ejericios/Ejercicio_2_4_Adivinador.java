import java.util.Random;
import java.util.Scanner;


public class Ejercicio_2_4_Adivinador {
    static final int MAX_VALOR = 100;
    
    private static int generarAleatorio(){
        /* Se crea un aleatorio entre 1 y 100 */
        Random generador = new Random();
        int aleatorio = generador.nextInt(MAX_VALOR);
        return aleatorio;
        }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingresar un número para empezar (va a adivinar un número entre 1 y 100): ");
        int n = scanner.nextInt();

        int numeroAAdivinar = generarAleatorio();

        boolean acierto = false;
        while(!acierto){
            if(n==numeroAAdivinar){
                acierto = true;
                System.out.println("Acerto! El número era: "+ n);
            } else if(n > numeroAAdivinar){
                System.out.print("Ingresar un número menor: ");
                n = scanner.nextInt();
            } else {
                System.out.print("Ingresar un número mayor: ");
                n = scanner.nextInt();

            }

        }

    }


}
