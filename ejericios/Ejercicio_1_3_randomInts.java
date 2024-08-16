
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

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
public class Ejercicio_1_3_randomInts {
    static final int CANTNUMEROS = 100;
    static final int MIN_VALOR = -100;
	static final int MAX_VALOR = 100;
    static final String NOMBRE_ARCHIVO = "src/ejemplo_InOut/numeros3.txt";

    private static void generarArchivo(){
    	try{
    		BufferedWriter buff = new BufferedWriter(new FileWriter(NOMBRE_ARCHIVO));
    		for (int i = 0; i < CANTNUMEROS ; i++){
    			double aleatorio = MIN_VALOR + (Math.random() * (MAX_VALOR - MIN_VALOR));
    			buff.write( aleatorio +"\n");
    			System.out.println(aleatorio);
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