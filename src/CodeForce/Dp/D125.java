package CodeForce.Dp;

import java.io.*;
import java.util.StringTokenizer;

/**
 *  https://atcoder.jp/contests/abc125/tasks/abc125_d
 */


public class D125 {
    public static void main(String[] args) {
        Kattio io = new Kattio();
        int n = io.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = io.nextInt();
        }
        long[][] dp = new long[n+1][2];
        dp[2][0] = nums[0]+nums[1]; dp[2][1] = -dp[2][0];
        for (int i = 3; i <= n; i++) {
            //当前值没反转的最大值
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1])+nums[i-1];
            //反转后的最大值
            dp[i][1] = Math.max(dp[i-1][0]-nums[i-1]-2*nums[i-2],dp[i-1][1]+2*nums[i-2]-nums[i-1]);
        }
        System.out.println(Math.max(dp[n][0],dp[n][1]));
        io.flush();
    }

    static class Kattio extends PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;

        // 标准 IO
        public Kattio() {
            this(System.in, System.out);
        }

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
            } catch (Exception e) {
            }
            return null;
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}


