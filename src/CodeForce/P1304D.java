package CodeForce;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class P1304D {
    public static void main(String[] args) {
        Kattio io = new Kattio();
        int t = io.nextInt();
        while(t-- > 0){
            int n = io.nextInt();
            String s = io.next();
            //构造LIS最短的数组
            int[] mi = new int[n];
            int p = 1;
            int[] prev = new int[n-1];//找到上一个>结束的位置idx，idx+1即为可以开始填充的地方
            for(int i = 0; i < n-1; i++){
                if(i == 0)
                    prev[i] = s.charAt(i) == '>' ? 0 : -1;
                else
                    prev[i] = s.charAt(i) == '>' ? i : prev[i-1];
            }
            //从右往左遍历，从左向右填充
            for(int i = n-2;i >= 0;i--){

                    int idx = prev[i];//当前元素的最左侧的>的位置
                    for(int j = idx+1; j <= i && mi[j] == 0; j++){
                        mi[j] = p++;
                    }

            }
            for(int i = n-1; i >= 0; i--){
                if(mi[i] == 0) mi[i] = p++;
            }
            StringBuilder ans1 = new StringBuilder();
            for(int i = 0; i < n; i++){
                ans1.append(mi[i]).append(" ");
            }
            //构造LIS最长的数组
            int[] mx = new int[n];

            //从后往前填充,从上一个 < 符号开始的地方开始递减填值
            int[] prec = new int[n-1];//上一个<的位置
            for(int i = 0; i < n-1; i++){
                if(i == 0)
                    prec[i] = s.charAt(i) == '<' ? i : -1;
                else
                    prec[i] = s.charAt(i) == '<' ? i : prec[i-1];
            }

            p = n;
            for(int i = n-2; i >= 0; i--){
                    if(i == n-2 && s.charAt(i) == '<') {
                        mx[i+1] = p--;
                        continue;
                    }
                    int idx = prec[i];//找到上一个<结束的位置idx，idx+1即为可以开始填充的地方
                    for(int j = idx+1; j <= i && mx[j] == 0; j++){
                        mx[j] = p--;
                    }
            }

            p = 1;
            for(int i = 0; i < n; i++){
                if(mx[i] == 0) mx[i] = p++;
            }
            StringBuilder ans2 = new StringBuilder();
            for(int i = 0; i < n; i++){
                ans2.append(mx[i]).append(" ");
            }
            System.out.println(ans1.toString());
            System.out.println(ans2.toString());
        }
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
