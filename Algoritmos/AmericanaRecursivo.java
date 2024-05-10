    package Algoritmos;
    import java.math.BigInteger;

    public class AmericanaRecursivo {
        
        // Método público para iniciar la multiplicación americana
        public static BigInteger multiplicacionAmericana(BigInteger multiplicando, BigInteger multiplicador) {
            // Llama al método recursivo con los parámetros iniciales
            return multiplicacionAmericanaRecursive(multiplicando, multiplicador);
        }

    // Método privado que realiza la multiplicación americana de forma recursiva
    private static BigInteger multiplicacionAmericanaRecursive(BigInteger multiplicando, BigInteger multiplicador) {
        // Convertir los números en cadenas para poder obtener la longitud de los dígitos
        String multiplicandoStr = multiplicando.toString();
        String multiplicadorStr = multiplicador.toString();
        
        // Calcular la longitud de los números
        int longitudMultiplicando = multiplicandoStr.length();
        int longitudMultiplicador = multiplicadorStr.length();
        
        // Caso base: si uno de los números tiene una sola cifra, multiplicar y devolver el resultado
        if (longitudMultiplicando == 1 || longitudMultiplicador == 1) {
            return multiplicando.multiply(multiplicador);
        }
        
        // Calcular el tamaño del nuevo número y dividirlos en mitades
        int mitadMultiplicando = longitudMultiplicando / 2;
        int mitadMultiplicador = longitudMultiplicador / 2;
        
        // Extraer las partes superiores e inferiores de los números
        BigInteger a = new BigInteger(multiplicandoStr.substring(0, mitadMultiplicando));
        BigInteger b = new BigInteger(multiplicandoStr.substring(mitadMultiplicando));
        BigInteger c = new BigInteger(multiplicadorStr.substring(0, mitadMultiplicador));
        BigInteger d = new BigInteger(multiplicadorStr.substring(mitadMultiplicador));
        
        // Calcular las multiplicaciones recursivamente
        BigInteger ac = multiplicacionAmericanaRecursive(a, c);
        BigInteger bd = multiplicacionAmericanaRecursive(b, d);
        BigInteger ad_bc = multiplicacionAmericanaRecursive(a.add(b), c.add(d)).subtract(ac).subtract(bd);
        
        // Calcular el resultado final utilizando la fórmula adecuada
        return ac.multiply(BigInteger.TEN.pow(longitudMultiplicando)).add(ad_bc.multiply(BigInteger.TEN.pow(mitadMultiplicando))).add(bd);
    }
}
