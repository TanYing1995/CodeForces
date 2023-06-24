package CodeForce.Dp;

import java.util.*;
import java.io.*;
import java.util.StringTokenizer;

/*
 * https://codeforces.com/problemset/problem/602/B
 * rating : 1400
 */



public class B602 {
    public static void main(String[] args) {
        Kattio io = new Kattio();
        int n = io.nextInt();
        int[] nums = new int[n]; 
        for(int i = 0; i < n; i++) nums[i] = io.nextInt();
        int ans = 1;
        //dp[i][0] 表示以nums[i]作为最小值的最大长度
        //dp[i][1] 表示以nums[i]作为最大值的最大长度
        int[][] dp = new int[n][2];
        dp[0][0] = 1;dp[0][1] = 1;
        for(int i = 1; i < n; i++){
            dp[i][0] = 1;dp[i][1] = 1;
            if(nums[i] == nums[i-1]+1){
                dp[i][1] = dp[i-1][0]+1;
            }
            if(nums[i] == nums[i-1]-1){
                dp[i][0] = dp[i-1][1]+1;
            }
            if(nums[i] == nums[i-1]){
                dp[i][0] = dp[i-1][0]+1;
                dp[i][1] = dp[i-1][1]+1;
            }
            ans = Math.max(ans,Math.max(dp[i][0],dp[i][1]));
        }
        System.out.println(ans);
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
