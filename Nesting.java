/*
 * A string S consisting of N characters is called properly nested if:

S is empty;
S has the form "(U)" where U is a properly nested string;
S has the form "VW" where V and W are properly nested strings.
For example, string "(()(())())" is properly nested but string "())" isn't.

Write a function:

class Solution { public int solution(String S); }

that, given a string S consisting of N characters, returns 1 if string S is properly nested and 0 otherwise.

For example, given S = "(()(())())", the function should return 1 and given S = "())", the function should return 0, as explained above.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [0..1,000,000];
string S is made only of the characters '(' and/or ')'.

AUTHOR: Boban Micoski
 */

import java.util.Stack;
public class Solution9 {
    public static int solution(String S){
        Stack<Character> stek = new Stack<Character>();
        char znak;
        int len = S.length();
        int flag = 0;
        for(int i = 0; i < len; i++){
            znak = S.charAt(i);
            if(znak == '('){
                stek.push(znak);
            }
            else{
                if(znak == ')' && stek.isEmpty()){
                    flag =1;
                    break;
                }

                else if(znak == ')' && stek.peek() == '('){
                    stek.pop();
                }
            }
        }
        if(flag == 0 && stek.isEmpty()){
            return 1;
        }
        else return 0;
    }
    
    public static void main(String[] args){
        String s = "(()(())())";
        String s1 = "())";
        String s2 = "VW";
        int izlez = solution(s);
        int izlez1 = solution(s1);
        int izlez2 = solution(s2);
        System.out.println(izlez);
        System.out.println(izlez1);
        System.out.println(izlez2);
    }
}
