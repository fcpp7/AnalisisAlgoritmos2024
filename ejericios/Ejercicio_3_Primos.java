import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


public class Ejercicio_3_Primos {

	public static boolean chequearPrimo(int numero){
		/* Iniciamos un boolean en true */
		boolean esPrimo = true; 
		if (numero <= 1){
			esPrimo = false;
		} else if (numero <= 3){
			esPrimo = true;
		} else if (numero % 2 == 0 || numero % 3 == 0){
			esPrimo = false;
		} else {        
	    int i = 5;
			while (i * i <= numero){
				if (numero % i == 0 || numero % (i + 2) == 0){
					esPrimo = false;
				}
				i += 6;
			}
		}

		return esPrimo;


	}



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingresar un número entero: ");
        int n = scanner.nextInt();
        
        int primos = 0;
        
        // Contamos los números primos entre 1 y n
        for (int i = 1; i <= n; i++) {
            if (chequearPrimo(i)) {
                primos++;
git p
            }
        }
        
        System.out.println("Entre 1 y " + n + " hay " + primos + " números primos");
        
        scanner.close();
    }
}