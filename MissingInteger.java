/*
 * This is a demo task.

Write a function:

class Solution { public int solution(int[] A); }

that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

Given A = [1, 2, 3], the function should return 4.

Given A = [−1, −3], the function should return 1.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [−1,000,000..1,000,000].

AUTHOR: Boban Micoski
 */

import java.util.Arrays;
public class Solution11 {
    public static void removeDuplicates(int [] A){
        int j = 0;
        for(int i = 1; i < A.length; i++){
            if(A[i] != A[j]){
                j++;
                A[j] = A[i];
            }
        }
    }
    public static int solution(int[] A){
        Arrays.sort(A);
        removeDuplicates(A);
        int dolzina = A.length;
        int maksimum = A[dolzina-1];
        int minimum = A[0];
        int najmal = 0;
        int brojac = minimum;
        if(minimum > 0){
            for(int i = 0; i < dolzina; i++){
                if(brojac != A[i]){
                    najmal = brojac;
                    //System.out.println(najmal);
                    break;
                }
                brojac++;
            }
        }
        else {najmal = 1;}
        if(najmal == 0){
            najmal = maksimum+1;
            //System.out.println(najmal);
            return najmal;
        }
        else{
        return najmal;
        }
    }
    
    public static void main(String[] args){
        int[] niza1 = {1, 3, 6, 4, 1, 2};
        int[] niza2 = {1, 2, 3,4,5,6,7};
        int[] niza3 = {-1, -3};
        int izlez1 = solution(niza1);
        int izlez2 = solution(niza2);
        int izlez3 = solution(niza3);
        System.out.println(izlez1);
        System.out.println(izlez2);
        System.out.println(izlez3);
    }
}
