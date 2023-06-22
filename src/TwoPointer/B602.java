package TwoPointer;

import java.util.*;
import java.io.*;

/*
 * https://codeforces.com/problemset/problem/602/B
 * rating : 1400
 * accept
 */

public class B602 {
    public static void main(String[] args) {
        Kattio io = new Kattio();
        int n = io.nextInt();
        int[] nums = new int[n]; 
        for(int i = 0; i < n; i++) nums[i] = io.nextInt();

        int mx = nums[0];
        int mi = mx;
        int[] cnt = new int[100001]; 
        int l = 0, r = 0;
        int ans = 1;
        //保证窗口之内只有两个数
        while(r < n){
            cnt[nums[r]]++;//新加入的元素
            if(nums[r] != mx && nums[r] != mi){
                if(nums[r] == mx+1){
                    //调整到最小值个数为0
                    if(mx == mi) {
                        mx = nums[r];
                        //System.out.println("......");    
                    }
                    else{
                        // System.out.println("-------");
                        // System.out.println(mi + " / "+ cnt[mi]);
                        while(cnt[mi] > 0){
                        //移动左指针
                            cnt[nums[l]]--;
                            l++;
                            //System.out.println("-------");
                        }
                        //cnt[mi] = 0;//清楚更小值
                        mi = cnt[mx] > 0 ? mx : nums[r];
                        mx = nums[r];
                    }
                }else if(nums[r] == mi-1){
                    if(mx == mi) {
                        mi = nums[r];
                    }else{
                        while(cnt[mx] > 0){
                            cnt[nums[l]]--;
                            l++;
                        }
                        mx = cnt[mi] > 0 ? mi : nums[r];
                        mi = nums[r];
                    }
                }else{ 
                    //移动指针
                    cnt[mx] = 0;
                    cnt[mi] = 0;
                    l = r;
                    mx = nums[r];
                    mi = mx;
                    cnt[mx] = 1;
                    //cnt[mi] = 1;
                }
            }
            ans = Math.max(r-l+1,ans);
            //System.out.println("L :" + l + " -- " +"R :" + r);
            r++;
            //System.out.println(mi +"  "+mx);
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
