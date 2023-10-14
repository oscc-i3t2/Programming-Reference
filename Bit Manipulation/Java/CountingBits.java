/*Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.
Example 1:

Input: n = 2
Output: [0,1,1]
Explanation:
0 --> 0
1 --> 1
2 --> 10 */
import java.util.Scanner;
class CountingBits {
    public int[] countBits(int n) {
        int count[]=new int[n+1];
        for(int i=1;i<=n;i++)
        count[i]=count[i/2]+(i%2==0?0:1);
        return count;
    }
    public static void main(String[] args)
    {
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter n=");
        int n=sc.nextInt();
        CountingBits obj=new CountingBits();
        int result[]=obj.countBits(n);
        for(int i=0;i<result.length;i++)
        System.out.println(result[i]);
        sc.close();
    }
}