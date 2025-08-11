/*A prime is a positive integer X that has exactly two distinct divisors: 1 and X. The first few prime integers are 2, 3, 5, 7, 11 and 13.

A prime D is called a prime divisor of a positive integer P if there exists a positive integer K such that D * K = P. For example, 2 and 5 are prime divisors of 20.

You are given two positive integers N and M. The goal is to check whether the sets of prime divisors of integers N and M are exactly the same.

For example, given:

N = 15 and M = 75, the prime divisors are the same: {3, 5};
N = 10 and M = 30, the prime divisors aren't the same: {2, 5} is not equal to {2, 3, 5};
N = 9 and M = 5, the prime divisors aren't the same: {3} is not equal to {5}.
Write a function:

class Solution { public int solution(int[] A, int[] B); }

that, given two non-empty arrays A and B of Z integers, returns the number of positions K for which the prime divisors of A[K] and B[K] are exactly the same.

For example, given:

    A[0] = 15   B[0] = 75
    A[1] = 10   B[1] = 30
    A[2] = 3    B[2] = 5
the function should return 1, because only one pair (15, 75) has the same set of prime divisors.

Write an efficient algorithm for the following assumptions:

Z is an integer within the range [1..6,000];
each element of arrays A and B is an integer within the range [1..2,147,483,647]. 

AUTHOR: Boban Micoski
*/
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
public class Solution38 {
    public static ArrayList<Integer> primeFactors(int n){
        ArrayList<Integer> lista = new ArrayList<Integer>();
        while(n%2==0){
            lista.add(2);
            n/=2;
        }
        for(int i = 3; i <= Math.sqrt(n); i+=2){
            while(n%i==0){
                lista.add(i);
                n/=i;
            }
        }
        if(n>2){
            lista.add(n);
        }
        return lista;
    }
    public static int solution(int[] A, int[] B){
        
        int brojac = 0;
        ArrayList<Integer> listaA = new ArrayList<Integer>();
        ArrayList<Integer> listaB = new ArrayList<Integer>();
        int broj1=0;
        int broj2=0;
        for(int i = 0; i < A.length; i++){
            broj1 = A[i];
            broj2 = B[i];
            listaA = primeFactors(broj1);
            listaB = primeFactors(broj2);
            Set<Integer> set1 = new HashSet<>(listaA.size());
            listaA.removeIf(p-> !set1.add(p));
            Set<Integer> set2 = new HashSet<>(listaB.size());
            listaB.removeIf(p-> !set2.add(p));
            if(listaA.equals(listaB)){
                brojac++;
            }
            listaA.clear();
            listaB.clear();
            set1.clear();
            set2.clear();
        }
        return brojac;
        


    }
    public static void main(String[] args){
        int[] nizaA = {15,10,3};
        int[] nizaB = {75,30,5};
        int izlez = solution(nizaA,nizaB);
        System.out.println(izlez);
    }
    
}
