package CodeForce;

import java.util.*;
import java.io.*;
import java.util.StringTokenizer;

public class P1833B {
    public static void main(String[] args) {
        Kattio io = new Kattio();
        //这是一个输入输出模板
        int t = io.nextInt();
        StringBuilder sb = new StringBuilder();
        while(t-- > 0){
            int n = io.nextInt();
            int k = io.nextInt();
            Integer[] a = new Integer[n];
            Integer[] b = new Integer[n];
            Integer[] idx = new Integer[n];
            for(int i = 0; i < n; i++) {
                a[i] = io.nextInt();
                idx[i] = i;
            }
            for(int i = 0; i < n; i++) b[i] = io.nextInt();
            Arrays.sort(b);
            Arrays.sort(idx,(i,j) -> a[i]-a[j]);
            int[] c = new int[n];
            for(int i = 0; i < n; i++){
                c[idx[i]] = b[i]; 
            }
            for(int i = 0; i < n; i++){
                sb.append(c[i]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
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
