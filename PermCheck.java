/*
 * A non-empty array A consisting of N integers is given.

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

public class Solution4{
    
    public static int solution(int [] A){
        int min = A[0];
        int maks = A[0];
        int flag = 0;
        for(int i =1; i < A.length; i++ ){
            if(min > A[i]){
                min = A[i];
            }
            else if(maks < A[i]){
                maks = A[i];
            }
        }
        
        int br_el = (maks -min)-1;
        if(br_el != A.length-2){
            return 0;
        }
        else{
        for(int i =0; i<A.length; i++){
            for(int j =i+1; j<A.length; j++){
                if(A[i] == A[j]){
                    flag =1;
                    break;
                }
            }
        }
        if(flag ==1){
            return 0;
        }
        else return 1;
    }

    }

    public static void main(String[] args){
        int [] niza = {8,1,3,2,4,6,7,5};
        int [] niza1 = {4,1,1,2};
        int izlez = solution(niza);
        int izlezz = solution(niza1);
        System.out.println("Prvata niza ke vrati: " + izlez);
        System.out.println("Vtorata niza ke vrati: "+izlezz);

    }
}