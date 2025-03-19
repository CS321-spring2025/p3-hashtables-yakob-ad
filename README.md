# Project #: Project Name

* Author: Yakob Adera
* Class: CS321 Section 002
* Semester: Spring 2025

## Overview

This program implements a hash table by implementing two hash tables 
`LinearProbing.java` and `DoubleHashing.java`(subclasses of the Hashtable class) 
that utilize open addressing probing techniques to insert into and search the 
Hashtable in an efficient manner. HashtableExperiment simulates the hash tables by 
testing insertion and searching methods and outputing various results showing the 
relationships between the load factor, average number of probes, number of inserts 
& duplicates, and so on.

## Reflection

The `TwinPrimeGenerator` class was the easiest class to write. As for the rest of 
the classes, they were much more difficult to implement. This project was
particularly challenging and time-consuming because I was constantly changing each 
class and rewriting specific methods, like the `insert()` `Hashtable` method, 
numerous times as I was testing it in `HashtableExperiment`. The instructions were 
not fully clear on topics like calculating average number of probes, or when to 
count a probe during insertion, etc. So I kept making changes during tests to get 
the expected results shown in Figures 1 & 2 of the instructions.

Implementing the code for Debug-Level 2 was very difficult because I had to keep track 
of a lot of information to have enough data to print out and display. I had to go back 
and document the output of every single `insert()` call and also the `Object` key of 
each `HashObject` being inserted, so it can be used later when I search for these 
elements from the hash table, extract their key and probe count information, and print
it to output.

## Compiling and Using

Ensure a JDK (Java Development Kit) is installed on your local environment and added to your system's PATH environment variable.

Open the terminal (preferably a Unix-Based terminal)

To Compile the Test Program:<br>
`$ javac HashtableExperiment.java`

To Run the Test Program:<br>
`$ java HashtableExperiment <dataSource> <loadFactor> [<debugLevel>]`

The command line arguments for running the program:<br>
`<dataSource>`: `1` ==> random numbers<br>
&#x2003;&#x2003;&#x2003;&#x2003;&#x2003; &#x2003; &#x2003;`2` ==> date value as a long<br>
&#x2003;&#x2003;&#x2003;&#x2003;&#x2003; &#x2003; &#x2003;`3` ==> word list<br>
`<loadFactor>`: The ratio of objects to table size, denoted by alpha = n/m<br>
`<debugLevel>`: `0` ==> print summary of experiment<br>
&#x2003;&#x2003;&#x2003;&#x2003;&#x2003; &#x2003; &#x2003;`1` ==> save the two hash tables to a file at the end<br>
&#x2003;&#x2003;&#x2003;&#x2003;&#x2003; &#x2003; &#x2003;`2` ==> print debugging output for each insert<br>

### Running the test scripts
Before running the test scripts, ensure they can be executed by owner with the following<br>
`$ chmod u+x ./run-tests.sh ./generate-results.sh`:<br>
then run the tests:<br>
`$ ./run-tests.sh`<br>
`$ ./generate-results.sh`<br>


## Results 

Results from running test script `./run-tests.sh`:<br>
```

Compiling the source code


!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
Running test for word-list for varying load factors
!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

Running java HashtableExperiment dataSource = 3 loadFactor = 0.5 

Test PASSED for linear probing and load = 0.5
Test PASSED for double probing and load = 0.5

Running java HashtableExperiment dataSource = 3 loadFactor = 0.6

Test PASSED for linear probing and load = 0.6
Test PASSED for double probing and load = 0.6

Running java HashtableExperiment dataSource = 3 loadFactor = 0.7 

Test PASSED for linear probing and load = 0.7
Test PASSED for double probing and load = 0.7

Running java HashtableExperiment dataSource = 3 loadFactor = 0.8 

Test PASSED for linear probing and load = 0.8
Test PASSED for double probing and load = 0.8

Running java HashtableExperiment dataSource = 3 loadFactor = 0.9 

Test PASSED for linear probing and load = 0.9
Test PASSED for double probing and load = 0.9

Running java HashtableExperiment dataSource = 3 loadFactor = 0.95 

Test PASSED for linear probing and load = 0.95
Test PASSED for double probing and load = 0.95

Running java HashtableExperiment dataSource = 3 loadFactor = 0.99

Test PASSED for linear probing and load = 0.99
Test PASSED for double probing and load = 0.99


```

Results from running test script `./generate-results.sh` were dumped into three different files corresponding to each data source:<br>

