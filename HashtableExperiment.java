public class HashtableExperiment {
    
    public static void main(String[] args) {
        // Usage string
        String usage =  "Usage: java HashtableExperiment <dataSource> <loadFactor> [<debugLevel>]\n" + //
                        "       <dataSource>: 1 ==> random numbers\n" + //
                        "                     2 ==> date value as a long\n" + //
                        "                     3 ==> word list\n" + //
                        "       <loadFactor>: The ratio of objects to table size,\n" + //
                        "                       denoted by alpha = n/m\n" + //
                        "       <debugLevel>: 0 ==> print summary of experiment\n" + //
                        "                     1 ==> save the two hash tables to a file at the end\n" + //
                        "                     2 ==> print debugging output for each insert";

        
        if (args.length >= 2 && args.length < 4) { // check if the number of command-line arguments are valid
            try {
                /**
                 * INITIALIZING COMMAND LINE ARGUMENT VARIABLES
                 */

                // <dataSource>: Three options --> (1) Random Integers, (2) Date values as Longs, (3) Word List from text file
                byte cacheSize = Byte.parseByte(args[0]);
                // <loadFactor>: ratio of (n) number of stored elements to (m) number of available hash table slots
                double loadFactor = Double.parseDouble(args[1]);

                
                if (args.length == 3) {
                    // <debug-level=0,1,2>: Level of debug to output
                    int debugLevel = Integer.parseInt(args[2]);
                    switch(debugLevel) {
                        case 0:
                            // Do something
                            break;
                        case 1:
                            // Do something
                            break;
                        case 2:
                            // Do something
                            break;
                        case 3:
                            // Do something
                            break;             
                        default: // If debug-level isn't 0,1, or 2, then by default, <something happens>
                            System.out.println("Debug Level should be 0, 1, or 2");
                            System.out.println(usage);
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Incorrect Format: Please use the correct data types for the arguments.");
                System.out.println(usage);
            }
        }
        else {
            System.out.println("Incorrect Format: Please include the correct number of arguments");
            System.out.println(usage);
        }

        // System.out.println(usage);

        // System.out.println("\nPrime number m where m and (m - 2) are both prime:\nm = " + TwinPrimeGenerator.generateTwinPrime(95500, 96000));
        // System.out.println("is m = 95791 prime: " + TwinPrimeGenerator.isPrime(95791));
        // System.out.println("is m - 2 = 95789 prime: " + TwinPrimeGenerator.isPrime(95791 - 2));

    }
}
