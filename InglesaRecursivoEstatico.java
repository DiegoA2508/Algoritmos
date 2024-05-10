import java.math.BigInteger;
import java.util.Random;

public class InglesaRecursivoEstatico {

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
        
        // Llamar a la función auxiliar recursiva para realizar la multiplicación
        return multiplicacionInglesaRecursiva(multiplicandoStr, multiplicadorStr, longitudMultiplicando, longitudMultiplicador);
    }
    
    private static BigInteger multiplicacionInglesaRecursiva(String multiplicando, String multiplicador, int longitudMultiplicando, int longitudMultiplicador) {
        // Caso base: si uno de los números tiene una sola cifra, multiplicar y devolver el resultado
        if (longitudMultiplicando == 1 || longitudMultiplicador == 1) {
            BigInteger a = new BigInteger(multiplicando);
            BigInteger b = new BigInteger(multiplicador);
            return a.multiply(b);
        }
        
        // Calcular el tamaño del nuevo número y dividirlos en mitades
        int mitadMultiplicando = longitudMultiplicando / 2;
        int mitadMultiplicador = longitudMultiplicador / 2;
        
        // Extraer las partes superiores e inferiores de los números
        String a = multiplicando.substring(0, mitadMultiplicando);
        String b = multiplicando.substring(mitadMultiplicando);
        String c = multiplicador.substring(0, mitadMultiplicador);
        String d = multiplicador.substring(mitadMultiplicador);
        
        // Calcular las multiplicaciones recursivamente
        BigInteger ac = multiplicacionInglesaRecursiva(a, c, mitadMultiplicando, mitadMultiplicador);
        BigInteger bd = multiplicacionInglesaRecursiva(b, d, longitudMultiplicando - mitadMultiplicando, longitudMultiplicador - mitadMultiplicador);
        BigInteger ad_bc = multiplicacionInglesaRecursiva(sumar(a, b), sumar(c, d), Math.max(mitadMultiplicando, longitudMultiplicando - mitadMultiplicando), Math.max(mitadMultiplicador, longitudMultiplicador - mitadMultiplicador)).subtract(ac).subtract(bd);
        
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
    
    public static void main(String[] args) {
        int longitudMultiplicando = 32500;
        int longitudMultiplicador = 32500;

        BigInteger multiplicando = generarNumeroAleatorio(longitudMultiplicando);
        BigInteger multiplicador = generarNumeroAleatorio(longitudMultiplicador);

        //System.out.println("Multiplicando: " + multiplicando);
        //System.out.println("Multiplicador: " + multiplicador);
        
        long startTime = System.currentTimeMillis();
        multiplicacionInglesa(multiplicando, multiplicador);
        long endTime = System.currentTimeMillis();
       
        //System.out.println("Resultado: " + resultado);
        System.out.println("El tiempo de ejecucion con " + longitudMultiplicador + " es: " +(endTime-startTime) + " ms ");
    }
}

