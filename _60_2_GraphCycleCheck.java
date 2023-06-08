// Detect cycle in directed graph

import java.util.ArrayList;

public class _60_2_GraphCycleCheck {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(4);
        adj.get(4).add(2);

        boolean ans = isCycle(5, adj);
        if (ans)
            System.out.println("Cycle is present!");
        else
            System.out.println("Cycle is absent");
    }

    static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean vis[] = new boolean[V];// visited stack
        boolean recS[] = new boolean[V];// recursion stack

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                if (dfs(i, adj, vis, recS))
                    return true;
            }
        }
        return false;
    }

    private static boolean dfs(int v, ArrayList<ArrayList<Integer>> adj, boolean[] vis, boolean recS[]) {
        vis[v] = true;
        recS[v] = true;

        for (Integer neighbor : adj.get(v)) {
            if (!vis[neighbor]) {
                if (dfs(neighbor, adj, vis, recS))
                    return true;
            } else if (recS[neighbor])
                return true;
        }

        recS[v] = false;
        return false;
    }
}
