import java.io.*;
import java.security.KeyPair;
import java.util.*;

public class P652D {

    static int[] c;
    static int n;
    public static void main(String[] args) {
        Kattio io = new Kattio();
        n = io.nextInt();
        int[][] nums = new int[n][2];
        Integer[] idx = new Integer[n];
        int[] e = new int[n];
        for(int i = 0; i < n; i++){
            nums[i][0] = io.nextInt();
            nums[i][1] = io.nextInt();
            idx[i] = i;
            e[i] = nums[i][1];
        }
        //先按照第一个元素降序，第二个元素升序排列
        Arrays.sort(idx, new Comparator<Integer>() {
            @Override
            public int compare(Integer x, Integer y) {
                if(nums[x][0] != nums[y][0])
                    return nums[y][0]-nums[x][0];
                else
                    return nums[x][1]-nums[y][1];
            }
        });

        //将第二位数据映射
        Map<Integer,Integer> map = new HashMap<>();
        Arrays.sort(e);//升序排列
        for(int i = 0; i < n; i++) map.put(e[i],i+1);

        c = new int[n+1];//树状数组
        int[] ans = new int[n];
        for(int i = 0; i < n; i++){
            ans[idx[i]] = query(map.get(nums[idx[i]][1]));
            update(map.get(nums[idx[i]][1]),1);
        }
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < n; i++){
            res.append(ans[i]).append("\n");
        }
        System.out.println(res.toString());
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
    //lowbit
    static int lowbit(int x){
        return(-x)&x;
    }
    //更新
    static void update(int idx,int v){
        for(int i = idx; i <= n; i+=lowbit(i)){
            c[i] += v;
        }
    }
    //查询
    static int query(int idx){
        int sum = 0;
        for(int i = idx;i > 0; i-=lowbit(i)){
            sum += c[i];
        }
        return sum;
    }
}
