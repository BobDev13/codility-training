/*
 * You are given an array A consisting of N integers.

For each number A[i] such that 0 ≤ i < N, we want to count the number of elements of the array that are not the divisors of A[i]. We say that these elements are non-divisors.

For example, consider integer N = 5 and array A such that:

    A[0] = 3
    A[1] = 1
    A[2] = 2
    A[3] = 3
    A[4] = 6
For the following elements:

A[0] = 3, the non-divisors are: 2, 6,
A[1] = 1, the non-divisors are: 3, 2, 3, 6,
A[2] = 2, the non-divisors are: 3, 3, 6,
A[3] = 3, the non-divisors are: 2, 6,
A[4] = 6, there aren't any non-divisors.
Write a function:

class Solution { public int[] solution(int[] A); }

that, given an array A consisting of N integers, returns a sequence of integers representing the amount of non-divisors.

Result array should be returned as an array of integers.

For example, given:

    A[0] = 3
    A[1] = 1
    A[2] = 2
    A[3] = 3
    A[4] = 6
the function should return [2, 4, 3, 2, 0], as explained above.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..50,000];
each element of array A is an integer within the range [1..2 * N].

AUTHOR: Boban Micoski
 */
//O(n^2)
import java.util.ArrayList;
public class Solution24 {
    public static int[] solution(int[] A){
        ArrayList<Integer> lista = new ArrayList<Integer>();
        int brojac = 0;
        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < A.length; j++){
                if(i != j && A[i]%A[j] != 0){
                    brojac++;
                }
            }
            lista.add(brojac);
            brojac = 0;
        }
        int[] izlez = new int[lista.size()];
        for(int i = 0; i < izlez.length; i++){
            izlez[i] = lista.get(i);
        }
        return izlez;
    }
    
    public static void main(String[] args){
        int[] niza = {3,1,2,3,6};
        int[] iz = solution(niza);
        for(int i = 0; i < iz.length; i++){
            System.out.println(iz[i]);
        }

    }
    
}