#### results-random.txt
```

--------------------------------------------------------------------------------
        Using Linear Probing
HashtableExperiment: size of hash table is 47896
        Inserted 47896 elements, of which 0 were duplicates
        Avg. no. of probes = 1.51

        Using Double Hashing
HashtableExperiment: size of hash table is 47896
        Inserted 47896 elements, of which 0 were duplicates
        Avg. no. of probes = 1.39
--------------------------------------------------------------------------------

--------------------------------------------------------------------------------
        Using Linear Probing
HashtableExperiment: size of hash table is 57475
        Inserted 57477 elements, of which 2 were duplicates
        Avg. no. of probes = 1.75

        Using Double Hashing
HashtableExperiment: size of hash table is 57475
        Inserted 57477 elements, of which 2 were duplicates
        Avg. no. of probes = 1.52
--------------------------------------------------------------------------------

--------------------------------------------------------------------------------
        Using Linear Probing
HashtableExperiment: size of hash table is 67054
        Inserted 67054 elements, of which 0 were duplicates
        Avg. no. of probes = 2.19

        Using Double Hashing
HashtableExperiment: size of hash table is 67054
        Inserted 67054 elements, of which 0 were duplicates
        Avg. no. of probes = 1.72
--------------------------------------------------------------------------------

--------------------------------------------------------------------------------
        Using Linear Probing
HashtableExperiment: size of hash table is 76633
        Inserted 76633 elements, of which 0 were duplicates
        Avg. no. of probes = 2.95

        Using Double Hashing
HashtableExperiment: size of hash table is 76633
        Inserted 76633 elements, of which 0 were duplicates
        Avg. no. of probes = 2.02
--------------------------------------------------------------------------------

--------------------------------------------------------------------------------
        Using Linear Probing
HashtableExperiment: size of hash table is 86212
        Inserted 86212 elements, of which 0 were duplicates
        Avg. no. of probes = 5.66

        Using Double Hashing
HashtableExperiment: size of hash table is 86212
        Inserted 86212 elements, of which 0 were duplicates
        Avg. no. of probes = 2.55
--------------------------------------------------------------------------------

--------------------------------------------------------------------------------
        Using Linear Probing
HashtableExperiment: size of hash table is 91002
        Inserted 91004 elements, of which 2 were duplicates
        Avg. no. of probes = 10.44

        Using Double Hashing
HashtableExperiment: size of hash table is 91002
        Inserted 91004 elements, of which 2 were duplicates
        Avg. no. of probes = 3.15
--------------------------------------------------------------------------------

--------------------------------------------------------------------------------
        Using Linear Probing
HashtableExperiment: size of hash table is 94834
        Inserted 94834 elements, of which 0 were duplicates
        Avg. no. of probes = 42.49

        Using Double Hashing
HashtableExperiment: size of hash table is 94834
        Inserted 94834 elements, of which 0 were duplicates
        Avg. no. of probes = 4.69
--------------------------------------------------------------------------------


```

#### results-date.txt
```

--------------------------------------------------------------------------------
        Using Linear Probing
HashtableExperiment: size of hash table is 47896
        Inserted 47896 elements, of which 0 were duplicates
        Avg. no. of probes = 1.28

        Using Double Hashing
HashtableExperiment: size of hash table is 47896
        Inserted 47896 elements, of which 0 were duplicates
        Avg. no. of probes = 1.38
--------------------------------------------------------------------------------

--------------------------------------------------------------------------------
        Using Linear Probing
HashtableExperiment: size of hash table is 57475
        Inserted 57475 elements, of which 0 were duplicates
        Avg. no. of probes = 1.44

        Using Double Hashing
HashtableExperiment: size of hash table is 57475
        Inserted 57475 elements, of which 0 were duplicates
        Avg. no. of probes = 1.65
--------------------------------------------------------------------------------

--------------------------------------------------------------------------------
        Using Linear Probing
HashtableExperiment: size of hash table is 67054
        Inserted 67054 elements, of which 0 were duplicates
        Avg. no. of probes = 1.60

        Using Double Hashing
HashtableExperiment: size of hash table is 67054
        Inserted 67054 elements, of which 0 were duplicates
        Avg. no. of probes = 1.98
--------------------------------------------------------------------------------

--------------------------------------------------------------------------------
        Using Linear Probing
HashtableExperiment: size of hash table is 76633
        Inserted 76633 elements, of which 0 were duplicates
        Avg. no. of probes = 1.82

        Using Double Hashing
HashtableExperiment: size of hash table is 76633
        Inserted 76633 elements, of which 0 were duplicates
        Avg. no. of probes = 2.41
--------------------------------------------------------------------------------

--------------------------------------------------------------------------------
        Using Linear Probing
HashtableExperiment: size of hash table is 86212
        Inserted 86212 elements, of which 0 were duplicates
        Avg. no. of probes = 2.18

        Using Double Hashing
HashtableExperiment: size of hash table is 86212
        Inserted 86212 elements, of which 0 were duplicates
        Avg. no. of probes = 3.10
--------------------------------------------------------------------------------

--------------------------------------------------------------------------------
        Using Linear Probing
HashtableExperiment: size of hash table is 91002
        Inserted 91002 elements, of which 0 were duplicates
        Avg. no. of probes = 2.70

        Using Double Hashing
HashtableExperiment: size of hash table is 91002
        Inserted 91002 elements, of which 0 were duplicates
        Avg. no. of probes = 3.82
--------------------------------------------------------------------------------

--------------------------------------------------------------------------------
        Using Linear Probing
HashtableExperiment: size of hash table is 94834
        Inserted 94834 elements, of which 0 were duplicates
        Avg. no. of probes = 5.41

        Using Double Hashing
HashtableExperiment: size of hash table is 94834
        Inserted 94834 elements, of which 0 were duplicates
        Avg. no. of probes = 5.30
--------------------------------------------------------------------------------


```

