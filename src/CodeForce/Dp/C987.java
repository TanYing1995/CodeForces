package CodeForce.Dp;

import java.io.*;
import java.util.StringTokenizer;

/**
 * https://codeforces.com/problemset/problem/987/C
 *  1500
 */

public class C987 {
    public static void main(String[] args) {
        Kattio io = new Kattio();
        // Template
        int n = io.nextInt();
        int[] a = new int[n],b = new int[n];
        for(int i = 0; i < n; i++) a[i] = io.nextInt();
        for(int i = 0; i < n; i++) b[i] = io.nextInt();
        long ans = Long.MAX_VALUE;
        //枚举j，遍历i,k更新最小值
        for(int j = 1; j < n-1; j++){
            long t = b[j];
            int lmin = Integer.MAX_VALUE;
            for(int i = j-1; i >= 0; i--){
                if(a[i] < a[j]){
                    lmin = Math.min(lmin,b[i]);
                }
            }
            int rmin = Integer.MAX_VALUE;
            for(int k = j+1; k < n; k++){
                if(a[j] < a[k]){
                    rmin = Math.min(rmin,b[k]);
                }
            }
            if(lmin != Integer.MAX_VALUE && rmin != Integer.MAX_VALUE){
                t += (lmin+rmin);
                ans = Math.min(ans,t);
            }
        }
        ans = ans == Long.MAX_VALUE ? -1 : ans;
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
