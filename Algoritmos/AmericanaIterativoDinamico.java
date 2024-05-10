package Algoritmos;
import java.math.BigInteger;
public class AmericanaIterativoDinamico {
    
    public static BigInteger multiplicacionAmericana(BigInteger multiplicando, BigInteger multiplicador) {
        // Convertir los números en cadenas para poder obtener la longitud de los dígitos
        String multiplicandoStr = multiplicando.toString();
        String multiplicadorStr = multiplicador.toString();
        
        // Calcular la longitud de los números
        int longitudMultiplicando = multiplicandoStr.length();
        int longitudMultiplicador = multiplicadorStr.length();
        
        // Crear un arreglo para almacenar los productos parciales
        int[][] productosParciales = new int[longitudMultiplicador][longitudMultiplicando + longitudMultiplicador];
        
        // Llenar la matriz con los productos parciales
        for (int i = longitudMultiplicador - 1; i >= 0; i--) {
            int digitoMultiplicador = multiplicadorStr.charAt(i) - '0';
            int carry = 0;
            
            for (int j = longitudMultiplicando - 1; j >= 0; j--) {
                int digitoMultiplicando = multiplicandoStr.charAt(j) - '0';
                int producto = (digitoMultiplicador * digitoMultiplicando) + carry;
                
                carry = producto / 10;
                producto %= 10;
                
                productosParciales[i][i + j + 1] = producto;
            }
            
            productosParciales[i][i] = carry;
        }
        
        // Sumar los productos parciales para obtener el resultado final
        int[] resultado = new int[longitudMultiplicando + longitudMultiplicador];
        int carry = 0;
        
        for (int j = longitudMultiplicando + longitudMultiplicador - 1; j >= 0; j--) {
            int suma = carry;
            for (int i = 0; i < longitudMultiplicador; i++) {
                suma += productosParciales[i][j];
            }
            
            carry = suma / 10;
            resultado[j] = suma % 10;
        }
        
        // Convertir el resultado en un BigInteger
        StringBuilder resultadoStr = new StringBuilder();
        for (int digit : resultado) {
            resultadoStr.append(digit);
        }
        
        return new BigInteger(resultadoStr.toString());
    }
}
