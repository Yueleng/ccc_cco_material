/**
 * CCC 2013 Senior 5: Factor Solitaire
 * 
 * The method is RIDICULOUSLY simple. Work BACKWARDS from the number.
 * 
 * How did I think of this?
 * 
 * The straight forward method of factoring completely 
 * all numbers up to 5,000,000 is simply too slow.
 * 
 * I studied the examples given. The numbers along the way to 
 * the solution looked totally random. Why choose those ones?
 * There was no obvious answer. Eg why go from 60 to 61 from huge cost
 * when one was so far from the end point?
 * 
 * I used my first program and printed the minimum cost for all #s up to 100.
 * Very quicly I noticed that the powers of 2 were VERY cheap. So too were 
 * the numbers between them. Could I use some sort of modified binary search
 * system to get to my number? A few example cases proved this didn't work.
 * 
 * I returned to the 2013 example. I noticed that when I factored the 
 * last number (2013 = 3 * 671). I got numbers that were added to get 
 * from 1342 to 2013. Why would that even work?
 * 
 * If you factor a number, SUBSTRACT one of the factors, what guarantee was 
 * there that you'd end up on a number that also had those factors? (So you 
 * could add them and get back to the first.) That was NOT at all obvious to me.
 * That's why my score on the contest would be about 30 and not 75 :-)
 * 
 * Okay, so 2013 has a factor of 671, what makes you think that the number 
 * (1342 = 2013 - 671) would also have a factor of 671? (and even if this was,
 * why would this be the minimum cost route to the number?)
 * 
 * ANSWER: multiplication means repeated addition!
 * Since 2013 = 3 * 671, if you substract 671 you are left with 2%671 or 1342
 * This DOES have the same factor (671)! AND you get it at a minimum cost.
 * 
 * Repeat the process till you're back to 1 [QED]
 * 
 * The only fly in the ointment is when you hit a prime.
 * You can't go back from there as there are no factors, so subtract 1 
 * (at a huge cost) and keep going.
 * 
 * Here's a trace for N = 15
 * 
 * N        factors    what_to_substract       new N   newN_factors        cost
 * 15         3 * 5           5                 10         2 * 5             2
 * 10          2*5            5                 5          1 * 5           2 + 1 = 3
 * 5          prime!          1                 4          4 * 1           3 + 4 = 7
 * 4          2 * 2           2                 2          1 * 2           7 + 1 = 8
 * 2          prime!          1                 1          1 * 1           8 + 1 = 9
 * 1
 * 
 * 
 * min(15) = 9
 * 
 * Left to prove that the procedure does give the MIN cost.
 * Any Hint?
 */

import java.io.*;
public class FactorSolitaire {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int cost = 0;
        
        while (num > 1) {
            int r = (int) Math.round(Math.sqrt(num));
        
            int f = 2;
            while (f <= r && num % f != 0) {
                f += 1;
            }
            
            if (f < num && num % f == 0) {
                int q = f;
                int p = num / q;   // q < p. and p * q == num
                num -= p;
                cost += q - 1;
                // System.out.println(f);
            } else {
                num -= 1;
                cost += num;
                // System.out.println(num);
            }
        }
        System.out.println(cost);
    }
}
