package CodeForce.Map;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * @Author: tanying
 * @Date: 2023/8/30
 * @Description: https://atcoder.jp/contests/abc233/tasks/abc233_d
 * @Param: Rating : 726
  * @param null
 * @return:
 */

public class D233 {
    public static void main(String[] args) {
        Kattio io = new Kattio();
        int n = io.nextInt();
        long k = io.nextLong();
        long[] nums = new long[n];
        long ans = 0L,presum = 0L;
        Map<Long,Integer> map = new HashMap<>();
        map.put(0L,1);
        for(int i = 0; i < n; i++) nums[i] = io.nextLong();
        for(int i = 0; i < n; i++){
            presum += nums[i];
            if(map.containsKey(presum-k)){
                ans += map.get(presum-k);
            }
            map.put(presum,map.getOrDefault(presum,0)+1);
        }
        System.out.println(ans);
        io.flush();
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


