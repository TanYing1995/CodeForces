import java.util.Scanner;

public class Main3 {
    static int n;
    static Tree[] tree;
    static long[] nums;
    public static void main(String[] args) {
        Scanner io = new Scanner(System.in);
        n = io.nextInt();
        int m = io.nextInt();
        nums = new long[n];
        for(int i = 0; i < n; i++) nums[i] = io.nextLong();
        tree = new Tree[4*n];
        for(int i = 0; i < tree.length; i++) tree[i] = new Tree();
        build(1,0,n-1);
        StringBuilder res = new StringBuilder();
        while(m-- > 0){
            int type = io.nextInt();
            if(type == 0){
                int idx = io.nextInt();
                long v = io.nextLong();
                update(1,idx,v);
            }
            else{
                int l = io.nextInt();
                int r = io.nextInt();
                res.append(query(1,l,r-1)).append("\n");
            }
        }
        System.out.println(res.toString());
    }

    static void update(int root,int idx,long v){

        if(tree[root].l == tree[root].r && tree[root].l == idx){
            tree[root].sum += v;
            return;
        }

        int mid = (tree[root].l+tree[root].r)/2;
        int lc = 2*root;
        int rc = lc+1;

        //在那一侧，就只更新那一侧的和
        if(idx <= mid){
            update(lc,idx,v);
        }
        else{
            update(rc,idx,v);
        }

        tree[root].sum = tree[lc].sum+tree[rc].sum;
    }

    static long query(int root,int l,int r){
        if(l <= tree[root].l && tree[root].r <= r) return tree[root].sum;

        int mid = (tree[root].l+tree[root].r)/2;
        int lc = 2*root;
        int rc = lc+1;

        long sum = 0L;
        if(l <= mid) sum += query(lc,l,r);
        if(r > mid) sum += query(rc,l,r);

        return sum;
    }

    static void build(int root,int l,int r){
        tree[root].l = l;
        tree[root].r = r;

        if(l == r){
            tree[root].sum = nums[l];
            return;//到达叶子节点，返回
        }

        int mid = (l+r)/2;
        int lc = 2*root;
        int rc = lc+1;

        build(lc,l,mid);
        build(rc,mid+1,r);

        tree[root].sum = tree[lc].sum+tree[rc].sum;
    }

    static class Tree{
        int l;
        int r;

        long sum;//字段和
    }
}
