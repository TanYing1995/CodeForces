package CodeForce.Greedy;

import java.io.*;
import java.util.StringTokenizer;

/**
 * https://codeforces.com/problemset/problem/1157/C2
 *
 */
public class C2_1157 {
    public static void main(String[] args) {
        Kattio io = new Kattio();
        // Template
        int n = io.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++) nums[i] = io.nextInt();
        StringBuilder sb = new StringBuilder();
        int ans = 0,val = 0;
        int l = 0,r = n-1;
        while(l <= r){
            if(val >= nums[l] && val >= nums[r]) break;
            //讨论一大一小的情况
            if(nums[l] <= val && val < nums[r]){
                val = nums[r];
                r--;ans++;
                sb.append("R");
            } else if (nums[r] <= val && val < nums[l]) {
                val = nums[l];
                l++;ans++;
                sb.append("L");
            } else if (val < nums[l] && val < nums[r]) {
                if(nums[l] < nums[r]){
                    val = nums[l];
                    l++;ans++;
                    sb.append("L");
                }else if(nums[l] > nums[r]){
                    val = nums[r];
                    r--;ans++;
                    sb.append("R");
                }else{
                    //两个边界值相等
                    int lc = 0,rc = 0;
                    //判断从哪个方向取值,从中间值较小的那一侧开始选
                    //此时一定是退出情况，只能从单侧取值，遍历找到最大长度
                    int pre = val;
                    for(int i = l; i <= r && nums[i] > pre; i++){
                            lc++;
                            pre = nums[i];
                    }
                    pre = val;
                    for(int i = r; i >= l && nums[i] > pre; i--){
                            rc++;
                            pre = nums[i];
                    }
                    if(lc > rc){
                        for(int i = 0; i < lc; i++) sb.append("L");
                    }else{
                        for(int i = 0; i < rc; i++) sb.append("R");
                    }
                    ans += Math.max(lc,rc);
                    r = -10;
                }
            }
        }
        System.out.println(ans);
        System.out.println(sb.toString());
        io.flush();
        io.close();
    }

    //计算当前区间内能以
//    static int solve(int[] nums, int l, int r,int val){
//
//    }
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
