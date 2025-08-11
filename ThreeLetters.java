/*Write a function solution that, given two integers A and B, returns a string containing exactly A letters 'a' and exactly B letters 'b' with no three consecutive 
letters being the same (in other words, neither "aaa" nor "bbb" may occur in the returned string).

Examples:

1. Given A = 5 and B = 3, your function may return "aabaabab". Note that "abaabbaa" would also be a correct answer. Your function may return any correct answer.

2. Given A = 3 and B = 3, your function should return "ababab", "aababb", "abaabb" or any of several other strings.

3. Given A = 1 and B = 4, your function should return "bbabb", which is the only correct answer in this case.

Assume that:

A and B are integers within the range [0..100];
at least one solution exists for the given A and B.
In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment. 

AUTHOR: Boban Micoski
*/
public class Solution45 {
    public static String solution(int A, int B){
        String izlez = "";
        if(A >= B){
            while(A !=0 || B !=0){
                if(A>=2){
                    izlez+="aa";
                    A-=2;
                }
                if(B>=2){
                    izlez+="bb";
                    B-=2;
                }
                if(A ==1 && izlez.endsWith("b")){
                    izlez+="a";
                    A--;
                }
                if(B==1 && izlez.endsWith("a")){
                    izlez+="b";
                    B--;
                }
            }
        }
        else{
            while(A !=0 || B !=0){
                if(B>=2){
                    izlez+="bb";
                    B-=2;
                }
                if(A>=2){
                    izlez+="aa";
                    A-=2;
                }
                if(B ==1 && izlez.endsWith("a")){
                    izlez+="b";
                    B--;
                }
                if(A==1 && izlez.endsWith("b")){
                    izlez+="a";
                    A--;
                }
            }

        }
        return izlez;
    }
    public static void main(String[] args){
        String izlez1 = solution(5,3);
        String izlez2 = solution(3,3);
        String izlez3 = solution(1,4);
        System.out.println(izlez1);
        System.out.println(izlez2);
        System.out.println(izlez3);

    }
    
}
