package Greedy;

import java.util.*;
import java.io.*;


/*
 * https://codeforces.com/contest/1843/problem/B
 * 
 * greedy 
 */

public class B1843 {
    public static void main(String[] args) {
        Kattio io = new Kattio();
        //这是一个输入输出模板
        int t = io.nextInt();
        StringBuilder sb = new StringBuilder();
        while(t-- > 0){
            int n = io.nextInt();
            Long[] nums= new Long[n];
            long sum = 0;
            List<Long> list = new ArrayList<>(); 
            for(int i = 0; i < n; i++) {
                nums[i] = io.nextLong();
                sum += (nums[i] > 0 ? nums[i] : -nums[i]);
                if(nums[i] != 0) list.add(nums[i]);
            }
            //dp[i]:到第i个数前面包含多少段只有小于0的段
            int ans = 0;
            int[] dp = new int[list.size()];
            if(!list.isEmpty()) dp[0] = list.get(0) < 0 ? 1 : 0;
            for(int i = 1; i < list.size(); i++){
                if(list.get(i) > 0){
                    dp[i] = dp[i-1];
                }else{
                    if(list.get(i-1) < 0)
                        dp[i] = dp[i-1];
                    else
                        dp[i] = dp[i-1]+1;
                }
            }
            ans = list.isEmpty() ? 0 : dp[list.size()-1];
            sb.append(sum).append(" ");
            sb.append(ans).append("\n");
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
