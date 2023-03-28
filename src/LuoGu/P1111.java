package LuoGu;

import java.io.*;
import java.util.*;

/**
 * DSU /: 并查集  https://www.luogu.com.cn/problem/P1111
 */
public class P1111 {
    static int[] fa;
    static int[][] nums;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        //并查集维护边权的最小值
        fa = new int[n+1];
        nums = new int[m][3];
        for(int i = 1; i <= n; i++) fa[i] = i;
        int size = n;
        for(int i = 0; i < m; i++){
            nums[i][0] = sc.nextInt();
            nums[i][1] = sc.nextInt();
            nums[i][2] = sc.nextInt();
        }
        //按照时间升序排列
        Arrays.sort(nums,(i,j) -> i[2]-j[2]);
        int ans = 1;
        for(int i = 0; i < m; i++){
            int x = nums[i][0], y = nums[i][1], time = nums[i][2];
            if(!connected(x,y)){
                size--;//合并后连通块数量减少
                ans = time;//更新答案
                union(x,y);
            }
        }
        if(size == 1)
            System.out.println(ans);
        else
            System.out.println(-1);
    }

    static boolean connected(int x,int y){
        return find(x) == find(y);
    }

    static int find(int x){
        if(fa[x] != x){
            fa[x] = find(fa[x]);
        }
        return fa[x];
    }

    static void union(int x,int y){
        int a = find(x);
        int b = find(y);
        if(a != b){
            fa[a] = b;
        }
    }
}
