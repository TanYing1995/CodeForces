package CodeForce.Greedy;

import java.io.*;
import java.util.StringTokenizer;

/**
 * https://codeforces.com/contest/1157/problem/C1
 *  1300
 */
public class C1_1157 {
    public static void main(String[] args) {
        Kattio io = new Kattio();
        // Template
        int n = io.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++) nums[i] = io.nextInt();
        int l = 0, r = n-1;
        int val = 0,ans = 0;
        StringBuilder sb = new StringBuilder();
        while(l <= r){
            if(val >= nums[l] && val >= nums[r]) break;
            if(nums[l] <= val && nums[r] > val){
                val = nums[r];
                r--;
                ans++;sb.append("R");
            } else if (nums[r] <= val && nums[l] > val) {
                val = nums[l];
                l++;
                ans++;sb.append("L");
            }else if(val < nums[l] && val < nums[r]){
                if(nums[l] < nums[r]){
                    val = nums[l];
                    l++;
                    ans++;sb.append("L");
                }else if(nums[l] > nums[r]){
                    val = nums[r];
                    r--;
                    ans++;sb.append("R");
                }else{
                    ans++;sb.append("R");
                    r--;
                }
            }
        }
//        System.out.println(l + "  "+ r);
        System.out.println(ans);
        System.out.println(sb.toString());
        io.flush();
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
