package AtCoder.ABC;

import java.util.*;
import java.io.*;

public class P272E {
    public static void main(String[] args) {
        Kattio sc = new Kattio();
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++) nums[i] = sc.nextInt();
        Map<Integer, List<Integer>> map = new HashMap<>();//操作次数--对应的结果,只记录有用的结果
        for(int i = 0; i < n; i++){
            if(nums[i] > n-1) continue;
            int r = Math.min(m+1,(n-1-nums[i])/(i+1)+1);//估计操作次数的上界
            int l = (nums[i] >= 0 ? 1 : (-nums[i]-1)/(i+1)+1);
            for(int j = l; j < r; j++){
                int t = nums[i]+j*(i+1);
                if(map.containsKey(j)){
                    map.get(j).add(t);
                }
                else {
                    List<Integer> list = new LinkedList<Integer>();
                    list.add(t);
                    map.put(j, list);
                }
            }
//            int cnt = Math.min(m,(n-1-nums[i])/(i+1));
//            int v = nums[i]+cnt*(i+1);
//            while(v >= 0 && cnt > 0){//操作后的值大于0
//                if(map.containsKey(cnt)){
//                    map.get(cnt).add(v);
//                }
//                else {
//                    Set<Integer> set = new HashSet<Integer>();
//                    set.add(v);
//                    map.put(cnt, set);
//                }
//                cnt--;
//                v -= (i+1);
//            }
        }
        int[] res = new int[m+1];
        int[] timestamp = new int[n+1];

        for(int i = 1; i <= m; i++){
           int ptr = 0;
           List<Integer> list = map.getOrDefault(i,Collections.EMPTY_LIST);
           for(int v : list){
               timestamp[v] = i;
               while(ptr <= n && timestamp[ptr] == i){
                   ptr++;
               }
           }
           res[i] = ptr;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= m; i++) {
            sb.append(res[i]).append("\n");
        }
        System.out.println(sb.toString());
        sc.flush();
    }

    public static class Kattio extends PrintWriter {
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