#### results-word-list.txt
```

--------------------------------------------------------------------------------
        Using Linear Probing
HashtableExperiment: size of hash table is 47896
        Inserted 1305930 elements, of which 1258034 were duplicates
        Avg. no. of probes = 1.60

        Using Double Hashing
HashtableExperiment: size of hash table is 47896
        Inserted 1305930 elements, of which 1258034 were duplicates
        Avg. no. of probes = 1.39
--------------------------------------------------------------------------------

--------------------------------------------------------------------------------
        Using Linear Probing
HashtableExperiment: size of hash table is 57475
        Inserted 1587659 elements, of which 1530184 were duplicates
        Avg. no. of probes = 2.15

        Using Double Hashing
HashtableExperiment: size of hash table is 57475
        Inserted 1587659 elements, of which 1530184 were duplicates
        Avg. no. of probes = 1.53
--------------------------------------------------------------------------------

--------------------------------------------------------------------------------
        Using Linear Probing
HashtableExperiment: size of hash table is 67054
        Inserted 1869206 elements, of which 1802152 were duplicates
        Avg. no. of probes = 3.60

        Using Double Hashing
HashtableExperiment: size of hash table is 67054
        Inserted 1869206 elements, of which 1802152 were duplicates
        Avg. no. of probes = 1.72
--------------------------------------------------------------------------------

--------------------------------------------------------------------------------
        Using Linear Probing
HashtableExperiment: size of hash table is 76633
        Inserted 2147748 elements, of which 2071115 were duplicates
        Avg. no. of probes = 6.71

        Using Double Hashing
HashtableExperiment: size of hash table is 76633
        Inserted 2147748 elements, of which 2071115 were duplicates
        Avg. no. of probes = 2.02
--------------------------------------------------------------------------------

--------------------------------------------------------------------------------
        Using Linear Probing
HashtableExperiment: size of hash table is 86212
        Inserted 2840050 elements, of which 2753838 were duplicates
        Avg. no. of probes = 19.81

        Using Double Hashing
HashtableExperiment: size of hash table is 86212
        Inserted 2840050 elements, of which 2753838 were duplicates
        Avg. no. of probes = 2.57
--------------------------------------------------------------------------------

--------------------------------------------------------------------------------
        Using Linear Probing
HashtableExperiment: size of hash table is 91002
        Inserted 3013622 elements, of which 2922620 were duplicates
        Avg. no. of probes = 110.59

        Using Double Hashing
HashtableExperiment: size of hash table is 91002
        Inserted 3013622 elements, of which 2922620 were duplicates
        Avg. no. of probes = 3.19
--------------------------------------------------------------------------------

--------------------------------------------------------------------------------
        Using Linear Probing
HashtableExperiment: size of hash table is 94834
        Inserted 3024134 elements, of which 2929300 were duplicates
        Avg. no. of probes = 471.67

        Using Double Hashing
HashtableExperiment: size of hash table is 94834
        Inserted 3024134 elements, of which 2929300 were duplicates
        Avg. no. of probes = 4.70
--------------------------------------------------------------------------------


```

## Sources used

* [Hash Tables and Hash Functions](https://www.youtube.com/watch?v=KyUTuwz_b7Q)

* [Writing Java Function that checks if a number is prime](https://stackoverflow.com/questions/72109026/how-do-i-get-an-if-statement-to-check-if-a-user-given-number-is-a-prime-number)

* [Java equals() and hashCode()](https://www.digitalocean.com/community/tutorials/java-equals-hashcode)

* [How to override equals method in Java](https://stackoverflow.com/questions/8180430/how-to-override-equals-method-in-java)

* [Java readLine() Method: Proper Usage Guide](https://ioflood.com/blog/java-read-line/)


## Notes

For debug-level 2, the instructions mentioned to print detailed information about each insert operation to the console, but this wouldn't be helpful with debugging because the console cuts off printed text when there is too much to output. So, I decided to dump all the data for each insert call into an output file titled `debug-level-2-output.txt` in table format.