// Detect cycle in undirected graph

import java.util.ArrayList;

public class _60_GraphCycleCheck {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(1).add(2);
        adj.get(1).add(3);
        adj.get(2).add(1);
        adj.get(3).add(1);
        adj.get(4).add(5);
        adj.get(4).add(6);
        adj.get(5).add(4);
        adj.get(5).add(6);
        adj.get(6).add(4);
        adj.get(6).add(5);
        boolean ans = isCycle(7, adj);
        if (ans)
            System.out.println("Cycle is present!");
        else
            System.out.println("Cycle is absent");
    }

    static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean vis[] = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                if (dfs(i, adj, vis, -1))
                    return true;
            }
        }
        return false;
    }

    private static boolean dfs(int v, ArrayList<ArrayList<Integer>> adj, boolean[] vis, int parent) {
        vis[v] = true;

        for (Integer neighbor : adj.get(v)) {
            if (!vis[neighbor]) {
                if (dfs(neighbor, adj, vis, v))
                    return true;
            } else if (parent != neighbor)
                return true;
        }

        return false;
    }
}
