/*TASK:
A binary gap within a positive integer N is any maximal sequence of consecutive zeros that is surrounded by ones at both ends in the binary representation of N.

For example, number 9 has binary representation 1001
content_copy
 and contains a binary gap of length 2. The number 529 has binary representation 1000010001
content_copy
 and contains two binary gaps: one of length 4 and one of length 3. The number 20 has binary representation 10100
content_copy
 and contains one binary gap of length 1. The number 15 has binary representation 1111
content_copy
 and has no binary gaps. The number 32 has binary representation 100000
content_copy
 and has no binary gaps.

Write a function:

class Solution { public int solution(int N); }
content_copy

that, given a positive integer N, returns the length of its longest binary gap. The function should return 0 if N doesn't contain a binary gap.

For example, given N = 1041 the function should return 5, because N has binary representation 10000010001
content_copy
 and so its longest binary gap is of length 5. Given N = 32 the function should return 0, because N has binary representation '100000' and thus no binary gaps.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..2,147,483,647]. 

AUTHOR: Boban Micoski
*/

class Solution{
	public static int solution(int N){
		int brojac = 0;
		int flag = 0;
		int maksimum = 0;
		String bin = Integer.toBinaryString(N);
		for(int i = 0; i < bin.length(); i++){
			if(bin.charAt(i) == '1'){
				if(brojac != 0){
					if(brojac > maksimum){ 
						maksimum = brojac;
						brojac = 0;
					}
					else{ brojac = 0;
					}
				}
				flag = 1;
			}
			else if(bin.charAt(i) == '0' && flag == 1){
				brojac++;
			}
		}
		return maksimum;
	}
	public static void main(String[] args){
		int br = 15;
		int izlez = solution(br);
		System.out.println(izlez);
	}
}