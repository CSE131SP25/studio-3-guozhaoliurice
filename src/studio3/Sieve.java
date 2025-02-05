package studio3;

import java.util.Scanner;

public class Sieve {
    public static int[] findPrimes(int n) {
        // Create a boolean array for marking prime numbers
        boolean[] isPrime = new boolean[n + 1];
        
        // Initialize all numbers as prime
        for (int i = 0; i <= n; i++) {
            isPrime[i] = true;
        }
        
        // 0 and 1 are not prime numbers
        isPrime[0] = isPrime[1] = false;
        
        // Apply Sieve of Eratosthenes
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                // Mark all multiples of i as non-prime
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        
        // Count number of primes to create appropriately sized array
        int primeCount = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                primeCount++;
            }
        }
        
        // Create and fill array with prime numbers
        int[] primes = new int[primeCount];
        int index = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                primes[index] = i;
                index++;
            }
        }
        
        return primes;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Get user input with input validation
        int n;
        do {
            System.out.print("Enter a positive integer greater than 1 to find primes up to: ");
            while (!scanner.hasNextInt()) {
                System.out.println("That's not a valid number. Please try again: ");
                scanner.next();
            }
            n = scanner.nextInt();
            if (n <= 1) {
                System.out.println("Please enter a number greater than 1.");
            }
        } while (n <= 1);
        
        // Find prime numbers and store in array
        int[] primes = findPrimes(n);
        
        // Print results
        System.out.println("\nPrime numbers up to " + n + " are:");
        for (int i = 0; i < primes.length; i++) {
            System.out.print(primes[i]);
            if (i < primes.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("\nTotal count of prime numbers: " + primes.length);
        
        scanner.close();
    }
}