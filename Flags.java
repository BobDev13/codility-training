/*
 * A non-empty array A consisting of N integers is given.

A peak is an array element which is larger than its neighbours. More precisely, it is an index P such that 0 < P < N − 1 and A[P − 1] < A[P] > A[P + 1].

For example, the following array A:

    A[0] = 1
    A[1] = 5
    A[2] = 3
    A[3] = 4
    A[4] = 3
    A[5] = 4
    A[6] = 1
    A[7] = 2
    A[8] = 3
    A[9] = 4
    A[10] = 6
    A[11] = 2
has exactly four peaks: elements 1, 3, 5 and 10.

You are going on a trip to a range of mountains whose relative heights are represented by array A, as shown in a figure below. You have to choose how many flags you should take with you. The goal is to set the maximum number of flags on the peaks, according to certain rules.



Flags can only be set on peaks. What's more, if you take K flags, then the distance between any two flags should be greater than or equal to K. The distance between indices P and Q is the absolute value |P − Q|.

For example, given the mountain range represented by array A, above, with N = 12, if you take:

two flags, you can set them on peaks 1 and 5;
three flags, you can set them on peaks 1, 5 and 10;
four flags, you can set only three flags, on peaks 1, 5 and 10.
You can therefore set a maximum of three flags in this case.

Write a function:

class Solution { public int solution(int[] A); }

that, given a non-empty array A of N integers, returns the maximum number of flags that can be set on the peaks of the array.

For example, the following array A:

    A[0] = 1
    A[1] = 5
    A[2] = 3
    A[3] = 4
    A[4] = 3
    A[5] = 4
    A[6] = 1
    A[7] = 2
    A[8] = 3
    A[9] = 4
    A[10] = 6
    A[11] = 2
the function should return 3, as explained above.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..400,000];
each element of array A is an integer within the range [0..1,000,000,000].

AUTHOR: Boban Micoski
 */

import java.util.ArrayList;
public class Solution22 {
    public static int solution(int[] A){
        int vrvovi = 0;
        int element = A[0];
        ArrayList<Integer> lista = new ArrayList<Integer>();
        for(int i = 1; i < A.length-1; i++){
            if(element < A[i] && A[i] > A[i+1]){
                    vrvovi++;
                    lista.add(i);   
            }
            element = A[i];
        }
        int br = vrvovi;
        int maksimum = 0;
        int dolzina = lista.size();
        
        int izl = 0;
        while(br != 1){
        int el = lista.get(dolzina-1);
        int fl = 0;
        for(int i =lista.size()-2; i >= 0; i--){
            if(el - lista.get(i) >= br && fl == 0){
                maksimum+=2;
                fl=1;
                el = lista.get(i);
            }
            else{
                if(el - lista.get(i) >= br && fl == 1){
                    maksimum+=1;
                    el = lista.get(i);
                }
            }
            
        }
        //System.out.println(maksimum);
        if(izl < maksimum && br>=maksimum){
            izl = maksimum;
            //System.out.println(izl);
            fl=0;
            maksimum = 0;
        }
        //System.out.println(izl);
        //System.out.println(br);
        maksimum = 0;
        br--;
    }
        return izl;
    }
    public static void main(String[] args){
        int[] niza = {1,5,3,4,3,4,1,2,3,4,6,2};
        int izlez = solution(niza);
        System.out.println(izlez);
    }
    
}
