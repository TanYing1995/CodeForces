package CodeForce.Dp;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://codeforces.com/contest/1272/problem/D
 * dp 1500
 */
public class D1272 {
    public static void main(String[] args) {
        Kattio io = new Kattio();
        // Template
        int n = io.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){nums[i] = io.nextInt();}
        //dp[i] 以nums[i]结尾的最长子数组长度
        int ans = 1;
        int[] l = new int[n];l[0] = 1;
        //不删除元素时的最大递增子数组长度
        int[] r = new int[n];r[n-1] = 1;
        for(int i = 1; i < n; i++){
            l[i] = (nums[i] > nums[i-1] ? l[i-1]+1 : 1);
            ans = Math.max(ans, l[i]);
            r[n-i-1] = (nums[n-i-1] < nums[n-i] ? r[n-i]+1 : 1);
        }
        //删除一个元素,删除的元素从[1,n-2]选择,从首尾删掉元素肯定不会优于不删除元素取得的结果
        for(int i = 1; i < n-1; i++){
            if(nums[i-1] < nums[i+1])
                ans = Math.max(ans,l[i-1]+r[i+1]);
        }
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
