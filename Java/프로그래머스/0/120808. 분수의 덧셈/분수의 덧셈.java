class Solution {  
    public static int gcd(int p, int q) {
	    if (q == 0) return p;
	    return gcd(q, p%q);
    }
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int numer = numer1 * denom2 + denom1 * numer2;
        int denom = denom1 * denom2;
        int gcdValue = gcd(numer, denom);
        int[] answer = { numer / gcdValue, denom / gcdValue };
        return answer;
    }
}