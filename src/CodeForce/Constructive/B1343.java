package Constructive;

import java.util.ArrayList;
import java.util.Scanner;

public class B1343 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        //List<Integer> = new ArrayList<>();
        while(t-- > 0){
            long n = sc.nextLong();
            long[] ans = new long[(int)n+1];
            long sum = (n/2+1)*(n/2);
            long tt = (n/2)*(n/2);
            System.out.println(sum);
            System.out.println(tt);
            //String str = new String();
            for(int i = 1; i <= n/2; i++)
            {
                ans[i] = 2*i;
            }

            for(int i = 1; i <= n/2; i++){
                //sum -= (2*i-1);
                ans[i+(int)n/2] = 2*(i)-1;
            }
            sum = sum - tt;
            //int y = get(x);
            if(sum < 0 || (sum%2 == 1))
            {
                System.out.println("NO");
            }
            else
                {
                ans[(int)n] += (sum);
                System.out.println("YES");
//              for(int i = 1; i <= n; i++){
//                    System.out.print(ans[i] + " ");
//              }
                System.out.println();
                System.out.println(ans[(int)n]);
            }
        }
    }

    int get(int x){
        return x;
    }

}
