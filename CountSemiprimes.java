/*
 * A prime is a positive integer X that has exactly two distinct divisors: 1 and X. The first few prime integers are 2, 3, 5, 7, 11 and 13.

A semiprime is a natural number that is the product of two (not necessarily distinct) prime numbers. The first few semiprimes are 4, 6, 9, 10, 14, 15, 21, 22, 25, 26.

You are given two non-empty arrays P and Q, each consisting of M integers. These arrays represent queries about the number of semiprimes within specified ranges.

Query K requires you to find the number of semiprimes within the range (P[K], Q[K]), where 1 ≤ P[K] ≤ Q[K] ≤ N.

For example, consider an integer N = 26 and arrays P, Q such that:

    P[0] = 1    Q[0] = 26
    P[1] = 4    Q[1] = 10
    P[2] = 16   Q[2] = 20
The number of semiprimes within each of these ranges is as follows:

(1, 26) is 10,
(4, 10) is 4,
(16, 20) is 0.
Write a function:

class Solution { public int[] solution(int N, int[] P, int[] Q); }

that, given an integer N and two non-empty arrays P and Q consisting of M integers, returns an array consisting of M elements specifying the consecutive answers to all the queries.

For example, given an integer N = 26 and arrays P, Q such that:

    P[0] = 1    Q[0] = 26
    P[1] = 4    Q[1] = 10
    P[2] = 16   Q[2] = 20
the function should return the values [10, 4, 0], as explained above.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..50,000];
M is an integer within the range [1..30,000];
each element of arrays P and Q is an integer within the range [1..N];
P[i] ≤ Q[i].

AUTHOR: Boban Micoski
 */

import java.util.Arrays;
import java.util.ArrayList;

public class Solution35 {
    
    public static boolean[] sieve(int n) {
        boolean[] sieve = new boolean[n + 1];
        Arrays.fill(sieve, true);
        sieve[0] = sieve[1] = false;
        int i = 2;
        while (i * i <= n) {
            if (sieve[i]) {
                for (int k = i * i; k <= n; k += i) {
                    sieve[k] = false;
                }
            }
            i++;
        }
        return sieve;
    }
    
    public static int[] solution(int N, int[] P, int[] Q){
        int polovina = N/2;
        boolean[] primes = sieve(polovina);
        ArrayList<Integer> niza = new ArrayList<Integer>();
        ArrayList<Integer> nizaA = new ArrayList<Integer>();
        int brojac = 0;
        for(int i = 0; i<=polovina; i++){
            if(primes[i]){
                niza.add(i);
            }
        }
        int[] izlez = new int[niza.size()];
        for(int i = 0; i < niza.size(); i++){
            izlez[i] = niza.get(i);
        }
        for(int i = izlez.length-1; i >= 0; i--){
            for(int j = i; j>=0; j--){
                if(izlez[i]*izlez[j] <= N){
                    nizaA.add(izlez[i]*izlez[j]);
                }
            }
        }
        nizaA.sort(null);
        int krajj = nizaA.size();
        int[] kNiza = new int[P.length];
        for(int i = 0; i < P.length; i++){
            int pocetok = P[i];
            int kraj = Q[i];
            if(pocetok<=nizaA.get(0) && kraj>= nizaA.get(krajj-1)){
                brojac = nizaA.size();
                kNiza[i] = brojac;
                brojac = 0;
            }
            else{
                while(pocetok!=kraj){
                    for(int j = 0; j < nizaA.size(); j++){
                        if(pocetok == nizaA.get(j)){
                            brojac++;
                            j++;
                            pocetok++;
                        }
                        else{
                            pocetok++;
                            j++;
                        }

                    }
                }
            }
        }
        for(int i = 0; i <nizaA.size(); i++){
            System.out.println(nizaA.get(i));
        }
        System.out.println("**********");
        return izlez;

    }
    public static void main(String[] args){
        int n = 26;
        int[] nizaA = {1,4,16};
        int[] nizaB = {26,10,20};
        int [] izlez = solution(n,nizaA,nizaB);
        for(int i = 0; i < izlez.length; i++){
            System.out.println(izlez[i]);
        }
    }
}
