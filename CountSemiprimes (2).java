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

that, given an integer N and two non-empty arrays P and Q consisting of M integers, returns an array consisting of M elements specifying the consecutive answers to 
all the queries.

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
Correctness 100%, Performance 0%

AUTHOR: Boban Micoski
 */

import java.util.ArrayList;
public class Solution72 {
    public static boolean checkPrime(int Number){
        boolean isitPrime = true;
        if(Number <= 1){
            isitPrime = false;
            return isitPrime;
        }
        else{
            for(int i = 2; i <= Number/2; i++){
                if((Number % i) == 0){
                    isitPrime = false;
                    break;
                }
            }
            return isitPrime;
        }

    } 
    public static int[] solution(int N, int[] P, int[] Q){
        ArrayList<Integer> lista = new ArrayList<Integer>();
        ArrayList<Integer> listaSemi = new ArrayList<Integer>();
        int[] izlez = new int[P.length];
        if(N<4){
            for(int i = 0; i < P.length; i++){
                izlez[i] = 0;
            }
            return izlez;
        }
        int polovina = N/2;
        int a = 0;
        int b = 0;
        int brojac = 0;
        //System.out.println(polovina);
        while(polovina != 1){
            if(checkPrime(polovina)){
                lista.add(polovina);
                polovina--;
            }
            else{
                polovina--;
            }
        }
        for(int i = 0; i < lista.size(); i++){
            for(int j = i+0; j < lista.size(); j++){
                if( (lista.get(i)*lista.get(j)) <= N){
                    listaSemi.add((lista.get(i)*lista.get(j)));
                }
            }
        }
        listaSemi.sort(null);
        for(int i = 0; i < P.length; i++){
            a = P[i];
            b = Q[i];
            for(int j = a; j < b+1; j++){
                if(listaSemi.contains(j)){
                    brojac++;
                }
            }
            izlez[i] = brojac;
            brojac = 0;
        }
        return izlez;
    }
    public static void main(String[] args){
        int n = 26;
        int[] p = {1,4,16};
        int[] q = {26,10,20};
        int[] izlez = solution(n,p,q);
        for(int i = 0; i < izlez.length; i++){
            System.out.println(izlez[i]);
        }
    }
}
