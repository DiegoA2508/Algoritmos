package Algoritmos;
import java.math.BigInteger;

public class DivideyVenceras {
    
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
}
