public class LargestPrime {
    public static void main(String[] args) {
        System.out.println(getLargestPrime(21));
        System.out.println(getLargestPrime(217));
        System.out.println(getLargestPrime(0));
        System.out.println(getLargestPrime(45));
        System.out.println(getLargestPrime(-1));
    }
    // Solución (menos eficiente):
    private static int getLargestPrime(int number) {
        // Debido a que no hay número primos menores a 2, filtro:
        if (number < 2) {
            return -1;
        }
        // Divido / 2 number hasta llegar a un impar.
        while (number % 2 == 0) {
            number /= 2;
        }
        // Si number era potencia de 2, y termina la división en 1, significa que el primo mayor es 2.
        if (number == 1) {
            return 2;
        }
        int highestPrime = number; // Creo variable highestPrime con valor number, que luego será reasignado con el valor solicitado (Mayor primo factor).
        // Uso bucle for al revés, disminuyendo de 2 en 2 (para solo pasar por impares), y en cada iteración:
        for(int i = number - 2; i >= 3; i-=2){
            // Si el índice es primo y divisor de number:
            if(isPrime(i) && (number % i == 0)) {
                highestPrime = i; // Reasigna number con el valor del índice.
                break; // Rompe el ciclo y se detiene.
            }
        }
        return highestPrime; // Retorna el valor actualizado de number (el mayor factor primo). En caso de no haber factor primo, devuelve el valor number, que resultaría ser primo.
    }
    // Función para determinar si el número es primo.
    private static boolean isPrime(int number) {
        // Validaciones:
        if(number<=1) {
            return false;
        }
        else if(number==2) {
            return true;
        }
        else if(number%2==0) {
            return false;
        }
        // Uso bucle for y en cada iteración:
        for (int divisor = 3; divisor <= Math.sqrt(number); divisor += 2) {
            // Si el número tiene tiene divisor:
            if (number % divisor == 0) {
                return false;  // Retorno...
            }
        }
        return true; // En caso contrario, retorno...
    }
    // Solución (más eficiente):
    public static int getLargestPrimeEnhanced(int number) {
        if (number < 2) {
            return -1; // No existen primos menores que 2.
        }

        // Divide por 2 mientras el número sea par.
        while (number % 2 == 0) {
            number /= 2;
        }

        // Si después de dividir por 2, el número se convierte en 1,
        // entonces 2 es el mayor primo. De lo contrario, el número es impar.
        if (number == 1) {
            return 2;
        }

        // Comienza a verificar desde 3, incrementando de 2 en 2 (solo impares).
        int largestPrime = 3;
        for (int i = 3; i <= Math.sqrt(number); i += 2) {
            // Divide por i mientras sea un divisor de number.
            while (number % i == 0) {
                largestPrime = i;
                number /= i;
            }
        }

        // Si number es un primo mayor que 2, entonces number es el mayor primo.
        if (number > 2) {
            largestPrime = number;
        }

        return largestPrime;
    }
}
