package CodeForce.Dp;


import java.io.*;
import java.util.StringTokenizer;

/**
 * https://codeforces.com/problemset/problem/1081/C
 * DP 1500
 */
public class C1081 {
    static final int MOD = 998244353;

    public static void main(String[] args) {
        Kattio io = new Kattio();
        // Template
        int n = io.nextInt();
        int m = io.nextInt();
        int k = io.nextInt();
        long[][] dp = new long[n][k+1];

        for(int i = 0; i < n ; i++){
            dp[i][0] = m;
        }

        for(int i = 1; i < n; i++){
            for(int j = 1; j <= k; j++){
                dp[i][j] = (dp[i-1][j]+(dp[i-1][j-1]%MOD*(m-1)%MOD)%MOD + MOD)% MOD;
            }
        }
        System.out.println(dp[n-1][k]);
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
