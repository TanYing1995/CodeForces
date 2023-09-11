package CodeForce.Dp;

import java.io.*;
import java.util.*;


 /**
 * @Author: tanying
 * @Date: 2023/9/11
 * @Description: https://atcoder.jp/contests/abc248/tasks/abc248_c
 * @Param: 
  * @param null
 * @return: 
 */

public class C248 {
    public static void main(String[] args) {
        Kattio io = new Kattio();
        int n = io.nextInt();
        int m = io.nextInt();
        int k = io.nextInt();
        long ans = 0L;
        int mod = 998244353;
        long[][] dp = new long[n+1][k+1];
        for(int i = 1; i <= k; i++) dp[1][i] = i;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= k; j++) {

            }
        }
        System.out.println(ans);
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


