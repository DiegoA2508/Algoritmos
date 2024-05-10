import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Random;

import javax.swing.*;

import Algoritmos.AmericanaIterativoDinamico;
import Algoritmos.AmericanaIterativoEstatico;
import Algoritmos.AmericanaRecursivo;
import Algoritmos.AmericanaRecursivoDinamico;
import Algoritmos.DivideyVenceras;
import Algoritmos.HinduIterativo;
import Algoritmos.InglesaIterativoDinamico;
import Algoritmos.InglesaIterativoEstatico;
import Algoritmos.InglesaRecursivoEstatico;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

public class Aplicacion extends Application {
    
    static int longitudMultiplicando = 5000; // Ajusta la longitud según tus necesidades
    static int longitudMultiplicador = 5000; // Ajusta la longitud según tus necesidades

    static BigInteger multiplicando = generarNumeroAleatorio(longitudMultiplicando);
    static BigInteger multiplicador = generarNumeroAleatorio(longitudMultiplicador);

    public static void main(String[] args) {
        showMenu(null);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Platform.runLater(() -> showMenu(primaryStage));
    }

    public static void showMenu(Stage primaryStage) {
        String[] options = {"Americana iterativo (estático)",
                        "Americana iterativo (dinámico)",
                        "Americana recursivo (estático)",
                        "Americana recursivo (dinámico)",
                        "Inglesa iterativo (estático)",
                        "Inglesa iterativo (dinámico)",
                        "Inglesa recursivo (estático)",
                        "Inglesa recursivo (dinámico)",
                        "Hindú iterativo (estático)",
                        "Divide y vencerás 1 (estático)",
                        "Gráfica",
                        "Salir"};

        String choice = (String) JOptionPane.showInputDialog(
                null,
                "Selecciona el algoritmo a probar",
                "Menú",
                JOptionPane.PLAIN_MESSAGE,
                null,
                options,
                options[0]);

        if (choice != null) {
            switch (choice) {
                case "Americana iterativo (estático)":
                    long startTime = System.currentTimeMillis();
                    AmericanaIterativoEstatico.multiplicacionAmericana(multiplicando, multiplicador);
                    long endTime = System.currentTimeMillis();
                    long tiempoEjecucion = (endTime-startTime);
                    JOptionPane.showMessageDialog(null, "El tiempo de ejecucion con " + longitudMultiplicador + " numeros es: " +(endTime-startTime) + " ms");
                    guardarEnArchivo(choice, longitudMultiplicador, tiempoEjecucion);
                    break;
                case "Americana iterativo (dinámico)":
                    startTime = System.currentTimeMillis();
                    AmericanaIterativoDinamico.multiplicacionAmericana(multiplicando, multiplicador);
                    endTime = System.currentTimeMillis();
                    tiempoEjecucion = (endTime-startTime);
                    JOptionPane.showMessageDialog(null, "El tiempo de ejecucion con " + longitudMultiplicador + " numeros es: " +(endTime-startTime) + " ms");
                    guardarEnArchivo(choice, longitudMultiplicador, tiempoEjecucion);break;
                case "Americana recursivo (estático)":
                    startTime = System.currentTimeMillis();
                    AmericanaRecursivo.multiplicacionAmericana(multiplicando, multiplicador);
                    endTime = System.currentTimeMillis();
                    tiempoEjecucion = (endTime-startTime);
                    JOptionPane.showMessageDialog(null, "El tiempo de ejecucion con " + longitudMultiplicador + " numeros es: " +(endTime-startTime) + " ms");
                    guardarEnArchivo(choice, longitudMultiplicador, tiempoEjecucion);
                    break;
                case "Americana recursivo (dinámico)":
                    startTime = System.currentTimeMillis();
                    AmericanaRecursivoDinamico.multiplicacionAmericana(multiplicando, multiplicador);
                    endTime = System.currentTimeMillis();
                    tiempoEjecucion = (endTime-startTime);
                    JOptionPane.showMessageDialog(null, "El tiempo de ejecucion con " + longitudMultiplicador + " numeros es: " +(endTime-startTime) + " ms");
                    guardarEnArchivo(choice, longitudMultiplicador, tiempoEjecucion);
                    break;
                case "Inglesa iterativo (estático)":
                    startTime = System.currentTimeMillis();
                    InglesaIterativoEstatico.multiplicacionInglesa(multiplicando, multiplicador);
                    endTime = System.currentTimeMillis();
                    tiempoEjecucion = (endTime-startTime);
                    JOptionPane.showMessageDialog(null, "El tiempo de ejecucion con " + longitudMultiplicador + " numeros es: " +(endTime-startTime) + " ms");
                    guardarEnArchivo(choice, longitudMultiplicador, tiempoEjecucion);
                    break;
                case "Inglesa iterativo (dinámico)":
                    startTime = System.currentTimeMillis();
                    InglesaIterativoDinamico.multiplicacionInglesa(multiplicando, multiplicador);
                    endTime = System.currentTimeMillis();
                    tiempoEjecucion = (endTime-startTime);
                    JOptionPane.showMessageDialog(null, "El tiempo de ejecucion con " + longitudMultiplicador + " numeros es: " +(endTime-startTime) + " ms");
                    guardarEnArchivo(choice, longitudMultiplicador, tiempoEjecucion);
                    break;
                case "Inglesa recursivo (estático)":
                    startTime = System.currentTimeMillis();
                    InglesaRecursivoEstatico.multiplicacionInglesa(multiplicando, multiplicador);
                    endTime = System.currentTimeMillis();
                    tiempoEjecucion = (endTime-startTime);
                    JOptionPane.showMessageDialog(null, "El tiempo de ejecucion con " + longitudMultiplicador + " numeros es: " +(endTime-startTime) + " ms");
                    guardarEnArchivo(choice, longitudMultiplicador, tiempoEjecucion);
                    break;
                case "Inglesa recursivo (dinámico)":
                    startTime = System.currentTimeMillis();
                    InglesaIterativoDinamico.multiplicacionInglesa(multiplicando, multiplicador);
                    endTime = System.currentTimeMillis();
                    tiempoEjecucion = (endTime-startTime);
                    JOptionPane.showMessageDialog(null, "El tiempo de ejecucion con " + longitudMultiplicador + " numeros es: " +(endTime-startTime) + " ms");
                    guardarEnArchivo(choice, longitudMultiplicador, tiempoEjecucion);
                    break;
                case "Hindú iterativo (estático)":
                    startTime = System.currentTimeMillis();
                    HinduIterativo.multiply(multiplicando, multiplicador);
                    endTime = System.currentTimeMillis();
                    tiempoEjecucion = (endTime-startTime);
                    JOptionPane.showMessageDialog(null, "El tiempo de ejecucion con " + longitudMultiplicador + " numeros es: " +(endTime-startTime) + " ms");
                    guardarEnArchivo(choice, longitudMultiplicador, tiempoEjecucion);
                    break;
                case "Divide y vencerás (estático)":
                    startTime = System.currentTimeMillis();
                    DivideyVenceras.multiply(multiplicando, multiplicador);
                    endTime = System.currentTimeMillis();
                    tiempoEjecucion = (endTime-startTime);
                    JOptionPane.showMessageDialog(null, "El tiempo de ejecucion con " + longitudMultiplicador + " numeros es: " +(endTime-startTime) + " ms");
                    guardarEnArchivo(choice, longitudMultiplicador, tiempoEjecucion);
                    break;
                case "Gráfica":
                    Platform.runLater(() -> {
                    Grafica grafica = new Grafica();
                    grafica.generarGrafica();
                });
                    break;
                case "Salir":
                    JOptionPane.showMessageDialog(null, "Saliendo del programa...");
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida");
            }
        }
    }
    public static BigInteger generarNumeroAleatorio(int longitud) {
        Random random = new Random();
        StringBuilder numeroAleatorioStr = new StringBuilder();
        // Asegurarse de que el primer dígito no sea cero
        numeroAleatorioStr.append(random.nextInt(9) + 1);
        for (int i = 1; i < longitud; i++) {
            numeroAleatorioStr.append(random.nextInt(10)); // Números del 0 al 9
        }
        return new BigInteger(numeroAleatorioStr.toString());
    }

    public static void guardarEnArchivo(String algoritmo, int longitudMultiplicador, long tiempoEjecucion) {
        String fileName = "tiempos_de_ejecucion.txt";
        try {
            FileWriter writer = new FileWriter(fileName, true);
            writer.write("Algoritmo: " + algoritmo + ", Longitud del multiplicador: " + longitudMultiplicador
                    + ", Tiempo de ejecucion: " + tiempoEjecucion + "ms\n");
            writer.close();
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
}
