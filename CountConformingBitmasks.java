/*In this problem we consider unsigned 30-bit integers, i.e. all integers B such that 0 ≤ B < 230.

We say that integer A conforms to integer B if, in all positions where B has bits set to 1, A has corresponding bits set to 1.

For example:

00 0000 1111 0111 1101 1110 0000 1111(BIN) = 16,244,239 conforms to
00 0000 1100 0110 1101 1110 0000 0001(BIN) = 13,032,961, but
11 0000 1101 0111 0000 1010 0000 0101(BIN) = 819,399,173 does not conform to
00 0000 1001 0110 0011 0011 0000 1111(BIN) = 9,843,471.
Write a function:

class Solution { public int solution(int A, int B, int C); }

that, given three unsigned 30-bit integers A, B and C, returns the number of unsigned 30-bit integers conforming to at least one of the given integers.

For example, for integers:

A = 11 1111 1111 1111 1111 1111 1001 1111(BIN) = 1,073,741,727,
B = 11 1111 1111 1111 1111 1111 0011 1111(BIN) = 1,073,741,631, and
C = 11 1111 1111 1111 1111 1111 0110 1111(BIN) = 1,073,741,679,
the function should return 8, since there are 8 unsigned 30-bit integers conforming to A, B or C, namely:

11 1111 1111 1111 1111 1111 0011 1111(BIN) = 1,073,741,631,
11 1111 1111 1111 1111 1111 0110 1111(BIN) = 1,073,741,679,
11 1111 1111 1111 1111 1111 0111 1111(BIN) = 1,073,741,695,
11 1111 1111 1111 1111 1111 1001 1111(BIN) = 1,073,741,727,
11 1111 1111 1111 1111 1111 1011 1111(BIN) = 1,073,741,759,
11 1111 1111 1111 1111 1111 1101 1111(BIN) = 1,073,741,791,
11 1111 1111 1111 1111 1111 1110 1111(BIN) = 1,073,741,807,
11 1111 1111 1111 1111 1111 1111 1111(BIN) = 1,073,741,823.
Write an efficient algorithm for the following assumptions:

A, B and C are integers within the range [0..1,073,741,823].

AUTHOR: Boban Micoski
*/

public class Solution59 {
    public static int conformingCount(String number){
        int brojac = 0;
        for(int i = 0; i < number.length(); i++){
            if(number.charAt(i) == '0'){
                brojac++;
            }
        }
        brojac+=30-number.length();
        return (int)Math.pow(2,brojac);
    }
    public static int solution(int A, int B, int C){
        String a = Integer.toBinaryString(A);
        String b = Integer.toBinaryString(B);
        String c = Integer.toBinaryString(C);
        String ab = Integer.toBinaryString(A|B);
        String ac = Integer.toBinaryString(A|C);
        String bc = Integer.toBinaryString(B|C);
        String abc = Integer.toBinaryString(A|B|C);
        System.out.println("gi sobirame: 2 na stepen brojac na nuli za prviot, vtoriot i tretiot broj 2na2 + 2na2 +2na2 = 4+4+4=12");
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println("**********odzemame: 2 na stepen brojac na nuli: 2na1=2 + 2na0=1 + 2na1=2 vkupno 2+1+2=5 t.e 12-5 =7");
        System.out.println(ab);
        System.out.println(ac);
        System.out.println(bc);
        System.out.println("******* dodavame: 2 na stepen brojac na nuli: 2na0 =1 t.e 7+1=8");
        System.out.println(abc);
        int vkupno = 0;
        vkupno = conformingCount(a) + conformingCount(b) + conformingCount(c);
        vkupno -=conformingCount(ab) + conformingCount(ac) + conformingCount(bc);
        vkupno+=conformingCount(abc);
        return vkupno;
    }

    public static void main(String[] args){
        int a = 1073741727;
        int b = 1073741631;
        int c = 1073741679;
        int izlez = solution(a,b,c);
        System.out.println(izlez);

    }
    
}
