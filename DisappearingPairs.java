/*A string S containing only the letters "A", "B" and "C" is given. The string can be transformed by removing one occurrence of  "AA", "BB" or "CC".

Transformation of the string is the process of removing letters from it, based on the rules described above. As long as at least one rule can be applied, the process should be repeated. If more than one rule can be used, any one of them could be chosen.

Write a function:

class Solution { public String solution(String S); }

that, given a string S consisting of N characters, returns any string that can result from a sequence of transformations as described above.

For example, given string S = "ACCAABBC" the function may return "AC", because one of the possible sequences of transformations is as follows:



Also, given string S = "ABCBBCBA" the function may return "", because one possible sequence of transformations is:



Finally, for string S = "BABABA" the function must return "BABABA", because no rules can be applied to string S.

Write an efficient algorithm for the following assumptions:

the length of string S is within the range [0..50,000];
string S is made only of the following characters: 'A', 'B' and/or 'C'. 

AUTHOR: Boban Micoski
*/

import java.util.Stack;
public class Solution50 {
    public static String solution(String S){
        Stack<Character> stek = new Stack<Character>();
        if(S.length() == 0 || S.charAt(0)==' '){
            return "";
        }
        stek.push(S.charAt(0));
        String izlez = "";
        String kraj = "";
        
        for(int i = 1; i < S.length(); i++){
            if(!stek.isEmpty() && S.charAt(i) == stek.peek() ){
                stek.pop();
            }
            else{
                stek.push(S.charAt(i));
            }
        }
        if(stek.isEmpty()){
            return "";
        }
        while(!stek.isEmpty()){
            izlez+=stek.pop();
        }
        for(int i = izlez.length()-1; i!= 0; i--){
            kraj+=izlez.charAt(i);
        }
        kraj+=izlez.charAt(0);
        return kraj;
    }   
    public static void main(String[] args){
        String zbor = " ";
        String iz = solution(zbor);
        System.out.println(iz);
    }
    
}
