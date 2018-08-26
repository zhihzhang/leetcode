package unionfind;

import java.util.Arrays;

public class BrickFalling803 {

	public static void main(String[] args) {
		int[][] grid = {{1,0,0,0},{1,1,1,0}};
		int[][] hits = {{1,0}};
		
		int[] result = hitBricks(grid, hits);
		for(int i: result){
			System.out.println(i);
		}
	}
	
    public static int[] hitBricks(int[][] grid, int[][] hits) {
        int R = grid.length, C = grid[0].length;
        int[] dr = {1, 0, -1, 0};
        int[] dc = {0, 1, 0, -1};

        int[][] A = new int[R][C];
        for (int r = 0; r < R; ++r)
            A[r] = grid[r].clone();
        for (int[] hit: hits)
            A[hit[0]][hit[1]] = 0;

        UFA dsu = new UFA(R*C + 1);
        for (int r = 0; r < R; ++r) {
            for (int c = 0; c < C; ++c) {
                if (A[r][c] == 1) {
                    int i = r * C + c;
                    if (r == 0)
                        dsu.union(i, R*C);
                    if (r > 0 && A[r-1][c] == 1)
                        dsu.union(i, (r-1) *C + c);
                    if (c > 0 && A[r][c-1] == 1)
                        dsu.union(i, r * C + c-1);
                }
            }
        }
        int t = hits.length;
        int[] ans = new int[t--];

        while (t >= 0) {
            int r = hits[t][0];
            int c = hits[t][1];
            int preRoof = dsu.top();
            if (grid[r][c] == 0) {
                t--;
            } else {
                int i = r * C + c;
                for (int k = 0; k < 4; ++k) {
                    int nr = r + dr[k];
                    int nc = c + dc[k];
                    if (0 <= nr && nr < R && 0 <= nc && nc < C && A[nr][nc] == 1)
                        dsu.union(i, nr * C + nc);
                }
                if (r == 0)
                    dsu.union(i, R*C);
                A[r][c] = 1;
                ans[t--] = Math.max(0, dsu.top() - preRoof - 1);
            }
        }

        return ans;
    }
	

}

class UFA {
    int[] parent;
    int[] rank;
    int[] sz;

    public UFA(int N) {
        parent = new int[N];
        for (int i = 0; i < N; ++i)
            parent[i] = i;
        rank = new int[N];
        sz = new int[N];
        Arrays.fill(sz, 1);
    }

    public int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    public void union(int x, int y) {
        int xr = find(x), yr = find(y);
        if (xr == yr) return;

        if (rank[xr] < rank[yr]) {
            parent[xr] = yr;
            sz[yr] += sz[xr];
            System.out.println("1..x:" + x + "  y:" +y + "  xr:" + xr + "  yr:"+ yr);
//            int tmp = yr;
//            yr = xr;
//            xr = tmp;
            
        } 
        else if (rank[xr] > rank[yr]) {
            parent[yr] = xr;
            sz[xr] += sz[yr];
            System.out.println("2..x:" + x + "  y:" +y + "  xr:" + xr + "  yr:"+ yr);
        }
        if (rank[xr] == rank[yr]) {
        	System.out.println("......rank xr:" + xr + "...yr:"+yr);
            rank[xr]++;
            parent[yr] = xr;
            sz[xr] += sz[yr];
        }
        
        

//        parent[yr] = xr;
//        sz[xr] += sz[yr];
        System.out.println("3......x:" + x + "  y:" +y + "  xr:" + xr + "  yr:"+ yr);
        System.out.println("rank..." + Arrays.toString(rank));
        System.out.println("size..." + Arrays.toString(sz));
        System.out.println("------------------------------------------------");
        
    }
    
    public int size(int x) {
        return sz[find(x)];
    }

    public int top() {
        return size(sz.length - 1) - 1;
    }
}
