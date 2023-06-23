package AtCoder.ARC;

import java.io.*;
import java.util.StringTokenizer;

public class P119B {
    public static void main(String[] args) {
        Kattio sc = new Kattio();
        int n = sc.nextInt();
        String s = sc.next();
        String t = sc.next();
        int x = 0; for(int i = 0; i < n; i++) x += (s.charAt(i) == '1' ? 1 : 0);
        int y = 0; for(int i = 0; i < n; i++) y += (t.charAt(i) == '1' ? 1 : 0);
        if(x != y){
            System.out.println(-1);
        }
        else{
            int ans = 0;
            int l = 0, r = 0;
            while(l < n && r < n){
                while(l < n && s.charAt(l) == '1') l++;
                while(r < n && t.charAt(r) == '1') r++;
                if(l != r){
                    ans += 1;
                }
                l++;
                r++;
            }
            System.out.println(ans);
        }
        sc.close();
    }

    public static class Kattio extends PrintWriter {
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

