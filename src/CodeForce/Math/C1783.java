

import java.util.*;
import java.io.*;
import java.util.StringTokenizer;

/*
 * https://codeforces.com/problemset/problem/1738/C
 */

public class C1783 {
    public static void main(String[] args) {
        Kattio io = new Kattio();
        //这是一个输入输出模板
        int t = io.nextInt();
        StringBuilder sb = new StringBuilder();
        while(t-- > 0){
            int n = io.nextInt();
            int[] nums = new int[n];
            int a = 0, b = 0;
            for(int i = 0; i < n; i++) {    
                int v = io.nextInt();
                if(v%2 == 0) a++;
                else b++;
            }
            String res = "";
            if(b%4 == 2){
                res = "Bob";
            }else if(b%4 == 3){
                res = "Alice";
            }else if(b%4 == 0){
                res = "Alice";
            }else if(a%2 == 1){
                res = "Alice";
            }else{
                res = "Bob";
            }
            sb.append(res).append("\n");
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
