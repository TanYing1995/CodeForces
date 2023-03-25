package CodeForce;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class P5C {
    public static void main(String[] args) {
        Kattio io = new Kattio();
        String s = io.next();
        int n = s.length();
        Deque<int[]> stack = new ArrayDeque<>();
        int[] pair = new int[n];
        int len = 0;int ans = 0;
        for(int i = 0; i < n; i++){
            int[] cur = new int[2];
            cur[0] = s.charAt(i) == '(' ? 1 : -1;
            cur[1] = i;
            if(stack.isEmpty()){
                stack.push(cur);
            }
            else{
                int[] top = stack.peek();
                if(top[0] == 1 && cur[0] == -1){
                    pair[top[1]] = i;//记录下左侧括号的匹配右侧索引
                    stack.pop();
                }
                else{
                    stack.push(cur);
                }
            }
        }
        for(int i = 0; i < n;){
            int sum = 0;
            while(i < n && pair[i] != 0){
                sum += (pair[i]-i+1);
                i = pair[i]+1;
            }
            if(sum == len){
                ans++;
            }
            else if(sum > len){
                len = sum;
                ans=1;
            }
            i++;
        }
        if(len != 0)
            System.out.println(len+" "+ans);
        else
            System.out.println(0+" "+1);
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
