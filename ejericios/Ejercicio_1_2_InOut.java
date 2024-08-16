
//import java.io.*
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Esta clase esta hecha para dar un primer ejemplo rapido de como funcionan
 * algunas clases provistas por Java para el manejo de entrada/salida desde archivos
 * de texto.
 *
 * En otras clases del mismo paquete veremos como generar archivos con caracteristicas
 * particulares, para generar conjuntos de valores random.
 */
public class Ejercicio_1_2_InOut {

    public static void main(String[] args) {
        String nombreArchivoEntrada = "src/ejemplo_InOut/entradaEj1_1.txt";
        String nombreArchivoSalida = "src/ejemplo_InOut/lineasImpares.txt";

        String linea = null;

        try {
            FileReader lectorArchivo = new FileReader(nombreArchivoEntrada);
            FileWriter escritorArchivo = new FileWriter(nombreArchivoSalida);

            BufferedReader bufferLectura = new BufferedReader(lectorArchivo);
            BufferedWriter bufferEscritura = new BufferedWriter(escritorArchivo);

            /* Creamos un contador y chequeamos en cada paso si es impar se agrega la línea, y si es par NO */
            int esImpar = 1;

            while ((linea = bufferLectura.readLine()) != null) {
                if(esImpar % 2 == 1){
                    System.out.println(linea);
                    bufferEscritura.write(linea +"\n");
                } 
                esImpar++;
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

