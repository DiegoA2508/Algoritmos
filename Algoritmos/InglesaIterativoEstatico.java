import java.math.BigInteger;
import java.util.Random;

public class InglesaIterativoEstatico {

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
    
    public static BigInteger multiplicacionInglesa(BigInteger multiplicando, BigInteger multiplicador) {
        // Convertir los números en cadenas para poder obtener la longitud de los dígitos
        String multiplicandoStr = multiplicando.toString();
        String multiplicadorStr = multiplicador.toString();
        
        // Calcular la longitud de los números
        int longitudMultiplicando = multiplicandoStr.length();
        int longitudMultiplicador = multiplicadorStr.length();
        
        // Crear una matriz para almacenar los productos parciales
        int[][] productosParciales = new int[longitudMultiplicador][longitudMultiplicando + longitudMultiplicador];
        
        // Llenar la matriz con los productos parciales
        for (int i = longitudMultiplicador - 1; i >= 0; i--) {
            int digitoMultiplicador = multiplicadorStr.charAt(i) - '0';
            int carry = 0;
            
            for (int j = longitudMultiplicando - 1; j >= 0; j--) {
                int digitoMultiplicando = multiplicandoStr.charAt(j) - '0';
                int producto = digitoMultiplicador * digitoMultiplicando + carry;
                
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
        
        // Convertir el resultado en una cadena de dígitos
        StringBuilder resultadoStr = new StringBuilder();
        for (int digit : resultado) {
            resultadoStr.append(digit);
        }
        
        // Convertir la cadena de dígitos en un BigInteger
        return new BigInteger(resultadoStr.toString());
    }
    
    public static void main(String[] args) {
        // Generar números aleatorios para la multiplicación
        int longitudMultiplicando = 1000000;  // Ajusta la longitud según tus necesidades
        int longitudMultiplicador = 40; // Ajusta la longitud según tus necesidades
        
        BigInteger multiplicando = generarNumeroAleatorio(longitudMultiplicando);
        BigInteger multiplicador = generarNumeroAleatorio(longitudMultiplicador);
        
        System.out.println("Multiplicando: " + multiplicando);
        System.out.println("Multiplicador: " + multiplicador);
        
        // Realizar la multiplicación
        long startTime = System.currentTimeMillis();
        multiplicacionInglesa(multiplicando, multiplicador);
        long endTime = System.currentTimeMillis();

        //System.out.println("Resultado: " + resultado);
        System.out.println("El tiempo de ejecucion es: " +(endTime-startTime));
    }
}
