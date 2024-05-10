import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Grafica {

    public void generarGrafica() {
        // Crear el eje X y el eje Y
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();

        // Crear el gráfico de barras
        final BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
        barChart.setTitle("Algoritmo de multiplicación de números grandes");
        xAxis.setLabel("Algoritmo");
        yAxis.setLabel("Tiempo Ejecucion (seg)");

        // Crear una serie de datos para el gráfico
        XYChart.Series<String, Number> series = new XYChart.Series<>();

        List<DataEntry> dataEntries = new ArrayList<>();

        try {
            // Leer datos del archivo datos.txt
            BufferedReader br = new BufferedReader(new FileReader("datos.txt"));
            String line;

            // Leer cada línea del archivo y agregar los datos a la lista
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String category = parts[0];
                double value = Double.parseDouble(parts[1]);
                dataEntries.add(new DataEntry(category, value));
            }

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Ordenar la lista de datos por el tiempo de ejecución en orden creciente
        Collections.sort(dataEntries, Comparator.comparingDouble(DataEntry::getValue));

        // Agregar los datos ordenados al gráfico
        for (DataEntry entry : dataEntries) {
            series.getData().add(new XYChart.Data<>(entry.getCategory(), entry.getValue()));
        }

        // Agregar la serie de datos al gráfico
        barChart.getData().add(series);

        // Crear la escena y mostrar el gráfico en una ventana
        Scene scene = new Scene(barChart, 800, 600);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    // Clase auxiliar para almacenar los datos del archivo
    private static class DataEntry {
        private String category;
        private double value;

        public DataEntry(String category, double value) {
            this.category = category;
            this.value = value;
        }

        public String getCategory() {
            return category;
        }

        public double getValue() {
            return value;
        }
    }
}
