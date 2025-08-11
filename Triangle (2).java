/*An array A consisting of N integers is given. A triplet (P, Q, R) is triangular if it is possible to build a triangle with sides of lengths A[P], A[Q] and A[R]. In other words, triplet (P, Q, R) is triangular if 0 ≤ P < Q < R < N and:

A[P] + A[Q] > A[R],
A[Q] + A[R] > A[P],
A[R] + A[P] > A[Q].
For example, consider array A such that:

  A[0] = 10    A[1] = 2    A[2] = 5
  A[3] = 1     A[4] = 8    A[5] = 12
There are four triangular triplets that can be constructed from elements of this array, namely (0, 2, 4), (0, 2, 5), (0, 4, 5), and (2, 4, 5).

Write a function:

class Solution { public int solution(int[] A); }

that, given an array A consisting of N integers, returns the number of triangular triplets in this array.

For example, given array A such that:

  A[0] = 10    A[1] = 2    A[2] = 5
  A[3] = 1     A[4] = 8    A[5] = 12
the function should return 4, as explained above.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [0..1,000];
each element of array A is an integer within the range [1..1,000,000,000]. 

AUTHOR: Boban Micoski
*/

public class Solution39 {
    public static int solution(int[] A){
        int brojac = 0;
        int c = 0;
        for(int i = 0; i < A.length-1; i++){
            for(int j = i+1; j<A.length; j++){
                c=j+1;
                while(c != A.length){
                    if((A[i]+A[j] > A[c]) && (A[j]+A[c] > A[i]) && (A[c]+A[i] > A[j])){
                        brojac++;
                        c++;
                    }
                    else c++;
            }
            }
        }
        return brojac;
    }

    public static void main(String[] args){
        int[] niza = {10,2,5,1,8,12};
        int brojac = solution(niza);
        System.out.println(brojac);
    }
    
}
