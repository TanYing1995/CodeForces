package CodeForce.Dp;

import java.io.*;
import java.util.StringTokenizer;

/**
* @Author: tanying
* @Date: 2023/8/18
* @Description: https://atcoder.jp/contests/abc253/tasks/abc253_e
* @Param: Score: 1073
 * @param
* @return:
*/

public class ABC_253E{
    public static void main(String[] args) {
        Kattio io = new Kattio();
        int n = io.nextInt();
        int m = io.nextInt();
        int k = io.nextInt();
        int MOD = 998244353;
        //dp[i][j] : 长为i,且最后的元素 <= j的方案总数
        long[][] dp = new long[n+1][m+1];
        for(int i = 1; i <= m; i++) dp[1][i] = dp[1][i-1]+1;
        for(int i = 2; i <= n; i++){
            for(int j = 1; j <= m; j++){
                int l = j > k ? j-k : 0;
                int r = Math.min(j+k-1,m);
                if(k > 0) dp[i][j] = (dp[i][j-1] + dp[i-1][m]-(dp[i-1][r]-dp[i-1][l])+MOD)%MOD;
                else dp[i][j] = (dp[i][j-1]+dp[i-1][m]+MOD)%MOD;
            }
        }
        System.out.println(dp[n][m]);
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


