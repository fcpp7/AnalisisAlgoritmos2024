
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

/**
 * Este otro ejemplo esta para mostrar como generar 10000 valores enteros, menores
 * a 1,000,000 de forma aleatoria, y los guardar en un archivo, de a uno por linea.
 *
 * https://docs.oracle.com/javase/7/docs/api/java/util/Random.html
 *
 * Otro enfoque es usar math.random() que les devuelve un double entre 0 y 1, y luego
 * "desnormalizar" los datos hacia el rango que les interese.
 * Ejemplo para generar doubles entre 5 y 10.
 * int techo = 10; int piso = 5;
 * double aleatorio = piso + (Math.random() * (techo - piso));
 *
 */
public class Ejercicio_1_5 {
    static final int CANTNUMEROS = 1000;
	static final int MAX_VALOR = 1000;
    static final String NOMBRE_ARCHIVO = "src/ejemplo_InOut/numeros5.txt";

    private static void generarArchivo(){
    	try{
    		BufferedWriter buff = new BufferedWriter(new FileWriter(NOMBRE_ARCHIVO));
    		Random generador = new Random();


			/* Creamos una lista de numeros que contiene los valores que ya salieron */
			List<Integer> numeros = new ArrayList<>();

    		for (int i = 0; i < CANTNUMEROS ; i++){
    			int num = generador.nextInt(MAX_VALOR);

				/* Chequea los casos en los que el número ya salio y en ese caso no lo considera, en su lugar imprime un mensaje por pantalla */
				/* Si se desea que esten todos los números hasta del 1 al 1000, se podría cambiar el for por un while y dejar que corrar hasta que la 
				 * lista tenga 1000 valores de longitud
				 */
				if(!numeros.contains(num)){
					buff.write( num +"\n");
					System.out.println(num);
					numeros.add(num);
				} else {
					System.out.println("El valor " + num + " esta repetido");
				}
    		}
    		buff.close();

    	}
    	catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage() + "\nSignifica que el archivo del "
                    + "que queriamos leer no existe.");
        }
        catch (IOException ex) {
            System.err.println("Error leyendo o escribiendo en algun archivo.");
        }
    }



    public static void main(String[] args) {
    	/** Como nos interesa medir la eficiencia de nuestros algoritmos, realizaremos mediciones
    	 * de eficiencia de los metodos que nos interese, partiendo del supuesto de que tenemos
    	 * datos cargados en memoria, para suprimir el sesgo que nos traeria la E/S (por más que
    	 * sea lineal, involucra operaciones muy lentas, y que varian muchisimo de un sistema a
    	 * otro.
    	 *
    	 * Podemos ver como varia el tiempo de ejecución nuestro algoritmo en función del tamaño
    	 * de entrada.
    	 */
    	generarArchivo(); //Una vez que ya tenemos un archivo generado, no hace falta generar uno nuevo.
    	long inicio = System.nanoTime(); // Tomamos la hora del sistema en nanosegundos

    	long fin = System.nanoTime();
    	System.out.println("Se tardo: " + (fin - inicio) + "nanosegundos en generar 100 números aleatorios entre -100 y 100");
    }
}