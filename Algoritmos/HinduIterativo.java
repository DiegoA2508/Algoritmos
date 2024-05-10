package Algoritmos;
import java.math.BigInteger;

public class HinduIterativo {
    
    public static BigInteger multiply(BigInteger x, BigInteger y) {
        // Convierte los números a arreglos de dígitos
        int[] xArr = convertToDigitsArray(x);
        int[] yArr = convertToDigitsArray(y);

        // Obtiene la longitud de los arreglos
        int n = Math.max(xArr.length, yArr.length);

        // Rellena los arreglos con ceros a la izquierda para que tengan la misma longitud
        xArr = leftPadWithZeros(xArr, n);
        yArr = leftPadWithZeros(yArr, n);

        // Almacena los resultados parciales
        BigInteger result = BigInteger.ZERO;

        // Realiza la multiplicación iterativa
        for (int i = 0; i < n; i++) {
            // Obtiene el dígito de x en la posición i
            int digitX = xArr[i];

            // Realiza la multiplicación de x por el dígito de y en la posición i
            BigInteger partialResult = BigInteger.ZERO;
            for (int j = 0; j < n; j++) {
                int digitY = yArr[j];
                partialResult = partialResult.add(BigInteger.valueOf(digitX * digitY).multiply(BigInteger.TEN.pow(i + j)));
            }

            // Añade el resultado parcial al resultado final
            result = result.add(partialResult);
        }

        return result;
    }

    // Método para convertir un BigInteger en un arreglo de dígitos
    private static int[] convertToDigitsArray(BigInteger num) {
        String numStr = num.toString();
        int[] arr = new int[numStr.length()];
        for (int i = 0; i < numStr.length(); i++) {
            arr[i] = numStr.charAt(i) - '0';
        }
        return arr;
    }

    // Método para rellenar un arreglo con ceros a la izquierda hasta que tenga la longitud especificada
    private static int[] leftPadWithZeros(int[] arr, int length) {
        if (arr.length >= length) {
            return arr;
        }
        int[] paddedArr = new int[length];
        System.arraycopy(arr, 0, paddedArr, length - arr.length, arr.length);
        return paddedArr;
    }
}
