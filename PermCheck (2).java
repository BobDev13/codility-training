/*A non-empty array A consisting of N integers is given.

A permutation is a sequence containing each element from 1 to N once, and only once.

For example, array A such that:

    A[0] = 4
    A[1] = 1
    A[2] = 3
    A[3] = 2
is a permutation, but array A such that:

    A[0] = 4
    A[1] = 1
    A[2] = 3
is not a permutation, because value 2 is missing.

The goal is to check whether array A is a permutation.

Write a function:

class Solution { public int solution(int[] A); }

that, given an array A, returns 1 if array A is a permutation and 0 if it is not.

For example, given array A such that:

    A[0] = 4
    A[1] = 1
    A[2] = 3
    A[3] = 2
the function should return 1.

Given array A such that:

    A[0] = 4
    A[1] = 1
    A[2] = 3
the function should return 0.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [1..1,000,000,000]. 

AUTHOR: Boban Micoski
*/

import java.util.Arrays;

public class Solution65 {
    public static int[] counting(int[] A, int m) {
        int n = A.length;
        int[] count = new int[m + 1];
        Arrays.fill(count, 0);
        for (int k = 0; k < n; k++) {
            count[A[k]]++;
        }
        return count;
    }
    public static int solution(int[] A){
        if(A.length == 1){
            if(A[0] == 1){
                return 1;
            }
            else return 0;
        }
        else{

        int max = A[0];
        for(int i = 1; i < A.length; i++){
            if(A[i] > max){
                max = A[i];
            }
        }
        int[] pomosna = new int[max+1];
        pomosna = counting(A, max);
        if(A.length == 1 || A.length ==2){}
        for(int i = 1; i < pomosna.length; i++){
            if(pomosna[i] != 1){
                return 0;
            }
        }
        return 1;
    }

    }
    public static void main(String[] args){
        int[] niza = {1,2,3,4,5,6,7,8,9,9,1,212,24,34,35,46,54,457,487,48,48,45,7436,4567,456,456,45645,6456456,46,456456456};
        int izlez = solution(niza);
        System.out.println(izlez);
    }
    
}
