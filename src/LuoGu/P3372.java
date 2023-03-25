package LuoGu;

import java.io.*;
import java.util.StringTokenizer;

public class P3372 {

    static class Tree{
        int l;//左节点编号
        int r;//右节点编号

        long lazyTag;//懒标记

        long sum;//区间和
    }

    static Tree[] tree;
    static int n;
    static int[] nums;

    public static void main(String[] args) {
        Kattio io = new Kattio();
        n = io.nextInt();int m = io.nextInt();
        nums = new int[n+1];
        tree = new Tree[4*n];
        for(int i = 0; i < tree.length; i++) tree[i] = new Tree();//初始化节点
        for(int i = 1; i <= n; i++) nums[i] = io.nextInt();
        build(1,1,n);//构建线段树
        StringBuilder sb = new StringBuilder();
        while(m-- > 0){
            int t = io.nextInt();
            int x = io.nextInt(),y = io.nextInt();
            if(t == 1){
                int k = io.nextInt();
                update(1,x,y,k);
            }
            else{
                sb.append(query(1,x,y)).append("\n");
            }
        }
        System.out.println(sb.toString());
        io.close();
    }

    static long query(int root,int l, int r){
        if(l <= tree[root].l && tree[root].r <= r){
            return tree[root].sum ;
        }
        pushdown(root);
        int mid = (tree[root].r+tree[root].l)/2;
        long ans = 0L;
        if(l <= mid) ans += query(2*root,l,r);
        if(r > mid) ans += query(2*root+1,l,r);
        return ans;
    }

    static void build(int root,int l, int r){
        tree[root].l = l;
        tree[root].r = r;
        tree[root].lazyTag = 0;//懒标记初始化为0

        if(l == r){
            tree[root].sum = 1L*nums[l];
            return;
        }

        int mid = l+(r-l)/2;
        int lc = 2*root;
        int rc = lc+1;

        build(lc,l,mid);
        build(rc,mid+1,r);

        tree[root].sum = tree[lc].sum+tree[rc].sum;
    }

    static void pushdown(int root){
        pass(2*root,tree[root].lazyTag);
        pass(2*root+1,tree[root].lazyTag);
        tree[root].lazyTag = 0;//清除自己的懒标记
    }

    static void pass(int root,long tag){
        tree[root].lazyTag += tag;
        tree[root].sum += 1L*tag*(tree[root].r-tree[root].l+1);
    }

    static void update(int root,int l, int r, int v){
        if(l <= tree[root].l && tree[root].r <= r){
            tree[root].sum += 1L*(tree[root].r-tree[root].l+1)*v;
            tree[root].lazyTag += v;
            return;
        }
        pushdown(root);//标记下传
        int mid = (tree[root].r+tree[root].l)/2;
        if(l <= mid) update(2*root,l,r,v);
        if(r > mid) update(2*root+1,l,r,v);

        tree[root].sum = tree[2*root].sum+tree[1+2*root].sum;
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
