/*
 * A company of dwarfs is travelling across the New Zealand. On reaching the Clutha River the dwarfs need to get across, but recent storms have washed away the bridge. Luckily, a small ferry, in the form of a square raft, is operating.

The raft is square and has N rows of seats, numbered from 1 to N. Each row contains N seats, labeled with consecutive letters (A, B, C, etc.). Each seat is identified by a string composed of its row number followed by its column number; for example, "9C" denotes the third seat in the 9th row.

The raft has already been loaded with barrels in some seat positions, and other seats are already occupied by dwarfs. Our company of dwarfs may only take the remaining unoccupied seats. The ferryman wants to accommodate as many dwarfs as possible, but the raft needs to be stable when making the crossing. That is, the following conditions must be satisfied:

the front and back halves of the raft (in terms of the rows of seats) must each contain the same number of dwarfs;
similarly, the left and right sides of the raft (in terms of the columns of seats) must each contain the same number of dwarfs.
You do not have to worry about balancing the barrels; you can assume that their weights are negligible.

For example, a raft of size N = 4 is shown in the following illustration:



Barrels are marked as brown squares, and seats that are already occupied by dwarfs are labeled d.

The positions of the barrels are given in string S. The occupied seat numbers are given in string T. The contents of the strings are separated by single spaces and may appear in any order. For example, in the diagram above, S = "1B 1C 4B 1D 2A" and T = "3B 2D".

In this example, the ferryman can accommodate at most six more dwarfs, as indicated by the green squares in the following diagram:



The raft is then balanced: both left and right halves have the same number of dwarfs (four), and both front and back halves have the same number of dwarfs (also four).

Write a function:

class Solution { public int solution(int N, String S, String T); }

that, given the size of the raft N and two strings S, T that describes the positions of barrels and occupied seats, respectively, returns the maximum number of dwarfs that can fit on the raft. If it is not possible to balance the raft with dwarfs, your function should return -1.

For instance, given N = 4, S = "1B 1C 4B 1D 2A" and T = "3B 2D", your function should return 6, as explained above.

Assume that:

N is an even integer within the range [2..26];
strings S, T consist of valid seat numbers, separated with spaces;
each seat number can appear no more than once in the strings;
no seat number can appear in both S and T simultaneously.
In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.

AUTHOR: Boban Micoski
 */

public class Solution60 {
    public static int solution(int N, String S, String T){
        int[][] matrica = new int[N][N];
        S.split(" ");
        int a;
        char b;
        int c;
        int frontSlobodni = 0;
        int backSlobodni = 0;
        int frontDwarfs = 0;
        int backDwarfs = 0;
        int leftSlobodni = 0;
        int leftDwarfs = 0;
        int rightSlobodni = 0;
        int rightDwarfs = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                a = i+1;
                c = (int)'A' +j;
                b = (char)c;
                if(S.contains((Integer.toString(a)+b))){
                    matrica[i][j] = 1;
                }
                else{
                    if(T.contains((Integer.toString(a)+b))){
                        matrica[i][j] = 2;
                    }
                    else{
                    matrica[i][j] = 0;
                    }
                }

            }
        }
        for(int i = 0; i < matrica.length; i++){
            for(int j = 0; j < matrica.length; j++){
                if(i<N/2){
                    if(matrica[i][j] == 0){
                        frontSlobodni++;
                    }
                    else if(matrica[i][j]==2){
                        frontDwarfs++;
                    }
                }
                if(i>=N/2){
                    if(matrica[i][j] == 0){
                        backSlobodni++;
                    }
                    else if(matrica[i][j]==2){
                        backDwarfs++;
                    }
                }
                if(j<N/2){
                    if(matrica[i][j] == 0){
                        leftSlobodni++;
                    }
                    else if(matrica[i][j]==2){
                        leftDwarfs++;
                    }
                }
                if(j>=N/2){
                    if(matrica[i][j] == 0){
                        rightSlobodni++;
                    }
                    else if(matrica[i][j]==2){
                        rightDwarfs++;
                    }
                }
                
            }
        }
        if(frontDwarfs == backDwarfs && leftDwarfs == rightDwarfs){
        int minimumFB = Math.min(frontSlobodni,backSlobodni);
        int minimumLR = Math.min(leftSlobodni, rightSlobodni);
        int minimum = Math.min(minimumFB,minimumLR);
        while(minimum>0){
            boolean pr = proveri(minimum, frontSlobodni, frontDwarfs, backSlobodni, backDwarfs, leftSlobodni, leftDwarfs, rightSlobodni, rightDwarfs);
            if(pr == true){
                return minimum*2;
            }
            else --minimum;
        }
        return -1;
        }
        else{
            if(S.length() == 0){
                return (int)Math.pow(2,N)-(frontDwarfs+backDwarfs);
            }
            else{
                //treba da se smeni za nebalansirano vo while-ot minimumot (primer moze gore da treba 3 strumfa a dole 5 )
                int minimumFB = Math.max(frontSlobodni,backSlobodni);
                int minimumLR = Math.max(leftSlobodni, rightSlobodni);
                int minimum = Math.max(minimumFB,minimumLR);
                while(minimum>0){
                    boolean pr = proveri(minimum, frontSlobodni, frontDwarfs, backSlobodni, backDwarfs, leftSlobodni, leftDwarfs, rightSlobodni, rightDwarfs);
                    if(pr == true){
                        return (minimum*2);
                    }
                    else --minimum;
                }
                return -1;
            }

        }
        
    }
    public static boolean proveri(int broj,int fs,int fd, int bs, int bd, int ls, int ld, int rs, int rd){
        int frontSl = fs-broj;
        int frontDw = fd+broj;
        int backSl = bs-broj;
        int backDw = bd+broj;
        int leftSl = ls-broj;
        int leftDw = ld+broj;
        int rightSl = rs-broj;
        int rightDw = rd+broj;
            if(frontDw == backDw && leftDw == rightDw){
                return true;
            }
            else return false;
        
    }
   
    public static void main(String[] args){
        int n = 4;
        String s = "1B 1C 4B 1D 2A";
        String t = "3B 2D";
        int n1 = 2;
        String s1 = "";
        String t1 = "1B";
        int izlez1 = solution(n1,s1,t1);
       // int izlez = solution(n,s,t);
        //System.out.println(izlez);
        System.out.println(izlez1);
    }
}
