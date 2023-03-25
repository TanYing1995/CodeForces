package CodeForce;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P1156B {
    public static void main(String[] args) {
        Kattio io = new Kattio();
        //这是一个输入输出模板
        int num = io.nextInt();
        while(num-- > 0){
            String s = io.next();
            String noans = "No answer";
            //先统计各个元素的个数
            int[] cnt = new int[26];
            //
            for(char c: s.toCharArray()) cnt[c-'a']++;
            List<int[]> list = new ArrayList<>();
            for(int i = 0; i < 26; i++){
                if(cnt[i] != 0){
                    int[] ele = new int[]{i,cnt[i]};
                    list.add(ele);
                }
            }
            int sz = list.size();
            if(sz == 1){
                System.out.println(s);
            }else {
                int l = 0,r = sz/2;
                boolean f = true;
                StringBuilder sb = new StringBuilder();
                int[] left = list.get(l),right = list.get(r);
                if(sz == 2 && right[0]-left[0] == 1) {
                    System.out.println(noans);
                }
                else{
                    //双指针，一个往后，一个往前
                    if(sz == 3){
                        //sz为3的时候需要特判
                        int x = list.get(1)[0]-list.get(0)[0], y = list.get(2)[0]-list.get(1)[0];
                        if(x == y && x == 1){
                            f = false;
                        }
                        else if(x == 1){
                            //交换首尾两个 abe -》 eba
                            swap(list,0,2);
                        }
                    }
                    while(f && (l < sz/2 || r < sz)){
                        if(r < sz){
                            right = list.get(r++);
                            char ch = (char) (right[0]+'a');
                            int k = right[1];
                            while(k-- > 0) sb.append(ch);
                        }
                        if(l < sz/2){
                            left = list.get(l++);
                            char ch = (char) (left[0]+'a');
                            int k = left[1];
                            while(k-- > 0) sb.append(ch);
                        }
                    }
                    if (!f)
                        System.out.println(noans);
                    else
                        System.out.println(sb.toString());
                }
            }
        }
        io.close();
    }

    static void swap(List<int[]> list,int i, int j){
        int[] t1 = list.get(i);
        int[] t2 = list.get(j);
        list.set(i,t2);
        list.set(j,t1);
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
