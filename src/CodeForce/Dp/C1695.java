package CodeForce.Dp;

import java.io.*;
import java.util.*;

/***
* @Author: tanying
* @Date: 2023/9/14
* @Description: https://codeforces.com/contest/1695/problem/C
* @Param: 
 * @param null
* @return: 
*/

public class C1695 {
    public static void main(String[] args) {
        Kattio io = new Kattio();
        int t = io.nextInt();
        while(t-- > 0){
            int n = io.nextInt();int m = io.nextInt();
            int[][] mat = new int[n][m];
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    mat[i][j] = io.nextInt();
                }
            }
            int[][][] dp = new int[n][m][2];
            dp[0][0][0] = mat[0][0];dp[0][0][1] = mat[0][0];
            for(int i = 1; i < n; i++){
                dp[i][0][0] = dp[i-1][0][0]+mat[i][0];
                dp[i][0][1] = dp[i-1][0][1]+mat[i][0];
            }
            for(int j = 1;j < m; j++){
                dp[0][j][0] = dp[0][j-1][0]+mat[0][j];
                dp[0][j][1] = dp[0][j-1][1]+mat[0][j];
            }
            for(int i = 1;i < n; i++){
                for(int j = 1; j < m; j++){
                    dp[i][j][0] = Math.max(dp[i-1][j][0],dp[i][j-1][0])+mat[i][j];//最大值转移
                    dp[i][j][1] = Math.min(dp[i-1][j][1],dp[i][j-1][1])+mat[i][j];//最小值转移
                }
            }
            int a = dp[n-1][m-1][0],b = dp[n-1][m-1][1];
            //System.out.println(a);
            //System.out.println(b);
            if(b <= 0 && a >= 0)
                if((b%2 == 0) || (a%2 == 0))
                    System.out.println("YES");
                else
                    System.out.println("NO");
            else
                System.out.println("NO");
        }
        io.close();
    }

    static class Kattio extends PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;
        // 标准 IO
        public Kattio() { this(System.in, System.out); }
        public Kattio(InputStream i, OutputStream o) {
            super(o);
            r = new BufferedReader(new InputStreamReader(i));
        }
        // 文件 IO
        public Kattio(String intput, String output) throws IOException {
            super(output);
            r = new BufferedReader(new FileReader(intput));
        }
        // 在没有其他输入时返回 null
        public String next() {
            try {
                while (st == null || !st.hasMoreTokens())
                    st = new StringTokenizer(r.readLine());
                return st.nextToken();
            } catch (Exception e) {}
            return null;
        }
        public int nextInt() { return Integer.parseInt(next()); }
        public double nextDouble() { return Double.parseDouble(next()); }
        public long nextLong() { return Long.parseLong(next()); }
    }
}