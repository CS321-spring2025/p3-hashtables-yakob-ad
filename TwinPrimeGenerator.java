public class TwinPrimeGenerator {

    /**
     * Confirms whether the given number is a prime number
     * 
     * @param number integer parameter to be tested
     * @return true if number is prime, false otherwise.
     */
    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) { // if number is divisible by i, then it is not prime
                return false;
            }
        }
        return true;
    }

    /**
     * Generates a value for the {@code HashTable} table size {@code m} 
     * in the range of {@code [min:max]}.
     * 
     * @param min minimum value in range
     * @param max maximum value in range
     * @return integer value {@code m} in the range of {@code [min:max]}
     */
    public static int generateTwinPrime(int min, int max) {
        int m = 0;

        for (int i = min; i <= max; i++) {
            if (isPrime(i) && isPrime(i - 2)) {
                m = i;
                break;
            }
            else if (isPrime(i)) {
                m = i;
            }
        }
        return m;
    }
}
