package Week_07;

public class SolutionOfNumberOfIslands {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0){
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        //System.out.println(n);
        UnionFind_2 unionFind_2 = new UnionFind_2(grid);
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] == '1'){
                    grid[i][j] = '0';
                    if (i - 1 >= 0 && grid[i-1][j] == '1') unionFind_2.union(i*n+j, (i-1)*n+j);
                    if (i + 1 < m && grid[i+1][j] == '1') unionFind_2.union(i*n+j, (i+1)*n+j);
                    if (j - 1 >= 0 && grid[i][j-1] == '1') unionFind_2.union(i*n+j, i*n+(j-1));
                    if (j + 1 < n && grid[i][j+1] == '1') unionFind_2.union(i*n+j, i*n+(j+1));
                }
            }
        }
        return unionFind_2.getCount();
    }
}
class UnionFind_2{
    private int count;
    private int[] parent;
    private int[] size;
    public UnionFind_2(char[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        this.count = 0;
        parent = new int[m * n];
        size = new int[m * n];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1'){
                    parent[i * n + j] = i * n + j;
                    count++;
                }
                size[i * n + j] = 1;
            }
        }
    }

    private int find(int p){
        int x = p;
        while (parent[x] != x){
            parent[x] = parent[parent[x]];
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

    public boolean connected(int p,int q){
        int rootP = find(p);
        int rootQ = find(q);
        return rootP == rootQ;
    }

    public int getCount(){
        return count;
    }
}
