import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Grafica {

    public void generarGrafica() {
        // Crear el eje X y el eje Y
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        
        // Crear el gráfico de barras
        final BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
        barChart.setTitle("Algoritmo de multiplicación de números grandes");
        xAxis.setLabel("Algoritmo");
        yAxis.setLabel("Tiempo Ejecucion");

        // Crear una serie de datos para el gráfico
        XYChart.Series<String, Number> series = new XYChart.Series<>();

        try {
            // Leer datos del archivo datos.txt
            BufferedReader br = new BufferedReader(new FileReader("datos.txt"));
            String line;

            // Leer cada línea del archivo y agregar los datos al gráfico
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String category = parts[0];
                double value = Double.parseDouble(parts[1]);
                series.getData().add(new XYChart.Data<>(category, value));
            }

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Agregar la serie de datos al gráfico
        barChart.getData().add(series);

        // Crear la escena y mostrar el gráfico en una ventana
        Scene scene = new Scene(barChart, 800, 600);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
}
