import java.math.BigInteger;
import java.util.Random;

public class DivideyVenceras {

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
    
    // Método para multiplicar dos BigIntegers utilizando el algoritmo de "divide y vencerás"
    public static BigInteger multiply(BigInteger x, BigInteger y) {
        int n = Math.max(x.bitLength(), y.bitLength());

        // Caso base: Si los números son pequeños, se usa la multiplicación convencional
        if (n <= 2000) {
            return x.multiply(y);
        }

        // Divide los números en mitades
        BigInteger[] halvesX = divideInHalf(x);
        BigInteger[] halvesY = divideInHalf(y);

        // Obtiene las mitades superiores e inferiores
        BigInteger xHigh = halvesX[0];
        BigInteger xLow = halvesX[1];
        BigInteger yHigh = halvesY[0];
        BigInteger yLow = halvesY[1];

        // Calcula las multiplicaciones recursivamente
        BigInteger z0 = multiply(xLow, yLow);
        BigInteger z1 = multiply(xLow.add(xHigh), yLow.add(yHigh));
        BigInteger z2 = multiply(xHigh, yHigh);

        // Calcula el resultado final combinando las soluciones parciales
        return z2.shiftLeft(n).add(z1.subtract(z2).subtract(z0).shiftLeft(n/2)).add(z0);
    }

    // Método para dividir un BigInteger en mitades
    private static BigInteger[] divideInHalf(BigInteger num) {
        int n = num.bitLength() / 2;
        BigInteger[] halves = new BigInteger[2];
        halves[0] = num.shiftRight(n);
        halves[1] = num.subtract(halves[0].shiftLeft(n));
        return halves;
    }

    public static void main(String[] args) {
        int longitudMultiplicando = 10000;
        int longitudMultiplicador = 10000;
        BigInteger x = generarNumeroAleatorio(longitudMultiplicando);
        BigInteger y = generarNumeroAleatorio(longitudMultiplicador);

        long startTime = System.currentTimeMillis();
        multiply(x, y);
        long endTime = System.currentTimeMillis();

        //System.out.println("Resultado de la multiplicación: " + multiply(x, y));
        System.out.println("El tiempo de ejecucion es: " +(endTime-startTime));
    }
}
