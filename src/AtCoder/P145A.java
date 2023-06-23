package AtCoder.ARC;

import java.io.*;
import java.util.StringTokenizer;

public class P145A {
    public static void main(String[] args) {
        Kattio io = new Kattio();
        int n = io.nextInt();
        String s = io.next();
        if(n == 2){
            if(s.charAt(0) == s.charAt(1))
                System.out.println("Yes");
            else
                System.out.println("No");
        }
        else{
            char a = s.charAt(0);
            char b = s.charAt(n-1);
            if(a == 'A' && b == 'B')
                System.out.println("No");
            else
                System.out.println("Yes");
        }
        io.close();
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
