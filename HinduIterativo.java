import java.math.BigInteger;
import java.util.Random;

public class HinduIterativo {

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
    
    public static BigInteger multiply(BigInteger x, BigInteger y) {
        // Convierte los números a cadenas para facilitar la manipulación
        String xStr = x.toString();
        String yStr = y.toString();

        // Obtiene la longitud de las cadenas
        int n = Math.max(xStr.length(), yStr.length());

        // Rellena las cadenas con ceros a la izquierda para que tengan la misma longitud
        xStr = leftPadWithZeros(xStr, n);
        yStr = leftPadWithZeros(yStr, n);

        // Almacena los resultados parciales
        BigInteger result = BigInteger.ZERO;

        // Realiza la multiplicación iterativa
        for (int i = 0; i < n; i++) {
            // Obtiene el dígito de x en la posición i
            int digitX = xStr.charAt(i) - '0';

            // Realiza la multiplicación de x por el dígito de y en la posición i
            BigInteger partialResult = BigInteger.ZERO;
            for (int j = 0; j < n; j++) {
                int digitY = yStr.charAt(j) - '0';
                partialResult = partialResult.add(BigInteger.valueOf(digitX * digitY).multiply(BigInteger.TEN.pow(i + j)));
            }

            // Añade el resultado parcial al resultado final
            result = result.add(partialResult);
        }

        return result;
    }

    // Método para rellenar una cadena con ceros a la izquierda hasta que tenga la longitud especificada
    private static String leftPadWithZeros(String str, int length) {
        StringBuilder paddedStr = new StringBuilder(str);
        while (paddedStr.length() < length) {
            paddedStr.insert(0, '0');
        }
        return paddedStr.toString();
    }

    public static void main(String[] args) {
        int longitudMultiplicando = 50000;
        int longitudMultiplicador = 50000;
        BigInteger x = generarNumeroAleatorio(longitudMultiplicando);
        BigInteger y = generarNumeroAleatorio(longitudMultiplicador);

        long startTime = System.currentTimeMillis();
        multiply(x, y);
        long endTime = System.currentTimeMillis();

        //System.out.println("Resultado de la multiplicación: " + multiply(x, y));
        System.out.println("El tiempo de ejecucion es: " +(endTime-startTime));
    }
}