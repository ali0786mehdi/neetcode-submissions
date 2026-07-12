class Solution {
    public Map<Integer, Integer> shortestPath(int n, List<List<Integer>> edges, int src) {

        // Build adjacency list
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (List<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            int w = edge.get(2);
            graph.get(u).add(new int[]{v, w});
        }

        // Distance array
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // Min Heap -> {distance, vertex}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.offer(new int[]{0, src});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currDist = current[0];
            int node = current[1];

            // Ignore outdated entries
            if (currDist > dist[node]) {
                continue;
            }

            for (int[] neighbor : graph.get(node)) {
                int next = neighbor[0];
                int weight = neighbor[1];

                if (dist[node] + weight < dist[next]) {
                    dist[next] = dist[node] + weight;
                    pq.offer(new int[]{dist[next], next});
                }
            }
        }

        // Prepare result map
        Map<Integer, Integer> result = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                result.put(i, -1);
            } else {
                result.put(i, dist[i]);
            }
        }

        return result;
    }
}