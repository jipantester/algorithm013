package Week_07;

class UnionFind{
    private int count;
    private int[] parent;
    private int[] size;

    public UnionFind(int n){
        this.count = n;
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++){
            parent[i] = i;
            size[i] = 1;
        }
    }

    private int find(int x){
        while (parent[x] != x ){
            x = parent[x];
        }
        return x;
    }

    public void union(int p, int q){
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;

        if (size[rootP] > size[rootQ]){
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];

        } else {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
        count--;
    }

    public int count(){
        return count;
    }

    public boolean connented(int p , int q){
        int rootP = find(p);
        int rootQ = find(q);
        return rootP == rootQ;
    }
}
public class SolutionOfFriendCircles{
    public int findCircleNum(int[][] M) {
        //获取节点数
        int n = M.length;
        //创建节点数为n的并查集
        UnionFind unionFind = new UnionFind(n);

        //遍历二位数组，M[i][j]
        for (int i = 0; i < n; i++){
            for (int j = 0; j < i; j++){
                if (M[i][j] == 1) {
                    unionFind.union(i,j);
                }
            }
        }
        return unionFind.count();
    }
}