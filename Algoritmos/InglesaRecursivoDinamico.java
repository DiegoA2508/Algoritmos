package Algoritmos;
import java.math.BigInteger;

public class InglesaRecursivoDinamico {
    
    public static BigInteger multiplicacionInglesa(BigInteger multiplicando, BigInteger multiplicador) {
        // Convertir los números en cadenas para poder obtener la longitud de los dígitos
        String multiplicandoStr = multiplicando.toString();
        String multiplicadorStr = multiplicador.toString();
        
        // Llamar a la función auxiliar recursiva para realizar la multiplicación
        return multiplicacionInglesaRecursiva(multiplicandoStr, multiplicadorStr);
    }
    
    private static BigInteger multiplicacionInglesaRecursiva(String multiplicando, String multiplicador) {
        // Caso base: si uno de los números tiene una sola cifra, multiplicar y devolver el resultado
        if (multiplicando.length() == 1 || multiplicador.length() == 1) {
            BigInteger a = new BigInteger(multiplicando);
            BigInteger b = new BigInteger(multiplicador);
            return a.multiply(b);
        }
        
        // Calcular el tamaño del nuevo número y dividirlos en mitades
        int longitudMultiplicando = multiplicando.length();
        int longitudMultiplicador = multiplicador.length();
        int mitadMultiplicando = longitudMultiplicando / 2;
        int mitadMultiplicador = longitudMultiplicador / 2;
        
        // Extraer las partes superiores e inferiores de los números
        String a = multiplicando.substring(0, mitadMultiplicando);
        String b = multiplicando.substring(mitadMultiplicando);
        String c = multiplicador.substring(0, mitadMultiplicador);
        String d = multiplicador.substring(mitadMultiplicador);
        
        // Calcular las multiplicaciones recursivamente
        BigInteger ac = multiplicacionInglesaRecursiva(a, c);
        BigInteger bd = multiplicacionInglesaRecursiva(b, d);
        BigInteger ad_bc = multiplicacionInglesaRecursiva(sumar(a, b), sumar(c, d)).subtract(ac).subtract(bd);
        
        // Calcular el resultado final utilizando la fórmula adecuada
        return ac.multiply(BigInteger.TEN.pow(longitudMultiplicando)).add(ad_bc.multiply(BigInteger.TEN.pow(mitadMultiplicando))).add(bd);
    }
    
    // Función para sumar dos números representados como cadenas
    private static String sumar(String num1, String num2) {
        int carry = 0;
        StringBuilder suma = new StringBuilder();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        
        while (i >= 0 || j >= 0 || carry != 0) {
            int digito1 = (i >= 0) ? num1.charAt(i--) - '0' : 0;
            int digito2 = (j >= 0) ? num2.charAt(j--) - '0' : 0;
            int sum = digito1 + digito2 + carry;
            carry = sum / 10;
            suma.insert(0, sum % 10);
        }
        
        return suma.toString();
    }
}
