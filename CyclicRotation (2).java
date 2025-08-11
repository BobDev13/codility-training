/*
 * An array A consisting of N integers is given. Rotation of the array means that each element is shifted right by one index, 
 * and the last element of the array is moved to the first place. For example, the rotation of array A = [3, 8, 9, 7, 6] is [6, 3, 8, 9, 7] 
 * (elements are shifted right by one index and 6 is moved to the first place).

The goal is to rotate array A K times; that is, each element of A will be shifted to the right K times.

Write a function:

class Solution { public int[] solution(int[] A, int K); }

that, given an array A consisting of N integers and an integer K, returns the array A rotated K times.

For example, given

    A = [3, 8, 9, 7, 6]
    K = 3
the function should return [9, 7, 6, 3, 8]. Three rotations were made:

    [3, 8, 9, 7, 6] -> [6, 3, 8, 9, 7]
    [6, 3, 8, 9, 7] -> [7, 6, 3, 8, 9]
    [7, 6, 3, 8, 9] -> [9, 7, 6, 3, 8]
For another example, given

    A = [0, 0, 0]
    K = 1
the function should return [0, 0, 0]

Given

    A = [1, 2, 3, 4]
    K = 4
the function should return [1, 2, 3, 4]

Assume that:

N and K are integers within the range [0..100];
each element of array A is an integer within the range [−1,000..1,000].
In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.

AUTHOR: Boban Micoski
 */

public class Solution62 {
    public static int[] solution(int[] A, int K){
        if(K == A.length || K == 0 || A.length==0 || A.length ==1){
            return A;
        }
        else{
            if( K < A.length){
                int[] pomosna = new int[A.length];
                int j = 0;
                int flag = 0;
                for(int i = 0; i < K; i++){
                    if(flag == 0){
                        j = A.length -K;
                    }
                        pomosna[i] = A[j];
                        flag = 1;
                        j++;
                }
                flag = 0;
                j = 0;
                for(int i = K; i < A.length; i++){
                    pomosna[i] = A[j];
                    j++;
                }
                return pomosna;

            }
            else{
                int[] pomosna = new int[A.length];
                int j = 0;
                int flag = 0;
                K=K%A.length;
                for(int i = 0; i < K; i++){
                    if(flag == 0){
                        j = A.length -K;
                    }
                        pomosna[i] = A[j];
                        flag = 1;
                        j++;
                }
                flag = 0;
                j = 0;
                for(int i = K; i < A.length; i++){
                    pomosna[i] = A[j];
                    j++;
                }
                return pomosna;
            }
        }
    }
    public static void main(String[] args){
        int[] niza = {3,8,9,7,6};
        int k = 1;
        int[] izlez = solution(niza,k);
        for(int i = 0; i < izlez.length; i++){
            System.out.print(izlez[i]+" ");
        }
    }
}