public class HashtableExperiment {
    
    public static void main(String[] args) {
        String usage =  "Usage: java HashtableExperiment <dataSource> <loadFactor> [<debugLevel>]\n" + //
                        "       <dataSource>: 1 ==> random numbers\n" + //
                        "                     2 ==> date value as a long\n" + //
                        "                     3 ==> word list\n" + //
                        "       <loadFactor>: The ratio of objects to table size,\n" + //
                        "                       denoted by alpha = n/m\n" + //
                        "       <debugLevel>: 0 ==> print summary of experiment\n" + //
                        "                     1 ==> save the two hash tables to a file at the end\n" + //
                        "                     2 ==> print debugging output for each insert";

        System.out.println(usage);

        System.out.println("\nPrime number m where m and (m - 2) are both prime:\nm = " + TwinPrimeGenerator.generateTwinPrime(95500, 96000));
        System.out.println("is m = 95791 prime: " + TwinPrimeGenerator.isPrime(95791));
        System.out.println("is m - 2 = 95789 prime: " + TwinPrimeGenerator.isPrime(95791 - 2));

    }
}
