/*An array A consisting of N different integers is given. The array contains integers in the range [1..(N + 1)], which means that exactly one element is missing.

Your goal is to find that missing element.

Write a function:

class Solution { public int solution(int[] A); }

that, given an array A, returns the value of the missing element.

For example, given array A such that:

  A[0] = 2
  A[1] = 3
  A[2] = 1
  A[3] = 5
the function should return 4, as it is the missing element.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [0..100,000];
the elements of A are all distinct;
each element of array A is an integer within the range [1..(N + 1)].
100%

AUTHOR: Boban Micoski
*/
import java.util.ArrayList;
import java.util.Collections;
public class Solution67 {
    public static int solution(int[] A){
        if(A.length == 0){
            return 1;
        }
        else{
        ArrayList<Integer> lista = new ArrayList<Integer>();
        for(int i = 0; i < A.length; i++){
            lista.add(A[i]);
        }
        lista.sort(null);
        Collections.reverse(lista);
        for(int i = 0; i < lista.size()-1; i++){
            if(lista.get(i)-lista.get(i+1) > 1){
                return lista.get(i)-1;
            }
        }
        if(!lista.contains(1)){
            return 1;
        }
        else{
        return lista.get(0)+1;
        }
    }
    }
    public static void main(String[] args){
        int[] niza = {};
        int izlez = solution(niza);
        System.out.println(izlez);

    }
    
}
