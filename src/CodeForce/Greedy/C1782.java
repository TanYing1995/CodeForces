package CodeForce.Greedy;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *  https://codeforces.com/problemset/problem/1728/C
 *  1400
 */

public class C1782{
    public static void main(String[] args) {
        Kattio io = new Kattio();
        int t = io.nextInt();
        while(t-- > 0){
            int n = io.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            int ans = 0;
            for(int i = 0; i < n; i++) a[i] = io.nextInt();
            for(int i = 0; i < n; i++) b[i] = io.nextInt();
            Arrays.sort(a);
            Arrays.sort(b);
            int i = 0, j = 0;
            //先处理相同对
            while(i < n && j < n){
                if(a[i] == b[j]){
                    a[i++] = -1;
                    b[j++] = -1;
                }else{
                    if(a[i] > b[j]){
                        j++;
                    }else{
                        i++;
                    }
                }
            }
            int[] cnt_a = new int[10];
            int[] cnt_b = new int[10];
            for(int k = 0; k < n; k++){
                if(a[k] > 9){
                    cnt_a[len(a[k])]++;
                    ans++;
                }else if(a[k] > 0){
                    cnt_a[a[k]]++;
                }
                if(b[k] > 9){
                    cnt_b[len(b[k])]++;
                    ans++;
                }else if(b[k] > 0){
                    cnt_b[b[k]]++;
                }
            }
            for(int k = 2; k < 10; k++){
                ans += Math.abs(cnt_a[k]-cnt_b[k]);
            }
            System.out.println(ans);
        }
        io.flush();
    }

    static int len(int a){
        int sum = 0;
        while(a != 0){
            a /= 10;
            sum++;
        }
        return sum;
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


