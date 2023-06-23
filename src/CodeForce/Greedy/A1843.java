package Greedy;

import java.util.*;
import java.io.*;
import java.util.StringTokenizer;

/*
 * https://codeforces.com/contest/1843/problem/A
 *  
 *  greedy sort
 */


public class A1843 {
    public static void main(String[] args) {
        Kattio io = new Kattio();
        //这是一个输入输出模板
        int t = io.nextInt();
        StringBuilder sb = new StringBuilder();
        while(t-- > 0){
            int n = io.nextInt();
            Integer[] nums = new Integer[n];
            for(int i = 0; i < n; i++) nums[i] = io.nextInt();
            if(n == 1){
                sb.append(0).append("\n");
            }else{
                Arrays.sort(nums);
                int l = 0, r = n-1;
                int ans = 0;
                while(r > l){
                    ans += (nums[r--]-nums[l++]);
                }
                sb.append(ans).append("\n");
            }
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
