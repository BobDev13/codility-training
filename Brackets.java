/*
 * A string S consisting of N characters is considered to be properly nested if any of the following conditions is true:

S is empty;
S has the form "(U)" or "[U]" or "{U}" where U is a properly nested string;
S has the form "VW" where V and W are properly nested strings.
For example, the string "{[()()]}" is properly nested but "([)()]" is not.

Write a function:

class Solution { public int solution(String S); }

that, given a string S consisting of N characters, returns 1 if S is properly nested and 0 otherwise.

For example, given S = "{[()()]}", the function should return 1 and given S = "([)()]", the function should return 0, as explained above.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [0..200,000];
string S is made only of the following characters: '(', '{', '[', ']', '}' and/or ')'.

AUTHOR: Boban Micoski
 */

import java.util.Stack;
public class Solution8 {
    public static int solution(String s){
        Stack<Character> stek = new Stack<Character>();
        int len = s.length();
        char znak;
        int flag = 0;
        for(int i = 0; i < len; i++){
             znak = s.charAt(i);
            if(znak == '(' || znak == '{' || znak == '[' ){
                stek.push(znak);
            }
            else if(znak == ')' || znak == '}' || znak ==']'){
                if(stek.isEmpty()){
                    flag =1;
                    break;
                }
                else{
                    if((stek.peek() == '(' && znak ==')') || (stek.peek() == '{' && znak =='}') || (stek.peek() == '[' && znak ==']')){
                        stek.pop();
                    }
                    else flag =1;
                    break;
                }
            }
        }
        if(flag ==0 && stek.isEmpty()){
            return 1;
        }
        else return 0;
    }
    public static void main(String [] args){
        String s = "([)()]";
        int izlez = solution(s);
        System.out.println(izlez);

    }
}
