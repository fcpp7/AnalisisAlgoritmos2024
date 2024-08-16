//import java.io.*
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

/* Ejercicio 1 del trabajo de repaso */

/**
 * Esta clase esta hecha para dar un primer ejemplo rapido de como funcionan
 * algunas clases provistas por Java para el manejo de entrada/salida desde archivos
 * de texto.
 *
 * En otras clases del mismo paquete veremos como generar archivos con caracteristicas
 * particulares, para generar conjuntos de valores random.
 */
public class Ejercicio_1_1_InOut {

    public static void main(String[] args) {
        String nombreArchivoEntrada = "src/ejemplo_InOut/entradaEj1_1.txt";
        String nombreArchivoSalida = "src/ejemplo_InOut/sinEspacios.txt";

        String linea = null;

        try {
            FileReader lectorArchivo = new FileReader(nombreArchivoEntrada);
            FileWriter escritorArchivo = new FileWriter(nombreArchivoSalida);

            BufferedReader bufferLectura = new BufferedReader(lectorArchivo);
            BufferedWriter bufferEscritura = new BufferedWriter(escritorArchivo);


            while ((linea = bufferLectura.readLine()) != null) {
                String lineaSinEspacios = linea.replaceAll("\\s+","");
                System.out.println(lineaSinEspacios);
                bufferEscritura.write(lineaSinEspacios +"\n");
            }

            bufferLectura.close();
            bufferEscritura.close();
        }
        catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage() + "\nSignifica que el archivo del "
                    + "que queriamos leer no existe.");
        }
        catch (IOException ex) {
            System.err.println("Error leyendo o escribiendo en algun archivo.");
        }
    }
}

