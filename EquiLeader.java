/*A non-empty array A consisting of N integers is given.

The leader of this array is the value that occurs in more than half of the elements of A.

An equi leader is an index S such that 0 ≤ S < N − 1 and two sequences A[0], A[1], ..., A[S] and A[S + 1], A[S + 2], ..., A[N − 1] have leaders of the same value.

For example, given array A such that:

    A[0] = 4
    A[1] = 3
    A[2] = 4
    A[3] = 4
    A[4] = 4
    A[5] = 2
we can find two equi leaders:

0, because sequences: (4) and (3, 4, 4, 4, 2) have the same leader, whose value is 4.
2, because sequences: (4, 3, 4) and (4, 4, 2) have the same leader, whose value is 4.
The goal is to count the number of equi leaders.

Write a function:

class Solution { public int solution(int[] A); }

that, given a non-empty array A consisting of N integers, returns the number of equi leaders.

For example, given:

    A[0] = 4
    A[1] = 3
    A[2] = 4
    A[3] = 4
    A[4] = 4
    A[5] = 2
the function should return 2, as explained above.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [−1,000,000,000..1,000,000,000]. 

AUTHOR: Boban Micoski
*/
import java.util.Stack;
import java.util.Arrays;
public class Solution19 {
    public static int solution(int[] A){
        Stack<Integer> stek = new Stack<Integer>();
        int mozenDominant = 0;
        int brojac = 0;
        int leftLen = 0;
        int rightLen = 0;
        int leftBrojac = 0;
        int rightBrojac = 0;
        int equi = 0;
        for(int i = 0; i < A.length; i++){
            if(stek.isEmpty()){
                stek.push(A[i]);
            }
            else{
                if(stek.peek() == A[i]){
                    stek.push(A[i]);
                }
                else{
                    stek.pop();
                }
            }
        }
        if(stek.isEmpty()){
            return 0;
        }
        else{
            mozenDominant = stek.peek();
            int[] kopija = A.clone();
            for(int i = 0; i < A.length; i++){
                if(mozenDominant == A[i]){
                    brojac++;
                }
                kopija[i] = brojac;
            }
            if(brojac > A.length/2){
                for(int i = 0; i < kopija.length-1; i++){
                    //System.out.println(kopija[i]);
                    leftLen = i+1;
                    rightLen = kopija.length - leftLen;
                    leftBrojac = kopija[i];
                    rightBrojac = brojac - leftBrojac;
                    if(leftBrojac > (int)(leftLen/2) && rightBrojac > (int)(rightLen/2)){
                        equi++;
                    }

                }
                return equi;
            }
            else return 0;
        }

    }
    public static void main(String[] args){
        int[] niza = {4,3,4,4,4,2};
        int izlez = solution(niza);
        System.out.println(izlez);
        int broj = (int)5/2;
        System.out.println(broj);
    }
    
}
