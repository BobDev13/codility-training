/*A non-empty array A consisting of N integers is given. The product of triplet (P, Q, R) equates to A[P] * A[Q] * A[R] (0 ≤ P < Q < R < N).

For example, array A such that:

  A[0] = -3
  A[1] = 1
  A[2] = 2
  A[3] = -2
  A[4] = 5
  A[5] = 6
contains the following example triplets:

(0, 1, 2), product is −3 * 1 * 2 = −6
(1, 2, 4), product is 1 * 2 * 5 = 10
(2, 4, 5), product is 2 * 5 * 6 = 60
Your goal is to find the maximal product of any triplet.

Write a function:

class Solution { public int solution(int[] A); }

that, given a non-empty array A, returns the value of the maximal product of any triplet.

For example, given array A such that:

  A[0] = -3
  A[1] = 1
  A[2] = 2
  A[3] = -2
  A[4] = 5
  A[5] = 6
the function should return 60, as the product of triplet (2, 4, 5) is maximal.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [3..100,000];
each element of array A is an integer within the range [−1,000..1,000].

AUTHOR: Boban Micoski
*/

import java.util.ArrayList;
public class Solution66 {
    public static int solution(int[] A){
        ArrayList<Integer> lista = new ArrayList<Integer>();
        if(A.length < 3){
            if(A.length == 1){
                return A[0];
            }
            else{
                return A[0]*A[1];
            }
        }
        else{
        for(int i = 0; i < A.length; i++){
            lista.add(A[i]);
        }
        lista.sort(null);
        
            int a = lista.get(lista.size()-1);
            int b = lista.get(lista.size()-2);
            int c = lista.get(lista.size()-3);
            int d = lista.get(0);
            int e = lista.get(1);
            int f = lista.get(2);
            if(a*b*c < d*e*a){
                return d*e*a;
            }
            else if(a*b*c < d*e*f){
                return d*e*f;
            }
            else
            return a*b*c;
        
    }
    }

    public static void main(String[] args){
        int[] niza = {-5,5,-5,4};
        int izlez = solution(niza);
        System.out.println(izlez);

    }
    
}
