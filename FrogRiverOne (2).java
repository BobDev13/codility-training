/*A small frog wants to get to the other side of a river. The frog is initially located on one bank of the river (position 0) and wants to get to the opposite bank 
(position X+1). Leaves fall from a tree onto the surface of the river.

You are given an array A consisting of N integers representing the falling leaves. A[K] represents the position where one leaf falls at time K, 
measured in seconds.

The goal is to find the earliest time when the frog can jump to the other side of the river. The frog can cross only when leaves appear at every position across 
the river from 1 to X (that is, we want to find the earliest moment when all the positions from 1 to X are covered by leaves). You may assume that the speed of the 
current in the river is negligibly small, i.e. the leaves do not change their positions once they fall in the river.

For example, you are given integer X = 5 and array A such that:

  A[0] = 1
  A[1] = 3
  A[2] = 1
  A[3] = 4
  A[4] = 2
  A[5] = 3
  A[6] = 5
  A[7] = 4
In second 6, a leaf falls into position 5. This is the earliest time when leaves appear in every position across the river.

Write a function:

class Solution { public int solution(int X, int[] A); }

that, given a non-empty array A consisting of N integers and integer X, returns the earliest time when the frog can jump to the other side of the river.

If the frog is never able to jump to the other side of the river, the function should return −1.

For example, given X = 5 and array A such that:

  A[0] = 1
  A[1] = 3
  A[2] = 1
  A[3] = 4
  A[4] = 2
  A[5] = 3
  A[6] = 5
  A[7] = 4
the function should return 6, as explained above.

Write an efficient algorithm for the following assumptions:

N and X are integers within the range [1..100,000];
each element of array A is an integer within the range [1..X]. 

AUTHOR: Boban Micoski
*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Solution64 {
    public static int[] counting(int[] A, int m) {
        int n = A.length;
        int[] count = new int[m + 1];
        Arrays.fill(count, 0);
        for (int k = 0; k < n; k++) {
            count[A[k]]++;
        }
        return count;
    }
    public static int[] removeDuplicateElements(int data[]){  
        List<Integer> uniqueElements = new ArrayList<>();
        for(int value : data){
            if(!uniqueElements.contains(value)){
                uniqueElements.add(value);
            }
        }
        int[] result = new int[uniqueElements.size()];
        int i = 0;
        for(int val : uniqueElements){
            result[i++] = val;
        }
        return result;
    } 
    public static int solution(int X, int[] A){
        int [] pomosna = new int[A.length];
        int [] B = new int[A.length];
        int flag = 0;
        int flagg = 0;
        for(int i = 0; i < A.length; i++){
            pomosna[i] = A[i];
            if(A[i] == X){
                flagg = 1;
                B = counting(pomosna, X);
                for(int j = 1; j < B.length; j++){
                    if(B[j] == 0){
                        flag =1;
                        break;
                    }
                }
                if(flag == 0){
                    return i;
                }
                else{
                    flag = 0;
                }
            }
            else if(flagg == 1){
                B = counting(pomosna, X);
                for(int j = 1; j < B.length; j++){
                    if(B[j] == 0){
                        flag =1;
                        break;
                    }
                }
                if(flag == 0){
                    return i;
                }
                else{
                    flag = 0;
                }

            }
        }
        return -1;
        /* 
        int kopija = X;
        ArrayList<Integer> lista = new ArrayList<Integer>();
        while(kopija != 0){
            lista.add(kopija);
            --kopija;
        }
        int len = A.length;
        int[] kopijaNiza = new int[len];
        for(int i = 0; i < len; i++){
            kopijaNiza[i] = A[i];
        }
        int[] kNiza = removeDuplicateElements(kopijaNiza);
        int brojac = 0;
        int broj = 0;
        for(int i = 0; i < kNiza.length; i++){
            //System.out.println(kNiza[i]);
            if(lista.contains(kNiza[i])){
                brojac++;
            }
            if(brojac == X){
                broj = kNiza[i];
                //System.out.println(broj);
                break;
            }
        }
        for(int i = 0; i < A.length; i++){
            if(A[i] == broj){
                return i;
            }
        }
        return -1;
        */
    }
    
    public static void main(String[] args){
        int x = 5;
        int[] niza = {1,3,1,4,1,3,5,4,2,5};
        int izlez = solution(x,niza);
        System.out.println(izlez);


    }
    
}
